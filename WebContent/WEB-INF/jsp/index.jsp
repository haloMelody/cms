<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>杰普科技首页</title>
<link rel="stylesheet" type="text/css" href="theme/1/css/common.css">
<link rel="stylesheet" type="text/css" href="theme/1/css/front/style.css">

</head>

<body>
<div id="main">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="content">
    	<div class="congw">
            <div class="clear"></div>
            
            <div class="box">
            
            	<c:forEach items="${categoryList }" var="c" >  
            	
                <div class="box_b">
                	<div class="title">
                    	<span class="txt_title">${c.name }有关产品</span>
                        <span class="txt_time">产品价格</span>
                    </div>
                    <div class="cont">
                    
                    	<ul class="discipUI">
                    		<c:forEach items="${c.products }" var="a">
                        	<li>	
                            	<span class="txt_title">${a.name }</span>
                            	<span class="txt_discipline">${a.price }</span>
                            </li>
                            </c:forEach>
                            
                           
                        </ul>
                    </div>
                </div>
                </c:forEach> 
                
            </div>
           
            
            
            
            <div class="link">
            	<div class="linelink">
            		<span>友情链接：</span><a href="javascript:void(0)">上海教育网</a><a href="javascript:void(0)">上海杰普软件科技有限公司</a><a href="javascript:void(0)">江西理工大学</a><a href="javascript:void(0)">南昌校区</a>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
    	<div class="foot">
        	<p>杰普信息发布系统 技术支持：<a href="javascript:void(0)">上海杰普软件科技有限公司</a>      电话：021-xxxxxxx</p>
        </div>
    </div>
</div>
</body>
</html>
