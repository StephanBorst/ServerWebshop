<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<html>
<link href="<c:url value="/resources/home.css" />" rel="stylesheet"
	type="text/css" />
<head>

<title>Overview Tickets</title>
</head>
<body>

<header>
		<h2> Overview of your orders at Borst Airlines</h2>
		
		</header>
		
		<article>
		<p> Here is an overview of your orders you can inspect and remove them.
		
		<img src="resources\Fleet.jpg">
		
	<ul>
		<c:forEach items="${Bestellingen}" var="Bestelling">
			<li>
				Bestelling ${Bestelling.id}: <a href="<c:url value="/bestelling/${Bestelling.id}" />">Show Details</a>, 
				<a href="<c:url value="/delete/${Bestelling.id}" />">Remove</a>
			</li>
		</c:forEach>
	</ul>
	
	<a class="button" href="http://localhost:8080/webshop" >Back to Home</a>
	</article>
	
</body>
</html>