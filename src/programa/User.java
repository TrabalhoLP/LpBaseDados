package programa;

import java.io.Serializable;
import java.io.*;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(String userpass) {
		// TODO Auto-generated constructor stub
		
	}

	public String getPassword() {
		return this.password;
	}
	
	public String getUsername() {
		return this.username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}