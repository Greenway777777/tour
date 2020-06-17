package com.serviceImpl;

import java.util.List;

import com.dao.CartDao;
import com.dao.ProductDao;
import com.daoImpl.CartDaoImpl;
import com.daoImpl.ProductDaoImpl;
import com.pojo.Cart;
import com.pojo.Product;
import com.service.CartService;

import javafx.scene.control.Alert;

public class CartServiceImpl implements CartService {
	
	CartDao cartDao = new CartDaoImpl();
	ProductDao productDao=new ProductDaoImpl();

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		int pquantity=cart.getPquantity();
		int uid=cart.getUid();
		int pid=cart.getPid();
		List<Cart> list=cartDao.getCartById(uid);
		int total = 0;
        for(Cart cart1:list)
        {	
        	int pquantity1=cart1.getPquantity();
        	
        	total+=pquantity1;
        }
		Product product=productDao.getProductByPid(pid);
		boolean flag=true;
		if((product.getPstock()-(total+pquantity))>=0)
		{
			cartDao.addCart(cart);
		}
		else
		{
			flag=false;
		}
		return flag;
	
	}

	@Override
	public List<Cart> getCartById(int uid) {
		// TODO Auto-generated method stub
		return cartDao.getCartById(uid);
	}

	@Override
	public void deleteCartByUid(int uid) {
		// TODO Auto-generated method stub
		cartDao.deleteCartByUid(uid);
		
	}

	@Override
	public void deleteCart(int cid) {
		// TODO Auto-generated method stub
		cartDao.deleteCart(cid);
	}

	@Override
	public List<Cart> getCartByPage(int uid, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		//通过当前页计算起始位置
		int start=(currentPage-1)*pageSize;
		return cartDao.getCartByPage(uid, start, pageSize);
	}

	@Override
	public int getCartCount(int uid) {
		// TODO Auto-generated method stub
		return cartDao.getCartCount(uid);
	}

}
