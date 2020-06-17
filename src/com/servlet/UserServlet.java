package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.User;
import com.service.UserService;
import com.serviceImpl.UserServiceImpl;




public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//获取Dao接口对象
	UserService userService=new UserServiceImpl(); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---doGet---");
		//区分请求调用下方方法
		
		//获取请求地址
		String path=request.getRequestURI();
		
		//获取地址最后一个斜杠的下标
		int index=path.lastIndexOf("/");
		
		//截取请求地址目标字符串
		String realPath=path.substring(index+1);
		
		if(realPath.equals("login"))
		{
			login(request, response);
		}
		else if(realPath.equals("register"))
		{
			register(request, response);
		}
		else if(realPath.equals("checkName"))
		{
			checkName(request, response);
		}

	}
	
	//登录方法
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---login---");
		
		String uname=request.getParameter("name");
		String upassword=request.getParameter("password");
		
		System.out.println("name:"+uname);
		System.out.println("passwprd:"+upassword);
		
		User user=userService.login(uname,upassword);
		
		if(user!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("message", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	//注册
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---register---");
		
		String uname=request.getParameter("name");
		String upassword=request.getParameter("password");
		String realName=request.getParameter("realName");
		String identity=request.getParameter("identity");
		String sex=request.getParameter("sex");
		String phones=request.getParameter("phone");
		
		long phone=Long.parseLong(phones);
		
		//封装数据
		User user=new User(uname,upassword,realName,identity,sex,phone);
		
		System.out.println(user);
		
		userService.register(user);
		
		response.sendRedirect("login.jsp");
		//request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
	
	//ajax验证
	protected void checkName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("---checkName---");
	     //获取printWriter对象
		 PrintWriter writer = response.getWriter();
		 
		 
	     String name = request.getParameter("name");
	     System.out.println("name:" + name);
	     String res="0";
	     User user = userService.checkName(name);
	     if (user!=null)
	     {
	         res="1";
	     }
	     else
	     {	 
	    	 res="0";
	  	 }
	     writer.write(res);

	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
