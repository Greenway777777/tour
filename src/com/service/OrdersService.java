package com.service;

import com.pojo.Orders;

public interface OrdersService {
	public void addOrdes(int uid,String uname);

	//
	public Orders getMyOrders(int uid);
}
