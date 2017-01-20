<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="mystyles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Presidents</title>
</head>
<body>
	<c:forEach var="president" items="${presidents}">
				<c:out value="${president.name}"></c:out>
				<br>
				<c:out value="${president.termNumber}"></c:out>
				<br>
				<c:out value="${president.years}"></c:out>
				<br>
				<c:out value="${president.party}"></c:out>
				<br>
				<c:out value="${president.funFact}"></c:out>
				<br>
				<c:out value="${president.image}"></c:out>
				<br>
				<div id="presPic"><img src="${president.image}"/></div>
				<br>
			</c:forEach>
			
<input type="button" value="next">
<input type="button" value="previous">
</body>
</html>