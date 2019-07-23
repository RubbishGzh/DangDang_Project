<%@page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
ul li {
	text-decoration: none;
	list-style-type: none;
	line-height: 20px;
}

body {
	font-family: 宋体, Arial, Helvetica, sans-serif;
	font-size: 12px;
	background: #769b72 url(../images/booksaleimg/bg_grad.gif) top center
		no-repeat;
	cursor: default;
	color: #404040;
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	/* 购买时，点击添加进入订单项 传入一个bookid */
		function addCart(id) {
		$("#buy"+id).prop("src","${pageContext.request.contextPath}/CartController/cart_AddBook.do?id="+id+"&time="+new Date().getTime());
		setTimeout("t1('"+id+"')",10);
		setTimeout("t2('"+id+"')",1000);
		setTimeout("t3('"+id+"')",1500);
	}
	/*0秒   从点击购买小图标           1秒  到反应小图标          1.5秒 到购买成功的对勾小图标*/
 	function t1(id) {
		$("#buy"+id).prop("src","${pageContext.request.contextPath}/images/load.gif");
	}
	function t2(id) {
		$("#buy"+id).prop("src","${pageContext.request.contextPath}/images/label3.gif");
	}
	function t3(id) {
		$("#buy"+id).prop("src","${pageContext.request.contextPath}/images/buttom_goumai.gif");
	}
	</script>
</head>
<body>
	<div style="width: 60%;margin:20px auto;">
		<div style="width:100%;float: left;">
			<h1>
			${product.dd_product_name }
				
				
			</h1>
			<div>
				<div style="float: left;width:20%;">
					<img
						src="${pageContext.request.contextPath}/productImages/${product.dd_product_img }"
						border=0 />
				</div>
				<div style="float: left;width:80%">
					<ul class="info">
						<li>作&nbsp;者：${product.dd_product_author }</li>
						<li>出版社： ${product.dd_product_press }</li>
						<li style="float:left;width:50%;">
							出版时间：${product.dd_product_presstime }
						</li>
						<li style="float:left;width:50%;">
							字数：${product.dd_product_wordcount }
						</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">
							版本号：${product.dd_product_edition }
						</li>
						<li style="float:left;width:50%;">
							页数：${product.dd_product_pagecount }
						</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">
							印刷时间：${product.dd_product_printtime }
						</li>
						<li style="float:left;width:50%;">
							页面规格：${product.dd_product_format }
						</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">
							印次：${product.dd_product_printcount }
						</li>
						<li style="float:left;width:50%;">
							纸张：${product.dd_product_paper }
						</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">
							ISBN：${product.dd_product_isbn }
						</li>
						<li style="float:left;width:50%;">
							包装：${product.dd_product_pack }
						</li>
						<li>
							<div class='your_position'>
								您现在的位置:&nbsp; <a href='../main/main.jsp'>当当图书</a> &gt;&gt; 
								<font style='color: #cc3300'> 
									<strong> 图书展示
									</strong>
								</font>
							</div>
						</li>
						<li>定价：￥${product.dd_product_price }&nbsp;&nbsp;
							当当价：￥${product.dd_product_ddprice }&nbsp;&nbsp; 
							节省：￥${product.dd_product_price -  product.dd_product_ddprice}</li>
							
						<li>
							<a href="javascript:void(0)"> 
								<img src='${pageContext.request.contextPath}/images/buttom_goumai.gif' class="abc"
									id="buy${product.dd_product_id }"
								    onclick="addCart('${product.dd_product_id }')" />
									
							</a>
						</li>
						
					</ul>
				</div>
				<div style="float: clear;"></div>
			</div>
		</div>

		<div style="width:100%;float: left;">
			<hr width="" size="1">
				<div>
					<h2>编辑推荐</h2>
					${product.dd_product_recommend }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>内容简介</h2>
					${product.dd_product_brief }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>作者简介</h2>
					${product.dd_product_authorbrief }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>目录</h2>
					${product.dd_product_directory }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>媒体评论</h2>
					${product.dd_product_mediacomment }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>书摘插图</h2>
					${product.dd_product_excerpt }
				</div>
			</hr>
			<div>
				<div style="float: clear"></div>
				<p>&nbsp;</p>
			</div>
		</div>
	</div>
	<!--页尾开始 -->
	<%@include file="../common/foot.jsp"%>
	<!--页尾结束 -->
</body>
</html>