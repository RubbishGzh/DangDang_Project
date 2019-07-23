<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>生成订单 - 当当网</title>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
 
        function checkname(){
        
           var nameTxt = document.getElementById("receiveName");
		   var spanobj=document.getElementById("name.info");
		   if(nameTxt.value == ""){
		   		spanobj.innerHTML="<font color=red>名字不能为空</font>";
		      	return false;
		   }else
		   spanobj.innerText = "";
		   return true;
          }
         function checkeaddress(){
		    var addressTxt = document.getElementById("fullAddress");
		    var spanobj = document.getElementById("address.info");
			if(addressTxt.value==""){
				spanobj.innerHTML="<font color=red>地址不能为空</font>";
				return false;
			}
			spanobj.innerText ="";
			return true;
			}
		  function checkpostalCode(){
	       var postalCodeTxt = document.getElementById("postalCode");
		   var spanobj=document.getElementById("postalCode.info");
		   if(postalCodeTxt.value==""){
		   	  spanobj.innerHTML="<font color=red>邮编不能为空</font>";
		      return false;
		   }else
		   spanobj.innerText = "";
		   return true;
          }
		  function checkmobile(){
	       var mobileTxt = document.getElementById("mobile");
		   var spanobj=document.getElementById("mobile.info");
		   if(mobileTxt.value==""){
		   	  spanobj.innerHTML="<font color=red>手机号不能为空</font>";
		      return false;
		   }else
		   spanobj.innerText = "";
		   return true;
          }
          function checkphone(){
	       var phoneTxt = document.getElementById("phone");
		   var spanobj=document.getElementById("telphone.info");
		   if(phoneTxt.value==""){
		   	  spanobj.innerHTML="<font color=red>电话不能为空</font>";
		      return false;
		   }else
		   spanobj.innerText = "";
		   return true;
          }
			
			// 表单验证
 			function checkForm(){
				if (checkname()==false 
						|| checkeaddress()==false 
						|| checkpostalCode()==false 
						|| checkmobile()==false
						|| checkphone()==false)
					return false;
				else
					return true;
			}
		
				
	
				
		
			
			
	 		function choiceAddress(obj){
				var a = $(obj).val();
				<s:iterator value="#session.addressList" >
					if(a=="<s:property value="addressId"/>"){
						$("#addressId").val("");
						$("#receiveName").val("<s:property value="addressReceiveName"/>");
						$("#fullAddress").val("<s:property value="addressAdd"/>");
						$("#postalCode").val("<s:property value="addressZipcode"/>");
						$("#phone").val("<s:property value="addressTelephone"/>");
						$("#mobile").val("<s:property value="addressMobile"/>");
						return 0 ;
					}else{
						$("#addressId").val("");
						$("#receiveName").val("");
						$("#fullAddress").val("");
						$("#postalCode").val("");
						$("#phone").val("");
						$("#mobile").val("");
					}
				</s:iterator>
			}
			

			
		</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		生成订单骤: 1.确认订单 ><span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
	</div>
	<div class="fill_message">

		<select id="address" onchange="choiceAddress(this)">
			<p>选择地址：</p>
			<option value="">请选择</option>
			<s:iterator value="#session.addressList">
				<option value="<s:property value="addressId"/>">
					<s:property value="addressAdd" />
				</option>
			</s:iterator>
		</select>
		
		<form name="ctl00" action="<s:url value="/Order/insertIntoListsOrder"/>"
			method="post" id="f" onsubmit="return checkForm()">
	
			<input type="hidden" name="address.id" id="addressId" />
			<table class="tab_login">
				<tr>
					<td valign="top" class="w1">收件人姓名：</td>
					<td><input onblur="checkname()" type="text" class="text_input"
						name="addressReceiveName" id="receiveName" />
						<div class="text_left" id="nameValidMsg">
							<p>请填写有效的收件人姓名</p>
							<span id="name.info" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">收件人详细地址：</td>
					<td><input onblur="checkeaddress()" type="text"
						name="addressAdd" class="text_input" id="fullAddress" />
						<div class="text_left" id="addressValidMsg">
							<p>请填写有效的收件人的详细地址</p>
							<span id="address.info" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">邮政编码</td>
					<td><input onblur="checkpostalCode()" type="text"
						class="text_input" name="addressZipcode" id="postalCode" />
						<div class="text_left" id="codeValidMsg">
							<p>请填写有效的收件人的邮政编码</p>
							<span id="postalCode.info" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">电话</td>
					<td><input onblur="checkphone()" type="text"
						class="text_input" name="addressTelephone" id="phone" />
						<div class="text_left" id="phoneValidMsg">
							<p>请填写有效的收件人的电话</p>
							<span id="telphone.info" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">手机</td>
					<td><input onblur="checkmobile()" type="text"
						class="text_input" name="addressMobile" id="mobile" />
						<div class="text_left" id="mobileValidMsg">
							<p>请填写有效的收件人的手机</p>
							<span id="mobile.info" style="color:red"></span>
						</div></td>
				</tr>
				
		<%-- 		<!-- 隐藏域，保存地址ID -->
					<tr>
					<td valign="top" class="w1">地址ID</td>
					<td><input  type="hidden" 
						class="text_input" name="addressId" id="addressId" />
						<div class="text_left" id="mobileValidMsg">
							<p>自动生成地址ID</p>
							<span id="mobile.info" style="color:red"></span>
						</div></td> --%>
				</tr>
			</table>

			<div class="login_in">
				
				<a href="order/order_info.jsp"><input id="btnClientRegister"
					class="button_1" name="submit" type="submit" value="取消" />
				</a> <input   id="btnClientRegister" class="button_1" name="submit" type="submit" 
				 value="下一步" />
					<!-- onclick="addressNext()" -->
			</div>
		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

