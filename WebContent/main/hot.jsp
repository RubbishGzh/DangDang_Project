<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>
	<span class="more"><a href="${pageContext.request.contextPath}/main/main.jsp?itemN=17" >更多&gt;&gt;</a> </span>热销图书

</h2>
<div class="book_c_04">
	
	<!--热销图书A开始-->
	<c:forEach var='s' items="${requestScope.list }">
		<div class="second_d_wai">
			<div class="img">
				<a href="${pageContext.request.contextPath }/ProductController/product/productshow.do?ddProId=${s.dd_product_id}" target='_blank'> 
					<img border=80  src="../productImages/${s.dd_product_img }" /> 
				</a>
			</div>
			<div class="shuming">
				<a 
					href="${pageContext.request.contextPath }/ProductController/product/productshow.do?ddProId=${s.dd_product_id}" target='_blank'> 
					${s.dd_product_name }
				</a>
			</div>
			<div class="price">
				定价：${s.dd_product_price }
			</div>
			<div class="price">
				当当价:${s.dd_product_ddprice }
			</div>
		</div>
			
		<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>