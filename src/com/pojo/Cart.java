package com.pojo;

public class Cart {
	
	private int cid;//购物车主键
    private int pid;//商品主键
    private int pquantity;//商品数量
    private int uid;//用户主键
    private Product product;//商品
    
    
	public Cart() {
	}
	
	 public Cart(int pid, int pquantity, int uid) {
	        this.pid = pid;
	        this.pquantity = pquantity;
	        this.uid = uid;
	    }


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public int getPquantity() {
		return pquantity;
	}


	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", pid=" + pid + ", pquantity=" + pquantity + ", uid=" + uid + ", product="
				+ product + "]";
	}
	
	
    
    

}
