package cn.net.caas.directory.sdk.dao;

import java.util.List;

import cn.net.caas.directory.sdk.domain.TransferTask;

public interface TransferTaskDAO {

	public boolean saveTransferTask(TransferTask transferTask);

	public boolean updateTransferTask(TransferTask transferTask);

	public List<TransferTask> queryTransferTask(TransferTask transferTask);
}
