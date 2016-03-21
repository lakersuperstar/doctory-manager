package cn.net.caas.directory.sdk.service.export.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.net.caas.directory.sdk.domain.UserFolder;
import cn.net.caas.directory.sdk.export.UserFolderExportService;
import cn.net.caas.directory.sdk.service.UserFolderService;

@Service("userFolderExportService")
public class UserFolderExportServiceImpl implements UserFolderExportService {

	@Resource
	private UserFolderService userFolderService;

	public boolean addUserFolder(List<UserFolder> userFolders) {
		return userFolderService.addUserFolder(userFolders);
	}

	public boolean deleteUserFolderById(long id) {
		return userFolderService.deleteUserFolderById(id);
	}

	public boolean deleteUserFolderByUserId(long userId) {
		return userFolderService.deleteUserFolderByUserId(userId);
	}

	public List<UserFolder> queryUserFolder(long userId) {
		return userFolderService.queryUserFolder(userId);
	}

	public UserFolderService getUserFolderService() {
		return userFolderService;
	}

	public void setUserFolderService(UserFolderService userFolderService) {
		this.userFolderService = userFolderService;
	}

}
