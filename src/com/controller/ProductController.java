package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.*;
import com.service.ProductService;

@RequestMapping("ProductController")
@Controller
public class ProductController {

	@Autowired 
	private ProductService productservice;


	@RequestMapping("/category/selectCategory")  //图书分类的所有信息
	public String selectCategory(Model model) throws Exception {
		List<dangdang_category1> list = productservice.selCat1_All();
		model.addAttribute("list", list);
		return "forward:/main/category.jsp";	
	}

	@RequestMapping("/product/selectRecommed")  //推荐图书
	public String selectRecommed(Model model) throws Exception {
		List<dangdang_product> list = productservice.selPro_Recommend();
		model.addAttribute("list", list);
		return "forward:/main/recommend.jsp";	
	}

	@RequestMapping("product/selectHot")  //热销图书
	public String selectHot(Model model) throws Exception {
		List<dangdang_product> list = productservice.selPro_Hot();
		model.addAttribute("list", list);
		return "forward:/main/hot.jsp";	
	}

	@RequestMapping("product/selectNew")  //最新上架图书
	public String selectNew(Model model) throws Exception {
		List<dangdang_product> list = productservice.selPro_New();
		model.addAttribute("list", list);
		return "forward:/main/new.jsp";	
	}

	@RequestMapping("product/selPro_HotBoard")  //热销图书榜
	public String selPro_HotBoard(Model model) throws Exception {
		List<dangdang_product> list = productservice.selPro_HotBoard(6);
		model.addAttribute("list", list);
		return "forward:/main/hotBoard.jsp";	
	}

	@RequestMapping("product/selectHotBoardMore")  //热销图书加载更多
	@ResponseBody
	public List<dangdang_product> selectHotBoardMore(Model model) throws Exception {
		int Hot_Num=6;
		List<dangdang_product> list = productservice.selPro_HotBoardMore(Hot_Num+=1,Hot_Num+=15);
		//model.addAttribute("list", list);
		return list;	
	}

	@RequestMapping("product/selectProductAndCategory")  //图书展示页面的分类预览的显示与显示数量
	public String selectProductAndCategory(Model model, int id,String ddproductname,String ddproductauthor,String ddproductpress) throws Exception {

		Map<String,Integer> c1Map = productservice.selectCountCategory1();
		Map<String,Integer> c2Map = productservice.selectCountCategory2();
		
		dangdang_product dd_p = new dangdang_product(ddproductname,ddproductauthor,ddproductpress);
		List<dangdang_product> productList = productservice.selProCat_Show(id,dd_p);
		List<dangdang_category1> categorylist = productservice.selCat1_All();
		List<String> ListPro_Press = productservice.selPro_GroupByPress();//分组查询出版社(去重)
		int totalCategoryCount = 0;
		for(dangdang_category1 c1:categorylist) {
			String category1Id = String.valueOf(c1.getDd_category1_id());
			Integer category1Count = c1Map.get(category1Id);
			if(category1Count == null) category1Count = 0;
			totalCategoryCount = totalCategoryCount+category1Count;
			c1.setDd_Category1Count(category1Count);
			for(dangdang_category2 c2:c1.getDangdang_category2()) {
				String category2Id = String.valueOf(c2.getDd_category2_id());	
				Integer category2Count = c2Map.get(category2Id);
				if(category2Count == null) {category2Count = 0;}
				c2.setDd_Category2Count(category2Count);
			}

		}
		
		model.addAttribute("ListPro_Press", ListPro_Press);//放入出版社信息
		model.addAttribute("productList", productList);
		//放入分类list
		model.addAttribute("categoryList", categorylist);
		//放入选中id
		model.addAttribute("chooseId", id);
		//放入全部分类量
		model.addAttribute("bookCount", totalCategoryCount);
		return "forward:/main/book_list.jsp";	
	}

	@RequestMapping("product/productshow")  //图书详情页面的展示
	public String productshow(Model model,int ddProId) throws Exception {
		dangdang_product  product =productservice.selPro_ById(ddProId);
		model.addAttribute("product", product);
		return "forward:/main/product.jsp";	
	}

	@RequestMapping("product/productsearch")  //搜索图书
	public String productsearch(Model model,dangdang_product dd_p){

		List<dangdang_product> list = productservice.selPro_ByNameAndAuthorAndPress(dd_p);
		model.addAttribute("productList",list);
		return "forward:/main/book_list.jsp";	

	}
}











