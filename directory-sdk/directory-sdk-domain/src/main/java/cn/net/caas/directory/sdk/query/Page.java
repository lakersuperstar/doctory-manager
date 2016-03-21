package cn.net.caas.directory.sdk.query;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5635045157633568351L;
	
	/** 当前页码 */
	private int pageNo;
	
	/** 每页行数 */
	private int pageSize;
	
	/** 总记录数 */
	private int totalRecord;
	
	/** 总页数 */
	private int totalPage;
	
	private List<T> data;

	
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

	
	public int getTotalRecord() {
		return totalRecord;
	}

	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	
	public int getTotalPage() {
		return totalPage;
	}

	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	
	public List<T> getData() {
		return data;
	}

	
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
