package com.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.CartDao;
import com.pojo.Cart;
import com.pojo.Product;
import com.utils.BaseDao;

public class CartDaoImpl extends BaseDao implements CartDao {

	@Override
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO cart(pid,pquantity,uid) VALUES(?,?,?)";
        Object[] params = new Object[]{cart.getPid(), cart.getPquantity(), cart.getUid()};
        update(sql, params);
        close();

	}

	@Override
	public List<Cart> getCartById(int uid) {
		// TODO Auto-generated method stub
		 String sql = "select c.*,p.pname,p.price  from cart c,product p WHERE c.pid=p.pid AND uid=?";
	     Object[] params = new Object[]{uid};
	     ResultSet rs = query(sql, params);
	     
	     ArrayList<Cart> list = new ArrayList<Cart>();
	     try {
	         while(rs.next()) {
	        	 //封装Cart数据
	             Cart cart = new Cart();
	             cart.setCid(rs.getInt("cid"));
	             cart.setPid(rs.getInt("pid"));
	             cart.setPquantity(rs.getInt("pquantity"));
	             cart.setUid(rs.getInt("uid"));
	             //封装Product数据
	             Product product = new Product();
	             product.setPrice(rs.getInt("price"));
	             product.setPname(rs.getString("pname"));
	             
	             //购物车与商品关联
	             cart.setProduct(product);
	             
	             //保存到集合
	             list.add(cart);
	         }
	     } catch (SQLException var11) {
	         var11.printStackTrace();
	     }

	        this.close();
	        return list;
	}

	@Override
	public void deleteCartByUid(int uid) {
		String sql = "delete from cart where uid=?";
        Object params[] ={uid};
        this.update(sql, params);
        this.close();
	}

	@Override
	public void deleteCart(int cid) {
		// TODO Auto-generated method stub
		String sql = "delete from cart where cid=?";
        Object params[] ={cid};
        this.update(sql, params);
        this.close();
		
	}

	@Override
	public List<Cart> getCartByPage(int uid, int start, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select c.*,p.pname,p.price  from cart c,product p WHERE c.pid=p.pid AND uid=? limit ?,?";
	    Object[] params = new Object[]{uid,start,pageSize};
	    ResultSet rs = query(sql, params);
	     
	     ArrayList<Cart> list = new ArrayList<Cart>();
	     try {
	         while(rs.next()) {
	        	 //封装Cart数据
	             Cart cart = new Cart();
	             cart.setCid(rs.getInt("cid"));
	             cart.setPid(rs.getInt("pid"));
	             cart.setPquantity(rs.getInt("pquantity"));
	             cart.setUid(rs.getInt("uid"));
	             //封装Product数据
	             Product product = new Product();
	             product.setPrice(rs.getInt("price"));
	             product.setPname(rs.getString("pname"));
	             
	             //购物车与商品关联
	             cart.setProduct(product);
	             
	             //保存到集合
	             list.add(cart);
	         }
	     } catch (SQLException var11) {
	         var11.printStackTrace();
	     }
	    this.close();
		return list;
	}

	@Override
	public int getCartCount(int uid) {
		// TODO Auto-generated method stub
		String sql = "select count(*) as c from cart where uid=?";
        Object params[] ={uid};
        int total=0;
        ResultSet rs = query(sql, params);
        try {
	         while(rs.next()) {
	        	 total=rs.getInt("c");
	         }
	     } catch (SQLException var11) {
	         var11.printStackTrace();
	     }

        this.close();
		return total;
	}

}
