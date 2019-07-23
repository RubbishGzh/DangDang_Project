package com.entity;

import java.util.List;

public class dangdang_category1 {

	
	  private int dd_category1_id;//一级分类id(序号)
	  private String dd_category1_name;//一级分类名称
	  private String dd_category1_create_date;//创建时间
	  private Integer dd_Category1Count;//一级分类计数
	  private List<dangdang_category2> dangdang_category2;//c2
		public dangdang_category1() {}
	 
	  @Override public String toString() { return
	  "dangdang_category1 [dd_category1_id=" + dd_category1_id +
	  ", dd_category1_name=" + dd_category1_name + ", dd_category1_create_date=" +
	  dd_category1_create_date + ", dangdang_category2=" + dangdang_category2 +
	  "]"; }
	 

	public dangdang_category1(int dd_category1_id, String dd_category1_name, String dd_category1_create_date,
			List<dangdang_category2> dangdang_category2) {
		super();
		this.dd_category1_id = dd_category1_id;
		this.dd_category1_name = dd_category1_name;
		this.dd_category1_create_date = dd_category1_create_date;
		this.dangdang_category2 = dangdang_category2;
	}

    public int getDd_Category1Count() {
		return dd_Category1Count;
	}

	public void setDd_Category1Count(int dd_Category1Count) {
		this.dd_Category1Count = dd_Category1Count;
	}

	public int getDd_category1_id() {
		return dd_category1_id;
	}
	public void setDd_category1_id(int dd_category1_id) {
		this.dd_category1_id = dd_category1_id;
	}
	public String getDd_category1_name() {
		return dd_category1_name;
	}
	public void setDd_category1_name(String dd_category1_name) {
		this.dd_category1_name = dd_category1_name;
	}
	public String getDd_category1_create_date() {
		return dd_category1_create_date;
	}
	public void setDd_category1_create_date(String dd_category1_create_date) {
		this.dd_category1_create_date = dd_category1_create_date;
	}
	public List<dangdang_category2> getDangdang_category2() {
		return dangdang_category2;
	}
	public void setDangdang_category2(List<dangdang_category2> dangdang_category2) {
		this.dangdang_category2 = dangdang_category2;
	}
	
}
