package com.service.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.clientDao;
import com.entity.dangdang_user;
import com.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private clientDao c_D;
	
	public dangdang_user selUser_ById(String dd_user_email,String dd_user_password) {//登陆
		return  c_D.selUser_ById(dd_user_email, dd_user_password);
		
	}
	
	public boolean ins_DdUser(dangdang_user du) {//注册(数据插入)
		return c_D.ins_DdUser(du);
	}
	
	public List<dangdang_user> selUser_All(){//查询所有用户数据
		return  c_D.selUser_All();
	}

}
