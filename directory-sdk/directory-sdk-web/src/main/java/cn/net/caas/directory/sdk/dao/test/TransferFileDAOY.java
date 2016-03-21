package cn.net.caas.directory.sdk.dao.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.net.caas.directory.sdk.domain.TransferFile;
import cn.net.caas.directory.sdk.scanner.dao.TransferFileDAO;

public class TransferFileDAOY {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring-config.xml");
		TransferFileDAO transferFileDAO = (TransferFileDAO) context.getBean("transferFileDAO");
		
		
		
		TransferFile transferFile1 = new TransferFile();
		transferFile1.setTaskId(1);
		transferFile1.setSourcePath("F:/copy-main/visio.exe");
		transferFile1.setDestPath("G:/copy-1/visio.exe");
		transferFile1.setUserId(1);
		transferFile1.setExecutionTime(new Date());
		
		TransferFile transferFile2 = new TransferFile();
		transferFile2.setTaskId(1);
		transferFile2.setSourcePath("F:/copy-main/visio.exe");
		transferFile2.setDestPath("G:/copy-2/visio.exe");
		transferFile2.setUserId(1);
		transferFile2.setExecutionTime(new Date());
		
		TransferFile transferFile3 = new TransferFile();
		transferFile3.setTaskId(1);
		transferFile3.setSourcePath("F:/copy-main/visio.exe");
		transferFile3.setDestPath("G:/copy-3/visio.exe");
		transferFile3.setUserId(1);
		transferFile3.setExecutionTime(new Date());
		
		TransferFile transferFile4 = new TransferFile();
		transferFile4.setTaskId(1);
		transferFile4.setSourcePath("F:/copy-main/visio.exe");
		transferFile4.setDestPath("G:/copy-4/visio.exe");
		transferFile4.setUserId(1);
		transferFile4.setExecutionTime(new Date());
		
		List<TransferFile> files = new ArrayList<TransferFile>();
		files.add(transferFile1);
		files.add(transferFile2);
		files.add(transferFile3);
		files.add(transferFile4);
		
		transferFileDAO.batchTransferFile(files);
	}
}
