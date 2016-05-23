<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <style>
 	th{
		background: lightblue;
		font-family: 微软雅黑;
		font-size: 14px;
	}
	td{
		text-align:center;
		font-family: 微软雅黑
		font-size: 14px;
	}
 </style>
<h1>栏目管理</h1>
<hr color="blue"/>
<table border="1" style="width: 80%;border-collapse: collapse;margin-top: 20px">
	<tr>
		<th>栏目id</th>
		<th>栏目名称</th>
		<th>栏目编号</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${categoryList }" var="c">
		<tr>
			<td><input type="checkbox" value="${c.id }"/></td>
			<td>${c.name }</td>
			<td>${c.code }</td>
			<td>
				<a href="javascript:void(0)" val="${c.id }" class="upd">修改</a>
				<a href="javascript:void(0)" val="${c.id }" class="del">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
<script>
    //页面点击是默认加载
	$(function(){
		$(".upd").off();
		$(".upd").on("click",function(){
			var id = $(this).attr("val");
			//出现错误
			$(".right").load("toUpdateCategory.action",{id:id});
		});
		
		//为某类（按钮）解绑
		$(".del").off();
		//绑定一个事件
		$(".del").on("click",function(){
			//获取val返回值
			var id = $(this).attr("val");
			//提示并返回bool类型变量
			var flag = confirm("确定删除吗？");
			if(flag){
				//执行功能 并且回调
				$.post("deleteCategory.action",{id:id},function(){
					//默认点击某栏目
					$(".baseUI li :contains('栏目管理')").trigger("click");
				});
			}
		});
	});
</script>