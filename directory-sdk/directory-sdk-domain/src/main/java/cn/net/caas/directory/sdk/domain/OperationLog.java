package cn.net.caas.directory.sdk.domain;

import java.io.Serializable;
import java.util.Date;

public class OperationLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -152795255047999259L;

	/** id */
	private long id;

	private long user_id;

	private String logInfo;

	private Date create_date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

}
