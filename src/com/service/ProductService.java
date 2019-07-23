package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.entity.*;

public interface ProductService{
	
	public List<String> selPro_GroupByPress();//分组查询出版社(去重)
	public List<dangdang_category1> selCat1_All();//一级分类的所有信息
	public List<dangdang_product> selPro_Recommend();//推荐图书信息
	public List<dangdang_product> selPro_Hot();//热销图书信息
	public List<dangdang_product> selPro_New();//最新上架
	public List<dangdang_product> selPro_HotBoard(int num);//热销榜
	public List<dangdang_product> selPro_HotBoardMore( int num1,int num2);//更多热榜
	public int selPro_Count();//图书总数量
	public Map<String,Integer> selectCountCategory1();//一级分类的计数
	public Map<String,Integer> selectCountCategory2();//二级分类的计数
	public List<dangdang_product> selProCat1_Show( int num);//一级分类下的图书展示
	public List<dangdang_product> selProCat2_Show(int num);//二级分类下的图书展示
	public dangdang_product selPro_ById(int num);//查询指定id的图书信息
	public List<dangdang_product> selPro_ByNameAndAuthorAndPress(dangdang_product d_p);//根据图书名称，作者，出版社查找指定图书(搜索框功能)
	public List<dangdang_product> selProCat_Show(int id,dangdang_product d_p);//图书的分类展示
}
