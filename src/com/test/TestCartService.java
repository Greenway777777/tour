package com.test;

import java.util.List;

import com.pojo.Cart;
import com.service.CartService;
import com.serviceImpl.CartServiceImpl;

public class TestCartService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CartService cartService=new CartServiceImpl();
		
//		List<Cart> list=cartService.getCartById(17);
//		for(Cart cart:list)
//		{
//			System.out.println(cart);
//		}
		int total=cartService.getCartCount(1);
		System.out.println(total);
	}

}
