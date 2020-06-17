package com.test;

import com.dao.CartDao;

import com.daoImpl.CartDaoImpl;
import com.pojo.Cart;


public class TestCartDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CartDao cartDao=new CartDaoImpl();
		Cart cart=new Cart(1,1,17);
		cartDao.addCart(cart);
		

	}

}
