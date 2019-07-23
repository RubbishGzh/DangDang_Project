package com.entity;

public class dangdang_category2 {
	
	private int dd_category2_id;//二级分类id(序号)
	private String dd_category2_name;//一级分类名称
	private int dd_category1_id;//一级分类id
	private Integer dd_Category2Count;//二级分类计数
	private String dd_category2_create_date;//创建时间
	
	public dangdang_category2() {}
	
	public dangdang_category2(int dd_category2_id, String dd_category2_name, int dd_category1_id,
			String dd_category2_create_date) {
		super();
		this.dd_category2_id = dd_category2_id;
		this.dd_category2_name = dd_category2_name;
		this.dd_category1_id = dd_category1_id;
		this.dd_category2_create_date = dd_category2_create_date;
	}

	@Override
	public String toString() {
		return "dangdang_category2 [dd_category2_id=" + dd_category2_id + ", dd_category2_name=" + dd_category2_name
				+ ", dd_category1_id=" + dd_category1_id + ", dd_category2_create_date=" + dd_category2_create_date
				+ "]";
	}

	public Integer getDd_Category2Count() {
		return dd_Category2Count;
	}

	public void setDd_Category2Count(Integer dd_Category2Count) {
		this.dd_Category2Count = dd_Category2Count;
	}
	
	  public int getDd_category2_id() {
		return dd_category2_id;
	}
	public void setDd_category2_id(int dd_category2_id) {
		this.dd_category2_id = dd_category2_id;
	}
	public String getDd_category2_name() {
		return dd_category2_name;
	}
	public void setDd_category2_name(String dd_category2_name) {
		this.dd_category2_name = dd_category2_name;
	}
	public int getDd_category1_id() {
		return dd_category1_id;
	}
	public void setDd_category1_id(int dd_category1_id) {
		this.dd_category1_id = dd_category1_id;
	}
	public String getDd_category2_create_date() {
		return dd_category2_create_date;
	}
	public void setDd_category2_create_date(String dd_category2_create_date) {
		this.dd_category2_create_date = dd_category2_create_date;
	}

}
