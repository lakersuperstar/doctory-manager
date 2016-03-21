package cn.net.caas.directory.sdk.scanner.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.net.caas.directory.sdk.domain.TransferFile;

public interface TransferFileDAO {
	
	/***
	 * 保存文件转移任务
	 * 
	 * @param transferFile
	 * @return boolean
	 * 
	 */
	boolean saveTransferFile(TransferFile transferFile);
	
	/***
	 * 批量保存文件转移任务
	 * 
	 * @param transferFile
	 * @return boolean
	 * 
	 */
	boolean batchTransferFile(List<TransferFile> transferFiles);
	
	/**
	 * 查询可执行的转移任务, 最大获取任务数为50 ,根据执行时间排序 ,根据任务Id分组
	 * 
	 * @param retry
	 * @param maxTaskNum
	 * @return List<TransferFile>
	 */
	List<TransferFile> findTransferTask(@Param("retry") int retry, @Param("maxTaskNum") int maxTaskNum);
	
	/**
	 * 锁定任务
	 * 
	 * @param id
	 * @return boolean
	 */
	boolean lockTransferTask(long id);
	
	/**
	 * 释放任务锁定
	 * 
	 * @param id
	 * @return boolean
	 */
	boolean unlockTransferTask(long id);
	
	/**
	 * 完成任务
	 * 
	 * @param id
	 * @return boolean
	 */
	boolean finishTask(long id);
	
}
