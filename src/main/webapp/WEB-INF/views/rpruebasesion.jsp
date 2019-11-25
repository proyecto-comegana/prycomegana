<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	HttpSession s = request.getSession();
	String numregxpag = (String)s.getAttribute("numregxpag");
	System.out.println("numregxpag: "+(String)s.getAttribute("numregxpag"));
	out.println("numregxpag: "+(String)s.getAttribute("numregxpag"));
%>
</body>
</html>