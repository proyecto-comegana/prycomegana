<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	
	<meta charset="utf-8">
	<title>White | responsive bootstrap3 html5 one page template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico"/>">
    
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
	
	<script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.nicescroll.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/superfish.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.flexslider-min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/owl.carousel.js"/>"></script>
	<script src="<c:url value="/resources/js/animate.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/myscript.js"/>" type="text/javascript"></script>
	
</head>
<body>

<!-- PRELOADER -->
<img id="preloader" src="images/preloader.gif" alt="" />
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
						<a href="index.html" ><span class="b1">C</span><span class="b2">o</span><span class="b3">m</span><span class="b4">e</span><span class="b5">g</span><span class="b5">a</span><span class="b5">n</span><span class="b5">a</span></a>
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
								<li class="first scroll_btn"><a href="index.html">Home</a></li>
								<li class="scroll_btn"><a href="index.html#about">About Us</a></li>
								<li class="scroll_btn"><a href="index.html#projects">Projects</a></li>
								<li class="scroll_btn"><a href="index.html#team">Team</a></li>
								<li class="scroll_btn"><a href="index.html#news">News</a></li>
								<li class="scroll_btn last"><a href="index.html#contacts">Contacts</a></li>
								<li class="sub-menu active">
									<a href="javascript:void(0);">Pages</a>
									<ul>
										<li class="active"><a href="blog.html">Blog</a></li>
										<li><a href="blog-post.html">Blog Post</a></li>
										<li><a href="portfolio-post.html">Portfolio Single Work</a></li>
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
				<h2><b>The</b> Blog</h2>
				<p>Publication of the latest news, articles, and free apps.</p>
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
							<div class="blog_post_img">
								<img src="images/blog/1.jpg" alt="" />
								<a class="zoom" href="blog-post.html" ></a>
							</div>
							<div class="blog_post_descr">
								<div class="blog_post_date">JANUARY 30 | 21:30</div>
								<a class="blog_post_title" href="blog-post.html" >Rihanna's Costume Designer Comes Into His Own with New Show</a>
								<ul class="blog_post_info">
									<li><a href="javascript:void(0);" >Admin</a></li>
									<li><a href="javascript:void(0);" >Creative</a></li>
									<li><a href="javascript:void(0);" >3 Comments</a></li>
								</ul>
								<hr>
								<div class="blog_post_content">The best way to describe Adam Selman would be simply to say that he is the epitome of cool. So it’s only fitting that his first runway collection was made for the ultimate cool girl.</div>
								<a class="read_more_btn" href="blog-post.html" >Read More</a>
							</div>
						</div><!-- //BLOG POST -->
						

						<!-- BLOG POST -->
						<div class="blog_post margbot50 clearfix" data-animated="fadeInUp">
							<div class="blog_post_img">
								<img src="images/blog/2.jpg" alt="" />
								<a class="zoom" href="blog-post.html" ></a>
							</div>
							<div class="blog_post_descr">
								<div class="blog_post_date">JANUARY 30 | 21:30</div>
								<a class="blog_post_title" href="blog-post.html" >The Four Week Workout to Tank Top Worthy Arm</a>
								<ul class="blog_post_info">
									<li><a href="javascript:void(0);" >Admin</a></li>
									<li><a href="javascript:void(0);" >Creative</a></li>
									<li><a href="javascript:void(0);" >3 Comments</a></li>
								</ul>
								<hr>
								<div class="blog_post_content">Our stomachs, legs, and butts, (thanks to Jen Selter) are usually top priority areas when it comes to getting in shape. But when I'm tagged in a photo on Instagram, I quite often find myself wishing for an arm-sculpting filter.</div>
								<a class="read_more_btn" href="blog-post.html" >Read More</a>
							</div>
						</div><!-- //BLOG POST -->
						
						
						<!-- BLOG POST -->
						<div class="blog_post margbot50 clearfix" data-animated="fadeInUp">
							<div class="blog_post_img">
								<img src="images/blog/3.jpg" alt="" />
								<a class="zoom" href="blog-post.html" ></a>
							</div>
							<div class="blog_post_descr">
								<div class="blog_post_date">JANUARY 30 | 21:30</div>
								<a class="blog_post_title" href="blog-post.html" >The Fault in Our Stars Trailer Makes Us Feel All The Feelings</a>
								<ul class="blog_post_info">
									<li><a href="javascript:void(0);" >Admin</a></li>
									<li><a href="javascript:void(0);" >Creative</a></li>
									<li><a href="javascript:void(0);" >3 Comments</a></li>
								</ul>
								<hr>
								<div class="blog_post_content">The trailer for 'The Fault in Our Stars', the movie based on John Green's tear-jerky YA novel, is finally out, and it's good.</div>
								<a class="read_more_btn" href="blog-post.html" >Read More</a>
							</div>
						</div><!-- //BLOG POST -->
						
						
						<!-- BLOG POST -->
						<div class="blog_post margbot50 clearfix" data-animated="fadeInUp">
							<div class="blog_post_img">
								<img src="images/blog/4.jpg" alt="" />
								<a class="zoom" href="blog-post.html" ></a>
							</div>
							<div class="blog_post_descr">
								<div class="blog_post_date">JANUARY 30 | 21:30</div>
								<a class="blog_post_title" href="blog-post.html" >The Broad City Girls Almost Make Us Pee Our Pant</a>
								<ul class="blog_post_info">
									<li><a href="javascript:void(0);" >Admin</a></li>
									<li><a href="javascript:void(0);" >Creative</a></li>
									<li><a href="javascript:void(0);" >3 Comments</a></li>
								</ul>
								<hr>
								<div class="blog_post_content">Last week I made a promise to the hilarious creators of the cover-your-eyes-with-one-hand, text-your-best-friend-to-watch-it-with-the-other-hand show, 'Broad City'.</div>
								<a class="read_more_btn" href="blog-post.html" >Read More</a>
							</div>
						</div><!-- //BLOG POST -->
						
						
						<!-- BLOG POST -->
						<div class="blog_post margbot50 clearfix" data-animated="fadeInUp">
							<div class="blog_post_img">
								<img src="images/blog/5.jpg" alt="" />
								<a class="zoom" href="blog-post.html" ></a>
							</div>
							<div class="blog_post_descr">
								<div class="blog_post_date">JANUARY 30 | 21:30</div>
								<a class="blog_post_title" href="blog-post.html" >Why Do We Need to Defend Wendy Davis for Being a Working Mom?</a>
								<ul class="blog_post_info">
									<li><a href="javascript:void(0);" >Admin</a></li>
									<li><a href="javascript:void(0);" >Creative</a></li>
									<li><a href="javascript:void(0);" >3 Comments</a></li>
								</ul>
								<hr>
								<div class="blog_post_content">On Tuesday, the daughters of Texas state senator Wendy Davis defended their mom against charges that she’s been smudging her biography</div>
								<a class="read_more_btn" href="blog-post.html" >Read More</a>
							</div>
						</div><!-- //BLOG POST -->
						
						
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
						
						<div style="font-size:22px;font-color:#fff;padding:13px 10px 12px 30px;">
							<ul>
								<li style="border-top:1px solid #e9e9e9;inline-block;line-height:24px;line-height:24px;padding:13px 10px 12px 30px;"><a href="javascript:void(0);" ><p style="color:gray;">Redes sociales</p></a></li>
								<li style="border-top:1px solid #e9e9e9;inline-block;line-height:24px;line-height:24px;padding:13px 10px 12px 30px;"><a href="javascript:void(0);" ><p style="color:gray;">Publicidad</p></a></li>
								<li style="border-top:1px solid #e9e9e9;inline-block;line-height:24px;line-height:24px;padding:13px 10px 12px 30px;"><a href="javascript:void(0);" ><p style="color:gray;">Cobertura</p></a></li>
								<li style="border-top:1px solid #e9e9e9;inline-block;line-height:24px;line-height:24px;padding:13px 10px 12px 30px;"><a href="javascript:void(0);" ><p style="color:gray;">Medios de pago</p></a></li>
								<li style="border-top:1px solid #e9e9e9;border-bottom:1px solid #e9e9e9;inline-block;line-height:24px;line-height:24px;padding:13px 10px 12px 30px;"><a href="javascript:void(0);" ><p style="color:gray;">Bancos</p></a></li>
							</ul>
						</div><!-- //META WIDGET -->
						<BR><BR>
						
						<!-- POPULAR POSTS WIDGET -->
						<div class="sidepanel widget_popular_posts">
							<h3><b>Popular</b> Posts</h3>
							
							<div class="recent_posts_widget clearfix">
								<div class="post_item_img_widget">
									<img src="images/blog/1.jpg" alt="" />
								</div>
								<div class="post_item_content_widget">
									<a class="title" href="blog.html" >How the Denver Broncos Cheerleaders Get in Shape for the Super Bowl</a>
									<ul class="post_item_inf_widget">
										<li>JANUARY 30  |  21:30</li>
									</ul>
								</div>
							</div>
							<div class="recent_posts_widget clearfix">
								<div class="post_item_img_widget">
									<img src="images/blog/2.jpg" alt="" />
								</div>
								<div class="post_item_content_widget">
									<a class="title" href="blog.html" >Barneys Spring Campaign Stars 17 Transgender Models</a>
									<ul class="post_item_inf_widget">
										<li>JANUARY 25  |  9:30</li>
									</ul>
								</div>
							</div>
							<div class="recent_posts_widget clearfix">
								<div class="post_item_img_widget">
									<img src="images/blog/3.jpg" alt="" />
								</div>
								<div class="post_item_content_widget">
									<a class="title" href="blog.html" >Dominic Cooper: I'm Nothing Like the Real James Bond</a>
									<ul class="post_item_inf_widget">
										<li>JANUARY 21  |  13:30</li>
									</ul>
								</div>
							</div>
						</div><!-- //POPULAR POSTS WIDGET -->
						
						<hr>
						
						<!-- POPULAR TAGS WIDGET -->
						<div class="sidepanel widget_tags">
							<h3><b>Popular</b> Tags</h3>
							<ul>
								<li><a href="javascript:void(0);" >Fashion</a></li>
								<li><a href="javascript:void(0);" >Shop</a></li>
								<li><a href="javascript:void(0);" >Color</a></li>
								<li><a href="javascript:void(0);" >Creative Agency</a></li>
								<li><a href="javascript:void(0);" >Theme</a></li>
								<li><a href="javascript:void(0);" >Dress</a></li>
								<li><a href="javascript:void(0);" >Wordpress</a></li>
							</ul>
						</div><!-- POPULAR TAGS WIDGET -->
						
						<hr>
						
						<!-- TEXT WIDGET -->
						<div class="sidepanel widget_text">
							<h3><b>About</b> Blog</h3>
							<p>I must admit this particular defense set me on edge a little bit, for two reasons. The first is that she’s being held to a completely different standard than male politicians are held to.</p>
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
					<h4><b>Featured</b> posts</h4>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="images/blog/1.jpg" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="blog.html" >As we have developed a unique layout template</a>
							<ul class="post_item_inf_small">
								<li>10 January 2014</li>
							</ul>
						</div>
					</div>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="images/blog/2.jpg" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="blog.html" >How much is to develop a design for the game?</a>
							<ul class="post_item_inf_small">
								<li>14 January 2014</li>
							</ul>
						</div>
					</div>
					<div class="recent_posts_small clearfix">
						<div class="post_item_img_small">
							<img src="images/blog/3.jpg" alt="" />
						</div>
						<div class="post_item_content_small">
							<a class="title" href="blog.html" >How to pump designer</a>
							<ul class="post_item_inf_small">
								<li>21 December 2013</li>
							</ul>
						</div>
					</div>
				</div>
				
				<div class="col-lg-4 col-md-4 col-sm-6 padbot30 foot_about_block">
					<h4><b>About</b> us</h4>
					<p>We value people over profits, quality over quantity, and keeping it real. As such, we deliver an unmatched working relationship with our clients.</p>
					<p>Our team is intentionally small, eclectic, and skilled; with our in-house expertise, we provide sharp and</p>
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
					<h4><b>Contacts</b> Us</h4>
					
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
				
				 <p>Crafted with <i class="fa fa-heart"></i>, <a href="http://designscrazed.org/" >Designscrazed</a></p>
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
</body>
</html>