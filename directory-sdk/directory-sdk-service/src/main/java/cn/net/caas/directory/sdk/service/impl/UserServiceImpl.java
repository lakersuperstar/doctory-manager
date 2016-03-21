package cn.net.caas.directory.sdk.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.net.caas.directory.sdk.domain.UserInfo;
import cn.net.caas.directory.sdk.query.Page;
import cn.net.caas.directory.sdk.query.UserQuery;
import cn.net.caas.directory.sdk.scanner.dao.UserDAO;
import cn.net.caas.directory.sdk.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDAO userDAO;
	
	@Override
	public boolean savaUser(UserInfo info) {
		return userDAO.savaUser(info);
	}
	
	@Override
	public boolean updateUser(UserInfo info) {
		return userDAO.updateUser(info);
	}
	
	@Override
	public UserInfo queryUserById(long id) {
		return userDAO.queryUserById(id);
	}
	
	@Override
	public UserInfo queryUserByAccount(String account) {
		return userDAO.queryUserByAccount(account);
	}
	
	@Override
	public Page<UserInfo> queryUserPage(UserQuery query) {
		Page<UserInfo> page = new Page<UserInfo>();
		List<UserInfo> data = userDAO.queryUserPage(query);
		int totalRecord = userDAO.queryTotalRecord(query);
		page.setData(data);
		page.setPageNo(query.getPageNo());
		page.setPageSize(query.getPageSize());
		page.setTotalRecord(totalRecord);
		page.setTotalPage(totalRecord / query.getPageSize() + 1);
		return page;
	}
	
	@Override
	public UserInfo verifyUser(String account, String password) {
		return userDAO.verifyUser(account, password);
	}
	
	@Override
	public boolean changePassword(String account, String oldPwd, String newPwd) {
		return userDAO.changePassword(account, oldPwd, newPwd);
	}
	
}
