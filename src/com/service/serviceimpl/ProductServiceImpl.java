package com.service.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.productDao;
import com.entity.*;
import com.service.ProductService;

	@Service
public class ProductServiceImpl implements ProductService  {
	
	@Autowired
	private productDao p_D;
	
	
	
	public List<dangdang_category1> selCat1_All(){//一级分类的所有信息
		List<dangdang_category1> list= p_D.selCat1_All();
		return list;	
	}
	
	public List<dangdang_product> selPro_Recommend(){//推荐图书信息
		List<dangdang_product> list = p_D.selPro_Recommend();
		return list;
	}
	
	public List<dangdang_product> selPro_Hot(){//热销图书信息
		List<dangdang_product> list = p_D.selPro_Hot();
		return list;
	}
	
		public List<dangdang_product> selPro_New(){//最新上架
		List<dangdang_product> list = p_D.selPro_New();
		return list;
	}
		
	public List<dangdang_product> selPro_HotBoard(int num){//热销榜
		List<dangdang_product> list = p_D.selPro_HotBoard(num);
		return list;
	}
	
	public List<dangdang_product> selPro_HotBoardMore( int num1,int num2){//更多热榜
		List<dangdang_product> list=p_D.selPro_HotBoardMore(num1, num2);
		return list;
	}
	
	public int selPro_Count() {//图书总数量
		return p_D.selPro_Count();
	}

	@Override
	public List<dangdang_product> selProCat1_Show(int num) {//一级分类下的图书展示
		return p_D.selProCat1_Show(num);
	}

	@Override
	public List<dangdang_product> selProCat2_Show(int num) {//二级分类下的图书展示
		return p_D.selProCat2_Show(num);
	}

	public List<dangdang_product> selProCat_Show(int id,dangdang_product d_p){
		List<dangdang_product> productList = null;
		if(id==0) productList = p_D.selPro_ByNameAndAuthorAndPress(d_p);
			else if(id<10) productList = p_D.selProCat1_Show(id);
				else productList = p_D.selProCat2_Show(id);
		return productList;
	}
	
	public Map<String,Integer> selectCountCategory1(){//一级分类的计数
		List<Map<String, Object>> list = p_D.selProCat1_Count();
		//初始化一级分类Map
		Map<String, Integer> map = new HashMap<String,Integer>();
		for(Map<String, Object> m : list) {
			String  ddCategory1Id = m.get("dd_Cat1_id").toString();	//获取一级分类ID
			int category1Count = Integer.parseInt(m.get("dd_Cat1_Count").toString());//获取一级分类数量
			map.put(ddCategory1Id, category1Count);//放入map
		}
		return map;
	}

	public Map<String,Integer> selectCountCategory2(){//二级分类的计数
		List<Map<String, Object>> list = p_D.selProCat2_Count();
		//初始化一级分类Map
		Map<String, Integer> map = new HashMap<String,Integer>();
		for(Map<String, Object> m : list) {
			String  ddCategory1Id = m.get("dd_Cat2_id").toString();	//获取一级分类ID
			int category1Count = Integer.parseInt(m.get("dd_Cat2_Count").toString());//获取一级分类数量
			map.put(ddCategory1Id, category1Count);//放入map
		}
		return map;
	}
	
	
	public dangdang_product selPro_ById(int num) {//查询指定id的图书信息
		return p_D.selPro_ById(num);
	}

	@Override
	public List<dangdang_product> 
	selPro_ByNameAndAuthorAndPress(dangdang_product d_p) {//根据图书名称，作者，出版社查找指定图书(搜索框功能)
		return p_D.selPro_ByNameAndAuthorAndPress(d_p);
	}

	@Override
	public List<String> selPro_GroupByPress() {//分组查询出版社(去重)
		return p_D.selPro_GroupByPress();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	