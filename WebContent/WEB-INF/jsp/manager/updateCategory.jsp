<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jquery  jquery.form 异步提交 -->
<script>
	$(function(){
		var form = $("#updateCategoryForm");
		form.off();
		form.on("submit",function(){
			form.ajaxSubmit(function(){
				alert("修改成功！");
				//模拟点击栏目管理
				$(".baseUI li :contains('栏目管理')").trigger("click");
			});
			
			return false;
		})
			
	})

</script>
<center style="color: blue">
<h1>修改栏目页面</h1>
<hr><br/>
<form action="updateCategory.action" method="post" id="updateCategoryForm">
	<input type="hidden" name="id" value="${category.id }"/>
	栏目名称:<input type="text" name="name" value="${category.name }"/><br/>
	栏目编号:<input type="text" name="code" value="${category.code }"/><br/>
	<input type="submit" value="提交"/><br/>
</form>
</center>