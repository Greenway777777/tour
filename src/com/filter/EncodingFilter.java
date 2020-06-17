package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class EncodingFilter implements Filter{

	
	//处理post请求中文乱码问题
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("---EncodingFilter---");
		
		//修改字符集
		arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
		
		arg2.doFilter(arg0, arg1);
		
	}
	

}
