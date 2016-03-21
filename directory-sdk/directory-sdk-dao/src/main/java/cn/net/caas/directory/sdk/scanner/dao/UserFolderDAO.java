package cn.net.caas.directory.sdk.scanner.dao;

import java.util.List;

import cn.net.caas.directory.sdk.domain.UserFolder;

public interface UserFolderDAO {

	/**
	 * 批量插入
	 * 
	 * @param userFolder
	 * @return
	 */
	boolean batchSaveUserFolder(List<UserFolder> userFolder);

	boolean deleteUserFolderById(long id);

	boolean deleteUserFolderByUserId(long userId);

	List<UserFolder> queryUserFolder(long userId);

}
