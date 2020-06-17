package com.dao;

import java.util.List;

import com.pojo.OrdersDetail;

public interface OrdersDetailDao {
	
	//添加订单详情
	public void addOrdersDetails(OrdersDetail ordersDetail);
	
	//根据oid查询订单详情
	public List<OrdersDetail> getOrdersDetailsByOid(int oid);

}
