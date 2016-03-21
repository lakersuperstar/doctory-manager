package cn.net.caas.directory.sdk.dao;

import java.util.List;

import cn.net.caas.directory.sdk.domain.UserInfo;

/**
 * @author Administrator
 * @date 2015-12-16 ����5:36:03
 */
public interface UserDAO {
	
	/**
	 * 
	 * @param UserInfo
	 * @return boolean
	 */
	boolean savaUser(UserInfo info);
	
	/**
	 * 
	 * @param UserInfo
	 * @return boolean
	 */
	boolean updateUser(UserInfo info);
	
	
	/**
	 * 
	 * @param UserInfo
	 * @return boolean
	 */
	List<UserInfo> queryUser();
	
	
}
