<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="backups.*"%>
<%@ page import="java.time.*" %>
<%@ page import="java.time.format.*" %>
<%@ page import="conexion.*" %>
<%@ page import="java.io.File" %>

<!DOCTYPE HTML>
<head>
<meta charset="ISO-8859-1">
<title>Restaurar copia de seguridad</title>
</head>
<body>
<%
	Process proceso;
	ProcessBuilder constructor;
	String host = "localhost";
	String puerto="5432";
	String usuario = "postgres";
	String clave = "123";
	String bd="comegana";
	String formato="custom";
	String path="C:\\Users\\usuario\\eclipse-workspace\\prycomegana\\src\\main\\java\\backups\\bd11.backup";
	CrudPersona persona = new CrudPersona();
	Connection con = persona.Conecta();
	if (con != null)
		out.print("Esta conectado a la base de datos comegana...");
	else
		out.print("No se ha podido conectar a la base de datos");
    try {
        File pgrestore = new File("C:/Program Files/PostgreSQL/9.4/bin\\pg_restore.exe");
        if(pgrestore.exists()){
            constructor = new ProcessBuilder("C:/Program Files/PostgreSQL/9.4/bin\\pg_restore.exe", "-i", "-h", host, "-p", puerto, "-U", usuario, "-d", bd, "-v", path);
            constructor.environment().put("PGPASSWORD", clave);
            constructor.redirectErrorStream(true);
            proceso=constructor.start();
        }else{
            constructor = new ProcessBuilder("/opt/PostgreSQL/9.4/bin/pg_restore", "-i", "-h", host, "-p", puerto, "-U", usuario, "-d", bd, "-v", path);
            constructor.environment().put("PGPASSWORD", clave);
            constructor.redirectErrorStream(true);
            proceso=constructor.start();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
</body>
</html>