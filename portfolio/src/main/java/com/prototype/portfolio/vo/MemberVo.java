package com.prototype.portfolio.vo;

import java.util.Date;

public class MemberVo {
	//phone_num_reference
	private String phone_num1;
	private String phone_num2;
	private String phone_num3;
	// email_reference
	private String email_id;
	private String email_domain;
	
	// define and initialize
	private String userid;
	private String userpwd;
	private String username;
	private String email;
	private String user_addr;
	private	Date reg_date;
	private Date update_date;
	private String nickname;
	
	
	
	public MemberVo() {
		super();
	}
	
	@Override
	public String toString() {
		return "MemberVo [phone_num1=" + phone_num1 + ", phone_num2=" + phone_num2 + ", phone_num3=" + phone_num3
				+ ", email_id=" + email_id + ", email_domain=" + email_domain + ", userid=" + userid + ", userpwd="
				+ userpwd + ", username=" + username + ", email=" + getEmail() + ", phone_num=" + getPhone_num() + ", user_addr="
				+ user_addr + ", reg_date=" + reg_date + ", update_date=" + update_date + ", nickname=" + nickname
				+ "]";
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getEmail_domain() {
		return email_domain;
	}

	public void setEmail_domain(String email_domain) {
		this.email_domain = email_domain;
	}

	public String getPhone_num1() {
		return phone_num1;
	}

	public void setPhone_num1(String phone_num1) {
		this.phone_num1 = phone_num1;
	}

	public String getPhone_num2() {
		return phone_num2;
	}

	public void setPhone_num2(String phone_num2) {
		this.phone_num2 = phone_num2;
	}

	public String getPhone_num3() {
		return phone_num3;
	}

	public void setPhone_num3(String phone_num3) {
		this.phone_num3 = phone_num3;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email_id+"@"+email_domain;
	}
	public void setEmail(String email) {
		String[] emailSplit = email.split("@");
		this.email_id = emailSplit[0];
		this.email_domain = emailSplit[1];
	}
	public String getPhone_num() {
		return phone_num1 + "-" + phone_num2 + "-" + phone_num3;
	}
	public void setPhone_num(String phone_num) {
		String[] phone_num_split = phone_num.split("-");
		this.phone_num1 = phone_num_split[0];
		this.phone_num2 = phone_num_split[1];
		this.phone_num3 = phone_num_split[2];
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
}
