package cn.net.caas.directory.sdk.dao;

import java.util.List;

import cn.net.caas.directory.sdk.domain.UserFolder;


public interface UserFolderDAO {
	
	boolean batchSavaUserFolder(List<UserFolder> userFolder);
	
	boolean deleteUserFolder(long userId);
	
	boolean queryUserFolder(long userId);
	
}
