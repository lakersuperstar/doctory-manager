package cn.net.caas.directory.sdk.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.net.caas.directory.sdk.domain.UserFolder;
import cn.net.caas.directory.sdk.scanner.dao.UserFolderDAO;
import cn.net.caas.directory.sdk.service.UserFolderService;

@Service("userFolderService")
public class UserFolderServiceImpl implements UserFolderService {

	@Resource
	private UserFolderDAO userFolderDAO;

	public boolean addUserFolder(List<UserFolder> userFolders) {
		return userFolderDAO.batchSaveUserFolder(userFolders);
	}

	public boolean deleteUserFolderById(long id) {
		return userFolderDAO.deleteUserFolderById(id);
	}

	public boolean deleteUserFolderByUserId(long userId) {
		return userFolderDAO.deleteUserFolderByUserId(userId);
	}

	public List<UserFolder> queryUserFolder(long userId) {
		return userFolderDAO.queryUserFolder(userId);
	}

	public UserFolderDAO getUserFolderDAO() {
		return userFolderDAO;
	}

	public void setUserFolderDAO(UserFolderDAO userFolderDAO) {
		this.userFolderDAO = userFolderDAO;
	}

}
