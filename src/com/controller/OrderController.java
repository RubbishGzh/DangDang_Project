package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.*;

import com.service.*;
import com.util.GeneralUtil;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	//生成订单，地址，订单详情条目
	@RequestMapping("/createOrder")
	@ResponseBody
	public boolean createOrder(HttpSession session,DangDangAddress address) {
		//获取总价
		double totalDDPrice = (double) session.getAttribute("totalDDPrice");
		//获取用户id
		dangdang_user user = (dangdang_user) session.getAttribute("users");
		System.out.println("订单");
		System.out.println(user);
		//非空判断
		if(user == null) {
			return false;
		}
		int userId = user.getDd_user_id();
		//获取购物车
		List<dangdang_book> cartList = (List<dangdang_book>) session.getAttribute("cartList");
		//生成订单号uuid
		String orderSSID = GeneralUtil.getUUID();
		//生成订单条目
		
		orderService.insOrder_All(orderSSID,totalDDPrice, userId);
		//生成地址条目
		//address.setDdUserId(userId);
		//addressService.insertAddress(address);
		//生成订单详情条目
		orderService.createOrderDetail(address, user,orderSSID,cartList);
		//存入订单号到session
		session.setAttribute("orderSSID", orderSSID);
		return true;
	}
}
