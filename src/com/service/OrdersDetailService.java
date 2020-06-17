package com.service;

import java.util.List;

import com.pojo.OrdersDetail;

public interface OrdersDetailService {
	//添加
	public void addOrdersDetails(OrdersDetail ordersDetail);
	
	//
	public List<OrdersDetail> getOrdersDetailsByOid(int oid);

}
