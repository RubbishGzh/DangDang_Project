package com.entity;

public class dangdang_product {
	
	  private int 		  dd_product_id           ;//主键
	  private String	  dd_product_name         ;//图书名称
	  private String	  dd_product_author       ;//作者
	  private String	  dd_product_img          ;//图片路径
	  private String	  dd_product_press        ;//出版社
	  private String	  dd_product_presstime    ;//出版时间
	  private String	  dd_product_edition      ;//版本号
	  private String	  dd_product_printtime    ;//印刷时间
	  private int	      dd_product_printcount   ;//印刷数量
	  private String	  dd_product_isbn         ;//ISBN
	  private String	  dd_product_wordcount    ;//总字数
	  private String	  dd_product_pagecount    ;//总页数
	  private String	  dd_product_format       ;//页面规格
	  private String	  dd_product_paper        ;//纸张
	  private String	  dd_product_pack         ;//包装
	  private int	      dd_product_price        ;//定价
	  private int	      dd_product_ddprice      ;//当当价
	  private int	      dd_product_count    	  ;//图书销量 
	  private String	  dd_product_addtime      ;//上架时间
	  private String	  dd_product_recommend    ;//推荐评语
	  private String	  dd_product_brief        ;//图书简介
	  private String	  dd_product_authorbrief  ;//作者简介
	  private String	  dd_product_directory    ;//目录
	  private String	  dd_product_mediacomment ;//视频推荐
	  private String	  dd_product_excerpt      ;//图书标记
	  private int	      dd_category2_id 	      ;//图书分类，分类2外键
	  private String	  dd_product_create_date  ;//时间戳
	
	  @Override
	public String toString() {
		return "dangdang_product [dd_product_id=" + dd_product_id + ", dd_product_name=" + dd_product_name
				+ ", dd_product_author=" + dd_product_author + ", dd_product_img=" + dd_product_img
				+ ", dd_product_press=" + dd_product_press + ", dd_product_presstime=" + dd_product_presstime
				+ ", dd_product_edition=" + dd_product_edition + ", dd_product_printtime=" + dd_product_printtime
				+ ", dd_product_printcount=" + dd_product_printcount + ", dd_product_isbn=" + dd_product_isbn
				+ ", dd_product_wordcount=" + dd_product_wordcount + ", dd_product_pagecount=" + dd_product_pagecount
				+ ", dd_product_format=" + dd_product_format + ", dd_product_paper=" + dd_product_paper
				+ ", dd_product_pack=" + dd_product_pack + ", dd_product_price=" + dd_product_price
				+ ", dd_product_ddprice=" + dd_product_ddprice + ", dd_product_count=" + dd_product_count
				+ ", dd_product_addtime=" + dd_product_addtime + ", dd_product_recommend=" + dd_product_recommend
				+ ", dd_product_brief=" + dd_product_brief + ", dd_product_authorbrief=" + dd_product_authorbrief
				+ ", dd_product_directory=" + dd_product_directory + ", dd_product_mediacomment="
				+ dd_product_mediacomment + ", dd_product_excerpt=" + dd_product_excerpt + ", dd_category2_id="
				+ dd_category2_id + ", dd_product_create_date=" + dd_product_create_date + "]";
	}
	  
    public dangdang_product() {}
    
    public dangdang_product(String dd_product_name,String dd_product_author,String dd_product_press) {
    	this.dd_product_name = dd_product_name;
    	this.dd_product_author = dd_product_author;
    	this.dd_product_press = dd_product_press;
    }
    
	public dangdang_product(int dd_product_id, String dd_product_name, String dd_product_author, String dd_product_img,
			String dd_product_press, String dd_product_presstime, String dd_product_edition,
			String dd_product_printtime, int dd_product_printcount, String dd_product_isbn, String dd_product_wordcount,
			String dd_product_pagecount, String dd_product_format, String dd_product_paper, String dd_product_pack,
			int dd_product_price, int dd_product_ddprice, int dd_product_count, String dd_product_addtime,
			String dd_product_recommend, String dd_product_brief, String dd_product_authorbrief,
			String dd_product_directory, String dd_product_mediacomment, String dd_product_excerpt, int dd_category2_id,
			String dd_product_create_date) {
		super();
		this.dd_product_id = dd_product_id;
		this.dd_product_name = dd_product_name;
		this.dd_product_author = dd_product_author;
		this.dd_product_img = dd_product_img;
		this.dd_product_press = dd_product_press;
		this.dd_product_presstime = dd_product_presstime;
		this.dd_product_edition = dd_product_edition;
		this.dd_product_printtime = dd_product_printtime;
		this.dd_product_printcount = dd_product_printcount;
		this.dd_product_isbn = dd_product_isbn;
		this.dd_product_wordcount = dd_product_wordcount;
		this.dd_product_pagecount = dd_product_pagecount;
		this.dd_product_format = dd_product_format;
		this.dd_product_paper = dd_product_paper;
		this.dd_product_pack = dd_product_pack;
		this.dd_product_price = dd_product_price;
		this.dd_product_ddprice = dd_product_ddprice;
		this.dd_product_count = dd_product_count;
		this.dd_product_addtime = dd_product_addtime;
		this.dd_product_recommend = dd_product_recommend;
		this.dd_product_brief = dd_product_brief;
		this.dd_product_authorbrief = dd_product_authorbrief;
		this.dd_product_directory = dd_product_directory;
		this.dd_product_mediacomment = dd_product_mediacomment;
		this.dd_product_excerpt = dd_product_excerpt;
		this.dd_category2_id = dd_category2_id;
		this.dd_product_create_date = dd_product_create_date;
	}


