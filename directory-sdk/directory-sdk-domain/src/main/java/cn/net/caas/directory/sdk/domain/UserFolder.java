package cn.net.caas.directory.sdk.domain;

public class UserFolder implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 432298648797432691L;
	
	/** id */
	private long id;
	
	private long userId;
	
	private String path;
	
	private int rw;

	
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

	
	public String getPath() {
		return path;
	}

	
	public void setPath(String path) {
		this.path = path;
	}

	
	public int getRw() {
		return rw;
	}

	
	public void setRw(int rw) {
		this.rw = rw;
	}
	
}
