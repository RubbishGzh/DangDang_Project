package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.*;

public interface clientDao {
	
	public dangdang_user selUser_ById//根据email和密码查找用户
		(@Param("dd_user_email")String dd_user_email,@Param("dd_user_password")String dd_user_password);
	
	public boolean ins_DdUser(@Param("dangdang_user") dangdang_user du);//dangdang_user表数据的插入
	
	public List<dangdang_user> selUser_All();//查询dangdang_user表中所有的数据
}
