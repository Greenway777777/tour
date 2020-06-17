package com.pojo;

public class OrdersDetail {

	private int id;
    private int oid;
    private int pid;
    private int pquantity;
    private String pname;
    private String pfilename;
    private int price;
    
	public OrdersDetail() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
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

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPfilename() {
		return pfilename;
	}

	public void setPfilename(String pfilename) {
		this.pfilename = pfilename;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	//", pfilename=" + pfilename + 
	@Override
	public String toString() {
		return "OrdersDetail [id=" + id + ", oid=" + oid + ", pid=" + pid + ", pquantity=" + pquantity + ", pname="
				+ pname + ", price=" + price + "]";
	}
    
    
}
