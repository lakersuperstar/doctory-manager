package cn.net.caas.directory.sdk.service.impl;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import cn.net.caas.directory.sdk.common.FileCopyCommon;
import cn.net.caas.directory.sdk.domain.TransferFile;
import cn.net.caas.directory.sdk.scanner.dao.TransferFileDAO;
import cn.net.caas.directory.sdk.service.TransferTaskService;

@Service("transferTaskService")
public class TransferTaskServiceImpl implements TransferTaskService {
	
	private final static Logger LOG = LoggerFactory.getLogger(TransferTaskServiceImpl.class);
	
	private ThreadPoolTaskExecutor taskPool;
	
	private int bufferSize = 1024 * 256;
	
	private int concurrentTask = 5;
	
	/** 任务定时器 */
	private final ScheduledExecutorService workTime = Executors.newScheduledThreadPool(5);
	
	@Resource
	private TransferFileDAO transferFileDAO;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// 初始化线程池
		initPool();
		// 初始化任务执行器
		workTime.scheduleWithFixedDelay(new TransferTask(), 1000 * 10, 1000 * 10, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public void destroy() throws Exception {
		taskPool.destroy();
		workTime.shutdown();
	}
	
	void initPool() {
		taskPool = new ThreadPoolTaskExecutor();
		taskPool.setQueueCapacity(0);
		taskPool.setCorePoolSize(concurrentTask);
		taskPool.setMaxPoolSize(concurrentTask);
		taskPool.setKeepAliveSeconds(30000);
		taskPool.setBeanName("TransferTaskService-poll");
		RejectedExecutionHandler handler = new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				LOG.error("线程池线程执行失败！ run [" + r.toString() + "]");
			}
		};
		taskPool.setRejectedExecutionHandler(handler);
		taskPool.initialize();
	}
	
	class TransferTask implements Runnable {
		
		@Override
		public void run() {
			try {
				List<TransferFile> transferFiles = getTransferFiles();
				if (transferFiles == null || transferFiles.size() <= 0) {
					LOG.error("TransferTask run [ task = null]");
					return;
				}
				
				for (TransferFile transferFile : transferFiles) {
					taskPool.execute(new FileCopyTask(transferFile));
				}
			} catch (Exception e) {
				LOG.error("TransferTask Exception", e);// 防御性容错
			}
		}
	}
	
	class FileCopyTask implements Runnable {
		
		final TransferFile transferFile;
		
		public FileCopyTask(TransferFile transferFile) {
			this.transferFile = transferFile;
		}
		
		@Override
		public void run() {
			// 执行拷贝
			try {
				fileCopy(transferFile);
			} catch (Exception e) {
				LOG.error("FileCopyTask Exception", e);// 防御性容错
			}
		}
		
		@Override
		public String toString() {
			return "taskId = " + transferFile.getTaskId() + " sourcePath = " + transferFile.getSourcePath()
					+ " destPath =  " + transferFile.getDestPath();
		}
	}
	
	private void fileCopy(TransferFile transferFile) {
		try {
			if (lockTransferTask(transferFile.getId())) {
				if (FileCopyCommon.fileCopyDirect(transferFile.getSourcePath(), transferFile.getDestPath(), bufferSize)) {
					// 更新状态为完成
					finishTask(transferFile.getId());
				}
			}
		} catch (Exception e) {
			LOG.error("fileCopy Exception", e);
		} finally {
			unLockTransferTask(transferFile.getId());
		}
	}
	
	@Override
	public boolean lockTransferTask(long id) {
		return transferFileDAO.lockTransferTask(id);
	}
	
	@Override
	public boolean unLockTransferTask(long id) {
		return transferFileDAO.unlockTransferTask(id);
	}
	
	@Override
	public List<TransferFile> getTransferFiles() {
		return transferFileDAO.findTransferTask(3, 50);
	}
	
	@Override
	public boolean finishTask(long id) {
		return transferFileDAO.finishTask(id);
	}
	
	@Override
	public boolean saveTransferFile(TransferFile transferFile) {
		return transferFileDAO.saveTransferFile(transferFile);
	}
	
	@Override
	public boolean batchTransferFile(List<TransferFile> transferFiles) {
		return transferFileDAO.batchTransferFile(transferFiles);
	}
	
}
