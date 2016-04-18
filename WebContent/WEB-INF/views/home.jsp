
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
<link href="<c:url value="/resources/home.css" />" rel="stylesheet"
	type="text/css" />
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body class="body">
	<header id = head>
		<h2>
			Welcome to Dream Airlines<br> Are You Ready for an Adventure?
		</h2>

	</header>

	<article>
		<p>This company provides safe and luxury travel through Space
		<hr>
		Most popular destinations
		<ol>
			<li>Middle Earth
			<li>Korhal
			<li>Coruscant
		</ol>
		<img src="resources\Spaceship.jpg">
	</article>
	<nav>
		<p>Action List
		<ul>
			<li>
				<form method="get" action="form">
					<button type="submit">Order Ticket</button>
				</form>
			<li><a class="button"
				href="overview">Overview Tickets</a>
		</ul>
	</nav>
	<script>
		$(document).ready(function() {
		
			var counter = 0;
		
		function ccolor(el) {
		
			if($(el).css('color') =='rgb(0, 0, 0)'){
			$(el).css('color', 'green');
			}
			else if($(el).css('color') =='rgb(0, 128, 0)'){
			$(el).css('color', 'red');
			}
			else if($(el).css('color') =='rgb(255, 0, 0)'){
			$(el).css('color', 'blue');
			}
			else if($(el).css('color') =='rgb(0, 0, 255)'){
			$(el).css('color', 'yellow');
			}
			else{$(el).css('color', 'black');}
		}
		
		function makenewcolorfunction(){
				return function() {ccolor(this)};
		}

		$('article').click(makenewcolorfunction());
		$('header').click(makenewcolorfunction());
		$('footer').click(makenewcolorfunction());
		$('nav').click(makenewcolorfunction());
		});
	</script>
	<footer>
		<p>Author: Stephan Borst, Date: April 26th, 2016
	</footer>
</body>
</html>