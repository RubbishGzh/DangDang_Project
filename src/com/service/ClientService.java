package com.service;

import java.util.List;
import com.entity.dangdang_user;

public interface ClientService {
	public dangdang_user selUser_ById(String dd_user_email,String dd_user_password);//登陆
	public boolean ins_DdUser(dangdang_user du);//注册(数据插入)
	public List<dangdang_user> selUser_All();//查询所有用户数据
	
}
