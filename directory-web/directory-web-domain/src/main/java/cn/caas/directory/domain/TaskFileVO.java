package cn.caas.directory.domain;

import java.io.Serializable;

public class TaskFileVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8320509059434271487L;

	private String toFolder;

	private long taskId;

	private String fromFile;

	public String getToFolder() {
		return toFolder;
	}

	public void setToFolder(String toFolder) {
		this.toFolder = toFolder;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getFromFile() {
		return fromFile;
	}

	public void setFromFile(String fromFile) {
		this.fromFile = fromFile;
	}

	@Override
	public String toString() {
		return "TaskFileVO [toFolder=" + toFolder + ", taskId=" + taskId
				+ ", fromFile=" + fromFile + "]";
	}

}
