package cn.caas.directory.service;

import java.util.List;

public interface TransferFileService {

	public boolean betchAddTransferFileService(long taskId, long userId,
			List<String> fromFile, String toFolder);

}
