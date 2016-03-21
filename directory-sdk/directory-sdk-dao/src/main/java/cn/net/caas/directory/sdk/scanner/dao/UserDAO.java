package cn.net.caas.directory.sdk.scanner.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.net.caas.directory.sdk.domain.UserInfo;
import cn.net.caas.directory.sdk.query.UserQuery;

/**
 * @author Administrator
 * @date 2015-12-16 15:36:03
 */
public interface UserDAO {
	
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
	 */
	UserInfo queryUserById(long id);
	
	/**
	 * 根据账户查询用户信息
	 */
	UserInfo queryUserByAccount(String account);
	
	/**
	 * 分页查询用户信息
	 * 
	 * @param UserInfo
	 * @return boolean
	 */
	List<UserInfo> queryUserPage(UserQuery query);
	
	/**
	 * 分页查询用户信息总条数
	 * 
	 * @param UserInfo
	 * @return boolean
	 */
	int queryTotalRecord(UserQuery query);
	
	/**
	 * 验证用户名密码并返回用户信息
	 * 
	 * @param UserInfo
	 * @return boolean
	 */
	UserInfo verifyUser(@Param("account") String account, @Param("password") String password);
	
	/**
	 * 用户修改密码
	 * 
	 * @param UserInfo
	 * @return boolean
	 */
	boolean changePassword(@Param("account") String account, @Param("oldPwd") String oldPwd,
			@Param("newPwd") String newPwd);
	
}
