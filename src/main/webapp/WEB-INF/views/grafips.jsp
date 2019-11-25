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
<%@ page import="org.jfree.data.category.DefaultCategoryDataset" %>
<%@ page import="java.awt.Color" %>
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
	System.out.println("desde grafips sRecurso: " + rec);
	String fec = (String)session1.getAttribute("sFecha");
	System.out.println("desde grafips sFecha: " + fec);
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
        	System.out.println("numero de accesos desde grafips: " + x);
        }
        connection.close();
	}catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
	/* 
		REGLA DE TRES CALCULO DE PORCENTAJES
	  	X               ->   100
		rsCont.getInt(1)->   ?
		FORMULA = rsCont.getInt(1)*100/x
	*/
	
	//AQUI GENERAMOS EL HISTOGRAMA 2D
	CrudPersona persona = new CrudPersona();
	Connection con = persona.Conecta();
	HttpSession sesion_actual = request.getSession();
	System.out.println("Total accesos desde grafips");

	if (con != null)
		out.print("Esta conectado a la base de datos comegana...");
	else
		out.print("No se ha podido conectar a la base de datos");

	DefaultCategoryDataset data = new DefaultCategoryDataset();
	HttpSession sesion_actua = request.getSession();
	System.out.println("Numero de accesos grafips: " +sesion_actua.getAttribute("numaccesos"));
	try{
		String sql = "select * from estadxips";
		PreparedStatement psCont = con.prepareStatement(sql);
		ResultSet rsCont = psCont.executeQuery();
		int porcentaje = 0;
		System.out.println("Valor x desde grafips: " + x);
		while (rsCont.next()){
			porcentaje = rsCont.getInt(2) * 100 / x;
 			data.setValue(rsCont.getInt(2), "Puntajes", rsCont.getString(1) + " (" + porcentaje + "%)");
        }
		
		JFreeChart chart = ChartFactory.createBarChart("Accesos por ips ("+ rec + ", " + fec +")", "Dirección ip", "Puntaje", data, PlotOrientation.HORIZONTAL, false, true, false);
		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.black);
		ChartFrame frame = new ChartFrame("Histograma accesos por ip", chart);
		frame.setVisible(true);
		frame.setSize(500, 400);
	}
	catch(Exception e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
%>

</body>
</html>