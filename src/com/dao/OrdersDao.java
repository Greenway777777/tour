package com.dao;

import com.pojo.Orders;

public interface OrdersDao {
	
	//保存订单信息
	public void addOrdes(Orders orders);
	
	//根据uid获取最后一条订单
	public int getOrdersByUid(int uid);
	
	//
	public Orders getMyOrders(int uid);

}
