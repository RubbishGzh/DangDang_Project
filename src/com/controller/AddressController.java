package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.*;
import com.service.*;


@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private OrderService orderService;
	
	//保存收货地址
	@RequestMapping("/insertAddress")
	@ResponseBody
	public boolean insertAddress(DangDangAddress address,HttpSession session) {
		//获取用户id
		dangdang_user user = (dangdang_user) session.getAttribute("users");
		if(user == null) {
			return false;
		}
		int userId = user.getDd_user_id();
		address.setDdUserId(userId);
		orderService.insAddress_All(address);
		return true;
	}
	
	//查询收货地址
	@RequestMapping("/queryAddress")
	@ResponseBody
	public List<DangDangAddress> queryAddress(HttpSession session){
		//获取用户id
		dangdang_user user = (dangdang_user) session.getAttribute("users");
		if(user == null) {
			return null;
		}
		int userId = user.getDd_user_id();
		List<DangDangAddress> list = orderService.selAdd_ByAddressIdAndUserId(0, userId);
		return list;
	}
	
	//选择地址事件
	@RequestMapping("/addressChange")
	@ResponseBody
	public DangDangAddress addressChange(int addressId) {
		DangDangAddress address = orderService.selAdd_ByAddressIdAndUserId(addressId, 0).get(0);
		return address;
	}
	
}
