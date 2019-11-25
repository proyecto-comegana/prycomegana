<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="conexion.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!doctype html>
<html lang="us">
<head>
<%
	//LIMPIA TABLA TEMPORAL ESTADXUSUARIO
	try{
		Conectar conectar3 = new Conectar();
		Connection connection3;
		connection3 = conectar3.Conecta();
        //CONTEO DE ACCESOS DIARIO
        String sql = "delete from estadxusuario";
        PreparedStatement psConteoEstados = null;
		psConteoEstados = connection3.prepareStatement(sql);
        ResultSet rsConteoEstados = psConteoEstados.executeQuery();
        connection3.close();
	}
	catch(Exception e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
%>
<%
	//LIMPIA TABLA TEMPORAL ESTADXESTADOS
	try{
		Conectar conectar4 = new Conectar();
		Connection connection4;
		connection4 = conectar4.Conecta();
        //CONTEO DE ACCESOS DIARIO
        String sql = "delete from estadxestados";
        PreparedStatement psConteoEstados = null;
		psConteoEstados = connection4.prepareStatement(sql);
        ResultSet rsConteoEstados = psConteoEstados.executeQuery();
        connection4.close();
	}
	catch(Exception e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
%>
<%
	//LIMPIA TABLA TEMPORAL ESTADXIPS
	try{
		Conectar conectar6 = new Conectar();
		Connection connection6;
		connection6 = conectar6.Conecta();
        //CONTEO DE ACCESOS DIARIO
        String sql = "delete from estadxips";
        PreparedStatement psConteoIps = null;
		psConteoIps = connection6.prepareStatement(sql);
        ResultSet rsConteoEstados = psConteoIps.executeQuery();
        connection6.close();
	}
	catch(Exception e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
%>

	<meta charset="utf-8">
	<title>P&aacute;gina estadistica diaria</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">

	<link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico"/>">
	<link href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet">
	<!-- CSS -->
	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/flexslider.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet" type="text/css" media="all" />
    <link href="<c:url value="/resources/css/owl.carousel.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/colors/"/>" rel="stylesheet" type="text/css" id="colors" />
    
	<!-- FONTS -->
	<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500italic,700,500,700italic,900,900italic' rel='stylesheet' type='text/css'>
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">	
    
	<!-- SCRIPTS -->
	<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <!--[if IE]><html class="ie" lang="en"> <![endif]-->
    
	<link type="text/css" href="<c:url value="/resources/js/jquery-ui.css"/>" rel="stylesheet">	
	<link type="text/css" href="<c:url value="/resources/js/jquery-ui.min.css"/>" rel="stylesheet">	
	<link type="text/css" href="<c:url value="/resources/js/jquery-ui.structure.css"/>" rel="stylesheet">	
	<link type="text/css" href="<c:url value="/resources/js/jquery-ui.structure.min.css"/>" rel="stylesheet">	
	<link type="text/css" href="<c:url value="/resources/js/jquery-ui.theme.css"/>" rel="stylesheet">	
	<link type="text/css" href="<c:url value="/resources/js/jquery-ui.theme.min.css"/>" rel="stylesheet">	

	<script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.nicescroll.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/superfish.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.flexslider-min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/owl.carousel.js"/>"></script>
	<script src="<c:url value="/resources/js/animate.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/myscript.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery-ui.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery-ui.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/external/jquery/jquery.js"/>"></script>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<style>
		.demoHeaders {
			margin-top: 2em;
		}
		#dialog-link {
			padding: .4em 1em .4em 20px;
			text-decoration: none;
			position: relative;
		}
		#dialog-link span.ui-icon {
			margin: 0 5px 0 0;
			position: absolute;
			left: .2em;
			top: 50%;
			margin-top: -8px;
		}
		#icons {
			margin: 0;
			padding: 0;
		}
		#icons li {
			margin: 2px;
			position: relative;
			padding: 4px 0;
			cursor: pointer;
			float: left;
			list-style: none;
		}
		#icons span.ui-icon {
			float: left;
			margin: 0 4px;
		}
		.fakewindowcontain .ui-widget-overlay {
			position: absolute;
		}
		select {
			width: 200px;
		}
	</style>
</head>
<body>
<!-- PRELOADER -->
<img id="preloader" src="<c:url value="/resources/images/preloader.gif"/>" alt="" />
<!-- //PRELOADER -->
<div class="preloader_hide">

	<!-- PAGE -->
	<div id="page" class="single_page">
	
		<!-- HEADER -->
		<header>
			
			<!-- MENU BLOCK -->
			<div class="menu_block">
			
				<!-- CONTAINER -->
				<div class="container clearfix">
					
					<!-- LOGO -->
					<div class="logo pull-left">
						<a href="<c:url value="home.jsp"/>" ><span class="b1">w</span><span class="b2">h</span><span class="b3">i</span><span class="b4">t</span><span class="b5">e</span></a>
					</div><!-- //LOGO -->
					
					<!-- SEARCH FORM -->
					<div id="search-form" class="pull-right">
						<form method="post" action="#">
							<input type="text" name="Search" value="Search" onFocus="if (this.value == 'Search') this.value = '';" onBlur="if (this.value == '') this.value = 'Search';" />
						</form>
					</div><!-- SEARCH FORM -->
					
					<!-- MENU -->
					<div class="pull-right">
						<nav class="navmenu center">
							<ul>
								<li class="first scroll_btn"><a href="<c:url value="home"/>">Inicio</a></li>
								<li class="scroll_btn"><a href="<c:url value="home.jsp#about"/>">Acerca de nosotros</a></li>
								<li class="scroll_btn"><a href="<c:url value="home.jsp#projects"/>">Proyectos</a></li>
								<li class="scroll_btn"><a href="<c:url value="home.jsp#team"/>">Equipo</a></li>
								<li class="scroll_btn"><a href="<c:url value="home.jsp#news"/>">Noticias</a></li>
								<li class="scroll_btn last"><a href="<c:url value="home.jsp#contacts"/>">Contactos</a></li>
								<li class="sub-menu active">
									<a href="javascript:void(0);">P&aacute;ginas</a>
									<ul>
										<li class="active"><a href="<c:url value="blog"/>">Blog</a></li>
										<li><a href="<c:url value="blog-post.html"/>">Blog Post</a></li>
										<li><a href="<c:url value="portfolio-post.html"/>">Portafolio Trabajo Individual</a></li>
									</ul>
								</li>
							</ul>
						</nav>
					</div><!-- //MENU -->
				</div><!-- //MENU BLOCK -->
			</div><!-- //CONTAINER -->
		</header><!-- //HEADER -->
		
		<!-- BREADCRUMBS -->
		<section class="breadcrumbs_block clearfix parallax">
			<div class="container center">
				<h2><b>Datos</b> del reporte diario</h2>
				<p>Actualice los datos del reporte diario</p>
			</div>
		</section><!-- //BREADCRUMBS -->

		<!-- BLOG -->
		<section id="blog">
			<!-- CONTAINER -->
			<div class="container">
