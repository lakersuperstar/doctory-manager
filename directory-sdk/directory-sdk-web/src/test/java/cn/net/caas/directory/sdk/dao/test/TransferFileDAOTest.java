package cn.net.caas.directory.sdk.dao.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.net.caas.directory.sdk.domain.TransferFile;
import cn.net.caas.directory.sdk.scanner.dao.TransferFileDAO;

public class TransferFileDAOTest {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring-config.xml");
		TransferFileDAO transferFileDAO = (TransferFileDAO) context.getBean("transferFileDAO");
		TransferFile transferFile1 = new TransferFile();
		transferFile1.setTaskId(1);
		transferFile1.setSourcePath("F:/copy-main/win7.0");
		transferFile1.setDestPath("G:/copy-1/win7.0");
		transferFile1.setUserId(1);
		transferFile1.setExecutionTime(new Date());
		transferFileDAO.saveTransferFile(transferFile1);
	}
}
