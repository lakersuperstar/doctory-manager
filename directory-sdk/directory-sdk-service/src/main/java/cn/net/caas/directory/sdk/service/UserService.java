package cn.net.caas.directory.sdk.service;

import cn.net.caas.directory.sdk.domain.UserInfo;
import cn.net.caas.directory.sdk.query.Page;
import cn.net.caas.directory.sdk.query.UserQuery;

public interface UserService {
	
	/**
	 * 添加用户
	 * 
	 * @param UserInfo
	 * @return boolean
	 */
	boolean savaUser(UserInfo info);
	
	/**
	 * 更新用户信息
	 * 
	 * @param UserInfo
	 * @return boolean
	 */
	boolean updateUser(UserInfo info);
	
	/**
	 * 根据ID查询用户信息
	 * 
	 * @param id
	 * @return UserInfo
	 */
	UserInfo queryUserById(long id);
	
	/**
	 * 根据账户查询用户信息
	 * 
	 * @param account
	 * @return UserInfo
	 */
	UserInfo queryUserByAccount(String account);
	
	/**
	 * 分页查询用户信息
	 * 
	 * @param UserInfo
	 * @return boolean
	 */
	Page<UserInfo> queryUserPage(UserQuery query);
	
	/**
	 * 验证用户名密码并返回用户信息
	 * 
	 * @param UserInfo
	 * @return boolean
	 */
	UserInfo verifyUser(String account, String password);
	
	/**
	 * 用户修改密码
	 * 
	 * @param UserInfo
	 * @return boolean
	 */
	boolean changePassword(String account, String oldPwd, String newPwd);
	
}
