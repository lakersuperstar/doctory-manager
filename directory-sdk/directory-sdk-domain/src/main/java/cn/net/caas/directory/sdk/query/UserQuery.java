package cn.net.caas.directory.sdk.query;

public class UserQuery extends PageQuery {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6319415194720503922L;
	
	private String name;
	
	private int yn;
	
	private String account;
	
	private int role;

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public int getYn() {
		return yn;
	}

	
	public void setYn(int yn) {
		this.yn = yn;
	}

	
	public String getAccount() {
		return account;
	}

	
	public void setAccount(String account) {
		this.account = account;
	}


	
	public int getRole() {
		return role;
	}

	
	public void setRole(int role) {
		this.role = role;
	}
	
}
