package cn.caas.directory.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.caas.directory.service.UserDirectorService;
import cn.net.caas.directory.sdk.domain.UserFolder;
import cn.net.caas.directory.sdk.export.UserFolderExportService;

@Service("userDirectorService")
public class UserDirectorServiceImpl implements UserDirectorService {

	@Resource
	private UserFolderExportService userFolderExportService;

	public List<UserFolder> queryUserFolder(long userId) {
		return userFolderExportService.queryUserFolder(userId);
	}

	public boolean addUserFolder(List<UserFolder> userFolders) {
		return userFolderExportService.addUserFolder(userFolders);
	}

	public boolean delUserFolderById(long id) {
		return userFolderExportService.deleteUserFolderById(id);
	}

	public boolean delUserFolderByUserId(long userId) {
		return userFolderExportService.deleteUserFolderByUserId(userId);
	}

	public UserFolderExportService getUserFolderExportService() {
		return userFolderExportService;
	}

	public void setUserFolderExportService(
			UserFolderExportService userFolderExportService) {
		this.userFolderExportService = userFolderExportService;
	}

}
