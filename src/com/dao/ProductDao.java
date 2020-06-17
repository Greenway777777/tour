package com.dao;

import com.pojo.Product;

public interface ProductDao {
	
	//修改商品库存
	public void updateProductByPid(int pid,int pquantity);
	
	//查询商品库存
	public Product getProductByPid(int pid);

}
