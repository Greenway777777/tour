package com.pojo;

import java.util.Date;

public class Orders {
	
	private int oid;
    private int uid;
    private String uname;
    private Date ocreatetime;
    private int ocost;
    
    
	public Orders() {
	}


	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public Date getOcreatetime() {
		return ocreatetime;
	}


	public void setOcreatetime(Date ocreatetime) {
		this.ocreatetime = ocreatetime;
	}


	public int getOcost() {
		return ocost;
	}


	public void setOcost(int ocost) {
		this.ocost = ocost;
	}


	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", uid=" + uid + ", uname=" + uname + ", ocreatetime=" + ocreatetime + ", ocost="
				+ ocost + "]";
	}
    
	
    
    

}
