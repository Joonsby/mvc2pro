<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String downFile = request.getParameter("downFile");
		out.println(downFile);
	%>
	파일 다운로드 화면입니다.
</body>
</html>