<%
	HttpSession sesion_actual = request.getSession();
	String recurs = sesion_actual.getAttribute("recur").toString();
	String fech = sesion_actual.getAttribute("fec").toString();
	int filas_recordset = 0;
	
	try{
		Conectar conectar = new Conectar();
		Connection connection;
		connection = conectar.Conecta();
		String sqlCont = "select count(*) from accesos where pagina = ? And fecha = ?";
		PreparedStatement psCont = connection.prepareStatement(sqlCont);
        psCont.setString(1, recurs);
        psCont.setString(2, fech);
		ResultSet rsCont = psCont.executeQuery();
        if (rsCont.next()){
        	sesion_actual.setAttribute("numaccesos", rsCont.getInt(1));
        	System.out.println("num_accesos: " + sesion_actual.getAttribute("numaccesos"));
        }
        connection.close();
	}catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
%>
<%
	String color1_fondo_tabla = new String("");
	String color2_fondo_tabla = new String("");
	String color_fuente = new String("");
	String color_fuente2 = new String("");
	
	try{
		HttpSession s = request.getSession();
		
		Conectar conexio = new Conectar();
		Connection connec;
		connec = conexio.Conecta();
		
		//CONSULTA PARAMETRO COLOR DE FONDO 1        
		String sqlquery = "select descripcion from parametro where nombre = ?";
		PreparedStatement ps = null;
		ps = connec.prepareStatement(sqlquery);
		ps.setString(1, "color1_fondo_tabla");
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			color1_fondo_tabla = rs.getString(1);
			session.setAttribute("color1_fondo_tabla", color1_fondo_tabla);
			System.out.println("Primer color de fondo de tabla: " + color1_fondo_tabla);
		}

	}catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}

	try{
		Conectar conexio = new Conectar();
		Connection connec;
		connec = conexio.Conecta();
		
		//CONSULTA PARAMETRO COLOR DE FONDO 2        
		String sqlquery = "select descripcion from parametro where nombre = ?";
		PreparedStatement ps = null;
		ps = connec.prepareStatement(sqlquery);
		ps.setString(1, "color2_fondo_tabla");
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			color2_fondo_tabla = rs.getString(1);
			session.setAttribute("color2_fondo_tabla", color2_fondo_tabla);
			System.out.println("Primer color de fondo de tabla: " + color2_fondo_tabla);
		}

	}catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}

	try{
		Conectar conexio_1 = new Conectar();
		Connection connec_1;
		connec_1 = conexio_1.Conecta();
		
		//CONSULTA PARAMETRO COLOR DE FONDO 2
		String sqlquery_1 = "select descripcion from parametro where nombre = ?";
		PreparedStatement ps_1 = null;
		ps_1 = connec_1.prepareStatement(sqlquery_1);
		ps_1.setString(1, "color_fuente");
		ResultSet rs_1 = ps_1.executeQuery();
		if (rs_1.next()){
			color_fuente = rs_1.getString(1);
			session.setAttribute("color_fuente", color_fuente);
			System.out.println("Color de fuente: " + color_fuente);
		}

	}catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
	
	try{
		Conectar conexio_2 = new Conectar();
		Connection connec_2;
		connec_2 = conexio_2.Conecta();
		
		//CONSULTA PARAMETRO COLOR DE FONDO 2
		String sqlquery_2 = "select descripcion from parametro where nombre = ?";
		PreparedStatement ps_2 = null;
		ps_2 = connec_2.prepareStatement(sqlquery_2);
		ps_2.setString(1, "color_fuente2");
		ResultSet rs_2 = ps_2.executeQuery();
		if (rs_2.next()){
			color_fuente2 = rs_2.getString(1);
			session.setAttribute("color_fuente2", color_fuente2);
			System.out.println("Color de fuente 2: " + color_fuente2);
		}
		connec_2.close();
	}catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}

    HashMap<String, Object> infoIP2 = new HashMap<String, Object>();

    int longitudarrayips = 0;
	try{
		Conectar conexi = new Conectar();
		Connection cone;
		cone = conexi.Conecta();
		String recurso = session.getAttribute("recur").toString();
        String fecha = session.getAttribute("fec").toString();

        //CONTEO DE ACCESOS DIARIO        
        String sql = "select count(*) from accesos where pagina = ? And fecha = ?";
        PreparedStatement psConteo = null;
		psConteo = cone.prepareStatement(sql);
        psConteo.setString(1, recurso);
        psConteo.setString(2, fecha);
        ResultSet rsConteo = psConteo.executeQuery();
		PrintWriter output = new PrintWriter(out);//Viene de System.out		

        //CONTEO DE DIRECCIONES IP
        sql = "select ip from accesos where pagina = ? And fecha = ?";
        PreparedStatement psConteoIps = null;
		psConteoIps = cone.prepareStatement(sql);
        psConteoIps.setString(1, recurso);
        psConteoIps.setString(2, fecha);
        ResultSet rsConteoIps = psConteoIps.executeQuery();
		ArrayList<String> listadoIP = new ArrayList<String>();
		ArrayList<String> listadoAuxIP = new ArrayList<String>();
		while(rsConteoIps.next()){
        	listadoIP.add(rsConteoIps.getString(1).toString());
		}
        
 		listadoAuxIP = listadoIP;
        for (String valor1: listadoIP)
        	System.out.println("Normal: " + valor1);

 		//ELIMINA REPETIDOS
        Set<String> hashSet = new HashSet<String>(listadoAuxIP);
        listadoAuxIP.clear();
        listadoAuxIP.addAll(hashSet);
 		
        //for (String valor: listadoAuxIP)
        	//System.out.println("Auxiliar: " + valor);

        int contadorIP=0;
        HashMap<String, Object> infoIP = new HashMap<String, Object>();
        for (String valor: listadoAuxIP){
        	for (String valor1: listadoIP){
        		if (valor.equals(valor1)){
        			contadorIP++;
        		}
        	}
        	infoIP.put(valor, contadorIP);
        }
		
        //CLONAMOS ARRAY CON ESTADISTICAS DE IPS
        infoIP2 = infoIP;
        
        for (Map.Entry<String, Object > entry : infoIP.entrySet()) {
            System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
        }
        
        System.out.println("########################################################");
        for (Map.Entry<String, Object > entry : infoIP2.entrySet()) {
            System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
            longitudarrayips++;
        }
        System.out.println("########################################################");

    	//LLENA LA TABLA TEMPORAL ESTADXIPS
    	try{
    		int filas = 0;
    		Conectar conexion5 = new Conectar();
    		Connection connection5;
    		connection5 = conexion5.Conecta();
    		String recurso5 = session.getAttribute("recur").toString();
            String fecha5 = session.getAttribute("fec").toString();
    		session.setAttribute("sRecurso", recurso5);
    		session.setAttribute("sFecha", fecha5);
    		System.out.println("longitud del arreglo: "+longitudarrayips);
    		Integer longitud = (Integer)sesion_actual.getAttribute("NumAccesosxUsuario");
            for (Map.Entry<String, Object > entry : infoIP2.entrySet()) {
    	        Statement stmnt = null;
    	        stmnt = cone.createStatement();
    	        //EJECUTAR PROCEDIMIENTO ALMACENADO
    	        CallableStatement cs = cone.prepareCall("select proc_crear_acceso_xip(?,?)");
    	        cs.setString(1, entry.getKey());
    	        cs.setInt(2, (int)entry.getValue());
    	        //Obtiene el conjunto de resultados
    	        ResultSet rs = cs.executeQuery();
    		}
            connection5.close();
    	}
    	catch(SQLException e){
    		System.out.println("Consulta del acceso fallida...");
    		System.out.println(e.getMessage());
    	}
        
        output.println("<TABLE border=2>");
		output.println("<CAPTION><b>Estadistica diaria</b></CAPTION>");
		String colorFondo1 = "<TR bgcolor=" + color1_fondo_tabla + ">";
		output.println(colorFondo1);
		//output.println("<TR bgcolor=#85abd1>");
		output.println("<th style=width:150px;><font color="+color_fuente+"><b>Cantidad de accesos: </th>");
		if (rsConteo.next())
			output.println("<td onmouseover=myFunction(this) onmouseout=myFunction2(this) style=width:150px;text-align:center; bgcolor=" + color2_fondo_tabla + "><font color=black><b>"+ rsConteo.getInt(1)+"</th>");
		else
			output.println(0);
		output.println("</TR>");
		output.println("</TABLE>");
		output.println("<BR><BR>");

        //IMPRIME INTERACCIONES CON IP DE ACCESO
		output.println("<TABLE id=mi_tabla border=2>");
		output.println("<TBODY>");
		output.println("<CAPTION><b>Interacciones de acceso con ip:</b></CAPTION>");
		output.println("<TR bgcolor="+color1_fondo_tabla+">");
		output.println("<th style=width:150px;><font color="+color_fuente+"><b>Direccion IP: </th>");
		output.println("<th style=width:150px;><font color="+color_fuente+"><b>Cantidad de accesos: </th>");
		output.println("</TR>");
		for (Map.Entry<String, Object > entry : infoIP.entrySet()) {
			output.println("<TR onmouseover=myFunction(this) onmouseout=myFunction2(this) bgcolor="+color2_fondo_tabla+">");
			//System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
  			output.println("<td style=width:150px;text-align:center;><font color="+color_fuente2+"><b>"+ entry.getKey()+"</th>");
  			output.println("<td style=width:150px;text-align:center;><font color="+color_fuente2+"><b>"+ entry.getValue()+"</th>");
		}
		output.println("</TBODY>");
		output.println("</TABLE>");
		output.println("<BR><BR>");
	
	}
	catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
