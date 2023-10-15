<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import ="vo.BoardBean" %>
<%
	BoardBean article = (BoardBean) request.getAttribute("article");
	String nowPage = (String) request.getAttribute("page");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다운로드</title>
</head>
<body>
	첨부파일이 다운로드 되었습니다.
	<a href="boardList.bo">게시판으로 이동</a>
</body>
</html>
