package cn.net.caas.directory.sdk.service;

import java.util.List;

import cn.net.caas.directory.sdk.domain.TransferFile;

public interface TransferFileService {

	boolean batchSaveTransferFile(List<TransferFile> transferFiles);
	
	

}
