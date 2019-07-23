package com.entity;

public class dangdang_user {//dangdang网用户表

	private int  dd_user_id;//主键
	private String dd_user_email;//账号
	private String dd_user_password;//密码
	private String dd_user_nickname;//昵称
	private int dd_user_state;//用户状态
	private String dd_user_salt;//盐值
	private String dd_user_role;//角色
	private String dd_user_create_date;//时间戳 
	
	@Override
	public String toString() {
		return "dangdang_user [dd_user_id=" + dd_user_id + ", dd_user_email=" + dd_user_email + ", dd_user_password="
				+ dd_user_password + ", dd_user_nickname=" + dd_user_nickname + ", dd_user_state=" + dd_user_state
				+ ", dd_user_salt=" + dd_user_salt + ", dd_user_role=" + dd_user_role + ", dd_user_create_date="
				+ dd_user_create_date + "]";
	}

	public dangdang_user() {}

	public dangdang_user(int dd_user_id, String dd_user_email, String dd_user_password, String dd_user_nickname,
			int dd_user_state, String dd_user_salt, String dd_user_role, String dd_user_create_date) {
		super();
		this.dd_user_id = dd_user_id;
		this.dd_user_email = dd_user_email;
		this.dd_user_password = dd_user_password;
		this.dd_user_nickname = dd_user_nickname;
		this.dd_user_state = dd_user_state;
		this.dd_user_salt = dd_user_salt;
		this.dd_user_role = dd_user_role;
		this.dd_user_create_date = dd_user_create_date;
	}
	public int getDd_user_id() {
		return dd_user_id;
	}
	public void setDd_user_id(int dd_user_id) {
		this.dd_user_id = dd_user_id;
	}
	public String getDd_user_email() {
		return dd_user_email;
	}
	public void setDd_user_email(String dd_user_email) {
		this.dd_user_email = dd_user_email;
	}
	public String getDd_user_password() {
		return dd_user_password;
	}
	public void setDd_user_password(String dd_user_password) {
		this.dd_user_password = dd_user_password;
	}
	public String getDd_user_nickname() {
		return dd_user_nickname;
	}
	public void setDd_user_nickname(String dd_user_nickname) {
		this.dd_user_nickname = dd_user_nickname;
	}
	public int getDd_user_state() {
		return dd_user_state;
	}
	public void setDd_user_state(int dd_user_state) {
		this.dd_user_state = dd_user_state;
	}
	public String getDd_user_salt() {
		return dd_user_salt;
	}
	public void setDd_user_salt(String dd_user_salt) {
		this.dd_user_salt = dd_user_salt;
	}
	public String getDd_user_role() {
		return dd_user_role;
	}
	public void setDd_user_role(String dd_user_role) {
		this.dd_user_role = dd_user_role;
	}
	public String getDd_user_create_date() {
		return dd_user_create_date;
	}
	public void setDd_user_create_date(String dd_user_create_date) {
		this.dd_user_create_date = dd_user_create_date;
	}

	
}
