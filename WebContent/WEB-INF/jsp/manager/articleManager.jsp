<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../theme/1/css/common.css">
<link rel="stylesheet" type="text/css" href="../theme/1/css/front/style.css">

<h1 align="center">文章管理</h1>
<hr color="blue"/><br>
<c:forEach items="${articleList }" var="c">
	<div class="art_box">
		<div class="art_img">
			<a href="javascript:void(0)" val="${c.id }" class="read" >
				<img src="../theme/1/images/front/doc.png">
			</a>
		</div>
			<div class="art_txt">
  	     	 	<div class="title">${c.title }</div>
  	     		<div class="tag_txt">
  	     			<span>归属栏目：${c.category.name }</span>
  	     			<span class="pl30">
  	     				<a href="javascript:void(0)" val="${c.id }" class="upd" >修改文章</a>
  	     			</span>
  	     			<span class="pl30">
  	     				<a href="javascript:void(0)" val="${c.id }" class="del">删除文章</a>
  	     			</span>
  	     		</div>
  		      	<div class="tag_txt">
   	         		<span>撰写人：${c.author }</span>
   	         		<span class="pl30">上传时间：${c.publisurDate }</span>
   	         		<span class="pl30">点击次数：${c.clickTimes }</span>
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
			$(".right").load("toUpdateArticle.action",{id:id});
		});
		
		$(".read").off();
		$(".read").on("click",function(){
			var id = $(this).attr("val");
			$(".right").load("toReadArticle.action",{id:id});
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
				$.post("deleteArticle.action",{id:id},function(){
					//默认点击某栏目
					$(".baseUI li :contains('文章管理')").trigger("click");
				});
			}
		});
	});
</script>
	