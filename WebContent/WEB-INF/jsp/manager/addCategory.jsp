<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
//使页面不发生跳转并不保留原值
	$(function(){
		var form = $("#addCategoryForm")
		form.off();
		form.on("submit",function(){
			form.ajaxSubmit(function(){
				alert("添加成功");
				form[0].reset();
			});
			return false;
		});
	
	});
</script>

<center style="color: blue">
	<h1>添加栏目</h1>
	<hr color="red"><br>
	<form action="addCategory.action" method="post" id="addCategoryForm">
		栏目名称：<input type="text" name="name"/><br/>
		栏目编号：<input type="text" name="code"/><br/>
		<input type="submit" value="添加"/>
	</form>
</center>