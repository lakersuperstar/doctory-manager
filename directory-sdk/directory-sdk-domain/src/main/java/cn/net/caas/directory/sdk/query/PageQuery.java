package cn.net.caas.directory.sdk.query;

import java.io.Serializable;

public class PageQuery implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3454280337235767885L;
	
	/** 当前页码 */
	private int pageNo;
	
	/** 每页行数 */
	private int pageSize;
	
	/** 开始行数 */
	private int startrownum;
	
	/** 结束行数 */
	private int endrownum;

	
	public int getPageNo() {
		return pageNo;
	}

	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	
	public int getPageSize() {
		return pageSize;
	}

	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	public int getStartrownum() {
		return startrownum;
	}

	
	public void setStartrownum(int startrownum) {
		this.startrownum = startrownum;
	}

	
	public int getEndrownum() {
		return endrownum;
	}

	
	public void setEndrownum(int endrownum) {
		this.endrownum = endrownum;
	}
	
}
