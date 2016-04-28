<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<link href="<c:url value="/resources/home.css" />" rel="stylesheet"
	type="text/css" />
<head>

<title>Overview Tickets</title>
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	function CustomConfirm() {
		this.render = function(id) {
			this.id = id;
			var x;
			var winW = window.innerWidth;
			var winH = window.innerHeight;
			var dialogoverlay = document.getElementById('dialogoverlay');
			var dialogbox = document.getElementById('dialogbox');
			dialogoverlay.style.display = "block";
			dialogoverlay.style.height = winH + "px";
			dialogbox.style.left = (winW / 2) - (550 * .5) + "px";
			dialogbox.style.top = "100px";
			dialogbox.style.display = "block";
			
		}
		this.no = function() {
			document.getElementById('dialogbox').style.display = "none";
			document.getElementById('dialogoverlay').style.display = "none";
		}
		this.yes = function() {
			window.location.href = 'delete/' + this.id;
			document.getElementById('dialogbox').style.display = "none";
			document.getElementById('dialogoverlay').style.display = "none";
		}
	}

	var Confirm = new CustomConfirm();
</script>
	<script>
		$(document).ready(function() {

			var counter = 0;

			function bcolor(el) {

				if ($(el).css('color') == 'rgb(0, 0, 0)') {
					$(el).css('color', 'green');
				} else if ($(el).css('color') == 'rgb(0, 128, 0)') {
					$(el).css('color', 'red');
				} else if ($(el).css('color') == 'rgb(255, 0, 0)') {
					$(el).css('color', 'blue');
				} else if ($(el).css('color') == 'rgb(0, 0, 255)') {
					$(el).css('color', 'yellow');
				} else {
					$(el).css('color', 'black');
				}
			}

			function makenewcolorfunction() {
				return function() {
					bcolor(this)
				};
			}

			$('#head').click(makenewcolorfunction());
			$('#Overview').click(makenewcolorfunction());

		});
	</script>
</head>
<body class="body">
	<div id="dialogoverlay"></div>
	<div id="dialogbox">
		<div>
			<div id="dialogboxhead">Confirm that action</div>
			<div id="dialogboxbody">You sure you wanna delete order?</div>
			<div id="dialogboxfoot"><button onclick = "Confirm.yes()">Yes</button> <button onclick = "Confirm.no()">No</button></div>
		</div>
	</div>
	<header id="head">
		<h2>Overview of your orders at Borst Airlines</h2>

	</header>

	<article id="Overview">
		<p>
			Here is an overview of your orders you can inspect and remove them. <img
				id="fleet" src="resources\Fleet.jpg">
		<ul>
			
			<c:forEach items="${Bestellingen}" var="Bestelling">
				<li>Bestelling ${Bestelling.id}: <a
					href="<c:url value="/bestelling/${Bestelling.id}" />">Show Details</a>, 
					
					<button onclick="Confirm.render(${Bestelling.id})">Delete</button>
			
				</li>
			</c:forEach>
		</ul>
		
		<a class="button" id="left" href="../webshop">Back to Home</a> <a
			class="button" id="right" href="../webshop/payment">Confirm
			Payment</a>
	</article>
	<p id="demo"></p>


</body>
</html>