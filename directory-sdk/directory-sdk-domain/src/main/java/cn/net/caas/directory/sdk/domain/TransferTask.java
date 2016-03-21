package cn.net.caas.directory.sdk.domain;

import java.io.Serializable;
import java.util.Date;

public class TransferTask implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3531117896166861917L;
	
	/** id */
	private long id;
	
	private long userId;
	
	private String toPath;
	
	private Date createDate;
	
	private Date updateDate;
	
	private int stats;
	
	private int yn;

	
	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	
	public long getUserId() {
		return userId;
	}

	
	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	public String getToPath() {
		return toPath;
	}

	
	public void setToPath(String toPath) {
		this.toPath = toPath;
	}

	
	public Date getCreateDate() {
		return createDate;
	}

	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
	public Date getUpdateDate() {
		return updateDate;
	}

	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	
	public int getStats() {
		return stats;
	}

	
	public void setStats(int stats) {
		this.stats = stats;
	}

	
	public int getYn() {
		return yn;
	}

	
	public void setYn(int yn) {
		this.yn = yn;
	}
	
}
