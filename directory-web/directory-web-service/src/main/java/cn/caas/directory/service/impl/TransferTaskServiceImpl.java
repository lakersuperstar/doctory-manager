package cn.caas.directory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.caas.directory.service.TransferTaskService;
import cn.net.caas.directory.sdk.domain.TransferTask;
import cn.net.caas.directory.sdk.export.TransferTaskExportService;

@Service("transferTaskService")
public class TransferTaskServiceImpl implements TransferTaskService {

	private TransferTaskExportService transferTaskExportService;

	public int addTransferTask(long userId) {
		return transferTaskExportService.addTransferTask(userId);
	}

	public boolean updateTransferTaskInit(long taskId) {
		return transferTaskExportService.updateTransferTaskInitById(taskId);
	}

	public List<TransferTask> queryTransferTaskByUser(long userId) {
		return transferTaskExportService.queryTransferTask(userId);
	}

}