%>
	<img src="<c:url value="/resources/images/histograma.png"/>"><a href="<c:url value="grafips"/>"><p>Ver grafica estad&iacute;stica de las direcciones ips en 2D, </p></a><p><a href="<c:url value="grafips3d"/>">3D</p></a></img>
	<BR><BR>
<%
	try{
		Conectar conexi = new Conectar();
		Connection cone;
		cone = conexi.Conecta();
		String recurso = session.getAttribute("recur").toString();
        String fecha = session.getAttribute("fec").toString();

        //CONTEO DE ACCESOS DIARIO
        String sql = "select estadotarea, count(*) as cantidad from accesos where pagina = ? And fecha = ? group by estadotarea order by estadotarea asc";
        PreparedStatement psConteoEstados = null;
		psConteoEstados = cone.prepareStatement(sql);
        psConteoEstados.setString(1, recurso);
        psConteoEstados.setString(2, fecha);
        ResultSet rsConteoEstados = psConteoEstados.executeQuery();
		PrintWriter output = new PrintWriter(out);//Viene de System.out		

		/*
			LOS ESTADOS POSIBLES DE LA TAREA SON:
			-Bloqueda
			-En proceso
			-Stand by
			-Terminada
		*/
		output.println("<TABLE id=mi_tabla border=2>");
		output.println("<TBODY>");
		output.println("<CAPTION><b>Estadisticas de estados de las tareas: </b></CAPTION>");
		while (rsConteoEstados.next()) {
			if (String.valueOf(rsConteoEstados.getString(1)).equals("Bloqueada")){
        		//System.out.println(rsConteoEstados.getString(1) + ": " + rsConteoEstados.getInt(2));
        		output.println("<TR bgcolor="+color1_fondo_tabla+">");
    			output.println("<th style=width:150px;><font color="+color_fuente+"><b> Bloqueadas: </th>");
    			output.println("<td onmouseover=myFunction(this) onmouseout=myFunction2(this) style=width:150px;text-align:center; bgcolor="+color2_fondo_tabla+"><font color="+color_fuente2+"><b>"+ rsConteoEstados.getInt(2)+"</th>");
           		output.println("</TR>");
			}
			if (String.valueOf(rsConteoEstados.getString(1)).equals("En proceso")){
        		//System.out.println(rsConteoEstados.getString(1) + ": " + rsConteoEstados.getInt(2));
        		output.println("<TR bgcolor="+color1_fondo_tabla+">");
    			output.println("<th style=width:150px;><font color="+color_fuente+"><b> En proceso: </th>");
    			output.println("<td onmouseover=myFunction(this) onmouseout=myFunction2(this) style=width:150px;text-align:center; bgcolor="+color2_fondo_tabla+"><font color="+color_fuente2+"><b>"+ rsConteoEstados.getInt(2)+"</th>");
           		output.println("</TR>");
			}
			if (String.valueOf(rsConteoEstados.getString(1)).equals("Stand by")){
        		//System.out.println(rsConteoEstados.getString(1) + ": " + rsConteoEstados.getInt(2));
        		output.println("<TR bgcolor="+color1_fondo_tabla+">");
    			output.println("<th style=width:150px;><font color="+color_fuente+"><b> Stand by: </th>");
    			output.println("<td onmouseover=myFunction(this) onmouseout=myFunction2(this) style=width:150px;text-align:center; bgcolor="+color2_fondo_tabla+"><font color="+color_fuente2+"><b>"+ rsConteoEstados.getInt(2)+"</th>");
           		output.println("</TR>");
			}
			if (String.valueOf(rsConteoEstados.getString(1)).equals("Terminada")){
        		//System.out.println(rsConteoEstados.getString(1) + ": " + rsConteoEstados.getInt(2));
        		output.println("<TR bgcolor="+color1_fondo_tabla+">");
    			output.println("<th style=width:150px;><font color="+color_fuente+"><b> Terminadas: </th>");
    			output.println("<td onmouseover=myFunction(this) onmouseout=myFunction2(this) style=width:150px;text-align:center; bgcolor="+color2_fondo_tabla+"><font color="+color_fuente2+"><b>"+ rsConteoEstados.getInt(2)+"</th>");
           		output.println("</TR>");
			}
		}
		output.println("</TBODY>");
		output.println("</TABLE>");		
   		output.println("<BR><BR>");  
   		cone.close();
	}
	catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
