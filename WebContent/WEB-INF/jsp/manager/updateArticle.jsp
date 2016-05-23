<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!-- jquery  jquery.form 异步提交 -->
<script>
	$(function(){
		var form = $("#updateArticleForm");
		form.off();
		form.on("submit",function(){
			form.ajaxSubmit(function(){
				alert("修改成功！");
				//模拟点击文章管理
				$(".baseUI li :contains('文章管理')").trigger("click");
			});
			
			return false;
		})
			
	})

</script>
<center style="color: blue">
<h1>修改文章页面</h1>
<hr><br/>
<form action="updateArticle.action" method="post" id="updateArticleForm">
	<input type="hidden" name="id" value="${article.id }"/>
	文章标题:<input type="text" name="title" value="${article.title }"/><br/>
	文章作者:<input type="text" name="author" value="${article.author }"/><br/>
	文章内容:<textarea name="content" rows="10" cols="30">${article.content }</textarea><br/>
	归属栏目:	<select name="category_id">
				<option value="">请选择</option>
				<c:forEach items="${categoryList }" var="c">
				<option value="${c.id }">${c.name }</option>
				</c:forEach>
			</select><br/>
	<input type="submit" value="提交"/><br/>
</form>
</center>