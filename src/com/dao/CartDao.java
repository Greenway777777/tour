package com.dao;

import java.util.List;

import com.pojo.Cart;

public interface CartDao {
	
	//添加
	public void addCart(Cart cart);
	
	//根据用户id查询购物车
	public List<Cart> getCartById(int uid);
	
	//根据uid删除记录
	public void deleteCartByUid(int uid);
	
	//根据cid删除记录
	public  void deleteCart(int cid);
	
	//分页查询
	public List<Cart> getCartByPage(int uid,int start,int pageSize);
	
	//查询总记录
	public int getCartCount(int uid);
}
