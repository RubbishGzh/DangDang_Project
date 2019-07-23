package com.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.*;
import com.service.ClientService;
import com.service.OrderService;
import com.service.ProductService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/applicationContext.xml"})
public class TestJunit {
	  
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ProductService productservice;
			
	@Autowired
	private OrderService orderservice;
	
	@Test
	public void method1() throws Exception{//登陆测试dangdanguser
		dangdang_user du = clientService.selUser_ById("user","123456");
		System.out.println(du);
	}
	
	@Test
	public void method2() throws Exception{//注册测试dangdanguser
		dangdang_user du = new dangdang_user();
		du.setDd_user_email("2567640999@qq.com");
		du.setDd_user_nickname("郭志航");
		du.setDd_user_password("123456");
		boolean x  = clientService.ins_DdUser(du);
		System.out.println(x);
	}
	
	@Test
	public void method3() throws Exception{//查询所有用户数据
		
		List<dangdang_user> list = clientService.selUser_All();

		for(dangdang_user item:list) {
			System.out.println(item);
		}
	}
	
	@Test
	public void method4() throws Exception{//一级分类的所有信息
		
		List<dangdang_category1> list = productservice.selCat1_All();
		for(dangdang_category1 item:list) {
			System.out.println(item.getDd_category1_id());
			for(dangdang_category2 x:item.getDangdang_category2()) {
				System.out.println(x);
			}
		}
	}
	
	@Test
	public void method5() throws Exception{//推荐图书信息测试
		
		List<dangdang_product> list = productservice.selPro_Recommend();
		for(dangdang_product item:list) {
			System.out.println(item);
		}
	}
	
	@Test
	public void method6() throws Exception{//热销图书信息测试
		
		List<dangdang_product> list = productservice.selPro_Hot();
		for(dangdang_product item:list) {
			System.out.println(item);
		}
	}
	@Test
	public void method7() throws Exception{//热销图书信息测试
		
		List<dangdang_product> list = productservice.selPro_New();
		for(dangdang_product item:list) {
			System.out.println(item);
		}
	}
	
	@Test
	public void method8() throws Exception{//热销榜测试
		
		List<dangdang_product> list = productservice.selPro_HotBoard(6);
		for(dangdang_product item:list) {
			System.out.println(item);
		}
	}
	
	@Test
	public void method9() throws Exception{//更多热榜
		
		List<dangdang_product> list = productservice.selPro_HotBoardMore(7, 13);
		for(dangdang_product item:list) {
			System.out.println(item);
		}
	}
	
	@Test
	public void method10() throws Exception{//图书总数量
	int i = productservice.selPro_Count();
	System.out.println(i);
	}
	

	@Test
	public void method13() throws Exception{//一级分类下的图书展示
		List<dangdang_product> list = productservice.selProCat1_Show(1);
		for(dangdang_product i:list) {
			System.out.println(i);
		}
	}
	
	@Test
	public void method14() throws Exception{//二级分类下的图书展示
		List<dangdang_product> list = productservice.selProCat2_Show(101);
		for(dangdang_product i:list) {
			System.out.println(i);
		}
	}
	
	@Test
	public void method15() throws Exception{//一级分类的计数
		Map<String, Integer> map = productservice.selectCountCategory1();
		System.out.println(map);
	}
	
	@Test
	public void method16() throws Exception{//二级分类的计数
		Map<String, Integer> map = productservice.selectCountCategory2();
		System.out.println(map);
	}
	
	@Test
	public void method17() throws Exception{//根据图书名称，作者，出版社查找指定图书(搜索框功能)
		dangdang_product d_p = new dangdang_product();
		//d_p.setDd_product_author("carey");
		//d_p.setDd_product_name("的");
		//d_p.setDd_product_press("猎豹");
	List<dangdang_product> list = productservice.selPro_ByNameAndAuthorAndPress(d_p);
		for(dangdang_product item:list) {
			System.out.println(item);
		}
	}	
	
	@Test
	public void method18() throws Exception{//分组查询出版社(去重)
		List<String> list = productservice.selPro_GroupByPress();
		for(String d:list) {
			System.out.println(d);
		}
	
	}
	
	@Test
	public void method127() throws Exception{//图书的分类展示
		dangdang_product dd_p = new dangdang_product("女","carey","小象");
		List<dangdang_product> i = productservice.selProCat_Show(0, dd_p);
		for(dangdang_product x:i) {
			System.out.println(x);
		}
		
	}	
	
	@Test
	public void method19() throws Exception{//order订单三张表的sql通过测试
	List<DangDangAddress> address = orderservice.selAddress_All();
	List<DangDangOrder> order = orderservice.selOrder_All();
	List<DangDangOrderDetail> detail = orderservice.selOrderDetail_All();
	
	System.out.println("这是address表的数据：");
	for(DangDangAddress i:address)
		System.out.println(i);
	
	System.out.println();
	System.out.println("这是order表的数据");
	for(DangDangOrder i:order)
		System.out.println(i);
	
	System.out.println();
	System.out.println("这是detail表的数据");
	for(DangDangOrderDetail i:detail)
		System.out.println(i);
	}	
	
	@Test
	public void method20() throws Exception{//Address表的查询
		List<DangDangAddress> list = orderservice.selAdd_ByAddressIdAndUserId(1,123);
		for(DangDangAddress i:list) {
			System.out.println(i);
		}
	}

	@Test
	public void method21() throws Exception{//address表的插入
		DangDangAddress address = 
				new DangDangAddress("测试二","测试二","测试二","测试二",123,123,null);
		orderservice.insAddress_All(address);
	}
	
	@Test
	public void method22() throws Exception{//order表生成订单
		int i = orderservice.insOrder_All("测试二",123,123);
		System.out.println(i);
	}
	
	@Test
	public void method23() throws Exception{//orderDetail表的数据插入
		DangDangOrderDetail orderDetail = new DangDangOrderDetail(123,123,123,"测试二",123,123,"测试二");
		int i = orderservice.insOrderDetail_All(orderDetail);
		System.out.println(i);
	}
}











