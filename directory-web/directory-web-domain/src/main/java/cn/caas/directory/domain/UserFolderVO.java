package cn.caas.directory.domain;

import java.io.Serializable;

public class UserFolderVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2743302268592699565L;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
