package com.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Orders;
import com.pojo.OrdersDetail;
import com.pojo.User;
import com.service.OrdersDetailService;
import com.service.OrdersService;
import com.serviceImpl.OrdersDetailServiceImpl;
import com.serviceImpl.OrdersServiceImpl;

public class ResultFilter implements Filter{
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("---ResultFilter---");
		
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;		
		
		//获取主键
		HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int uid = user.getUid();
        System.out.println("uid:"+uid);
		
        OrdersService ordersService=new OrdersServiceImpl();
        
        OrdersDetailService ordersDetailService=new OrdersDetailServiceImpl();
        
        //获取当前用户订单信息
		Orders orders=ordersService.getMyOrders(uid);
		
		//获取订单编号
		int oid=orders.getOid();
		
		//根据oid查询订单详情
		List<OrdersDetail> list=ordersDetailService.getOrdersDetailsByOid(oid);
		
		session.setAttribute("orders", orders);
		session.setAttribute("list", list);
        
        
		arg2.doFilter(request, response);
		
	}
	

}
