package cn.caas.directory.service;

import java.util.List;

import cn.net.caas.directory.sdk.domain.TransferTask;

public interface TransferTaskService {

	public int addTransferTask(long userId);

	public boolean updateTransferTaskInit(long taskId);

	public List<TransferTask> queryTransferTaskByUser(long userId);
}
