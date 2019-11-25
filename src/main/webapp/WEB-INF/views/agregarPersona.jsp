<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.time.*" %>
<%@ page import="java.time.format.*" %>
<!doctype html>
<html lang="us">
<head>
	<meta charset="utf-8">
	<title>P&aacute;gina persona</title>
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
<%
	//ESTABLECE FECHA ACTUAL CON FORMATO
	LocalDate fecha;
	fecha = LocalDate.now();
	DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM/dd/YYYY");
	session.setAttribute("fecha_actual", formateador.format(fecha));
	//ESTABLECE HORA ACTUAL CON FORMATO
	LocalTime hora;
	hora = LocalTime.now();
	System.out.println(hora.toString());
	DateTimeFormatter formateador1 = DateTimeFormatter.ofPattern("hh:mm");
	session.setAttribute("hora_actual", hora.format(formateador1));
%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	(function (){
		window.addEventListener('DOMContentLoaded',validarCorreo);
		setInterval(validarCorreo, 15000);//TEMPORIZADOR QUE LLAMA LA FUNCION CADA 500 ms
		function validarCorreo() {
			var valor = document.getElementById('sCorreo').value;
			if (/^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i.test(valor)){
				document.getElementById('agregar').disabled = false;
			}else {
				alert("La dirección de email es incorrecta:"+valor);
				document.getElementById('agregar').disabled = true;
			}
		}
}())
</script>
<script type="text/javascript">
	$(function() {
		//CAMBIA EL VALOR SELECCIONADO EN EL CONTROL HORA
		$(document).ready(function(){ 
			$("#lPersona").keydown(function(event) {
				if (event.shiftKey){
					event.preventDefault();
				}
				if (event.keyCode >= 48 && event.keyCode <= 57) {
   			    }
  	            else{
  	        	   if (event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 37 || event.keyCode == 39
  	        			   || event.keyCode == 58){//TECLA SUPRIMIR O BACKSPACE, FLECHAS IZQUIERDA, DERECHA
  	        	   }
  	        	   else
						event.preventDefault();
  	            }
		    });//fin eventos telefono
			$("#sTelefono").keydown(function(event) {
				if (event.shiftKey){
					event.preventDefault();
				}
				if (event.keyCode >= 48 && event.keyCode <= 57) {
   			    }
  	            else{
  	        	   if (event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 37 || event.keyCode == 39
  	        			   || event.keyCode == 58){//TECLA SUPRIMIR O BACKSPACE, FLECHAS IZQUIERDA, DERECHA
  	        	   }
  	        	   else
						event.preventDefault();
  	            }
		    });//fin eventos telefono
			$("#sNombres").keydown(function(event) {
				if (event.keyCode >= 96 && event.keyCode <= 105){//BLOQUEA NUMEROS TECLADO NUMERICO
					event.preventDefault();
				}
				if ((event.keyCode >= 65 && event.keyCode <= 90) || (event.keyCode >= 97 && event.keyCode <= 122)) {
   			    }
  	            else{
  	        	   if (event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 37 || event.keyCode == 39
  	        			   || event.keyCode == 58){//TECLA SUPRIMIR O BACKSPACE, FLECHAS IZQUIERDA, DERECHA
  	        	   }
  	        	   else{
						event.preventDefault();
  	        	   }
  	            }
		    });//fin eventos nombres
			$("#sApellidos").keydown(function(event) {
				if (event.keyCode >= 96 && event.keyCode <= 105){//BLOQUEA NUMEROS TECLADO NUMERICO
					event.preventDefault();
				}
				if ((event.keyCode >= 65 && event.keyCode <= 90) || (event.keyCode >= 97 && event.keyCode <= 122)) {
   			    }
  	            else{
  	        	   if (event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 37 || event.keyCode == 39
  	        			   || event.keyCode == 58){//TECLA SUPRIMIR O BACKSPACE, FLECHAS IZQUIERDA, DERECHA
  	        	   }
  	        	   else{
						event.preventDefault();
  	        	   }
  	            }
		    });//fin eventos nombres
		});
	});
