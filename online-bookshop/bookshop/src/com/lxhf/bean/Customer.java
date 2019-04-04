package com.lxhf.bean;

public class Customer {
	private Integer id;
	private String username;
	private String password;
	private String nickname;
	private String phonenum;
	private String email;
	private String address;
	private Boolean status;
	private Integer characterid;
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getCharacterid() {
		return characterid;
	}
	public void setCharacterid(Integer characterid) {
		this.characterid = characterid;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", phonenum=" + phonenum + ", email=" + email + ", address=" + address + ", status=" + status
				+ ", characterid=" + characterid + "]";
	}
	

	
}