%>
	<img src="<c:url value="/resources/images/histograma.png"/>"><a href="<c:url value="grafestados"/>"><p>Ver grafica estad&iacute;stica de los estados</p></a>
	<BR><BR>
<%
	//CREAMOS UN ARREGLO
	Integer numaccesosxestado = (Integer)sesion_actual.getAttribute("numaccesos");
	System.out.println("Accesos x estado = " + numaccesosxestado);
	String[][] accesosxestado = new String[numaccesosxestado][2];
	int longitudestados = 0;
	
	try{
		Conectar conexi = new Conectar();
		Connection cone;
		cone = conexi.Conecta();
		String recurso = session.getAttribute("recur").toString();
		System.out.println("Estado - recurso " + recurso);
		String fecha = session.getAttribute("fec").toString();
		System.out.println("Estado - fecha " + fecha);

		
	    //CONTEO DE ACCESOS DIARIO
	    String sql = "select estadotarea, count(*) as cantidad from accesos where pagina = ? And fecha = ? group by estadotarea order by estadotarea asc";
	    PreparedStatement psConteoEstados = null;
		psConteoEstados = cone.prepareStatement(sql);
	    psConteoEstados.setString(1, recurso);
	    psConteoEstados.setString(2, fecha);
	    ResultSet rsConteoEstados = psConteoEstados.executeQuery();
	
		int f = 0;

		while (rsConteoEstados.next()) {
	   		accesosxestado[f][0] = rsConteoEstados.getString(1);
	   		accesosxestado[f][1] = String.valueOf(rsConteoEstados.getInt(2));
	   		f++;
	   		longitudestados++;
		}
			sesion_actual.setAttribute("NumAccesosxEstado", f);
		
		int longitud = f;
		f = 0;
		System.out.println("----------------------estados-------------------------------");
		while (f < longitud){
			System.out.println(accesosxestado[f][0]+"        "+accesosxestado[f][1]);
			f++;
		}
		System.out.println("------------------------------------------------------------");
		cone.close();	
	}
	catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}

	try{
		Conectar conectar2 = new Conectar();
		Connection connection2;
		connection2 = conectar2.Conecta();
		String recurso1 = session.getAttribute("recur").toString();
		String fecha1 = session.getAttribute("fec").toString();
		session.setAttribute("sRecurso", recurso1);
		session.setAttribute("sFecha", fecha1);
        int filas = 0;
		while (filas < longitudestados){
	        Statement stmnt = null;
	        stmnt = connection2.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = connection2.prepareCall("select proc_crear_acceso_xestado(?,?)");
	        cs.setString(1, accesosxestado[filas][0]);
	        cs.setString(2, accesosxestado[filas][1]);
	        //Obtiene el conjunto de resultados
	        ResultSet rs = cs.executeQuery();
        	filas++;
		}
	}
	catch(Exception e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
%>
<%
	//CREAMOS UN ARREGLO
	Integer numaccesos = (Integer)sesion_actual.getAttribute("numaccesos");
	System.out.println("Accesos de usuarios = " + numaccesos);
	Integer[][] accesos = new Integer[numaccesos][2];

	int fi = 0;
	try{
		Conectar conexi = new Conectar();
		Connection cone;
		cone = conexi.Conecta();
		String recurso = session.getAttribute("recur").toString();
        String fecha = session.getAttribute("fec").toString();

        //CONTEO DE ACCESOS DIARIO
        String sql = "select usuario, count(*) as cantidad from accesos where pagina = ? And fecha = ? group by usuario order by usuario asc";
        PreparedStatement psConteoUsuarios = null;
		psConteoUsuarios = cone.prepareStatement(sql);
        psConteoUsuarios.setString(1, recurso);
        psConteoUsuarios.setString(2, fecha);
        ResultSet rsConteoUsuarios = psConteoUsuarios.executeQuery();
		PrintWriter output = new PrintWriter(out);

		output.println("<TABLE id=mi_tabla border=2>");
		output.println("<TBODY>");
		output.println("<CAPTION><b>Estadisticas de usuarios: </b></CAPTION>");
		output.println("<TR bgcolor="+color1_fondo_tabla+">");
		output.println("<th style=width:150px;text-align:center;><font color="+color_fuente+"><b>Codigo de usuario </th>");
		output.println("<th style=width:150px;text-align:center;><font color="+color_fuente+"><b>Cantidad de accesos </th>");
		output.println("</TR>");

		while (rsConteoUsuarios.next()) {
    		output.println("<TR onmouseover=myFunction(this) onmouseout=myFunction2(this)  bgcolor="+color2_fondo_tabla+">");
			output.println("<td style=width:150px;text-align:center;><font color="+color_fuente2+"><b>" + rsConteoUsuarios.getInt(1) + "</th>");
			output.println("<td style=width:150px;text-align:center;><font color="+color_fuente2+"><b>"+ rsConteoUsuarios.getInt(2)+"</th>");
       		output.println("</TR>");
       		accesos[fi][0] = rsConteoUsuarios.getInt(1);
       		accesos[fi][1] = rsConteoUsuarios.getInt(2);
       		fi++;
		}
   		sesion_actual.setAttribute("NumAccesosxUsuario", fi);
		
		int longitud = fi;
		fi = 0;
		System.out.println("-----------------------------------------------------");
		while (fi < longitud){
			System.out.println(accesos[fi][0]+"        "+accesos[fi][1]);
			fi++;
		}
		System.out.println("-----------------------------------------------------");

		output.println("</TBODY>");
		output.println("</TABLE>");
		output.println("<BR><BR>");
		cone.close();
	}
	catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}

	int fil = 0;
	//LLENA LA TABLA ESTADXUSUARIO
	try{
		Conectar conexi = new Conectar();
		Connection cone;
		cone = conexi.Conecta();
		String recurso = session.getAttribute("recur").toString();
        String fecha = session.getAttribute("fec").toString();
		session.setAttribute("sRecurso", recurso);
		session.setAttribute("sFecha", fecha);
		System.out.println("longitud del arreglo: "+accesos.length);
		Integer longitud = (Integer)sesion_actual.getAttribute("NumAccesosxUsuario");
        while (fil<longitud){
	        Statement stmnt = null;
	        stmnt = cone.createStatement();
	        //EJECUTAR PROCEDIMIENTO ALMACENADO
	        CallableStatement cs = cone.prepareCall("select proc_crear_acceso_usuario(?,?)");
	        cs.setInt(1, accesos[fil][0]);
	        cs.setInt(2, accesos[fil][1]);
	        //Obtiene el conjunto de resultados
	        ResultSet rs = cs.executeQuery();

        	fil++;
		}
        cone.close();
	}
	catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
