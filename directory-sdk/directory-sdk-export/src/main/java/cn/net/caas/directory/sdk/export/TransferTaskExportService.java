package cn.net.caas.directory.sdk.export;

import java.util.List;

import cn.net.caas.directory.sdk.domain.TransferTask;

public interface TransferTaskExportService {

	int addTransferTask(long userId);

	boolean updateTransferTaskInitById(long taskId);

	List<TransferTask> queryTransferTask(long userId);

}
