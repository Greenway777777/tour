<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/jqzoom.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.3.2.min.js"></script>
<script src="js/jquery.jqzoom1.0.1.js"></script>
<script src="js/jqzoom.pack.1.0.1.js"></script>
<script src="js/detail.js"></script>

<script type="text/javascript">
function aaa(){
		$.ajax({
			url:"shopping",
			data:{"pid":1,"pquantity":1},
			type:"post",
			dataType:"text",
			success:function(data){
				
				if(data==1){//用户名存在
					alert("库存不足");
				}
				else
				{
					window.location.href="query"; 
				}
			}
		});
	};
</script>

</head>

<body>
<span>${message}</span>
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
<li><a href="index.jsp">首页</a></li>
<li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
<li><a href="type.jsp">境内游</a></li>
<li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
<li><a href="#">境外游</a></li>
<li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
<li><a href="#">热门游</a></li> 
<li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
<li><a href="group.jsp">团购</a></li>
<!-- 点击添加到购物车，发出shopping请求 -->
<li><a href="query"><img src="images/che.jpg" width="176" height="42" /></a></li>
</ul>
</div>
</div>
<!--广告位图片-->
<div id="banner"><img src="images/banner.jpg" width="1003" height="93" /></div>

<!--主体内容第一部分开始-->
<div class="jindck">
<div class="jindck-meun">[多重优惠+超值赠送]品质全景，张家界、凤凰、天门山、宝峰湖纯玩双飞5日游<img src="images/tjcp.jpg" width="40" height="40" /><img src="images/fk.jpg" width="40" height="40" /></div>
<div class="jin2">
<div class="jin2-left">
<ul>
<li>
<a href="" title="">
<img src="images/fhgc.jpg" width="400" height="250" />
</a>
</li>
<li class="pics"><a href="images/jdckb1.jpg" class="zoom" title="凤凰古城" ><img src="images/jdcks1.jpg" width="100" height="63" /></a></li>
<li class="pics"><a href="images/jdckb2.jpg" class="zoom" title="凤凰古城"><img src="images/jdcks2.jpg" width="100" height="63" /></a></li>
<li class="pics"><a href="images/jdckb3.jpg" class="zoom" title="凤凰古城"><img src="images/jdcks3.jpg" width="100" height="63" /></a></li>
</div>
<div class="jin2-right">
<ul>
<li>途乐行价：<span class="colorc">￥2988</span></li>
<li>团购价：<strong>￥2888</strong> 起</li>
<li>最大优惠：￥100</li>
<li>出游天数：5天</li>
<li>出游人数：已有<span>0</span>人出游此线路</li>
<li>提前报名：建议提前一天报名</li>
<!-- 点击添加到购物车，发出shopping请求，并将商品主键和要购买的商品数量作为参数传递到对应处理的servlet -->
<li><a onclick="aaa();" href="#"><img src="images/jgwc.jpg" width="122" height="42" /></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="order.jsp"><img src="images/js.jpg" width="123" height="43" /></a></li>
</ul>
</div>
</div>
<div class="tuijian">
<div class="tuijian-m">推荐理由</div>
<div class="tuijian-inf">
<ul>
<li>含3早6正，早餐6元/人/餐，正餐15元/人/餐（十人一桌、四荤四素、八菜一汤、不含酒水）</li>
<li>标准等当地非星级酒店，参考酒店，长沙：万怡商务酒店、广圣风景酒店、佳居酒店；武陵源：永辉、福立德；凤凰 ：星期八酒店、慢走商务 (2-3人间，独立卫生间、彩电、定时热水19:00—23:00、定时空调，无一次性用品)。</li>
<li>轻松休闲之旅，漫步古城，体会千年文化。</li>
</ul>
</div>
<div class="tuijian-t">特别优惠</div>
<div class="tuijian-inf">
<ul>
<li>凤凰古城是国家历史文化名城，曾被新西兰著名作家路易艾黎称赞为中国最美丽的小城。</li>
<li>热热闹闹的土家风情园，感受当地独特的人文底蕴。</li>
<li>武昌/长沙往返空调火车硬座，当地空调旅游车（保证一人一座）</li>
</ul>
</div>
</div>
<div class="jianjie">
<div class="jianjie-m">景点简介</div>
<div> 张家界土家风情园坐落在风景明珠张家界市境内。交通十分便利，距机场、火车站仅十分钟车程。园区占地80余亩,总投资7500万元，是一座人文景观与自然景观相融合，集旅游观光、文艺表演、奇珍展览、住宿、餐饮、娱乐、购物等于一体的大型综合性旅游服务企业。土家风情园主要由土家建筑群落、民风民俗展示、文艺演出、客房、餐饮、大型狩猎场、珍稀植物园、根雕基地等功能区构成。 园内建筑多为木石结构，雕梁画栋，金碧辉煌，飞檐翘角，玲珑雅致。代表作有土司城堡、摆手堂、土家山寨、垕王宫等。特别是冲天楼，依山造阁，气势恢宏，楼高48米，九重十二层，曲径回复，独具匠心。祭祖活动、土家历史文物展示、土家民俗演示，园内的建筑多为木石结构，雕梁画栋、金壁辉煌、飞檐翘角、玲珑雅致，代表作有土司城堡、摆手堂、土家山寨、垕王宫等。特别是冲天楼，依山造阁，气势恢宏，楼高48米，九重十二层，曲径回复，独具匠心，曾荣获&ldquo;九重天&rdquo;&ldquo;千人毛古斯&rdquo;两项世界吉尼斯之最，土家园林艺术等丰富多彩 </div>
</div>
<div class="tuijian">
  <div class="tuijian-m">温馨提示</div>
  <div class="tuijian-inf">
    <ul>
      <li> 按2人入住1间房核算，如出现单男单女，尽量安排该客人与其他同性别团友拼房；如不愿拼房或未能拼房，请补齐单房差以享用单人房间。 </li>
      <li> 当地购物时请慎重考虑，把握好质量与价格，务必索要发票。 </li>
      <li> 出团通知最晚于出团前1天发送，若能提前确定，我们将会第一时间通知您。 </li>
      <li> 出游过程中，如产生退费情况，以退费项目旅行社折扣价为依据，均不以挂牌价为准。 </li>
      <li> 如遇国家政策性调整门票、交通价格等，按调整后的实际价格结算。 </li>
    </ul>
  </div>
</div>
</div>
<!--主体内容第一部分结束-->
<!--底部-->
<div id="foot">
<div id="foot-t"><p>许可证编号：WE125482154 鄂ICP备125478966</p>
<p><a href="#">隐私保护</a> | <a href="#">诚聘英才</a> | <a href="#">关于我们</a> | <a href="#">网站地图</a> | <a href="#">友情链接</a> | <a href="#">商务合作</a></p>
</div>
</div>
</body>
</html>
