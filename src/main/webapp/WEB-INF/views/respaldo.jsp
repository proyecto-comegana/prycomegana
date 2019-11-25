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
<title>Generar Backup</title>
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
	//ESTABLECE FECHA ACTUAL CON FORMATO
	LocalDate fecha;
	fecha = LocalDate.now();
	DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM/dd/YYYY");
	String anio = new String(String.valueOf(fecha.getYear()));
	System.out.println("Año:"+anio);
	anio = anio.substring(2);
	System.out.println("Año:"+anio);
	String path="C:\\Users\\usuario\\eclipse-workspace\\prycomegana\\src\\main\\java\\backups\\bd"+fecha.getMonthValue()+
			fecha.getDayOfMonth()+anio+".backup";
	CrudPersona persona = new CrudPersona();
	Connection con = persona.Conecta();
	if (con != null)
		out.print("Esta conectado a la base de datos comegana...");
	else
		out.print("No se ha podido conectar a la base de datos");

    try{
        File pgdump= new File("C:/Program Files/PostgreSQL/9.4/bin\\pg_dump.exe");
        if(pgdump.exists()){
            if(!path.equalsIgnoreCase("")) {
                constructor = new ProcessBuilder("C:/Program Files/PostgreSQL/9.4/bin\\pg_dump.exe", "--verbose", "--format", formato, "-f", path);
            } else {                             
                constructor = new ProcessBuilder("C:/Program Files/PostgreSQL/9.4/bin\\pg_dump.exe", "--verbose", "--inserts", "--column-inserts", "-f", path);
                System.out.println("ERROR");
            }
            constructor.environment().put("PGHOST", host);
            constructor.environment().put("PGPORT", puerto);
            constructor.environment().put("PGUSER", usuario);
            constructor.environment().put("PGPASSWORD", clave);
            constructor.environment().put("PGDATABASE", bd);
            constructor.redirectErrorStream(true);
            proceso= constructor.start();
            System.out.println("terminado backup " + path);
        }else{
            if(!path.equalsIgnoreCase("")) {
                constructor = new ProcessBuilder("/opt/PostgreSQL/9.4/bin/pg_dump", "--verbose", "--format", formato, "-f", path);
            } else {                             
                constructor = new ProcessBuilder("/opt/PostgreSQL/9.4/bin/pg_dump", "--verbose", "--inserts", "--column-inserts", "-f", path);
                System.out.println("ERROR");
            }
            constructor.environment().put("PGHOST", host);
            constructor.environment().put("PGPORT", puerto);
            constructor.environment().put("PGUSER", usuario);
            constructor.environment().put("PGPASSWORD", clave);
            constructor.environment().put("PGDATABASE", bd);
            constructor.redirectErrorStream(true);
            proceso= constructor.start();
            System.out.println("terminado backup " + path);
            out.println("<h1>Backup realizado exitosamente...</h1>");
        }
    }catch(Exception ex){
        System.err.println(ex.getMessage()+ "Error de backup");
        //hecho=false;
    }
%>
</body>
</html>