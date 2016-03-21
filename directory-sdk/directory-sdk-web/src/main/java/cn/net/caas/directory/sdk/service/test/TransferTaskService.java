package cn.net.caas.directory.sdk.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TransferTaskService {
	
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring-config.xml");
	}
}
