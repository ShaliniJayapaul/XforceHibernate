package com.dev.dto;

public class userInfo {
	@Override
	public String toString() {
		return "userInfo [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	
	public int getId() {
		return userId;
	}
	public void setId(int id) {
		this.userId = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
