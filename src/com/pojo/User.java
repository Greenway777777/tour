package com.pojo;

public class User {
	
	private int uid;
	private String uname;
	private String upassword;
	private String realName;
	private String identity;
	private String sex;
	private long phone;
	
	public User() {
	}
	
	
	
	public User(String uname, String upassword, String realname, String identity, String sex, long phone) {
		super();
		this.uname = uname;
		this.upassword = upassword;
		this.realName = realname;
		this.identity = identity;
		this.sex = sex;
		this.phone = phone;
	}



	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realname) {
		this.realName = realname;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", realname=" + realName
				+ ", identity=" + identity + ", sex=" + sex + ", phone=" + phone + "]";
	}

	
}
