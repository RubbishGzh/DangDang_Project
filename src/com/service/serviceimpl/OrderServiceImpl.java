package com.service.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.orderDao;
import com.entity.*;
import com.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private orderDao o_D;

	public List<DangDangOrder> selOrder_All(){
		return o_D.selOrder_All();
	}
	public List<DangDangOrderDetail> selOrderDetail_All(){
		return o_D.selOrderDetail_All();
	}
	public List<DangDangAddress> selAddress_All(){
		return o_D.selAddress_All();
	}
/*--------------------------------------------------------------*/
	@Override
	public List<DangDangAddress> selAdd_ByAddressIdAndUserId(int addressId, int ddUserId) {//查询
		return o_D.selAdd_ByAddressIdAndUserId(addressId, ddUserId);
	}
	
	@Override
	public int insAddress_All(DangDangAddress address) {//address表的数据插入(生成地址条目)
		return o_D.insAddress_All(address);
	}
	
	@Override
	public int insOrder_All(String uuid, double orderTotalPrice, int ddUserId) {//order表生成订单
		return o_D.insOrder_All(uuid, orderTotalPrice, ddUserId);
	}
	
	@Override
	public int insOrderDetail_All(DangDangOrderDetail orderDetail) {//orderDetail表的数据插入
		return o_D.insOrderDetail_All(orderDetail);
	}
	
	//生成订单详情条目
	public boolean createOrderDetail(DangDangAddress address,dangdang_user user,String orderSSID,List<dangdang_book> cartList) {
		//获取参数
		int addressId = address.getAddressId();
		int userId = user.getDd_user_id();
		
		//循环生成多个订单详情条目 后期应改为MyBatis的批量插入
		for(dangdang_book book : cartList) {
			//获取商品参数
			String bookName = book.getBookName();
			int bookCount = book.getBookCount();
			int bookDdprice = book.getBookDdprice();
			int bookId = book.getBookId();
			//准备对象
			DangDangOrderDetail orderDetail = new DangDangOrderDetail();
			orderDetail.setDetailProductName(bookName);
			orderDetail.setDetailCount(bookCount);
			orderDetail.setDetailDdprice(bookDdprice);
			orderDetail.setDdProductId(bookId);
			orderDetail.setOrderSsid(orderSSID);
			orderDetail.setAddressId(addressId);
			orderDetail.setDdUserId(userId);
			//生成条目
			int i = o_D.insOrderDetail_All(orderDetail);
		}
		return true;
	}	
}
