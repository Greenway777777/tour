<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 订单页</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/adv.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<style type="text/css">
#oderview {
	font-size: 14px
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
	<!--导航-->
	<div id="menu">
		<div id="menu-m">
			<ul>
				<li><a href="index.jsp">首页</a>
				</li>
				<li style="width:8px;"><img src="images/t1.jpg" width="8"
					height="42" />
				</li>
				<li><a href="type.jsp">境内游</a>
				</li>
				<li style="width:8px;"><img src="images/t1.jpg" width="8"
					height="42" />
				</li>
				<li><a href="#">境外游</a>
				</li>
				<li style="width:8px;"><img src="images/t1.jpg" width="8"
					height="42" />
				</li>
				<li><a href="#">热门游</a>
				</li>
				<li style="width:8px;"><img src="images/t1.jpg" width="8"
					height="42" />
				</li>
				<li><a href="group.jsp">团购</a>
				</li>
				<li><a href="query"><img src="images/che.jpg" width="176"
						height="42" />
				</a>
				</li>
			</ul>
		</div>
	</div>


	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">途乐行旅游网</a> &gt; 最新订单
	</div>
	<div class="wrap">
		<div id="shopping">
			<form action="doBuy" method="post">
				<table id="oderview">
					<tr>
						<th>订单时间:${orders.ocreatetime }</th>
						<th>订单号:${orders.oid }</th>
						<th>订单总额:${orders.ocost } 元</th>
						<th>
						<th>
					</tr>
					<!-- 根据用户订单详情生成列表 -->
					<c:forEach items="${list}" var="detail">
						<tr id="product_id_1">
							<td class="thumb">							
								<img style="width: 100px; height: 100px;" src="images/fhgc.jpg" />
								<a href="#">${detail.pname }</a>
							</td>
							<td class="price">￥<span>单价：${detail.price }</span></td>
							<td class="number"><span>X${detail.pquantity}</span></td>
							<td class="delete">购买成功</td>

						</tr>
						
					</c:forEach>

				</table>
			</form>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2016 oracle All Rights
		Reserved.</div>
</body>
</html>

