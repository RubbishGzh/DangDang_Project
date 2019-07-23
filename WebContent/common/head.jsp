<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath }/css/book_head090107.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(function(){

	if($("#nickname").html()!=""){
	$("#nickname").css("display","online");
	$("#remove_login").html("<a href='${pageContext.request.contextPath}/ClientController/remove_login.do' >退出登录</a> | ");
	}
	else{
	$("#login").html("<a href='${pageContext.request.contextPath}/user/login.jsp' >登录</a> | ");
	$("#register").html("<a href='${pageContext.request.contextPath}/user/register.jsp'>注册</a>");
	}
	});

</script>

<div class="head_container">
	<!-- 头部的最顶端，登录|注册               购物车|我的当当|帮助 -->
	<div class="head_welcome">
		<div class="head_welcome_right">
		<span class="head_welcome_text"></span>
			<span class="head_welcome_text"></span>
			<span class="head_welcome_text"> 
				<span class="little_n">
				| <a href="#" name="mydangdang" class="head_black12a">我的当当</a>|
				<a href="#" name="helpcenter" class="head_black12a" target="_blank">帮助</a>
					| 
					<a id="login"></a>
					<a id="register"></a>
					<a id="remove_login"></a>
					<span id="nickname" style="display:none">${sessionScope.nickname}</span>
				</span> 
			</span>
			<div class="cart gray4012">
				<a href="${pageContext.request.contextPath}/cart/cart_list.jsp" />购物车</a> 
			</div>
		</div>
		
		<!-- 头部的最左侧，没有登录的时候显示登录|注册；登录成功之后，显示欢迎语 -->
		<span class="head_toutext" id="logininfo">
			
			<c:if test="${sessionScope.user != null }" >
				<!-- 显示欢迎语 -->
				${user.ddUserNickName },欢迎您！ 
				<!-- 注销，返回登录页面 -->
				<a href="${pageContext.request.contextPath }/user/clearSessionUser.do" class="b">注销</a>
			</c:if>
			
		</span>
	</div>
	<!-- =========END=======头部的最顶端，登录|注册               购物车|我的当当|帮助===========END== -->
	
	<!-- 头部的当当网logo -->
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo"><a href="${pageContext.request.contextPath }/main/main.jsp" name="backtobook"><img
						src="${pageContext.request.contextPath }/images/booksaleimg/book_logo.gif" /> </a> </span>
		</div>
		<div class="head_head_list_right">
			<div class="head_head_list_right_b">
			</div>
		</div>
	</div>
	<!-- ======END=====头部的当当网logo=========END======= -->
	
	<!-- 这个div可加入全局搜索的功能 -->
	<%-- <div class="head_search_div" style="text-align:center">
	<form action='#' method="get">
	<select id="globalSerch" name="">
			<option value="">请选择</option>
	  		<option value="dsp.productName">书名</option>
	  		<option value="dsp.productAuthor">作者</option>
	  		<option value="dsp.productDdprice">当当价</option>
	  		<option value="<s:property value="id"/>" ><s:property value="address"/></option>
	</select>
		<input id="selectName" type="text" name="" />
		<input type="submit" value="查询" />
	</form>
	
	</div> --%>
	<!-- <div class="head_search_bg"></div> -->
</div>
