package com.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.OrdersDao;
import com.pojo.Orders;
import com.utils.BaseDao;

public class OrdersDaoImpl extends BaseDao implements OrdersDao {

	@Override
	public void addOrdes(Orders orders) {
		String sql = "insert into orders(uid,uname,ocreatetime,ocost) values(?,?,?,?)";
        Object params[] = {orders.getUid(), orders.getUname(), orders.getOcreatetime(), orders.getOcost()};
        update(sql, params);
        close();

	}

	@Override
	public int getOrdersByUid(int uid) {
		// TODO Auto-generated method stub
		String sql = "select* from orders where uid=?";
        Object params[] = {uid};
        int oid=0;//保存查询出来的订单oid
        ResultSet rs = query(sql, params);
        
        try {
			if(rs.last())
			{
				oid=rs.getInt("oid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oid;
	}

	@Override
	public Orders getMyOrders(int uid) {
		// TODO Auto-generated method stub
		String sql = "select* from orders where uid=?";
        Object params[] = {uid};
        
        Orders orders=null;
        
        ResultSet rs = query(sql, params);
        
        try {
			if(rs.last())
			{
				orders=new Orders();
				orders.setOid(rs.getInt("oid"));
				orders.setOcost(rs.getInt("ocost"));
				orders.setOcreatetime(rs.getDate("ocreatetime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

}
