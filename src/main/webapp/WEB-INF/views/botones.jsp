<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String accion = request.getParameter("submit");
	if (accion != null)
		System.out.println("acci�n realizada: " + accion);
	if (accion == null){
		System.out.println("No se ha presionado ning�n bot�n");
	}else if (accion.equals("primero")){
		System.out.println("Presion� ir al primero");
	}else if (accion.equals("anterior")){
		System.out.println("Presion� ir al anterior");
	}else if (accion.equals("siguiente")){
		System.out.println("Presion� ir al siguiente");
	}else if (accion.equals("ultimo")){
		System.out.println("Presion� ir al �ltimo");
	}else{
		System.out.println("Acci�n desconocida...");
	}
%>
								<CENTER><BR>
									<TABLE cellspacing=2 cellpading=2>
										<tr>						
											<c:url value="/botones" var="formUrl"/>
										    <form:form class="clearfix" method="GET" action="${formUrl}">
												<tr align="center">
													<td><input type="submit" name="submit" value="primero" class="btn btn-primary btn-lg" /></td>
													<td><input type="submit" name="submit" value="anterior" class="btn btn-primary btn-lg" /></td>
													<td><input type="submit" name="submit" value="siguiente" class="btn btn-primary btn-lg" /></td>
													<td><input type="submit" name="submit" value="ultimo" class="btn btn-primary btn-lg" /></td>
												</tr>
											</form:form>
										</tr>
									</TABLE>
								</CENTER> 

</body>
</html>