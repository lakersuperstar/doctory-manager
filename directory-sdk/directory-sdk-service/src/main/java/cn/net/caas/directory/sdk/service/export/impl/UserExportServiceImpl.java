package cn.net.caas.directory.sdk.service.export.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.net.caas.directory.sdk.domain.UserInfo;
import cn.net.caas.directory.sdk.export.UserExportService;
import cn.net.caas.directory.sdk.query.Page;
import cn.net.caas.directory.sdk.query.UserQuery;
import cn.net.caas.directory.sdk.service.UserService;

@Service("userExportService")
public class UserExportServiceImpl implements UserExportService {
	
	@Resource
	private UserService userService;
	
	@Override
	public boolean savaUser(UserInfo info) {
		return userService.savaUser(info);
	}
	
	@Override
	public boolean updateUser(UserInfo info) {
		return userService.updateUser(info);
	}
	
	@Override
	public UserInfo queryUserById(long id) {
		return userService.queryUserById(id);
	}
	
	@Override
	public UserInfo queryUserByAccount(String account) {
		return userService.queryUserByAccount(account);
	}
	
	@Override
	public Page<UserInfo> queryUserPage(UserQuery query) {
		return userService.queryUserPage(query);
	}
	
	@Override
	public UserInfo verifyUser(String account, String password) {
		return userService.verifyUser(account, password);
	}
	
	@Override
	public boolean changePassword(String account, String oldPwd, String newPwd) {
		return userService.changePassword(account, oldPwd, newPwd);
	}
	
}
