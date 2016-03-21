package cn.caas.directory.service;

import java.util.List;

import cn.net.caas.directory.sdk.domain.UserFolder;

public interface UserDirectorService {

	public List<UserFolder> queryUserFolder(long userId);

	public boolean addUserFolder(List<UserFolder> userFolders);

	public boolean delUserFolderById(long id);

	public boolean delUserFolderByUserId(long userId);
}