%>
		<img src="<c:url value="/resources/images/histograma.png"/>"><a href="<c:url value="grafusuarios"/>"><p>Ver grafica pie estad&iacute;stica de los usuarios, </p></a><a href="<c:url value="grafusuarioslineal"/>"><p>Gr&aacute;fica lineal</p></a></img>
		<BR><BR>
								<!-- TABLA REPORTE VISITAS DIARIAS -->
								<table border=2 id="mi_tabla">
									<TBODY>
									<CAPTION><b>Listado de interacciones con el recurso:</b></CAPTION>
									<tr bgcolor='<%=session.getAttribute("color1_fondo_tabla") %>'>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>C&oacute;digo</b></font></th>
										<th style="text-align:center" width="100"><font color='<%=session.getAttribute("color_fuente") %>'><b>Ip</b></font></th>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>M&oacute;dulo</b></font></th>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>P&aacute;gina</b></font></th>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>Objeto</font></b></th>
										<th style="text-align:center" width="200"><font color='<%=session.getAttribute("color_fuente") %>'><b>Tabla</b></font></th>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>Operaci&oacute;n</b></font></th>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>Acci&oacute;n</b></font></th>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>Proceso</b></font></th>
										<th style="text-align:center" width="200"><font color='<%=session.getAttribute("color_fuente") %>'><b>Estado tarea</b></font></th>
										<th style="text-align:center" width="200"><font color='<%=session.getAttribute("color_fuente") %>'><b>Comando</b></font></th>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>Aplicaci&oacute;n</b></font></th>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>Tiempo</b></font></th>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>Transacci&oacute;n</b></font></th>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>Fecha</b></font></th>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>Hora</b></font></th>
										<th style="text-align:center"><font color='<%=session.getAttribute("color_fuente") %>'><b>Usuario</b></font></th>
									</tr>
    <script>
    	function myFunction(x) {
            // Obtenemos todos los TR de la tabla con id "mi_tabla"
            // despues del tbody.
            var elementos = document.getElementById('mi_tabla').
            getElementsByTagName('TBODY')[0].getElementsByTagName('TR');
     
            // Por cada TR empezando por el segundo, ponemos fondo blanco.
            for (var i = 1; i < elementos.length; i++) {
                elementos[i].style.background='#f1f3f4';
            }
            // Al elemento clickeado le ponemos fondo amarillo.
            x.style.background='#a5eab2';
        }
        function myFunction2(x) {
            // Obtenemos todos los TR de la tabla con id "mi_tabla"
            // despues del tbody.
            var elementos = document.getElementById('mi_tabla').
            getElementsByTagName('TBODY')[0].getElementsByTagName('TR');
     
            // Por cada TR empezando por el segundo, ponemos fondo blanco.
            for (var i = 1; i < elementos.length; i++) {
                elementos[i].style.background='#f1f3f4';
            }
            // Al elemento clickeado le ponemos fondo amarillo.
            x.style.background='#f1f3f4';
        }
    </script>			
