<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!doctype html>
<html lang="us">
<head>
	<meta charset="utf-8">
	<title>P&aacute;gina recargas</title>
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
				<h2><b>Datos</b> de la recarga</h2>
				<p>Informaci&oacute;n  de la recarga</p>
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
								<!-- FORMULARIO CONSULTAR CIUDAD -->
								<div id="fields">
								      <form:form class="clearfix" method="GET" action="">
								      		<legend>FORMULARIO CONSULTAR RECARGA</legend>
          									<table>
              									<tr>
	             									<td><form:label path="lCodigo">C&oacute;digo: </form:label></td>
                  									<td><form:input size="110" path="lCodigo" value="${codigo_recarga}"/></td>
              									</tr>
              									<tr>
	             									<td><form:label path="lCliente">Cliente: </form:label></td>
                  									<td><form:input size="110" path="lCliente" value="${cliente_recarga}"/></td>
              									</tr>
              									<tr>
	             									<td><form:label path="lValor">Valor: </form:label></td>
                  									<td><form:input size="110" path="lValor" value="${valor_recarga}"/></td>
              									</tr>
              									<tr>
                  									<td><form:label path="sFecha">Fecha: </form:label></td>
                  									<td><form:input size="110" path="sFecha" value="${fecha_recarga}"/></td>
              									</tr>
              									<tr>
                  									<td><form:label path="sHora">Hora: </form:label></td>
                  									<td><form:input size="110" path="sHora" value="${hora_recarga}"/></td>
              									</tr>
              									<tr align="center">
                  									<td colspan="2">
                  										<input type="submit" value="Salir" class="btn btn-primary btn-lg"/>
                 									</td>
              									</tr>
          									</table>
      									</form:form>
								</div>
							</div><!-- //FORM REGISTRO -->
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
						<div class="sidepanel widget_meta">
							<ul>
								<li><a href="javascript:void(0);" >Redes sociales</a></li>
								<li><a href="javascript:void(0);" >Publicidad</a></li>
								<li><a href="javascript:void(0);" >Cobertura</a></li>
								<li><a href="javascript:void(0);" >Medios de pago</a></li>
								<li><a href="javascript:void(0);" >Bancos</a></li>
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
<%
	session.removeAttribute("codigo_ciudad");
	session.removeAttribute("nombre_ciudad");
	session.removeAttribute("depto_ciudad");
	session.removeAttribute("fecha_ciudad");
	session.removeAttribute("hora_ciudad");
%>
</body>
</html>