</script>
<script type="text/javascript">
(function (){
	var fechaOk;
	window.addEventListener('DOMContentLoaded',validarHora);
	window.addEventListener('DOMContentLoaded',validarFecha);
	window.addEventListener('DOMContentLoaded',validarFechaNac);
	setInterval(validarHora, 15000);//TEMPORIZADOR QUE LLAMA LA FUNCION CADA 7000 ms
	setInterval(validarFecha, 15000);//TEMPORIZADOR QUE LLAMA LA FUNCION CADA 7000 ms
	setInterval(validarFechaNac, 15000);//TEMPORIZADOR QUE LLAMA LA FUNCION CADA 7000 ms

	function validarFechaNac(){
		var fecha = document.getElementById('sFecha_Nac').value;
		var longitud = fecha.length;
		//COMPROBAR FORMATO DE FECHA ESTE COMPLETO MM/DD/AA
		var posicionSlash1 = 0;
		var fecha_aux;
		var fecha_resto;
		var bMesReparado = false;
		var caracterSlash2;
		//VERIFICA LONGITUDES DEL MES
		var caracterSlash1 = fecha.charAt(0);
		if (caracterSlash1 == '/'){// SLASH POSICION CERO
			alert('Error: faltan dos digitos del mes!');
			document.getElementById('agregar').disabled = true;
			fechaOk = false;
		}

		//VERIFICA SLASH MES EN POSICION 2
		caracterSlash1 = fecha.charAt(2);
		if (caracterSlash1 == '/'){
			fechaOk = true;
			document.getElementById('agregar').disabled = false;
		}
			
		caracterSlash1 = fecha.charAt(1);
		if (caracterSlash1 == '/'){// m/dd/aaaa
			document.getElementById('agregar').disabled = true;
			alert('Error: falta un digito en el mes! el sistema lo solucionará por usted...');
			fecha_aux = chequearNumero(fecha.substring(0,1));
			fecha_resto = fecha.substring(1, 10);
			document.getElementById('sFecha_Nac').value = fecha_aux+fecha_resto;
			bMesReparado = true;
		}
		if (bMesReparado == true){
			document.getElementById('agregar').disabled = false;
		}
		//VERIFICA LONGITUDES DEL DIA
		//CASO: DD//AAAA
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(3);
		if (caracterSlash1=='/' && caracterSlash2=='/'){
			document.getElementById('agregar').disabled = true;
			fechaOk=false;
			alert('Error: faltan dos digitos en el día!');
		}
		//CASO: MM/DD/AAAA
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(5);
		if (caracterSlash1=='/' && caracterSlash2=='/'){
			document.getElementById('agregar').disabled = false;
			fechaOk=true;
		}
		//CASO: MM/D/AAAA
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(4);
		if (caracterSlash1=='/' && caracterSlash2=='/'){
			document.getElementById('agregar').disabled = true;
			fechaOk=false;
			alert('Error: falta un digito en el día! el sistema lo solucionará por usted...');
			var inicioFecha = fecha.substring(0,3);
			fecha_aux = chequearNumero(fecha.charAt(3));
			fecha_resto = fecha.substring(4);
			document.getElementById('sFecha_Nac').value = inicioFecha+fecha_aux+fecha_resto;
			fechaOk=false;		
		}

		//CASO: MM/D/AAAA
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(5);
		if (caracterSlash1=='/' && caracterSlash2=='/'){		
			document.getElementById('agregar').disabled = true;
			fechaOk=true;
		}
		
		//CASO: MM/DD/
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(5);
		if (caracterSlash1=='/' && caracterSlash2=='/'){
			longitud = fecha.length;
			if (longitud == 6){
				document.getElementById('agregar').disabled = true;		
				fechaOk=false;
			}
		}

		//CASO: MM/DD/AAAA
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(5);
		if (caracterSlash1=='/' && caracterSlash2=='/' && fecha.length == 10){
			document.getElementById('agregar').disabled = false;			
			fechaOk=true;
		}

		//CASO: MM/DD/AAAA
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(5);
		if (caracterSlash1=='/' && caracterSlash2=='/' && fecha.length < 10){
			document.getElementById('agregar').disabled = true;
			alert('Error: el año se encuentra mal escrito, son 4 digitos...');
			fechaOk = false;
		}
		
		longitud = fecha.length;
		if (longitud > 10){
			document.getElementById('agregar').disabled = true;
			alert ('Error: el formato de fecha supera los 10 digitos, verifique el formato!');
			fechaOk = false;
		}
		if (fecha==''){
			document.getElementById('agregar').disabled = true;
			alert ('Error: el campo fecha se encuentra vacio!');
			fechaOk = false;
		}
		if (!(fecha.substr(0,2) >= 0 && fecha.substr(0,2) <= 12)){
			document.getElementById('agregar').disabled = true;
			alert ('Error: mes no valido! debe ingresar un valor entre 0 y 12...');
			fechaOk = false;
		}
		else{
			document.getElementById('agregar').disabled = false;
			fechaOk = true;
		}
		if (!(fecha.substr(3,2) >= 0 && fecha.substr(3,2) <= 31)){//   xx/xx/xx
			document.getElementById('agregar').disabled = true;
			alert ('Error: mes no valido! debe ingresar un valor entre 0 y 12');
			fechaOk = false;
		}
		else{
			document.getElementById('agregar').disabled = false;
			fechaOk = true;
		}
		if (!(fecha.substr(6,4) >= 1950 && fecha.substr(6,4) <= 2100)){//   xx/xx/xxxx
			document.getElementById('agregar').disabled = true;
			alert ('Error: año no valido! debe ingresar un valor entre 1950 y 2100');
			fechaOk = false;
		}
		else{
			document.getElementById('agregar').disabled = false;
			fechaOk = true;
		}
		function chequearNumero(numero){
			if(numero < 10) numero = "0" + numero;
		  		return numero;
		}
	}

	function validarFecha(){
		var fecha = document.getElementById('sFecha').value;
		var longitud = fecha.length;
		//COMPROBAR FORMATO DE FECHA ESTE COMPLETO MM/DD/AA
		var posicionSlash1 = 0;
		var fecha_aux;
		var fecha_resto;
		var bMesReparado = false;
		var caracterSlash2;
		//VERIFICA LONGITUDES DEL MES
		var caracterSlash1 = fecha.charAt(0);
		if (caracterSlash1 == '/'){// SLASH POSICION CERO
			alert('Error: faltan dos digitos del mes!');
			document.getElementById('agregar').disabled = true;
			fechaOk = false;
		}

		//VERIFICA SLASH MES EN POSICION 2
		caracterSlash1 = fecha.charAt(2);
		if (caracterSlash1 == '/'){
			fechaOk = true;
			document.getElementById('agregar').disabled = false;
		}
			
		caracterSlash1 = fecha.charAt(1);
		if (caracterSlash1 == '/'){// m/dd/aaaa
			document.getElementById('agregar').disabled = true;
			alert('Error: falta un digito en el mes! el sistema lo solucionará por usted...');
			fecha_aux = chequearNumero(fecha.substring(0,1));
			fecha_resto = fecha.substring(1, 10);
			document.getElementById('sFecha').value = fecha_aux+fecha_resto;
			bMesReparado = true;
		}
		if (bMesReparado == true){
			document.getElementById('agregar').disabled = false;
		}
		//VERIFICA LONGITUDES DEL DIA
		//CASO: DD//AAAA
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(3);
		if (caracterSlash1=='/' && caracterSlash2=='/'){
			document.getElementById('agregar').disabled = true;
			fechaOk=false;
			alert('Error: faltan dos digitos en el día!');
		}
		//CASO: MM/DD/AAAA
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(5);
		if (caracterSlash1=='/' && caracterSlash2=='/'){
			document.getElementById('agregar').disabled = false;
			fechaOk=true;
		}
		//CASO: MM/D/AAAA
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(4);
		if (caracterSlash1=='/' && caracterSlash2=='/'){
			document.getElementById('agregar').disabled = true;
			fechaOk=false;
			alert('Error: falta un digito en el día! el sistema lo solucionará por usted...');
			var inicioFecha = fecha.substring(0,3);
			fecha_aux = chequearNumero(fecha.charAt(3));
			fecha_resto = fecha.substring(4);
			document.getElementById('sFecha').value = inicioFecha+fecha_aux+fecha_resto;
			fechaOk=false;		
		}

		//CASO: MM/D/AAAA
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(5);
		if (caracterSlash1=='/' && caracterSlash2=='/'){		
			document.getElementById('agregar').disabled = true;
			fechaOk=true;
		}
		
		//CASO: MM/DD/
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(5);
		if (caracterSlash1=='/' && caracterSlash2=='/'){
			longitud = fecha.length;
			if (longitud == 6){
				document.getElementById('agregar').disabled = true;		
				fechaOk=false;
			}
		}

		//CASO: MM/DD/AAAA
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(5);
		if (caracterSlash1=='/' && caracterSlash2=='/' && fecha.length == 10){
			document.getElementById('agregar').disabled = false;			
			fechaOk=true;
		}

		//CASO: MM/DD/AAAA
		caracterSlash1 = fecha.charAt(2);
		caracterSlash2 = fecha.charAt(5);
		if (caracterSlash1=='/' && caracterSlash2=='/' && fecha.length < 10){
			document.getElementById('agregar').disabled = true;
			alert('Error: el año se encuentra mal escrito, son 4 digitos...');
			fechaOk = false;
		}
		
		longitud = fecha.length;
		if (longitud > 10){
			document.getElementById('agregar').disabled = true;
			alert ('Error: el formato de fecha supera los 10 digitos, verifique el formato!');
			fechaOk = false;
		}
		if (fecha==''){
			document.getElementById('agregar').disabled = true;
			alert ('Error: el campo fecha se encuentra vacio!');
			fechaOk = false;
		}
		if (!(fecha.substr(0,2) >= 0 && fecha.substr(0,2) <= 12)){
			document.getElementById('agregar').disabled = true;
			alert ('Error: mes no valido! debe ingresar un valor entre 0 y 12...');
			fechaOk = false;
		}
		else{
			document.getElementById('agregar').disabled = false;
			fechaOk = true;
		}
		if (!(fecha.substr(3,2) >= 0 && fecha.substr(3,2) <= 31)){//   xx/xx/xx
			document.getElementById('agregar').disabled = true;
			alert ('Error: mes no valido! debe ingresar un valor entre 0 y 12');
			fechaOk = false;
		}
		else{
			document.getElementById('agregar').disabled = false;
			fechaOk = true;
		}
		if (!(fecha.substr(6,4) >= 1950 && fecha.substr(6,4) <= 2100)){//   xx/xx/xxxx
			document.getElementById('agregar').disabled = true;
			alert ('Error: año no valido! debe ingresar un valor entre 1950 y 2100');
			fechaOk = false;
		}
		else{
			document.getElementById('agregar').disabled = false;
			fechaOk = true;
		}
		function chequearNumero(numero){
			if(numero < 10) numero = "0" + numero;
		  		return numero;
		}
	}
	
	function validarHora(){
		//CASO H:MM
		var horas = document.getElementById('sHora').value;
		var longitud = horas.length;
		//COMPROBAR FORMATO DE HORAS ESTE COMPLETO HH:MM
		var posDosPuntos = horas.indexOf(":",0);
		var horas_aux;
		var horas_resto;
		if (posDosPuntos==0){
			alert('Error: faltan dos digitos de hora (Entre 00 y 24), el formato debe ser HH:MM!');
			document.getElementById('agregar').disabled = true;
		}
		if (longitud ==5){
			document.getElementById('agregar').disabled = false;
		}
		if (posDosPuntos==1){
			alert('Error: falta un digito en las horas! el sistema lo solucionara por usted...');
			horas_aux = horas.substring(0,1);
			horas_aux = chequearNumero(horas_aux);
			horas = document.getElementById('sHora').value;
			longitud = horas.length;
			if (longitud == 4){//x:xx
				horas_resto = horas.substring(2,4);
				document.getElementById('sHora').value = horas_aux+':'+horas_resto;
			}
		}
		longitud = horas.length;
		horas = document.getElementById('sHora').value;
		if (posDosPuntos==2 && longitud == 4){//XX:X
			document.getElementById('agregar').disabled = true;
			horas_resto = horas.substring(3,4);
			horas_aux = horas.substring(0,2);
			horas_resto = chequearNumero(horas_resto);
			document.getElementById('sHora').value = horas_aux+':'+horas_resto;
		}
		if (posDosPuntos==2 && longitud==5)
			document.getElementById('agregar').disabled = false;
		if (posDosPuntos==2 && longitud==3){
			document.getElementById('agregar').disabled = true;
			alert('Error: faltan dos digitos de minutos (Entre 00 y 59), el formato debe ser HH:MM!');
		}
		if (posDosPuntos==2 && longitud==5)
			document.getElementById('agregar').disabled = false;
		//FORMATO :
		longitud = horas.length;
		if (longitud==1){
			alert('Error: faltan dos digitos de hora (Entre 00 y 24), dos digitos de minutos (Entre 00 y 59), el formato debe ser HH:MM!');
			document.getElementById('agregar').disabled = true;
		}
		//VALIDA QUE LA INFO SEA NUMERICA
		horas = document.getElementById('sHora').value;
		if (horas.substr(0,2) >= 0 && horas.substr(0,2) <= 24 && horas !=''){
			document.getElementById('agregar').disabled = false;
		}
		else{
			alert('Error: formato horas incorrecto, debe ingresar un valor entre 00 y 24');
			document.getElementById('agregar').disabled = true;
		}
			
		if (horas.substr(3,4) >= 0 && horas.substr(3,4) <= 59 && horas !=''){
			document.getElementById('agregar').disabled = false;
		}
		else{
			alert('Error: formato minutos incorrecto, debe ingresar un valor entre 00 y 59');
			document.getElementById('agregar').disabled = true;
		}
		function chequearNumero(numero){
			if(numero < 10) numero = "0" + numero;
		  		return numero;
		}
		horas = document.getElementById('sHora').value;
		longitud = horas.length;
		if (longitud==0){
			alert('Error: el valor horas se encuentra vacio!');
			document.getElementById('agregar').disabled = true;
		}
		if (longitud > 5){
			alert('Error: el valor horas posee una longitud mayor a 5 posiciones: formato hh:mm');
			document.getElementById('agregar').disabled = true;
		}
		if (fechaOk == false)
			document.getElementById('agregar').disabled = true;
	}
}())
</script>
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
						<form method="get" action="#">
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
				<h2><b>Datos</b> de la persona</h2>
				<p>Diligencie los datos de la persona</p>
			</div>
		</section><!-- //BREADCRUMBS -->
		<!-- BLOG -->
		<section id="blog">
			
			<!-- CONTAINER -->
			<div class="container">
				
				<!-- ROW -->
				<div class="row">
				
					<!-- BLOG BLOCK -->
					<div class="blog_block col-lg-9 col-md-9 padbot50">
						
						<!-- BLOG POST -->
						<div class="blog_post margbot50 clearfix" data-animated="fadeInUp">
								<!-- FORMULARIO DE LA PERSONA -->
								<div id="fields">
									  <c:url value="/agregaUsuario" var="formUrl"/>
								      <form:form class="clearfix" method="GET" action="${formUrl}">
								      		<legend>FORMULARIO REGISTRO DATOS BASICOS DE LA PERSONA</legend>
          									<table>
              									<tr>
	             									<td><form:label path="lPersona">Persona:</form:label></td>
                  									<td><form:input size="110" path="lPersona" /></td>
              									</tr>
              									<tr>
                  									<td><form:label path="sNombres">Nombres: </form:label></td>
                  									<td><form:input size="110" path="sNombres" /></td>
              									</tr>
              									<tr>
                  									<td><form:label path="sApellidos">Apellidos: </form:label></td>
                  									<td><form:input size="110" path="sApellidos" /></td>
              									</tr>
              									<tr>
                  									<td><form:label path="sDireccion">Direcci&oacute;n: </form:label></td>
                  									<td><form:input size="110" path="sDireccion" /></td>
              									</tr>
              									<tr>
                  									<td><form:label path="sTelefono">Tel&eacute;fono: </form:label></td>
                  									<td><form:input size="110" path="sTelefono" /></td>
              									</tr>
              									<tr>
                  									<td><form:label path="sCorreo">Correo: </form:label></td>
                  									<td><form:input size="110" path="sCorreo" /></td>
              									</tr>
              									<tr>
                  									<td><form:label path="sFecha_Nac">Fecha de nacimiento: </form:label></td>
                  									<td><form:input size="110" path="sFecha_Nac" /></td>
              									</tr>
              									<tr>
                  									<td><form:label path="sSexo">Sexo: </form:label></td>
                  									<td>
                  										<form:select path="sSexo" value="NONE" style="min-width:765px;height:37px;">
              											<form:option value="NONE" selected="selected" label="Seleccione una opción"/>
              											<form:options items="${lstSexo}" />
              											</form:select>
              										</td>
              									</tr>
              									<tr>
                  									<td><form:label path="sCiudad">Ciudad: </form:label></td>
                  									<td>
                  										<form:select path="sCiudad" value="NONE" style="min-width:765px;height:37px;">
              											<form:option value="NONE" selected="selected" label="Seleccione una opción"/>
              											<form:options items="${lstCiudades}" />
              											</form:select>
              										</td>
              									</tr>
              									<tr>
                  									<td><form:label path="sFecha">Fecha: </form:label></td>
                  									<td><form:input size="110" path="sFecha" value="${fecha_actual}"/></td>
              									</tr>
              									<tr>
                  									<td><form:label path="sHora">Hora: </form:label></td>
                  									<td><form:input size="110" path="sHora" value="${hora_actual}"/></td>
              									</tr>
              									<tr align="center">
                  									<td colspan="2">
                  										<input type="submit" id="agregar" value="Agregar" class="btn btn-primary btn-lg"/>
								                  		<input type="reset" value="Limpiar" class="btn btn-primary btn-lg"/>
                  									</td>
              									</tr>
          									</table>
      									</form:form> 
								</div>
							</div>
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
									<a class="title" href="<c:url value="blog"/>" >Gracias a este tipo de aplicaciones miles de personas en el mundo pueden alimentarse bien contribuyendo a la protecci&oacute;n del medio ambiente</a>
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
									<a class="title" href="<c:url value="blog"/>" >La econom&iacute;a solidaria un pilar para las aplicaciones de venta de alimentos en los restaurantes de lujo, primera, segunda, tercera y cuarta categor&iacute;a permitiendo rentabilizar a los propietarios de negocios en estrategias que antes eran imposibles de hacer realidad.</a>
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
									<a class="title" href="<c:url value="blog"/>">La aplicación Comegana una nueva alternativa para combatir los problemas de hambre en el mundo en las personas de escasos recursos.</a>
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
							<p>En el mundo ya existen algunas aplicaciones que est&aacute;n de facto en los establecimientos de ventas de comida, ejemplo de ello tenemos Food for All, Too Food to Go, Nice to eat, Karma, etc., surgidas como respuesta a iniciativas del gobierno por acabar con la pobreza alimentaria en el tercer planeta.</p>
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
							<a class="title" href="<c:url value="blog"/>" >Comegana esta diseñada para cualquier categoria de restaurantes o establecimmientos de venta de comida preparada.</a>
							<ul class="post_item_inf_small">
								<li>Octubre 20 de 2019</li>
							</ul>
						</div>
					</div>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="<c:url value="/resources/images/blog/2.jpg"/>" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="<c:url value="blog"/>" >Con la aplicaci&oacute;n Comegana el usuario puede obtener comida de alta calidad gracias al sistema de recargas de valera electr&oacute;nica en línea proporcionado para tal fin</a>
							<ul class="post_item_inf_small">
								<li>Octubre 14 del 2019</li>
							</ul>
						</div>
					</div>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="<c:url value="/resources/images/blog/3.jpg"/>" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="<c:url value="blog.html"/>" >El software solidario busca mitigar los problemas de hambre en el mundo, esta basado en el beneficio común de las necesidades del ser humano que 
							a diario es considerado como una vulnerabilidad de la sociedad.</a>
							<ul class="post_item_inf_small">
								<li>Agosto 11 del 2019</li>
							</ul>
						</div>
					</div>
				</div>
				
				<div class="col-lg-4 col-md-4 col-sm-6 padbot30 foot_about_block">
					<h4><b>Acerca de </b> nosotros</h4>
					<p>Somos una empresa dedicada a brindar soluciones basadas en los modelos econ&oacute;micos financieros solidarios en pro del mejoramiento de la calidad de vida de las personas de todos los niveles econ&oacute;micos </p>
					<p></p>
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
				
				 <p>Aplicaci&oacute;n web para adquisición de comida <i class="fa fa-heart"></i>, <a href="http://designscrazed.org/" >en restaurantes</a></p>
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
   		$("#sFecha_Nac").datepicker();
	});  
</script>  
<%
	session.removeAttribute("fecha_actual");
	session.removeAttribute("hora_actual");
%>
</body>
</html>