<%
	int iNumFilas = 0;
	int iContador = 0;
	
	try{
		String sRecurso = session.getAttribute("recur").toString();
		String sFecha = session.getAttribute("fec").toString();

		Conectar conectar = new Conectar();
		Connection connection;
		connection = conectar.Conecta();
		String sqlCont = "select count(*) from accesos where pagina = ? And fecha = ?";
		PreparedStatement psCont = connection.prepareStatement(sqlCont);
        psCont.setString(1, sRecurso);
        psCont.setString(2, sFecha);
		ResultSet rsCont = psCont.executeQuery();
        if (rsCont.next()){
        	iNumFilas = rsCont.getInt(1);
        	System.out.println("# de filas: " + iNumFilas);
        }
        connection.close();
	}catch(SQLException e){
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
	
	try {
		HttpSession s = request.getSession();
		String sRecurso = s.getAttribute("recur").toString();
		String sFecha = s.getAttribute("fec").toString();

		Integer numregxpag = (Integer)s.getAttribute("numregxpag");
		Integer inInicio = (Integer)s.getAttribute("iInicio");
		Integer inFin = (Integer)s.getAttribute("iFin");
		Integer inCuenta = (Integer)s.getAttribute("iCuenta");
		boolean bInicio = false;
		boolean bFin = false;

		System.out.println("numregxpag: "+String.valueOf(numregxpag));
		Conectar conex = new Conectar();
		
		Connection con;
		con = conex.Conecta();
		Statement stmnt = null;
        stmnt = con.createStatement();

    	String accion = request.getParameter("submit");
    	if (accion == null){
    		System.out.println("No se ha presionado ningún botón");
    	}else if (accion.equals("primero")){
			if (iNumFilas > 10 && bInicio == false){
    			inInicio = 1;
	    		inFin = 10;
	    		inCuenta = 10;
	    		bInicio = true;
			}
    	}else if (accion.equals("anterior")){
    		if (iNumFilas > 10 && bInicio == false){
    			inInicio = inCuenta + 1 - 10;
    			inFin = inCuenta;
    			inCuenta = inCuenta;
    			bFin = false;
    			if (inInicio == 1 && inFin == 10)
    				bInicio = true;
    		}
    	}else if (accion.equals("siguiente")){
    		if (iNumFilas > 10 && bFin == false){
    			inInicio = inCuenta + 1;
    			inFin = inCuenta + 10;
    			inCuenta = inCuenta + 10;
    			bInicio = false;
    		}
    	}else if (accion.equals("ultimo")){
			if (iNumFilas > 10 && bFin == false){
    			inInicio = iNumFilas + 1 - (iNumFilas%10);
				inFin = iNumFilas - (iNumFilas%10) + 10;
				inCuenta = iNumFilas - (iNumFilas%10) + 10;
				bFin = true;
				bInicio = false;
    		}
    	}else{
    		System.out.println("Acción desconocida...");
    	}

		s.setAttribute("ixInicio", inInicio);
		s.setAttribute("ixFin", inFin);
		s.setAttribute("ixCuenta", inCuenta);
		System.out.println("Inicio: " + inInicio + "Fin: " + inFin);
		
        //LISTADO DE ACCESOS DIARIOS
        String consulta = "select * from accesos where pagina = ? And fecha = ? and codigo between ? and ?";
        PreparedStatement ps = con.prepareStatement(consulta);
        ps.setString(1, sRecurso);
        ps.setString(2, sFecha);
        ps.setInt(3, inInicio);
        ps.setInt(4, inFin);
        ResultSet rs = ps.executeQuery();
		PrintWriter output = new PrintWriter(out);	
		
		while (rs.next()) {
				output.println("<TR onmouseover=myFunction(this) onmouseout=myFunction2(this) bgcolor="+color2_fondo_tabla+">");
	        	output.println("<TD style=text-align:center;>"+rs.getLong(1)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(2)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getInt(3)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(4)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(5)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(6)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(7)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(8)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(9)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(10)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(11)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(12)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getInt(13)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(14)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(15)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(16)+"</TD>");
	        	output.println("<TD style=text-align:center;>"+rs.getString(17)+"</TD>");
	        	output.println("</TR>");
        }
		stmnt.close();//Liberar objeto
        con.close();//Cierra conexion
        HttpSession sesi = request.getSession();
        sesi.setAttribute("sRecurso", sRecurso);
        sesi.setAttribute("sFecha", sFecha);
	}catch(SQLException e) {
		System.out.println("Consulta del acceso fallida...");
		System.out.println(e.getMessage());
	}
%>
									</TBODY>
								</table>
								<CENTER><BR>
									<TABLE cellspacing=2 cellpading=2>
										<tr>						
											<c:url value="/rEstadis_Diaria" var="formUrl"/>
										    <form:form class="clearfix" method="GET" action="${formUrl}">
												<tr align="center">
													<input type="hidden" name="iInicio" value="${ixInicio}"></input>
													<input type="hidden" name="iFin" value="${ixFin}"></input>
													<input type="hidden" name="iCuenta" value="${ixCuenta}"></input>
													<input type="hidden" name="sNombreRecurso" value="${recur}"></input>
													<input type="hidden" name="sFecha" value="${fec}"></input>
													<td><input type="submit" name="submit" value="primero" class="btn btn-primary btn-lg" /></td>
													<td><input type="submit" name="submit" value="anterior" class="btn btn-primary btn-lg" /></td>
													<td><input type="submit" name="submit" value="siguiente" class="btn btn-primary btn-lg" /></td>
													<td><input type="submit" name="submit" value="ultimo" class="btn btn-primary btn-lg" /></td>
												</tr>
											</form:form>
										</tr>
									</TABLE>
								</CENTER> 

				<!-- ROW -->
				<div class="row">
				
					<!-- BLOG BLOCK -->
					<div class="blog_block col-lg-9 col-md-9 padbot50">
						
						<!-- BLOG POST -->
						<div class="blog_post margbot50 clearfix" data-animated="fadeInUp">
						<!-- PAGINATION -->
						<ul class="pagination clearfix">
							<li><a href="javascript:void(0);" >1</a></li>
							<li><a href="javascript:void(0);" >2</a></li>
							<li class="active"><a href="javascript:void(0);" >3</a></li>
							<li><a href="javascript:void(0);" >4</a></li>
							<li><a href="javascript:void(0);" >5</a></li>
							<li><a href="javascript:void(0);" >. . .</a></li>
							<li><a href="javascript:void(0);" >75</a></li>
						</ul><!-- //PAGINATION -->
					</div><!-- //BLOG BLOCK -->
					
					
					<!-- SIDEBAR -->
					<div class="sidebar col-lg-3 col-md-3 padbot50">
						
						<!-- META WIDGET -->
						<div style="font-size:22px;font-color:#fff;padding:13px 10px 12px 30px;">
							<ul>
								<li style="border-top:1px solid #e9e9e9;inline-block;line-height:24px;line-height:24px;padding:13px 10px 12px 30px;"><a href="javascript:void(0);" ><p style="color:gray;">Redes sociales</p></a></li>
								<li style="border-top:1px solid #e9e9e9;inline-block;line-height:24px;line-height:24px;padding:13px 10px 12px 30px;"><a href="javascript:void(0);" ><p style="color:gray;">Publicidad</p></a></li>
								<li style="border-top:1px solid #e9e9e9;inline-block;line-height:24px;line-height:24px;padding:13px 10px 12px 30px;"><a href="javascript:void(0);" ><p style="color:gray;">Cobertura</p></a></li>
								<li style="border-top:1px solid #e9e9e9;inline-block;line-height:24px;line-height:24px;padding:13px 10px 12px 30px;"><a href="javascript:void(0);" ><p style="color:gray;">Medios de pago</p></a></li>
								<li style="border-top:1px solid #e9e9e9;border-bottom:1px solid #e9e9e9;inline-block;line-height:24px;line-height:24px;padding:13px 10px 12px 30px;"><a href="javascript:void(0);" ><p style="color:gray;">Bancos</p></a></li>
							</ul>
						</div><!-- //META WIDGET -->
						
						<!-- POPULAR POSTS WIDGET -->
						<div class="sidepanel widget_popular_posts">
							<h3><b>Publicaciones</b> Populares</h3>
							
							<div class="recent_posts_widget clearfix">
								<div class="post_item_img_widget"><c:url value="/resources/images/blog/1.jpg"/>
									<img src="<c:url value="/resources/images/blog/1.jpg"/>" alt="" />
								</div>
								<div class="post_item_content_widget">
									<a class="title" href="<c:url value="blog"/>" >Cómo las porristas de los Broncos de Denver se ponen en forma para el Super Bowl</a>
									<ul class="post_item_inf_widget">
										<li>ENERO 30  |  21:30</li>
									</ul>
								</div>
							</div>
							<div class="recent_posts_widget clearfix">
								<div class="post_item_img_widget">
									<img src="<c:url value="/resources/images/blog/2.jpg"/>" alt="" />
								</div>
								<div class="post_item_content_widget">
									<a class="title" href="<c:url value="blog"/>" >Campaña de primavera de Barneys protagoniza 17 modelos transgénero</a>
									<ul class="post_item_inf_widget">
										<li>ENERO 25  |  9:30</li>
									</ul>
								</div>
							</div>
							<div class="recent_posts_widget clearfix">
								<div class="post_item_img_widget">
									<img src="<c:url value="/resources/images/blog/3.jpg"/>" alt="" />
								</div>
								<div class="post_item_content_widget">
									<a class="title" href="<c:url value="blog"/>" >Dominic Cooper: No soy nada como el verdadero James Bond</a>
									<ul class="post_item_inf_widget">
										<li>ENERO 21  |  13:30</li>
									</ul>
								</div>
							</div>
						</div><!-- //POPULAR POSTS WIDGET -->
						
						<hr>
						
						<!-- POPULAR TAGS WIDGET -->
						<div class="sidepanel widget_tags">
							<h3><b>Etiquetas</b> Populares</h3>
							<ul>
								<li><a href="javascript:void(0);" >Moda</a></li>
								<li><a href="javascript:void(0);" >Almacen</a></li>
								<li><a href="javascript:void(0);" >Color</a></li>
								<li><a href="javascript:void(0);" >Agencia creativa</a></li>
								<li><a href="javascript:void(0);" >Tema</a></li>
								<li><a href="javascript:void(0);" >Vestido</a></li>
								<li><a href="javascript:void(0);" >Wordpress</a></li>
							</ul>
						</div><!-- POPULAR TAGS WIDGET -->
						
						<hr>
						
						<!-- TEXT WIDGET -->
						<div class="sidepanel widget_text">
							<h3><b>Acerca</b> del Blog</h3>
							<p>Debo admitir que esta defensa en particular me puso un poco nervioso, por dos razones. La primera es que está siendo mantenida en un nivel completamente diferente al que los políticos masculinos tienen.</p>
						</div><!-- //TEXT WIDGET -->
					</div><!-- //SIDEBAR -->
				</div><!-- //ROW -->
			</div><!-- //CONTAINER -->
		</section><!-- //BLOG -->
	</div><!-- //PAGE -->

	
	<!-- CONTACTS -->
	<section id="contacts">
	</section><!-- //CONTACTS -->
	
	<!-- FOOTER -->
	<footer>
			
		<!-- CONTAINER -->
		<div class="container">
			
			<!-- ROW -->
			<div class="row" data-appear-top-offset="-200" data-animated="fadeInUp">
				
				<div class="col-lg-4 col-md-4 col-sm-6 padbot30">
					<h4><b>Publicaciones</b> destacadas</h4>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="<c:url value="/resources/images/blog/1.jpg"/>" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="<c:url value="blog"/>" >Como hemos desarrollado una plantilla de diseño única.</a>
							<ul class="post_item_inf_small">
								<li>Enero 10 de 2014</li>
							</ul>
						</div>
					</div>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="<c:url value="/resources/images/blog/2.jpg"/>" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="<c:url value="blog"/>" >¿Cuánto cuesta desarrollar un diseño para el juego?</a>
							<ul class="post_item_inf_small">
								<li>Enero 14 del 2014</li>
							</ul>
						</div>
					</div>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="<c:url value="/resources/images/blog/3.jpg"/>" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="<c:url value="blog.html"/>" >Cómo bombear diseñador</a>
							<ul class="post_item_inf_small">
								<li>Diciembre 21 del 2013</li>
							</ul>
						</div>
					</div>
				</div>
				
				<div class="col-lg-4 col-md-4 col-sm-6 padbot30 foot_about_block">
					<h4><b>Acerca de </b> nosotros</h4>
					<p>Valoramos a las personas por los beneficios, la calidad por encima de la cantidad y manteniéndolos reales. Como tal, entregamos una relación de trabajo inigualable con nuestros clientes.</p>
					<p>Nuestro equipo es intencionalmente pequeño, ecléctico y hábil; Con nuestra experiencia interna, proporcionamos agudo y</p>
					<ul class="social">
						<li><a href="javascript:void(0);" ><i class="fa fa-twitter"></i></a></li>
						<li><a href="javascript:void(0);" ><i class="fa fa-facebook"></i></a></li>
						<li><a href="javascript:void(0);" ><i class="fa fa-google-plus"></i></a></li>
						<li><a href="javascript:void(0);" ><i class="fa fa-pinterest-square"></i></a></li>
						<li><a href="javascript:void(0);" ><i class="map_show fa fa-map-marker"></i></a></li>
					</ul>
				</div>
				
				<div class="respond_clear"></div>
				
				<div class="col-lg-4 col-md-4 padbot30">
					<h4><b>Contactenos</h4>
					
					<!-- CONTACT FORM -->
					<div class="span9 contact_form">
						<div id="note"></div>
						<div id="fields">
							<form id="contact-form-face" class="clearfix" action="#">
								<input type="text" name="name" value="Name" onFocus="if (this.value == 'Name') this.value = '';" onBlur="if (this.value == '') this.value = 'Name';" />
								<textarea name="message" onFocus="if (this.value == 'Message') this.value = '';" onBlur="if (this.value == '') this.value = 'Message';">Message</textarea>
								<input class="contact_btn" type="submit" value="Send message" />
							</form>
						</div>
					</div><!-- //CONTACT FORM -->
				</div>
			</div><!-- //ROW -->
			<div class="row copyright">
				<div class="col-lg-12 text-center">
				
				 <p>Crafted with <i class="fa fa-heart"></i>, <a href="http://designscrazed.org/" >Dise&nacute;os enloquecidos</a></p>
				</div>
			
			</div><!-- //ROW -->
		</div><!-- //CONTAINER -->
	</footer><!-- //FOOTER -->
	
	
	<!-- MAP -->
	<div id="map">
		<a class="map_hide" href="javascript:void(0);"><i class="fa fa-angle-right"></i><i class="fa fa-angle-left"></i></a>
		<iframe src="http://maps.google.com/maps?f=q&amp;give%20a%20hand=s_q&amp;hl=en&amp;geocode=&amp;q=london&amp;sll=37.0625,-95.677068&amp;sspn=42.631141,90.263672&amp;ie=UTF8&amp;hq=&amp;hnear=London,+United+Kingdom&amp;ll=51.500141,-0.126257&amp;spn=0.026448,0.039396&amp;z=14&amp;output=embed" ></iframe>
	</div><!-- //MAP -->
</div>

<!-- 
<div id="datepicker"></div>
-->

<script src="<c:url value="/resources/js/external/jquery/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
<script>  
	$ (function() {
   		$("#sFecha").datepicker();  
	});  
</script>  
</body>
</html>