package com.entity;

import java.io.Serializable;

public class dangdang_book implements Serializable{

	private int bookId;//图书编号,主键
	private String bookName;//图书路径
	private String bookImg;//图书图片路径
	private int bookPrice;//图书市场价
	private int bookDdprice;//图书当当价
	private int bookCount;//图书购买数量
	private int bookState;//状态
	
	public dangdang_book() {}
	
	public dangdang_book(int bookId, String bookName, String bookImg, int bookPrice, int bookDdprice, int bookCount,
			int bookState) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookImg = bookImg;
		this.bookPrice = bookPrice;
		this.bookDdprice = bookDdprice;
		this.bookCount = bookCount;
		this.bookState = bookState;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public String getBookImg() {
		return bookImg;
	}



	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}



	public int getBookPrice() {
		return bookPrice;
	}



	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}



	public int getBookDdprice() {
		return bookDdprice;
	}



	public void setBookDdprice(int bookDdprice) {
		this.bookDdprice = bookDdprice;
	}



	public int getBookCount() {
		return bookCount;
	}



	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}



	public int getBookState() {
		return bookState;
	}



	public void setBookState(int bookState) {
		this.bookState = bookState;
	}



	@Override
	public String toString() {
		return "dangdang_book [bookId=" + bookId + ", bookName=" + bookName + ", bookImg=" + bookImg + ", bookPrice="
				+ bookPrice + ", bookDdprice=" + bookDdprice + ", bookCount=" + bookCount + ", bookState=" + bookState
				+ "]";
	}

	
}
