package cn.net.caas.directory.sdk.service;

import java.util.List;

import cn.net.caas.directory.sdk.domain.UserFolder;

public interface UserFolderService {

	/**
	 * 增加用户可操作的文件夹
	 * 
	 * @param userFolders
	 * @return
	 */
	public boolean addUserFolder(List<UserFolder> userFolders);

	/**
	 * 删除用户可操作的文件夹
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteUserFolderById(long id);

	/**
	 * 删除用户下所有的目录
	 * 
	 * @param userId
	 * @return
	 */
	public boolean deleteUserFolderByUserId(long userId);

	/**
	 * 查询用户可操作的权限
	 * 
	 * @param userId
	 * @return
	 */
	public List<UserFolder> queryUserFolder(long userId);
}
