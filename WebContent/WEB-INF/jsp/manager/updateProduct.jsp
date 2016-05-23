<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!-- jquery  jquery.form 异步提交 -->
<script>
	$(function(){
		var form = $("#updateProductForm");
		form.off();
		form.on("submit",function(){
			form.ajaxSubmit(function(){
				alert("修改成功！");
				//模拟点击产品管理
				$(".baseUI li :contains('产品管理')").trigger("click");
			});
			
			return false;
		})
			
	})

</script>
<center style="color: blue">
<h1>修改产品页面</h1>
<hr><br/>
<form action="updateProduct.action" method="post" id="updateProductForm">
	<input type="hidden" name="id" value="${product.id }"/>
	产品名称:<input type="text" name="name" value="${product.name }"/><br/>
	产品价格:<input type="text" name="price" value="${product.price}"/><br/>
	发布单位:<input type="text" name="author" value="${product.author}"/><br/>
	归属栏目:	<select name="category_id">
				<option value="">请选择</option>
				<c:forEach items="${categoryList }" var="c">
				<option value="${c.id }">${c.name }</option>
				</c:forEach>
			</select><br/>
	<input type="submit" value="提交"/><br/>
</form>
</center>