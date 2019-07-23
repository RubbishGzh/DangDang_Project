package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.*;
import com.service.*;

@Controller
@RequestMapping("CartController")
public class CartController {

	@Autowired 
	private CartService cartservice;//购物车service
	
	@Autowired 
	private ProductService productservice;//商品service(使用里面的根据id查找图书的方法)
	
	private List<dangdang_book> cart = new ArrayList<dangdang_book>();//用来存放购物车里的商品数据
	
	
	//添加商品
	@RequestMapping("/cart_AddBook")   
	public String cart_AddBook(int id,HttpSession session) throws Exception {
		dangdang_product i = productservice.selPro_ById(id);				//根据id获取图书的信息
		dangdang_book d_book = new dangdang_book();							//新建存放购物车图书信息的对象
		d_book.setBookName(i.getDd_product_name());
		d_book.setBookImg(i.getDd_product_img());
		d_book.setBookId(i.getDd_product_id());
		d_book.setBookPrice(i.getDd_product_price());
		d_book.setBookDdprice(i.getDd_product_ddprice());					//将图书信息实体类(dangdang_product)的数据存放到购物车图书实体类(dangdang_book)中去
		List<dangdang_book> cartList = cartservice.addCart(cart, d_book);	//生成购物车(每次调用添加商品controller时,将一个商品的信息添加至购物车)
		session.setAttribute("cartList",cartList);							//将购物车放入session
		return "forward:/cart/cart_list.jsp";
	}
	
	//计算价格
	@RequestMapping("/getCart") 
	@ResponseBody
	public Map<String, Double> getCart(HttpSession session) throws Exception{
		List<dangdang_book> list = cartservice.getCart(session);//获取购物车
		Map<String, Double> map = cartservice.countPrice(list);//计算商品的市场价格和当当价格的总和
		session.setAttribute("totalDDPrice", map.get("totalDDPrice"));
			return map;
	}
	
	//变更购物车图书数量
	@RequestMapping("/setBookCount")
	@ResponseBody
	public boolean setBookCount(HttpSession session,int id,int count) throws Exception{//count是用户在jsp界面输入的值
		List<dangdang_book> cartList = cartservice.getCart(session);//获取购物车
		for(dangdang_book d_b:cartList) {//遍历购物车
			 if(id==d_b.getBookId()) {//匹配购物车中的商品id
				 d_b.setBookCount(count);//将用户输入的值(数量)添加至指定的购物车中的商品内
			 }
		}
			return true;
	}
	
	
	@RequestMapping("/deleteBook")//移动至恢复区
	public String deleteBook(int id,HttpSession session) throws Exception{
		List<dangdang_book> list = cartservice.getCart(session);//获取购物车
		dangdang_book d_book = new dangdang_book();//新建购物车商品对象d_book
		for(int i=0;i<list.size();i++) {//遍历购物车
			if(list.get(i).getBookId()==id) {//如果购物车里的商品id与删除按钮获取的id相同
				d_book = list.get(i);//使d_book获取删除的商品
				list.remove(i);//删除购物车中指定的商品
			}
		}
		List<dangdang_book> cartList = cartservice.removeToStore(session, d_book);
		
		session.setAttribute("cartList2",cartList);
		return "forward:/cart/cart_list.jsp";
	}
	
	
	@RequestMapping("/removeBook") //图书的彻底删除
	public String removeBook(int id,HttpSession session) throws Exception{
		List<dangdang_book> list = (List<dangdang_book>) session.getAttribute("cartList2");
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getBookId()==id) {
				list.remove(i);
			}
		}
		return "forward:/cart/cart_list.jsp";
	}
	
	@RequestMapping("/restoreBook")//从恢复区恢复图书
	public String restoreBook(int id,HttpSession session) throws Exception{
		List<dangdang_book> list = cartservice.getCart(session);//获取购物车
		List<dangdang_book> list2 = (List<dangdang_book>) session.getAttribute("cartList2");//获取恢复区
			for(int i=0;i<list2.size();i++) {
				if(list2.get(i).getBookId()==id) {
					cartservice.addCart(list,list2.get(i));
					list2.remove(i);
				}
			}
		return "forward:/cart/cart_list.jsp";
	}
}








