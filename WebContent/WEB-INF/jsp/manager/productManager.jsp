<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../theme/1/css/common.css">
<link rel="stylesheet" type="text/css" href="../theme/1/css/front/style.css">

<h1 align="center">产品管理</h1>
<hr color="blue"/><br>
<c:forEach items="${productList }" var="c">
	<div class="art_box">
		<div class="art_img">
			<center><br>产<br>品<br>信<br>息</center>
		</div>
			<div class="art_txt">
  	     	 	<div class="title">${c.name }</div>
  	     		<div class="tag_txt">
  	     			<span>归属栏目：${c.category.name }</span>
  	     			<span class="pl30">
  	     				<a href="javascript:void(0)" val="${c.id }" class="upd" >修改产品信息</a>
  	     			</span>
  	     			<span class="pl30">
  	     				<a href="javascript:void(0)" val="${c.id }" class="del">删除产品</a>
  	     			</span>
  	     		</div>
  		      	<div class="tag_txt">
   	         		<span>产品价格：${c.price }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   	         		<span>发布单位：${c.author }</span>
			</div>
			</div>
	</div>
</c:forEach>

<script>
    //页面点击是默认加载
	$(function(){
		$(".upd").off();
		$(".upd").on("click",function(){
			var id = $(this).attr("val");
			$(".right").load("toUpdateProduct.action",{id:id});
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
				$.post("deleteProduct.action",{id:id},function(){
					//默认点击某栏目
					$(".baseUI li :contains('产品管理')").trigger("click");
				});
			}
		});
	});
</script>