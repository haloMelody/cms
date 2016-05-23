<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<script>
//使页面不发生跳转并不保留原值
	$(function(){
		var form = $("#addProductForm")
		form.off();
		form.on("submit",function(){
			form.ajaxSubmit(function(){
				alert("发布成功");
				form[0].reset();
			});
			return false;
		});
	
	});
</script>

<center style="color: blue">
	<h1>添加产品</h1>
	<hr color="red"><br>
	<form action="addProduct.action" method="post" id="addProductForm">
	产品名称:<input type="text" name="name"/><br/>
	产品价格:<input type="text" name="price"/><br/>
	发布单位:<input type="text" name="author" value="${product.author}"/><br/>
	所属栏目:	<select name="category_id">
				<option value="">请选中</option>
				<c:forEach items="${categoryList }" var="c">
				<option value="${c.id }">${c.name }</option>
				</c:forEach>
			</select><br/>
	<input type="submit" value="提交"/><br/>
</form>
</center>