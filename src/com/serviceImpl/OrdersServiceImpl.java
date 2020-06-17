package com.serviceImpl;

import java.util.Date;
import java.util.List;

import com.dao.CartDao;
import com.dao.OrdersDao;
import com.dao.OrdersDetailDao;
import com.dao.ProductDao;
import com.daoImpl.CartDaoImpl;
import com.daoImpl.OrdersDaoImpl;
import com.daoImpl.OrdersDetailDaoImpl;
import com.daoImpl.ProductDaoImpl;
import com.pojo.Cart;
import com.pojo.Orders;
import com.pojo.OrdersDetail;
import com.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {
	
	//
	OrdersDao ordersDao=new OrdersDaoImpl();
	CartDao cartDao=new CartDaoImpl();
	OrdersDetailDao odersDetailDao=new OrdersDetailDaoImpl();
	ProductDao productDao=new ProductDaoImpl();

	@Override
	public void addOrdes(int uid,String uname) {
		
		Orders orders=new Orders();
		orders.setUid(uid);
		orders.setUname(uname);
		orders.setOcreatetime(new Date());
		
		List<Cart> list=cartDao.getCartById(uid);
		int totalPrice = 0;
		for(Cart cart:list)
		{
			//获取商品数量
        	int pquantity=cart.getPquantity();
        	//获取商品单价
        	int price=cart.getProduct().getPrice();
        	//商品总价
        	int sum=pquantity*price;
        	//所有商品总价格
        	totalPrice+=sum;
			
		}
		//总金额
		orders.setOcost(totalPrice);
		
		
		//保存
		ordersDao.addOrdes(orders);
		
		//获取当前用户在订单表中的主键
		int oid=ordersDao.getOrdersByUid(uid);
		
		//创建要保存的对象
		OrdersDetail ordersDetail=new OrdersDetail();
		ordersDetail.setOid(oid);//设置oid
		for(Cart cart:list)
		{
			//获取商品数量
        	int pquantity=cart.getPquantity();
        	//获取商品单价
        	int price=cart.getProduct().getPrice();
        	//商品总价
        	int sum=pquantity*price;
        	//商品名称
        	String pname=cart.getProduct().getPname();
        	//pid
        	int pid=cart.getPid();
        	
        	//保存到ordersDetail
        	ordersDetail.setPquantity(pquantity);
        	ordersDetail.setPid(pid);
        	ordersDetail.setPrice(price);
        	ordersDetail.setPname(pname);
        	
			//执行保存
        	odersDetailDao.addOrdersDetails(ordersDetail);
        	
        	//修改商品库存
        	productDao.updateProductByPid(pid, pquantity);
		}
		
		
		//删除购物车信息
		cartDao.deleteCartByUid(uid);
		
	}

	@Override
	public Orders getMyOrders(int uid) {
		// TODO Auto-generated method stub
		return ordersDao.getMyOrders(uid);
	}

}
