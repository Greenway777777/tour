package com.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.ProductDao;
import com.pojo.Product;
import com.utils.BaseDao;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	@Override
	public void updateProductByPid(int pid,int pquantity) {
		// TODO Auto-generated method stub
		String sql = "update product set pstock=pstock-? where pid=?";
        Object[] params = new Object[]{pquantity,pid};
        update(sql, params);
        
	}

	@Override
	public Product getProductByPid(int pid) {
		// TODO Auto-generated method stub
		String sql = "select* from product where pid=?";
        Object params[] ={pid};
        ResultSet rs = query(sql, params);
        Product product = null;

        try {
            while(rs.next()) {
                product = new Product();
                product.setPid(rs.getInt("pid"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getInt("price"));
                product.setPstock(rs.getInt("pstock"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
	}

}
