package cn.caas.directory.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.caas.directory.service.TransferFileService;
import cn.net.caas.directory.sdk.domain.TransferFile;
import cn.net.caas.directory.sdk.export.TransferFileExportServie;

@Service("transferFileService")
public class TransferFileServiceImpl implements TransferFileService {

//	@Resource
	private TransferFileExportServie transferFileExportServie;

	public boolean betchAddTransferFileService(long taskId, long userId,
			List<String> fromFile, String toFolder) {
		List<TransferFile> files = new ArrayList<TransferFile>();
		if (fromFile != null && fromFile.size() > 0) {
			for (String from : fromFile) {
				TransferFile file = new TransferFile();
				file.setSourcePath(from);
				file.setTaskId(taskId);
				file.setUserId(userId);
				file.setDestPath(toFolder);
				files.add(file);
			}
		}
		return transferFileExportServie.betchAddTransferFile(files);
	}

	public TransferFileExportServie getTransferFileExportServie() {
		return transferFileExportServie;
	}

	public void setTransferFileExportServie(
			TransferFileExportServie transferFileExportServie) {
		this.transferFileExportServie = transferFileExportServie;
	}

}
