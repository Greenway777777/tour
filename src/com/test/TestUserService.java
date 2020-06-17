package com.test;

import com.pojo.User;
import com.service.UserService;
import com.serviceImpl.UserServiceImpl;

public class TestUserService {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserService userService=new UserServiceImpl();
		
		String uname="xiaohai2";
		String upassword="xiaohai2";
		String realName="李四";
		String identity="440923199808273822";
		String sex="男";
		String phones="18319372613";
		
		long phone=Long.parseLong(phones);
		
		//封装数据
		User user=new User(uname,upassword,realName,identity,sex,phone);
		
		userService.register(user);

	}

}
