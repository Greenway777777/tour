package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet rs;

	//连接池<=92
	public boolean getConnection()
	{
		boolean flag=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/tour";
			String username="root";
			String password="123456";
			connection=DriverManager.getConnection(url, username, password);
			if(connection!=null)
			{
				//System.out.println("数据库连接成功");
				flag=true;
			}
			else
			{
				System.out.println("数据库连接失败");
				flag=false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	//查询操作
	public ResultSet query(String sql,Object params[])
	{
		try {
			if(getConnection())
			{
				
				statement=connection.prepareStatement(sql);
				
				for(int i=0;i<params.length;i++)
				{
					statement.setObject(i+1, params[i]);
				}
				rs=statement.executeQuery();
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}
	//添加，修改，删除操作
	public int update(String sql,Object params[])
	{
		int total=0;
		try {
			if(getConnection())
			{
				statement=connection.prepareStatement(sql);
				//占位符赋值
				for(int i=0;i<params.length;i++)
				{
					statement.setObject(i+1, params[i]);
				}
				total=statement.executeUpdate();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	
	//关闭连接池
	//连接池先开后关（堆栈原理）
	public void close()
	{
		try {
				if(rs!=null)
				{
					rs.close();
				}
				if(statement!=null)
				{
					statement.close();
				}
				if(connection!=null)
				{
					connection.close();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
