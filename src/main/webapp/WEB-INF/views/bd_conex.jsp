<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
try {
	String driver = "org.postgresql.Driver";
	String url = "jdbc:postgresql://localhost:5432/comegana";
	String username = "postgres";
	String password = "123";
	Connection myConnection = null;
	PreparedStatement myPreparedStatement = null;
	Class.forName(driver).newInstance();
	myConnection = DriverManager.getConnection(url,username,password);
	if (myConnection != null){ 
		System.out.println("Conexion establecida...");
		out.print("Conexión exitosa...");
	}
	else{
		System.out.println("Conexion no establecida...");
		out.print("Conexión fallida...");
	}
}
catch(ClassNotFoundException e){
	System.out.println("No se encontro la clase org.postgresql.Driver");
}
catch (SQLException ex)
{
	out.print("SQLException: "+ex.getMessage());
	out.print("SQLState: " + ex.getSQLState());
	out.print("VendorError: " + ex.getErrorCode());
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>