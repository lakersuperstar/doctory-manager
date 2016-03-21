package cn.net.caas.directory.sdk.export;

import java.util.List;

import cn.net.caas.directory.sdk.domain.TransferFile;

public interface TransferFileExportServie {

	boolean betchAddTransferFile(List<TransferFile> files);
}
