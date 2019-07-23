package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.*;

public interface orderDao {
	public List<DangDangOrder> selOrder_All();//测试order表的sql连接
	public List<DangDangOrderDetail> selOrderDetail_All();//测试OrderDetail表的sql连接
	public List<DangDangAddress> selAddress_All();//测试Address表的sql连接
	/*---------------------------------------------------------------------*/
	public List<DangDangAddress> selAdd_ByAddressIdAndUserId(@Param("addressId")int addressId,@Param("ddUserId")int ddUserId);	//查询
	public int insAddress_All(DangDangAddress address);	//address表的数据插入(生成地址条目)

	public int insOrder_All(@Param("uuid")String uuid,
						@Param("orderTotalPrice")double orderTotalPrice,
						@Param("ddUserId")int ddUserId);	//order表生成订单
	
	public int insOrderDetail_All(@Param("orderDetail")DangDangOrderDetail orderDetail);//orderDetail表的数据插入
	
}