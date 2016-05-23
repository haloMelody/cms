<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<center>
<h1 align="center">${article.title }</h1>
<h4>作者：${article.author }&nbsp;&nbsp;&nbsp;&nbsp;发布时间：${article.publisurDate }</h4>
<hr color="blue"/><br>
<textarea name="content" rows="40" cols="80">${article.content }</textarea>
</center> 