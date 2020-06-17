package com.service;

import com.pojo.User;

public interface UserService {
	
	//利用用户名密码实现登录
	public User login(String uname,String upassword);
	
	
	//注册
	public void register(User user);
	
	//验证
	User checkName(String name);

}
