package com.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.OrdersDetailDao;
import com.pojo.Cart;
import com.pojo.OrdersDetail;
import com.pojo.Product;
import com.utils.BaseDao;

public class OrdersDetailDaoImpl extends BaseDao implements OrdersDetailDao {

	@Override
	public void addOrdersDetails(OrdersDetail ordersDetail) {
		// TODO Auto-generated method stub
		String sql = "insert into orders_detail(oid,pid,pquantity,pname,price) values(?,?,?,?,?)";
        Object params[] = {ordersDetail.getOid(), ordersDetail.getPid(), ordersDetail.getPquantity(), ordersDetail.getPname(),ordersDetail.getPrice()};
        update(sql, params);
        close();

	}

	@Override
	public List<OrdersDetail> getOrdersDetailsByOid(int oid) {
		// TODO Auto-generated method stub
		String sql = "select *  from orders_detail  WHERE oid=?";
	     Object[] params = new Object[]{oid};
	     
	     
	     ResultSet rs = query(sql, params);
	     
	     ArrayList<OrdersDetail> list = new ArrayList<OrdersDetail>();
	     try {
	         while(rs.next()) {
	        	 //封装Cart数据
	        	 OrdersDetail OrdersDetail = new OrdersDetail();
	             
	        	 OrdersDetail.setId(rs.getInt("id"));
	        	 OrdersDetail.setOid(rs.getInt("oid"));
	        	 OrdersDetail.setPname(rs.getString("pname"));
	        	 OrdersDetail.setPrice(rs.getInt("price"));
	        	 OrdersDetail.setPquantity(rs.getInt("pquantity"));
	             
	             //保存到集合
	             list.add(OrdersDetail);
	         }
	     } catch (SQLException var11) {
	         var11.printStackTrace();
	     }

	        this.close();
	        return list;
	}

}
