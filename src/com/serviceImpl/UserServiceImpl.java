package com.serviceImpl;

import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
import com.pojo.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao=new UserDaoImpl();

	@Override
	public User login(String uname, String upassword) {
		// TODO Auto-generated method stub
		return userDao.login(uname, upassword);
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		userDao.register(user);
		}

	@Override
	public User checkName(String name) {
		// TODO Auto-generated method stub
		return userDao.checkName(name);
	}
}
