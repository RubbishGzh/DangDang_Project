package com.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.entity.dangdang_book;

public interface CartService {
	public List<dangdang_book> getCart(HttpSession session);						  //获取购物车
	public List<dangdang_book> addCart(List<dangdang_book> cart,dangdang_book book);  //购物车添加
	public Map<String,Double> countPrice(List<dangdang_book> cartList);				  //计算购物车内商品价格
	public List<dangdang_book> removeToStore(HttpSession session,dangdang_book book); //删除到恢复区
	
	
}
