<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
	session.setAttribute("param_usuario", "Frank Jairo Castillo Padilla");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Inicio aplicaci&oacute;n Comegana</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico"/>">
	<!-- CSS -->
	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/flexslider.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/prettyPhoto.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet" type="text/css" media="all" />
    <link href="<c:url value="/resources/css/owl.carousel.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css" />
    
	<!-- FONTS -->
	<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500italic,700,500,700italic,900,900italic' rel='stylesheet' type='text/css'>
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">	
    
	<!-- SCRIPTS -->
	<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <!--[if IE]><html class="ie" lang="en"> <![endif]-->
	<script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.prettyPhoto.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.nicescroll.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/superfish.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.flexslider-min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/owl.carousel.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/animate.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.BlackAndWhite.js"/>"></script>
	<script src="<c:url value="/resources/js/myscript.js"/>" type="text/javascript"></script>
	<script>
		
		//PrettyPhoto
		jQuery(document).ready(function() {
			$("a[rel^='prettyPhoto']").prettyPhoto();
		});
		
		//BlackAndWhite
		$(window).load(function(){
			$('.client_img').BlackAndWhite({
				hoverEffect : true, // default true
				// set the path to BnWWorker.js for a superfast implementation
				webworkerPath : false,
				// for the images with a fluid width and height 
				responsive:true,
				// to invert the hover effect
				invertHoverEffect: false,
				// this option works only on the modern browsers ( on IE lower than 9 it remains always 1)
				intensity:1,
				speed: { //this property could also be just speed: value for both fadeIn and fadeOut
					fadeIn: 300, // 200ms for fadeIn animations
					fadeOut: 300 // 800ms for fadeOut animations
				},
				onImageReady:function(img) {
					// this callback gets executed anytime an image is converted
				}
			});
		});
		
	</script>
