package cn.net.caas.directory.sdk.dao;

import java.util.List;

import cn.net.caas.directory.sdk.domain.TransferFile;

public interface TransferFileDAO {

	public boolean saveTransferFile(TransferFile transferFile);

	public List<TransferFile> queryTransferFile(TransferFile transferFile);
}
