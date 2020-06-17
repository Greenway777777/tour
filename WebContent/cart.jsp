<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/nf.lightbox.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/NFLightBox.js"></script>
<script type="text/javascript" src="js/shop.js"></script>
<style type="text/css">
.mask { /*遮罩层*/
    background-color:gray;
    left:0;
    position:absolute;
    top:0;
    z-index:100;
    filter:alpha(opacity=30);
   opacity:0.3;
}

div.dialog {
	width: 296px;
	height:173px;
	position: absolute;
	z-index: 101;
	display: none;
    background-image:url(images/dialog.png)
}

div.title {
	padding-top: 5px;
	padding-left:270px;
}
div.dialog div.content {

	height: 90px;
	text-align:center;

	font:bold 15px/90px Verdana, Geneva, sans-serif;
}

div.dialog div.bottom {
	text-align: right;
	padding: 10px 10px 10px 0px;
	border-top:1px dashed #999999;

}
div.bottom .btn1 {
	border:none;
	width: 63px;
	height: 29px;
	cursor:pointer;
	
}
div.bottom #btnSure{
	background-image:url(images/delSure.jpg);
}
div.bottom #btnCancel{
	background-image:url(images/delCancel.jpg);
}
#shop-inf{ overflow:auto; margin-top:10px;}
#shop-inf table tr th{ 
	
	background:url(images/shopt.jpg) repeat-x;  
	height:40px;
	line-height:40px;
	text-align:center;
	font-size:20px;
	color:white;
	  font-weight: 200;
}

.back{
	background:#BCC6C8;
}
</style>
</head>

<body>
<!--头部-->
<div id="top-cont">
  <div id="top-min">
    <div id="min-left"></div>
    <div id="min-right"></div>
  </div>
</div>
<div id="menu">
  <div id="menu-m">
    <ul>
      <li><a href="index.jsp">首页</a></li>
      <li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
      <li><a href="type.jsp">境内游</a></li>
      <li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
      <li><a href="#">境外游</a></li>
      <li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
      <li><a href="#">热门游</a></li>
      <li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
      <li><a href="group.jsp">团购</a></li>
      <li><a href="cart.jsp"><img src="images/che.jpg" width="176" height="42" /></a></li>
    </ul>
  </div>
</div>
<!--广告位图片-->


<!--注册版块-->
<div id="shop">
  <div id="shop-t">
    <div id="shop-l"><img src="images/sh.jpg" width="74" height="67" /></div>
    <div id="shop-r">我的购物车</div>
  </div>
  <div id="shop-inf">  	
    <table>
    	<tr>
    		<th class="xh">序号</th>
    		<th class="lx">路线名称</th>
    		<th class="rs">单价</th>
    		<th class="dj">购票数量</th>
    		<th class="cz">操作</th>    		
    	</tr>
    	
    	<c:forEach items="${list }" var="cart" varStatus="status">
    		<tr align="center" style="font-size:14px;" 
    			<c:if test="${status.index%2==0 }">
    				class="back"
    			</c:if>>
    			<td>${cart.cid}</td>
    			<td>${cart.getProduct().getPname() }</td>
    			<td>${cart.getProduct().getPrice() }</td>
    			<td>${cart.getPquantity() }</td>
    			<td>
    				<a href="deleteCart?cid=${cart.getCid()}">删除</a>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
  </div>  
<div id="fanye">
	<a href="query?currentPage=1">首页</a> 
	<a href="query?currentPage=${pages.getPrePage() }">上一页</a> 
	<c:forEach items="${pages.getPageList() }" var="ps">
		<a href="query?currentPage=${ps }">[${ps }]</a>
	</c:forEach>
	<a href="query?currentPage=${pages.getNextPage() }">下一页</a> 
	<a href="query?currentPage=${pages.getTotalPage() }">尾页</a></div>
<div id="jine">应付金额：${totalMoney }元</div>
<div id="js">
  <input name="button" type="image" id="button" value="images/js.jpg" src="images/js.jpg" />
</div>
</div>

<!--底部-->
<div id="foot">
  <div id="foot-t">
    <p>许可证编号：WE125482154 鄂ICP备125478966</p>
    <p><a href="#">隐私保护</a> | <a href="#">诚聘英才</a> | <a href="#">关于我们</a> | <a href="#">网站地图</a> | <a href="#">友情链接</a> | <a href="#">商务合作</a></p>
  </div>
</div>
<script type="text/javascript">
$(function(){
	//点击结算触发的点击事件
	$("[name=button]").click(function(){
		location.href="buy";
	});
});
</script>

</body>
</html>
