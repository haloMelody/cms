<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<script>
//使页面不发生跳转并不保留原值
	$(function(){
		var form = $("#addArticleForm")
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
	<h1>发布文章</h1>
	<hr color="red"><br>
	<form action="addArticle.action" method="post" id="addArticleForm">
	文章标题:<input type="text" name="title"/><br/>
	文章作者:<input type="text" name="author"/><br/>
	所属栏目:	<select name="category_id">
				<option value="">请选中</option>
				<c:forEach items="${categoryList }" var="c">
				<option value="${c.id }">${c.name }</option>
				</c:forEach>
			</select><br/>
	文章内容:
			<textarea name="content" rows="10" cols="30"></textarea><br/>
	<input type="submit" value="提交"/><br/>
</form>
</center>