package com.test;

import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
import com.pojo.User;

public class TestUserDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDaoImpl();
		
		String uname="xiaohai";
		String upassword="xiaohai";
		String realName="李四";
		String identity="440923199808273522";
		String sex="男";
		String phones="18319372613";
		
		long phone=Long.parseLong(phones);
		
		//封装数据
		User user=new User(uname,upassword,realName,identity,sex,phone);
		
		userDao.register(user);

	}

}
