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
	Integer numregxpag = new Integer(10);
	s.setAttribute("numregxpag", "10");
%>
	<a href="rpruebasesion">Ir a Pagina</a>
</body>
</html>