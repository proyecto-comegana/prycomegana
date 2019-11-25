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
<%@ page import="org.jfree.util.Rotation" %>

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
	System.out.println("desde grafestados sRecurso: " + rec);
	String fec = (String)session1.getAttribute("sFecha");
	System.out.println("desde grafestados sFecha: " + fec);
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
        	System.out.println("numero de accesos desde grafestados: " + x);
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
	System.out.println("Total accesos desde grafestados");

	if (con != null)
		out.print("Esta conectado a la base de datos comegana...");
	else
		out.print("No se ha podido conectar a la base de datos");

	DefaultPieDataset data = new DefaultPieDataset();
	
	HttpSession sesion_actua = request.getSession();
	System.out.println("Numero de accesos grafestados: " +sesion_actua.getAttribute("numaccesos"));
	
	try{
		String sql = "select * from estadxestados";
		PreparedStatement psCont = con.prepareStatement(sql);
		ResultSet rsCont = psCont.executeQuery();
		int porcentaje = 0;
		System.out.println("Valor x: " + x);
		while (rsCont.next()){
			porcentaje = rsCont.getInt(2) * 100 / x;
 			data.setValue(rsCont.getString(1) + " (" + porcentaje + "%)", rsCont.getInt(2));
        }
		
        JFreeChart grafico = ChartFactory.createPieChart3D("Accesos por estado ("+rec+","+fec+")", data, true, true, true);
		final PiePlot3D plot = (PiePlot3D)grafico.getPlot();
		plot.setStartAngle(290D);
		plot.setDepthFactor(0.5);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.80f);
		plot.setInteriorGap(0.03);
        response.setContentType("image/JPEG");
        OutputStream sa = response.getOutputStream();
        ChartUtilities.writeChartAsJPEG(sa, grafico, 750, 500);
   		con.close();
	}catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
%>
	
</body>
</html>