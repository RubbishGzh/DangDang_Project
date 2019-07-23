<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	
	<c:forEach var='s' items="${requestScope.list }">
		<div class=second_c_02_b1>
			<a href="${pageContext.request.contextPath }/ProductController/product/productshow.do?ddProId=${s.dd_product_id}" target='_blank'> 
			<div class=second_c_02_b1_1>
				<img border=0 height="110px" src="../productImages/${s.dd_product_img }" />
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					书名：${s.dd_product_name }</a>
				</h3>
				<h4>
					作者：${s.dd_product_author }
					<br />
					出版社：${s.dd_product_press }
					出版时间：${s.dd_product_presstime }
				</h4>
				<h5>
					简介：${s.dd_product_brief }
				</h5>
				<h6>
					定价：${s.dd_product_price }
					当当价：${s.dd_product_ddprice }
				</h6>
				<div class=line_xx></div>
			</div>
			<a>
		</div>
	</c:forEach>
	
	
			
	</div>
</div>

