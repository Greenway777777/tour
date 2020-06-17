package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Cart;
import com.pojo.User;
import com.service.CartService;
import com.service.OrdersService;
import com.serviceImpl.CartServiceImpl;
import com.serviceImpl.OrdersServiceImpl;
import com.utils.Pages;


/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CartService cartService=new CartServiceImpl();
	OrdersService ordersService=new OrdersServiceImpl();
       
 
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---doGet---");
		//区分请求调用下方方法
		
		//获取请求地址
		String path=request.getRequestURI();
		
		//获取地址最后一个斜杠的下标
		int index=path.lastIndexOf("/");
		
		//截取请求地址目标字符串
		String realPath=path.substring(index+1);
		
		if(realPath.equals("shopping"))
		{
			shopping(request, response);
		}
		else if(realPath.equals("query"))
		{
			queryCart(request,response);
		}
		else if(realPath.equals("buy"))
		{
			buy(request,response);
		}
		else if(realPath.equals("deleteCart"))
		{
			deleteCart(request,response);
		}
	}
	
	protected void shopping(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---shopping---");
		
		String pids = request.getParameter("pid");
        int pid = Integer.parseInt(pids);
        
        String pquantities = request.getParameter("pquantity");
        int pquantity = Integer.parseInt(pquantities);
        
        System.out.println("pid:"+pids);
        System.out.println("pquantity:"+pquantities);
        
        //获取用户主键
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int uid = user.getUid();
        Cart cart = new Cart(pid, pquantity, uid);
        System.out.println("cart:"+cart);
        
        //添加到购物车
        //cartService.addCart(cart);
        
        PrintWriter writer = response.getWriter();
        boolean flag=cartService.addCart(cart);
        String res="0";
        if(flag)
		{	
        	queryCart(request, response);
        	res="0";
		}
		else
		{
			res="1";
		}
        writer.write(res);
       
	}
	
	protected void queryCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---queryCart---");
		//获取当前页
		String current = request.getParameter("currentPage");
        int currentpage=1;
        if (current == null) {//没有接受到值
            currentpage = 1;
        } else {
            currentpage = Integer.parseInt(current);
        }
		
		//获取主键
		HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int uid = user.getUid();
        //查询购物车信息
        List<Cart> list=cartService.getCartById(uid);
        
        int totalPrice = 0;
        for(Cart cart:list)
        {
        	System.out.println(cart);
        	//获取商品数量
        	int pquantity=cart.getPquantity();
        	//获取商品单价
        	int price=cart.getProduct().getPrice();
        	//商品总价
        	int sum=pquantity*price;
        	//所有商品总价格
        	totalPrice+=sum;
        }
        System.out.println("totalPrice:"+totalPrice);
        
        //分页工具类
        Pages pages = new Pages();
        
        pages.setCurrentPage(currentpage);
        int totalCount=cartService.getCartCount(uid);
        pages.setTotalCount(totalCount);
        
        List<Cart> list2 = this.cartService.getCartByPage(uid, pages.getCurrentPage(), pages.getPageSize());
        
        //保存到request
        request.setAttribute("totalMoney", totalPrice);
        //保存到request
        request.setAttribute("list", list2);
        
        request.setAttribute("pages", pages);
        
        request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	
	
	protected void buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---buy---");
		
		//获取主键
		HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int uid = user.getUid();
        System.out.println("uid:"+uid);
        
        String uname=user.getUname();
        
        
        //执行支付功能
        ordersService.addOrdes(uid, uname);
        
        //跳转页面
        response.sendRedirect("shopping-result.jsp");
        
	}
	

	//删除购物车的商品
	protected void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---deleteCart---");
		String cids = request.getParameter("cid");
        System.out.println("cids:" + cids);
        int cid = Integer.parseInt(cids);
        cartService.deleteCart(cid);
        queryCart(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
