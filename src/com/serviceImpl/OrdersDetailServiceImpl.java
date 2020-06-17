package com.serviceImpl;

import java.util.List;

import com.dao.OrdersDetailDao;
import com.daoImpl.OrdersDetailDaoImpl;
import com.pojo.OrdersDetail;
import com.service.OrdersDetailService;

public class OrdersDetailServiceImpl implements OrdersDetailService {
	
	OrdersDetailDao ordersDetailDao = new OrdersDetailDaoImpl();

	@Override
	public void addOrdersDetails(OrdersDetail ordersDetail) {
		// TODO Auto-generated method stub
		ordersDetailDao.addOrdersDetails(ordersDetail);

	}

	@Override
	public List<OrdersDetail> getOrdersDetailsByOid(int oid) {
		// TODO Auto-generated method stub
		return ordersDetailDao.getOrdersDetailsByOid(oid);
	}

}
