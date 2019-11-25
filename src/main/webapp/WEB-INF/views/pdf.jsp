<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="conexion.*" %>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="net.sf.jasperreports.engine.JRException" %>
<%@ page import="net.sf.jasperreports.engine.JasperFillManager" %>
<%@ page import="net.sf.jasperreports.engine.JasperPrint" %>
<%@ page import="net.sf.jasperreports.engine.export.JRPdfExporter" %>
<%@ page import="net.sf.jasperreports.export.SimpleExporterInput" %>
<%@ page import="net.sf.jasperreports.export.SimpleOutputStreamExporterOutput" %>
<%@ page import="net.sf.jasperreports.export.SimplePdfExporterConfiguration" %>
<%@ page import="net.sf.jasperreports.view.JasperViewer" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	CrudPersona persona = new CrudPersona();
	Connection con = persona.Conecta();
	if (con != null)
		out.print("Esta conectado a la base de datos comegana...");
	else
		out.print("No se ha podido conectar a la base de datos");

	// descarga dentro del mismo proyecto
	JasperPrint jasperPrint = JasperFillManager.fillReport("C:\\Users\\usuario\\eclipse-workspace\\prycomegana\\src\\main\\java\\reportes\\paisesReporte.jasper", null, con);
	System.out.println("Ruta: "+application.getRealPath("paisesReporte.jasper"));
	JRPdfExporter exp = new JRPdfExporter();
	exp.setExporterInput(new SimpleExporterInput(jasperPrint));
	exp.setExporterOutput(new SimpleOutputStreamExporterOutput("C:\\Users\\usuario\\eclipse-workspace\\prycomegana\\src\\main\\java\\reportes\\ReportePaises.pdf"));
	SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
	exp.setConfiguration(conf);
	exp.exportReport();
	 
	// se muestra en una ventana aparte para su descarga
	//JasperPrint jasperPrintWindow = JasperFillManager.fillReport(application.getRealPath("paisesReporte.jasper"), null, con);
	JasperPrint jasperPrintWindow = JasperFillManager.fillReport("C:\\Users\\usuario\\eclipse-workspace\\prycomegana\\src\\main\\java\\reportes\\paisesReporte.jasper", null, con);
	JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
	jasperViewer.setVisible(true);	
%>
</body>
</html>