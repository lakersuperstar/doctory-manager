package cn.caas.directory.domain;

import java.io.Serializable;
import java.util.List;

public class FileDirectoryVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3669297782351677561L;

	private List<String> directoryFullName;

	private String directorys;

	private List<String> userId;

	private String fullName;

	public List<String> getDirectoryFullName() {
		return directoryFullName;
	}

	public void setDirectoryFullName(List<String> directoryFullName) {
		this.directoryFullName = directoryFullName;
	}

	public String getDirectorys() {
		return directorys;
	}

	public List<String> getUserId() {
		return userId;
	}

	public void setUserId(List<String> userId) {
		this.userId = userId;
	}

	public void setDirectorys(String directorys) {
		this.directorys = directorys;
	}

	@Override
	public String toString() {
		return "FileDirectoryVO [directoryFullName=" + directoryFullName
				+ ", directorys=" + directorys + ", userId=" + userId
				+ ", fullName=" + fullName + "]";
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
