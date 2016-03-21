package cn.net.caas.directory.sdk.domain;

import java.io.Serializable;
import java.util.Date;

public class TransferFile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7129294725341475349L;
	
	/** id */
	private long id;
	
	/** 任务id */
	private long taskId;
	
	/** 转移任务的文件名 */
	private String sourcePath;
	
	/** 转移任务目标的文件名 */
	private String destPath;
	
	/** 转移任务目标执行时间 */
	private Date executionTime;
	
	/** 转移任务的用户ID */
	private long userId;
	
	/** 重试次数 */
	private int retry;
	
	/** 转移任务的执行状态 */
	private int status;
	
	/** 转移任务锁 */
	private int lock;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getTaskId() {
		return taskId;
	}
	
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	
	public String getSourcePath() {
		return sourcePath;
	}
	
	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}
	
	public String getDestPath() {
		return destPath;
	}
	
	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getRetry() {
		return retry;
	}
	
	public void setRetry(int retry) {
		this.retry = retry;
	}

	
	public int getLock() {
		return lock;
	}

	
	public void setLock(int lock) {
		this.lock = lock;
	}

	
	public Date getExecutionTime() {
		return executionTime;
	}

	
	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}
	
}
