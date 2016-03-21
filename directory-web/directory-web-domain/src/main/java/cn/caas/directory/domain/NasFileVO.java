package cn.caas.directory.domain;

import java.io.Serializable;

/**
 * 文件列表展示VO
 * 
 * @author songk
 *
 */
public class NasFileVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4901940761770860407L;

	/**
	 * 文件ID
	 */
	private String id;

	/**
	 * 文件名称
	 */
	private String name;

	/**
	 * 是否是父节点
	 */
	private String isParent;

	/**
	 * 文件全路径
	 */
	private String fullName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "NasFileVO [id=" + id + ", name=" + name + ", isParent="
				+ isParent + ", fullName=" + fullName + "]";
	}

}
