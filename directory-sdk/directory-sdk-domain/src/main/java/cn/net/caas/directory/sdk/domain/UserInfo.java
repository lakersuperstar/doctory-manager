package cn.net.caas.directory.sdk.domain;

import java.util.Date;

public class UserInfo implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8444809060192594634L;
	
	/** id */
	private long id;
	
	/** 账户 */
	private String account;
	
	/** 密码 */
	private String password;
	
	/** 名称 */
	private String name;
	
	/** 电话 */
	private String phone;
	
	/** 公司名称 */
	private String companyName;
	
	/** 部门 */
	private String department;
	
	/** 账户有效期 */
	private Date expire;
	
	/** 创建时间 */
	private Date createDate;
	
	/** 功能角色 */
	private int role;
	
	/** 是否有效 */
	private int yn;
	
	/** 是否开启自动转移 */
	private int isAutoTransfer;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Date getExpire() {
		return expire;
	}
	
	public void setExpire(Date expire) {
		this.expire = expire;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public int getRole() {
		return role;
	}
	
	public void setRole(int role) {
		this.role = role;
	}
	
	public int getYn() {
		return yn;
	}
	
	public void setYn(int yn) {
		this.yn = yn;
	}
	
	public int getIsAutoTransfer() {
		return isAutoTransfer;
	}
	
	public void setIsAutoTransfer(int isAutoTransfer) {
		this.isAutoTransfer = isAutoTransfer;
	}
	
}