	public int getDd_product_id() {
		return dd_product_id;
	}
	public void setDd_product_id(int dd_product_id) {
		this.dd_product_id = dd_product_id;
	}
	public String getDd_product_name() {
		return dd_product_name;
	}
	public void setDd_product_name(String dd_product_name) {
		this.dd_product_name = dd_product_name;
	}
	public String getDd_product_author() {
		return dd_product_author;
	}
	public void setDd_product_author(String dd_product_author) {
		this.dd_product_author = dd_product_author;
	}
	public String getDd_product_img() {
		return dd_product_img;
	}
	public void setDd_product_img(String dd_product_img) {
		this.dd_product_img = dd_product_img;
	}
	public String getDd_product_press() {
		return dd_product_press;
	}
	public void setDd_product_press(String dd_product_press) {
		this.dd_product_press = dd_product_press;
	}
	public String getDd_product_presstime() {
		return dd_product_presstime;
	}
	public void setDd_product_presstime(String dd_product_presstime) {
		this.dd_product_presstime = dd_product_presstime;
	}
	public String getDd_product_edition() {
		return dd_product_edition;
	}
	public void setDd_product_edition(String dd_product_edition) {
		this.dd_product_edition = dd_product_edition;
	}
	public String getDd_product_printtime() {
		return dd_product_printtime;
	}
	public void setDd_product_printtime(String dd_product_printtime) {
		this.dd_product_printtime = dd_product_printtime;
	}
	public int getDd_product_printcount() {
		return dd_product_printcount;
	}
	public void setDd_product_printcount(int dd_product_printcount) {
		this.dd_product_printcount = dd_product_printcount;
	}
	public String getDd_product_isbn() {
		return dd_product_isbn;
	}
	public void setDd_product_isbn(String dd_product_isbn) {
		this.dd_product_isbn = dd_product_isbn;
	}
	public String getDd_product_wordcount() {
		return dd_product_wordcount;
	}
	public void setDd_product_wordcount(String dd_product_wordcount) {
		this.dd_product_wordcount = dd_product_wordcount;
	}
	public String getDd_product_pagecount() {
		return dd_product_pagecount;
	}
	public void setDd_product_pagecount(String dd_product_pagecount) {
		this.dd_product_pagecount = dd_product_pagecount;
	}
	public String getDd_product_format() {
		return dd_product_format;
	}
	public void setDd_product_format(String dd_product_format) {
		this.dd_product_format = dd_product_format;
	}
	public String getDd_product_paper() {
		return dd_product_paper;
	}
	public void setDd_product_paper(String dd_product_paper) {
		this.dd_product_paper = dd_product_paper;
	}
	public String getDd_product_pack() {
		return dd_product_pack;
	}
	public void setDd_product_pack(String dd_product_pack) {
		this.dd_product_pack = dd_product_pack;
	}
	public int getDd_product_price() {
		return dd_product_price;
	}
	public void setDd_product_price(int dd_product_price) {
		this.dd_product_price = dd_product_price;
	}
	public int getDd_product_ddprice() {
		return dd_product_ddprice;
	}
	public void setDd_product_ddprice(int dd_product_ddprice) {
		this.dd_product_ddprice = dd_product_ddprice;
	}
	public int getDd_product_count() {
		return dd_product_count;
	}
	public void setDd_product_count(int dd_product_count) {
		this.dd_product_count = dd_product_count;
	}
	public String getDd_product_addtime() {
		return dd_product_addtime;
	}
	public void setDd_product_addtime(String dd_product_addtime) {
		this.dd_product_addtime = dd_product_addtime;
	}
	public String getDd_product_recommend() {
		return dd_product_recommend;
	}
	public void setDd_product_recommend(String dd_product_recommend) {
		this.dd_product_recommend = dd_product_recommend;
	}
	public String getDd_product_brief() {
		return dd_product_brief;
	}
	public void setDd_product_brief(String dd_product_brief) {
		this.dd_product_brief = dd_product_brief;
	}
	public String getDd_product_authorbrief() {
		return dd_product_authorbrief;
	}
	public void setDd_product_authorbrief(String dd_product_authorbrief) {
		this.dd_product_authorbrief = dd_product_authorbrief;
	}
	public String getDd_product_directory() {
		return dd_product_directory;
	}
	public void setDd_product_directory(String dd_product_directory) {
		this.dd_product_directory = dd_product_directory;
	}
	public String getDd_product_mediacomment() {
		return dd_product_mediacomment;
	}
	public void setDd_product_mediacomment(String dd_product_mediacomment) {
		this.dd_product_mediacomment = dd_product_mediacomment;
	}
	public String getDd_product_excerpt() {
		return dd_product_excerpt;
	}
	public void setDd_product_excerpt(String dd_product_excerpt) {
		this.dd_product_excerpt = dd_product_excerpt;
	}
	public int getDd_category2_id() {
		return dd_category2_id;
	}
	public void setDd_category2_id(int dd_category2_id) {
		this.dd_category2_id = dd_category2_id;
	}
	public String getDd_product_create_date() {
		return dd_product_create_date;
	}
	public void setDd_product_create_date(String dd_product_create_date) {
		this.dd_product_create_date = dd_product_create_date;
	}

	
}
