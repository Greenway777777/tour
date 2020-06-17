package com.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserDao;
import com.pojo.User;
import com.utils.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User login(String uname, String upassword) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM USER WHERE uname=? AND upassword=?";
		//占位符赋值
		Object params[]= {uname,upassword};
		
		User user=null;
		
		//执行查询操作
		ResultSet rs=query(sql,params);
		try {
			while(rs.next())
			{
				user=new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setUpassword(rs.getString("upassword"));
				user.setRealName(rs.getString("realName"));
				user.setIdentity(rs.getString("identity"));
				user.setSex(rs.getString("sex"));
				user.setPhone(rs.getLong("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return user;
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO USER(UNAME,UPASSWORD,REALNAME,IDENTITY,SEX,PHONE) VALUES(?,?,?,?,?,?)";
		Object params[]= {user.getUname(),user.getUpassword(),user.getRealName(),user.getIdentity(),user.getSex(),user.getPhone()};	
		update(sql, params);
		close();
		
	}

	@Override
	public User checkName(String name) {
		// TODO Auto-generated method stub
		 String sql = "select* from user where uname=?";
	     Object params[] = {name};
	     User user = null;
	     ResultSet rs = query(sql, params);

	     try {
	         if (rs.next()) 
	         {
	             user = new User();
	         }
	       } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	}

}
