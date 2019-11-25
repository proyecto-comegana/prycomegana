<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="conexion.*" %>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="org.jfree.chart.plot.*" %>
<%@ page import="org.jfree.data.general.*" %>
<%@ page import="org.jfree.data.category.DefaultCategoryDataset.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	HttpSession session1 = request.getSession();
	String rec = (String)session1.getAttribute("sRecurso");
	System.out.println("desde grafusuarios sRecurso: " + rec);
	String fec = (String)session1.getAttribute("sFecha");
	System.out.println("desde grafusuarios sFecha: " + fec);
	int x = 0;
	//CONTAMOS LA CANTIDAD DE ACCESOS
	try{
		Conectar conectar = new Conectar();
		Connection connection;
		connection = conectar.Conecta();
		String sqlCont = "select count(*) from accesos where pagina = ? And fecha = ?";
		PreparedStatement psCont = connection.prepareStatement(sqlCont);
        psCont.setString(1, rec);
        psCont.setString(2, fec);
		ResultSet rsCont = psCont.executeQuery();
        if (rsCont.next()){
        	x = rsCont.getInt(1);
        	System.out.println("numero de accesos desde grafusuarios: " + x);
        }
        connection.close();
	}catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
	//REGLA DE TRES
	//X               ->   100
	//rsCont.getInt(1)->   ?
	//rsCont.getInt(1)*100/x
	//AQUI GENERAMOS LA TORTA
	CrudPersona persona = new CrudPersona();
	Connection con = persona.Conecta();
	HttpSession sesion_actual = request.getSession();
	System.out.println("Total accesos desde grafusuarios");

	if (con != null)
		out.print("Esta conectado a la base de datos comegana...");
	else
		out.print("No se ha podido conectar a la base de datos");

	DefaultPieDataset data = new DefaultPieDataset();

	HttpSession sesion_actua = request.getSession();
	System.out.println("Numero de accesos grafusuarios: " +sesion_actua.getAttribute("numaccesos"));
	
	try{
		String sqlCont = "select * from estadxusuario";
		PreparedStatement psCont = con.prepareStatement(sqlCont);
		ResultSet rsCont = psCont.executeQuery();
		String lblCodUsuario = new String("");  
		int porcentaje = 0;
		System.out.println("Valor x: " + x);
		while (rsCont.next()){
			porcentaje = rsCont.getInt(2) * 100 / x;
			lblCodUsuario = "Usuario" + "_" + rsCont.getInt(1) + " (" + porcentaje + "%)"; 	
 			data.setValue(lblCodUsuario, rsCont.getInt(2));
        }
        JFreeChart grafico = ChartFactory.createPieChart("Accesos por usuario ("+rec+","+fec+")", data, true, true, true);
        response.setContentType("image/JPEG");
        OutputStream sa = response.getOutputStream();
        ChartUtilities.writeChartAsJPEG(sa, grafico, 600, 600);
        con.close();
	}catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
%>
</body>
</html>