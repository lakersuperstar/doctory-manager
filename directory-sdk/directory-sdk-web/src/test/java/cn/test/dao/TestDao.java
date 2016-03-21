package cn.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.net.caas.directory.sdk.domain.UserFolder;
import cn.net.caas.directory.sdk.service.UserFolderService;

public class TestDao {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"classpath:spring-config.xml");
		UserFolderService userFolderService = (UserFolderService) context
				.getBean("userFolderService");

		System.out.println(userFolderService.queryUserFolder(1));

		System.out.println(userFolderService.deleteUserFolderById(1));

		System.out.println(userFolderService.deleteUserFolderByUserId(1));
		List<UserFolder> userFolders = new ArrayList<UserFolder>();
		UserFolder userFolder = new UserFolder();
		userFolder.setPath("aa");
		userFolder.setRw(1);
		userFolder.setUserId(1);
		userFolders.add(userFolder);

		UserFolder userFolder1 = new UserFolder();
		userFolder1.setPath("aa");
		userFolder1.setRw(1);
		userFolder1.setUserId(1);
		userFolders.add(userFolder1);

		UserFolder userFolder2 = new UserFolder();
		userFolder2.setPath("aa");
		userFolder2.setRw(1);
		userFolder2.setUserId(1);
		userFolders.add(userFolder2);

		boolean flag = userFolderService.addUserFolder(userFolders);
		System.out.println(flag);
	}
}
