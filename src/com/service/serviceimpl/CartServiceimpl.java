package com.service.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import com.entity.dangdang_book;
import com.service.CartService;

@Service
public class CartServiceimpl implements CartService{
	 
	//获取购物车
	public List<dangdang_book> getCart(HttpSession session){	
		List<dangdang_book> cartList=null;								  //初始化购物车
		cartList = (List<dangdang_book>) session.getAttribute("cartList");//尝试获取session中的购物车
		if(cartList == null) { 											  //如果购物车是空，就创建
			cartList = new ArrayList<dangdang_book>();
			}
		return cartList;												  //如果不是空,就直接使用
	}
	
	//购物车添加
	public List<dangdang_book> addCart(List<dangdang_book> cart,dangdang_book book){
		int bookId = book.getBookId();									  //获取图书id
		for(dangdang_book b : cart) {		
			if(bookId == b.getBookId()) {  								  //表示商品重复
				int count = b.getBookCount();//不添加商品,仅叠加数量
				b.setBookCount(++count);
				return cart;
			}
		}
		int bookCount = book.getBookCount();
		if(bookCount == 0) 											      //判断是否是新书
			{book.setBookCount(1);}										  //新书数量置1
		else 
			{book.setBookCount(bookCount);
			}								  //恢复原数量
		cart.add(book);													  //无重复,添加该图书
		return cart;
	}
	
	
	//计算购物车内商品价格
	public Map<String,Double> countPrice(List<dangdang_book> cartList){
		HashMap<String, Double> map = new HashMap<String,Double>();   	  //初始化反参
		double totalPrice = 0.0;								          //初始化市场总价
		double totalDDPrice = 0.0;										  //初始化当当总价
		if(cartList != null) {
			for(dangdang_book book : cartList) {
				totalPrice = totalPrice + book.getBookPrice()*book.getBookCount();
				totalDDPrice = totalDDPrice + book.getBookDdprice()*book.getBookCount();
				}
		}
		map.put("totalPrice", totalPrice);
		map.put("totalDDPrice", totalDDPrice);
		return map;
	}
		
	//删除到恢复区
	public List<dangdang_book> removeToStore(HttpSession session,dangdang_book book){
		List<dangdang_book> cartList2 = null;							  //初始化恢复区
		cartList2 = (List<dangdang_book>)session.getAttribute("cartList2");//尝试获取session中的购物车
		if(cartList2 == null) {
			cartList2 = new ArrayList<dangdang_book>();
			}
			
		for(dangdang_book b : cartList2) {							  	//重复，叠加数量
			if(book.getBookId() == b.getBookId()) {						//表示商品重复		
				int count = b.getBookCount();							//不删除商品,仅叠加数量
				b.setBookCount(count+book.getBookCount());
				return cartList2;
			}
		}
			
			if(book.getBookId()!=0)
			cartList2.add(book);										//不重复，直接添加
			return cartList2;
	}
}
