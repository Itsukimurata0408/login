package jp.co.aforce.beans;

public class LoginBean {
	private String username;
	private String password;
	private String error;

	public LoginBean(){};

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public String getEmsg() {
		return error;
	}

	public void setEmsg(String error) {
		this.error = error;

	}


}
