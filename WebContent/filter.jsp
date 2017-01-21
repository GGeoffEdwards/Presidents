<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyles2.css">
<link href='http://fonts.googleapis.com/css?family=Cinzel'
	rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Filter Presidents</title>
</head>
<body>
	<a href="presidents.do">Home</a>
	<c:forEach items="${filterPresident}" var="pres"  >
	<ul>
	<div id="picName"><li><img src="${pres.image}"/></li>
	<li>${pres.name}</li></div>
	</ul>
	</c:forEach>
</body>
</html>