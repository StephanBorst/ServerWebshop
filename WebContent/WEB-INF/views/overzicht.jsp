<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!doctype html>
<html>
<head>

<title>Overzicht Bestellingen</title>
</head>
<body>
	<ul>
		<c:forEach items="${Bestelling}" var="rit">
			<li>
				Bestelling ${Bestelling.id}: <a href="<c:url value="/bestelling/${Bestelling.id}" />"></a>, 
				<a href="<c:url value="/delete/${Bestelling.id}" />">verwijder</a>
			</li>
		</c:forEach>
	</ul>
	
	
</body>
</html>