</head>
<body>
<!-- PRELOADER -->
<img id="preloader" src="<c:url value="/resources/images/preloader.gif"/>" alt="" />
<!-- //PRELOADER -->
<div class="preloader_hide">

	<!-- PAGE -->
	<div id="page">
	
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
								<li class="first active scroll_btn"><a href="#home" >Inicio</a></li>
								<li class="scroll_btn"><a href="#about" >Acerca de nosotros</a></li>
								<li class="scroll_btn"><a href="#projects" >Proyectos</a></li>
								<li class="scroll_btn"><a href="#team" >Equipo</a></li>
								<li class="scroll_btn"><a href="#news" >Noticias</a></li>
								<li class="scroll_btn last"><a href="#contacts" >Contactenos</a></li>
								<li class="sub-menu">
									<a href="javascript:void(0);" >Sesi&oacute;n</a>
									<ul>
										<li><a href="<c:url value="login"/>">Darse de alta</a></li>
										<li><a href="<c:url value="agregarPersonaReg"/>">Registrarse</a></li>
									</ul>
								</li>
								<li class="sub-menu">
									<a href="javascript:void(0);" >Otros</a>
									<ul>
										<li><a href="<c:url value="blog"/>" >Blog</a></li>
										<li><a href="<c:url value="blog-post.html"/>" >Blog Post</a></li>
										<li><a href="<c:url value="portfolio-post.html"/>" >Portafolio</a></li>
									</ul>
								</li>
							</ul>
						</nav>
					</div><!-- //MENU -->
				</div><!-- //MENU BLOCK -->
			</div><!-- //CONTAINER -->
		</header><!-- //HEADER -->
		
		
		<!-- HOME -->
		<section id="home" class="padbot0">
				
			<!-- TOP SLIDER -->
			<div class="flexslider top_slider">
				<ul class="slides">
					<li class="slide1">
						<div class="flex_caption1">
							<p class="title1 captionDelay2 FromTop">Bienvenido</p>
							<p class="title2 captionDelay4 FromTop">a nuestra aplicaci&oacute;n</p>
							<p class="title3 captionDelay6 FromTop">Comegana</p>
							<p class="title4 captionDelay7 FromBottom">Un novedoso sistema para hacer recargas de compra de comida en restaurantes basado en el modelo financiero de econom&iacute;a solidaria</p>
						</div>
						<a class="slide_btn FromRight" href="javascript:void(0);" >Leer m&aacute;s</a>
					<li class="slide2">
						<div class="flex_caption1">
							<p class="title1 captionDelay6 FromLeft">Obtenga</p>
							<p class="title2 captionDelay4 FromLeft">grandes bonificaciones</p>
							<p class="title3 captionDelay2 FromLeft">y premios</p>
							<p class="title4 captionDelay7 FromLeft">por hacer recargas a la valera con la que puede adquirir comida preparada en cualquier restaurante de la ciudad</p>
						</div>
						<a class="slide_btn FromRight" href="javascript:void(0);" >Leer m&aacute;s</a>
					</li>
					<li class="slide3">
						<div class="flex_caption1">
							<p class="title1 captionDelay1 FromBottom">Propietarios de restaurantes</p>
							<p class="title2 captionDelay2 FromBottom">establecen a d&iacute;ario</p>
							<p class="title3 captionDelay3 FromBottom">fabulosos convenios con KMI</p>
							<p class="title4 captionDelay5 FromBottom">y obtienen fantasticos beneficios en nuestra de red de afiliados</p>
						</div>
						<a class="slide_btn FromRight" href="javascript:void(0);" >Leer m&aacute;s</a>
						
						<!-- VIDEO BACKGROUND -->
						<a id="P2" class="player" data-property="{videoURL:'tDvBwPzJ7dY',containment:'.top_slider .slide3',autoPlay:true, mute:true, startAt:0, opacity:1}" ></a>
						<!-- //VIDEO BACKGROUND -->
					</li>
				</ul>
			</div>
			<div id="carousel">
				<ul class="slides">
					<li><img src="<c:url value="/resources/images/slider/slide1_bg.jpg"/>" alt="Restaurante 1" /></li>
					<li><img src="<c:url value="/resources/images/slider/slide2_bg.jpg"/>" alt="Restaurante 2" /></li>
					<li><img src="<c:url value="/resources/images/slider/slide3_bg.jpg"/>" alt="Restaurante 3" /></li>
				</ul>
			</div><!-- //TOP SLIDER -->
		</section><!-- //HOME -->
		
		
		<!-- ABOUT -->
		<section id="about">
			
			<!-- SERVICES -->
			<div class="services_block padbot40" data-appear-top-offset="-200" data-animated="fadeInUp">
				
				<!-- CONTAINER -->
				<div class="container">
				
					<!-- ROW -->
					<div class="row">
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-ss-12 margbot30">
							<a class="services_item" href="javascript:void(0);" >
								<p><b>Econom&iacute;a solidaria</p>
								<span>Compromiso pleno con el entorno social y cooperación con otras empresas af&iacute;nes.</span>
							</a>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-ss-12 margbot30">
							<a class="services_item" href="javascript:void(0);" >
								<p><b>Sin &aacute;nimo de lucro</p>
								<span>El modelo economico solidario busca la promoci&oacute;n humana y social con una esencia no lucrativa. 
								los beneficios alcanzados se invierten en otros proyectos solidarios o de cooperaci&oacute;n
								</span>
							</a>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-ss-12 margbot30">
							<a class="services_item" href="javascript:void(0);" >
								<p><b>Protecci&oacute;n del medio ambiente</p>
								<span>Los metodos de protecci&oacute;n y operaciones de la organizaci&oacute;n buscan la protecci&oacute;n del medio ambiente.</span>
							</a>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-ss-12 margbot30">
							<a class="services_item" href="javascript:void(0);" >
								<p><b>Otras cuestiones</p>
								<span>Libertad economica mayormente operante, servicio a la sociedad, participaci&oacute;n constante y consciente de los implicados, principio de equidad</span>
							</a>
						</div>
					</div><!-- //ROW -->
				</div><!-- //CONTAINER -->
			</div><!-- //SERVICES -->
			
			<!-- CLEAN CODE -->
			<div class="cleancode_block">
				
				<!-- CONTAINER -->
				<div class="container" data-appear-top-offset="-200" data-animated="fadeInUp">
					
					<!-- CASTOM TAB -->
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade in active clearfix" id="tab1">
							<p class="title"><b>Misi&oacute;n</p>
							<span>So&nacute;amos con un mundo mejor para todos, con un planeta sostenible, en el que podamos prosperar, disfrutar de una larga vida saludable y ser felices. Un mundo sin hambre, sin pobreza y mejor educado.</span>
						</div>
						<div class="tab-pane fade clearfix" id="tab2">
							<p class="title"><b>Soporte</b> t&eacute;cnico</p>
							<span>So&nacute;amos con un mundo mejor para todos, con un planeta sostenible, en el que podamos prosperar, disfrutar de una larga vida saludable y ser felices. Un mundo sin hambre, sin pobreza y mejor educado.</span>
						</div>
						<div class="tab-pane fade clearfix" id="tab3">
							<p class="title"><b>Responsivo</b></p>
							<span>So&nacute;amos con un mundo mejor para todos, con un planeta sostenible, en el que podamos prosperar, disfrutar de una larga vida saludable y ser felices. Un mundo sin hambre, sin pobreza y mejor educado.</span>
						</div>
						<div class="tab-pane fade clearfix" id="tab4">
							<p class="title"><b>Documentaci&oacute;n</b></p>
							<span>So&nacute;amos con un mundo mejor para todos, con un planeta sostenible, en el que podamos prosperar, disfrutar de una larga vida saludable y ser felices. Un mundo sin hambre, sin pobreza y mejor educado.</span>
						</div>
						<div class="tab-pane fade clearfix" id="tab5">
							<p class="title"><b>Calidad</b></p>
							<span>So&nacute;amos con un mundo mejor para todos, con un planeta sostenible, en el que podamos prosperar, disfrutar de una larga vida saludable y ser felices. Un mundo sin hambre, sin pobreza y mejor educado.</span>
						</div>
						<div class="tab-pane fade clearfix" id="tab6">
							<p class="title"><b>Soporte</b></p>
							<span>So&nacute;amos con un mundo mejor para todos, con un planeta sostenible, en el que podamos prosperar, disfrutar de una larga vida saludable y ser felices. Un mundo sin hambre, sin pobreza y mejor educado.</span>
						</div>
					</div>
					<ul id="myTab" class="nav nav-tabs">
						<li class="active"><a class="i1" href="#tab1" data-toggle="tab" ><i></i><span>C&oacute;digo limpio</span></a></li>
						<li><a class="i2" href="#tab2" data-toggle="tab" ><i></i><span>Soporte</span></a></li>
						<li><a class="i3" href="#tab3" data-toggle="tab" ><i></i><span>Responsivo</span></a></li>
						<li><a class="i4" href="#tab4" data-toggle="tab" ><i></i><span>Documentaci&oacute;n</span></a></li>
						<li><a class="i5" href="#tab5" data-toggle="tab" ><i></i><span>Calidad</span></a></li>
						<li><a class="i6" href="#tab6" data-toggle="tab" ><i></i><span>Soporte</span></a></li>
					</ul><!-- CASTOM TAB -->
				</div><!-- //CONTAINER -->
			</div><!-- //CLEAN CODE -->
			
			<!-- MULTI PURPOSE -->
			<div class="purpose_block">
				
				<!-- CONTAINER -->
				<div class="container">
					
					<!-- ROW -->
					<div class="row">
					
						<div class="col-lg-7 col-md-7 col-sm-7" data-appear-top-offset="-200" data-animated="fadeInLeft">
							<h2><b>Caracter&iacute;sticas del negocio</h2>
							<p>Somos una empresa dedicada a brindar soluciones informativas de alto nivel en los restaurantes que pretenden mejorar y aumentar las alternativas de servicio a sus clientes.</p>
							<p>En el 2030 pretendemos ser una de las empresas lideres a nivel mundial en lo que concierne a la venta de comida preparada aplicando sistemas inform&aacute;ticos basados en el modelo financiero de econom&iacute;a solidaria.</p>
							<a class="btn btn-active" href="javascript:void(0);" ><span data-hover="Ver mas aspectos">Otras caracter&iacute;sticas</span></a>
							<a class="btn" href="javascript:void(0);" >Mas informaci&oacute;n</a>
						</div>
						
						<div class="col-lg-5 col-md-5 col-sm-5 ipad_img_in" data-appear-top-offset="-200" data-animated="fadeInRight">
							<img class="ipad_img1" src="<c:url value="/resources/images/img1.png"/>" alt="" />
						</div>
					</div><!-- //ROW -->
				</div><!-- //CONTAINER -->
			</div><!-- //MULTI PURPOSE -->
		</section><!-- //ABOUT -->
		
		
		<!-- PROJECTS -->
		<section id="projects" class="padbot20">
		
			<!-- CONTAINER -->
			<div class="container">
				<h2><b>Medios de </b> Pago</h2>
			</div><!-- //CONTAINER -->
			
				
			<div class="projects-wrapper" data-appear-top-offset="-200" data-animated="fadeInUp">
				<!-- PROJECTS SLIDER -->
				<div class="owl-demo owl-carousel projects_slider">
					
					<!-- work1 -->
					<div class="item">
						<div class="work_item">
							<div class="work_img">
								<img src="<c:url value="/resources/images/works/1.jpg"/>" alt="" />
								<a class="zoom" href="<c:url value="/resources/images/works/1.jpg"/>" rel="prettyPhoto[portfolio1]" ></a>
							</div>
							<div class="work_description">
								<div class="work_descr_cont">
									<a href="<c:url value="portfolio-post.html"/>" >Ginger Beast</a>
									<span>Marzo 17, 2041</span>
								</div>
							</div>
						</div>
					</div><!-- //work1 -->
					
					<!-- work2 -->
					<div class="item">
						<div class="work_item">
							<div class="work_img">
								<img src="<c:url value="/resources/images/works/2.jpg"/>" alt="" />
								<a class="zoom" href="<c:url value="/resources/images/works/2.jpg"/>" rel="prettyPhoto[portfolio1]" ></a>
							</div>
							<div class="work_description">
								<div class="work_descr_cont">
									<a href="<c:url value="portfolio-post.html"/>" >Ginger Beast</a>
									<span>Marzo 17, 2041</span>
								</div>
							</div>
						</div>
					</div><!-- //work2 -->
					
					<!-- work3 -->
					<div class="item">
						<div class="work_item">
							<div class="work_img">
								<img src="<c:url value="/resources/images/works/3.jpg"/>" alt="" />
								<a class="zoom" href="<c:url value="/resources/images/works/3.jpg"/>" rel="prettyPhoto[portfolio1]" ></a>
							</div>
							<div class="work_description">
								<div class="work_descr_cont">
									<a href="portfolio-post.html" >Ginger Beast</a>
									<span>Marzo 17, 2041</span>
								</div>
							</div>
						</div>
					</div><!-- //work3 -->
					
					<!-- work4 -->
					<div class="item">
						<div class="work_item">
							<div class="work_img">
								<img src="<c:url value="/resources/images/works/4.jpg"/>" alt="" />
								<a class="zoom" href="<c:url value="/resources/images/works/4.jpg"/>" rel="prettyPhoto[portfolio1]" ></a>
							</div>
							<div class="work_description">
								<div class="work_descr_cont">
									<a href="portfolio-post.html" >Ginger Beast</a>
									<span>Marzo 17, 2041</span>
								</div>
							</div>
						</div>
					</div><!-- //work4 -->
					
					<!-- work5 -->
					<div class="item">
						<div class="work_item">
							<div class="work_img">
								<img src="<c:url value="/resources/images/works/5.jpg"/>" alt="" />
								<a class="zoom" href="<c:url value="/resources/images/works/5.jpg"/>" rel="prettyPhoto[portfolio1]" ></a>
							</div>
							<div class="work_description">
								<div class="work_descr_cont">
									<a href="portfolio-post.html" >Ginger Beast</a>
									<span>Marzo 17, 2041</span>
								</div>
							</div>
						</div>
					</div><!-- //work5 -->
					
					<!-- work6 -->
					<div class="item">
						<div class="work_item">
							<div class="work_img">
								<img src="<c:url value="/resources/images/works/6.jpg"/>" alt="" />
								<a class="zoom" href="<c:url value="/resources/images/works/6.jpg"/>" rel="prettyPhoto[portfolio1]" ></a>
							</div>
							<div class="work_description">
								<div class="work_descr_cont">
									<a href="portfolio-post.html" >Ginger Beast</a>
									<span>Marzo 17, 2041</span>
								</div>
							</div>
						</div>
					</div><!-- //work6 -->
					
					<!-- work7 -->
					<div class="item">
						<div class="work_item">
							<div class="work_img">
								<img src="<c:url value="/resources/images/works/7.jpg"/>" alt="" />
								<a class="zoom" href="<c:url value="/resources/images/works/7.jpg"/>" rel="prettyPhoto[portfolio1]" ></a>
							</div>
							<div class="work_description">
								<div class="work_descr_cont">
									<a href="portfolio-post.html" >Ginger Beast</a>
									<span>Marzo 17, 2041</span>
								</div>
							</div>
						</div>
					</div><!-- //work7 -->
				</div><!-- //PROJECTS SLIDER -->
			</div>
			
			
			<!-- NUESTROS CLIENTES -->
			<div class="our_clients">
			
				<!-- CONTENEDOR -->
				<div class="container" data-appear-top-offset="-200" data-animated="fadeInUp">
					
					<!-- ROW -->
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-2 client_img">
							<img src="<c:url value="/resources/images/clients/1.jpg"/>" alt="" />
						</div>
						<div class="col-lg-2 col-md-2 col-sm-2 client_img">
							<img src="<c:url value="/resources/images/clients/2.jpg"/>" alt="" />
						</div>
						<div class="col-lg-2 col-md-2 col-sm-2 client_img">
							<img src="<c:url value="/resources/images/clients/3.jpg"/>" alt="" />
						</div>
						<div class="col-lg-2 col-md-2 col-sm-2 client_img">
							<img src="<c:url value="/resources/images/clients/4.jpg"/>" alt="" />
						</div>
						<div class="col-lg-2 col-md-2 col-sm-2 client_img">
							<img src="<c:url value="/resources/images/clients/5.jpg"/>" alt="" />
						</div>
						<div class="col-lg-2 col-md-2 col-sm-2 client_img">
							<img src="<c:url value="/resources/images/clients/6.jpg"/>" alt="" />
						</div>
					</div><!-- //FILA -->
				</div><!-- CONTENEDOR -->
			</div><!-- //NUESTROS CLIENTES -->
		</section><!-- //PROYECTOS -->
		
		
		<!-- TEAM -->
		<section id="team">
		
			<!-- CONTAINER -->
			<div class="container">
				<h2><b>Nuestro</b> Equipo</h2>
				
				<!-- ROW -->
				<div class="row" data-appear-top-offset="-200" data-animated="fadeInUp">
						
					<!-- TEAM SLIDER -->
					<div class="owl-demo owl-carousel team_slider">
				
						<!-- crewman1 -->
						<div class="item">
							<div class="crewman_item">
								<div class="crewman">
									<img src="<c:url value="/resources/images/team/1.jpg"/>" alt="Restaurante 1" height="370"/>
								</div>
								<div class="crewman_descr center">
									<div class="crewman_descr_cont">
										<p>Frank Jairo</p>
										<span>Master</span>
									</div>
								</div>
								<div class="crewman_social">
									<a href="javascript:void(0);" ><i class="fa fa-twitter"></i></a>
									<a href="javascript:void(0);" ><i class="fa fa-facebook-square"></i></a>
								</div>
							</div>
						</div><!-- crewman1 -->
						
						<!-- crewman2 -->
						<div class="item">
							<div class="crewman_item">
								<div class="crewman">
									<img src="<c:url value="/resources/images/team/2.jpg"/>" alt="" height="370"/>
								</div>
								<div class="crewman_descr center">
									<div class="crewman_descr_cont">
										<p>Jorge Davila</p>
										<span>Doctor en econom&iacute;a</span>
									</div>
								</div>
								<div class="crewman_social">
									<a href="javascript:void(0);" ><i class="fa fa-google-plus"></i></a>
									<a href="javascript:void(0);" ><i class="fa fa-twitter"></i></a>
									<a href="javascript:void(0);" ><i class="fa fa-facebook-square"></i></a>
								</div>
							</div>
						</div><!-- crewman1 -->
						
						<!-- crewman3 -->
						<div class="item">
							<div class="crewman_item">
								<div class="crewman">
									<img src="<c:url value="/resources/images/team/3.jpg"/>" alt="" />
								</div>
								<div class="crewman_descr center">
									<div class="crewman_descr_cont">
										<p>Rafael Ramirez</p>
										<span>Ingeniero de sistemas</span>
									</div>
								</div>
								<div class="crewman_social">
									<a href="javascript:void(0);" ><i class="fa fa-twitter"></i></a>
									<a href="javascript:void(0);" ><i class="fa fa-facebook-square"></i></a>
								</div>
							</div>
						</div><!-- crewman3 -->
						
						<!-- crewman4 -->
						<div class="item">
							<div class="crewman_item">
								<div class="crewman">
									<img src="<c:url value="/resources/images/team/4.jpg"/>" alt="" />
								</div>
								<div class="crewman_descr center">
									<div class="crewman_descr_cont">
										<p>Jeff</p>
										<span>Profesional en contabilidad</span>
									</div>
								</div>
								<div class="crewman_social">
									<a href="javascript:void(0);" ><i class="fa fa-twitter"></i></a>
									<a href="javascript:void(0);" ><i class="fa fa-facebook-square"></i></a>
								</div>
							</div>
						</div><!-- crewman4 -->
						
						<!-- crewman5 -->
						<div class="item">
							<div class="crewman_item">
								<div class="crewman">
									<img src="<c:url value="/resources/images/team/5.jpg"/>" alt="" />
								</div>
								<div class="crewman_descr center">
									<div class="crewman_descr_cont">
										<p>Jefferson</p>
										<span>Administrador financiero</span>
									</div>
								</div>
								<div class="crewman_social">
									<a href="javascript:void(0);" ><i class="fa fa-google-plus"></i></a>
									<a href="javascript:void(0);" ><i class="fa fa-twitter"></i></a>
									<a href="javascript:void(0);" ><i class="fa fa-facebook-square"></i></a>
								</div>
							</div>
						</div><!-- crewman5 -->
						
						<!-- crewman6 -->
						<div class="item">
							<div class="crewman_item">
								<div class="crewman">
									<img src="<c:url value="/resources/images/team/6.jpg"/>" alt="" />
								</div>
								<div class="crewman_descr center">
									<div class="crewman_descr_cont">
										<p>John Marks</p>
										<span>Designer</span>
									</div>
								</div>
								<div class="crewman_social">
									<a href="javascript:void(0);" ><i class="fa fa-twitter"></i></a>
									<a href="javascript:void(0);" ><i class="fa fa-facebook-square"></i></a>
								</div>
							</div>
						</div><!-- crewman6 -->
						
						<!-- crewman7 -->
						<div class="item">
							<div class="crewman_item">
								<div class="crewman">
									<img src="<c:url value="/resources/images/team/7.jpg"/>" alt="" />
								</div>
								<div class="crewman_descr center">
									<div class="crewman_descr_cont">
										<p>Joe Mades</p>
										<span>Developer</span>
									</div>
								</div>
								<div class="crewman_social">
									<a href="javascript:void(0);" ><i class="fa fa-twitter"></i></a>
									<a href="javascript:void(0);" ><i class="fa fa-facebook-square"></i></a>
								</div>
							</div>
						</div><!-- crewman7 -->
						
						<!-- crewman8 -->
						<div class="item">
							<div class="crewman_item">
								<div class="crewman">
									<img src="<c:url value="/resources/images/team/8.jpg"/>" alt="" />
								</div>
								<div class="crewman_descr center">
									<div class="crewman_descr_cont">
										<p>Julia Anderson</p>
										<span>Developer</span>
									</div>
								</div>
								<div class="crewman_social">
									<a href="javascript:void(0);" ><i class="fa fa-google-plus"></i></a>
									<a href="javascript:void(0);" ><i class="fa fa-twitter"></i></a>
									<a href="javascript:void(0);" ><i class="fa fa-facebook-square"></i></a>
								</div>
							</div>
						</div><!-- crewman8 -->
					</div><!-- EQUIPO SLIDER -->
				</div><!-- //FILA -->
			</div><!-- //CONTENEDOR -->
		</section><!-- //EQUIPO -->
		
		
		<!-- NEWS -->
		<section id="news">
		
			<!-- CONTAINER -->
			<div class="container">
				<h2><b>Visi&oacute;n</h2>
				
				<!-- TESTIMONIALS -->
				<div class="testimonials" data-appear-top-offset="-200" data-animated="fadeInUp">
						
					<!-- TESTIMONIALES SLIDER -->
					<div class="owl-demo owl-carousel testim_slider">
						
						<!-- TESTIMONIALES -->
						<div class="item">
							<div class="testim_content">Estamos comprometidos con acciones al emprender actividades que promuevan una vida digan y con calidad para todos los seres vivos, fomentamos la sostenibilidad del planeta, a trav&eacute;s de una econom&iacute;a colaborativa
							e inclusiva, protectora y conservadora de la naturaleza. </div>
							<div class="testim_author">—  Frank Castillo, <b>Ingeniero de sistemas</b></div>
						</div><!-- TESTIMONIAL1 -->
						
						<!-- TESTIMONIALES -->
						<div class="item">
							<div class="testim_content">Estamos convencidos que juntos podemos combatir el desperdicio de alimentos y lograr un cambio positivo. Centrados en la promoción de la conciencia de la importancia de expandir nuestra mis&iacute;on a trav&eacute;s de
							equipos colaborativos sin&eacute;rgicos, para impactar en cada hogar, cada empresa, a trav&eacute;s de la educaci&oacute;n</div>
							<div class="testim_author">—  Jorge D&aacute;vila, <b>Econom&iacute;sta</b></div>
						</div><!-- TESTIMONIAL2 -->
						
						<!-- TESTIMONIALES -->
						<div class="item">
							<div class="testim_content">Evitamos el desperdicio de alimentos al tiempo que facilitamos que quienes no tienen acceso a ellos pueden satisfacer sus necesidades b&aacute;sicas de alimentaci&oacute;n</div>
							<div class="testim_author">—  Rafa&eacute;l Ramirez, <b>Ingeniero de sistemas</b></div>
						</div><!-- TESTIMONIALES -->
					</div><!-- TESTIMONIALES SLIDER -->
				</div><!-- //TESTIMONIALES -->
				
				<!-- RECENT POSTS -->
				<div class="row recent_posts" data-appear-top-offset="-200" data-animated="fadeInUp">
					<div class="col-lg-4 col-md-4 col-sm-4 padbot30 post_item_block">
						<div class="post_item">
							<div class="post_item_img">
								<img src="<c:url value="/resources/images/blog/1.jpg"/>" alt="" />
								<a class="link" href="<c:url value="blog-post.html"/>" ></a>
							</div>
							<div class="post_item_content">
								<a class="title" href="<c:url value="blog-post.html"/>" >Restaurante de lujo</a>
								<ul class="post_item_inf">
									<li><a href="javascript:void(0);" >Anna</a> |</li>
									<li><a href="javascript:void(0);" >Elegancia</a> |</li>
									<li><a href="javascript:void(0);" >10 Comentarios</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-4 padbot30 post_item_block">
						<div class="post_item">
							<div class="post_item_img">
								<img src="<c:url value="/resources/images/blog/2.jpg"/>" alt="" />
								<a class="link" href="<c:url value="blog-post.html"/>"></a>
							</div>
							<div class="post_item_content">
								<a class="title" href="<c:url value="blog-post.html"/>" >Restaurantes de segundo nivel</a>
								<ul class="post_item_inf">
									<li><a href="javascript:void(0);" >Anna</a> |</li>
									<li><a href="javascript:void(0);" >Comfort</a> |</li>
									<li><a href="javascript:void(0);" >No hay comentarios</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-4 padbot30 post_item_block">
						<div class="post_item">
							<div class="post_item_img">
								<img src="<c:url value="/resources/images/blog/3.jpg"/>" alt="" />
								<a class="link" href="<c:url value="blog-post.html"/>"></a>
							</div>
							<div class="post_item_content">
								<a class="title" href="<c:url value="blog-post.html"/>" >Restaurantes paradisiacos</a>
								<ul class="post_item_inf">
									<li><a href="javascript:void(0);" >Anna</a> |</li>
									<li><a href="javascript:void(0);" >Creativo</a> |</li>
									<li><a href="javascript:void(0);" >3 Comentarios</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div><!-- POSTS RECIENTES -->
			</div><!-- //CONTENEDOR-->
		</section><!-- //NOTICIAS -->
	</div><!-- //PAGINA -->
	
	<!-- CONTACTOS -->
	<section id="contacts">
	</section><!-- //CONTACTOS -->
	
	<!-- FOOTER -->
	<footer>
			
		<!-- CONTAINER -->
		<div class="container">
			
			<!-- ROW -->
			<div class="row" data-appear-top-offset="-200" data-animated="fadeInUp">
				
				<div class="col-lg-4 col-md-4 col-sm-6 padbot30">
					<h4><b>Restaurantes</b> destacados</h4>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="<c:url value="/resources/images/blog/1.jpg"/>" alt="" />
						</div>
						<div class="post_item_content_small"><c:url value="blog.html"/>
							<a class="title" href="<c:url value="blog.html"/>" >Hoteles de lujo</a>
							<ul class="post_item_inf_small">
								<li>Agosto 5 de 2019</li>
							</ul>
						</div>
					</div>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="<c:url value="/resources/images/blog/2.jpg"/>" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="<c:url value="blog.html"/>" >Hoteles de primera categor&iacute;a</a>
							<ul class="post_item_inf_small">
								<li>Octubre 24 de 2019</li>
							</ul>
						</div>
					</div>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="<c:url value="/resources/images/blog/3.jpg"/>" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="<c:url value="blog.html"/>" >Hoteles tur&iacute;sticos</a>
							<ul class="post_item_inf_small">
								<li>Octubre 21 de 2019</li>
							</ul>
						</div>
					</div>
				</div>
				
				<div class="col-lg-4 col-md-4 col-sm-6 padbot30 foot_about_block">
					<h4><b>Acerca</b> de nosotros</h4>
					<p>Somos una empresa que fomenta las leyes anti-desperdicio promovida por algunos paises en el planeta.</p>
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
					<h4><b>Contactanos</h4>
					
					<!-- CONTACT FORM -->
					<div class="span9 contact_form">
						<div id="note"></div>
						<div id="fields">
							<form id="contact-form-face" class="clearfix" action="#">
								<input type="text" name="name" value="Name" onFocus="if (this.value == 'Name') this.value = '';" onBlur="if (this.value == '') this.value = 'Name';" />
								<textarea name="message" onFocus="if (this.value == 'Message') this.value = '';" onBlur="if (this.value == '') this.value = 'Message';">Message</textarea>
								<input class="contact_btn" type="submit" value="Enviar mensaje" />
							</form>
						</div>
					</div><!-- //FORMULARIO DE CONTACTO -->
				</div>
			</div><!-- //FILA -->
			<div class="row copyright">
				<div class="col-lg-12 text-center">
				
				 <p>Elaborado con diseños  <i class="fa fa-heart"></i>, <a href="http://designscrazed.org/" >enloquecidos</a></p>
				</div>
			
			</div><!-- //ROW -->
		</div><!-- //CONTAINER -->
	</footer><!-- //FOOTER -->
	
	<!-- MAP -->
	<div id="map">
		<a class="map_hide" href="javascript:void(0);" ><i class="fa fa-angle-right"></i><i class="fa fa-angle-left"></i></a>
		<iframe src="http://maps.google.com/maps?f=q&amp;give%20a%20hand=s_q&amp;hl=en&amp;geocode=&amp;q=london&amp;sll=37.0625,-95.677068&amp;sspn=42.631141,90.263672&amp;ie=UTF8&amp;hq=&amp;hnear=London,+United+Kingdom&amp;ll=51.500141,-0.126257&amp;spn=0.026448,0.039396&amp;z=14&amp;output=embed" ></iframe>
	</div><!-- //MAP -->
</div>
</body>
</html>