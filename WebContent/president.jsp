<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyles.css">
<link href='http://fonts.googleapis.com/css?family=Cinzel'
	rel='stylesheet' type='text/css'>
<script src="https://use.fontawesome.com/4bc3d12307.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Presidents</title>
</head>
<body>
	<%--     <c:forEach var="president" items="${presidents}" varStatus="status">
--%>
	<div id="contain">
		<div id="presNum">
			<c:out value="${president.termNumber}"></c:out>
			.
		</div>
		<div id="presName">
			<c:out value="${president.name}"></c:out>
		</div>
	</div>
	<br class="clear">
	<div id="contain2">
		<span class="word">Years in Office:</span>
		<c:out value="${president.years}"></c:out>
		<br> <span class="word">Party:</span>
		<c:out value="${president.party}"></c:out>
		<br> <span class="word">Fun Fact:</span>
		<c:out value="${president.funFact}"></c:out>
		<br>
	</div>
	<div id="presPic">
		<img src="${president.image}" />
	</div>
	<br>
	<%--             </c:forEach>
--%>
	<div id="shift">
		<form action="president.do">
			<!--         <input type ="submit" name="submit" value="next"/> -->

			<c:if test="${president.termNumber != 1}">
				<button class="button" name="submit" value="${prevNumber}">
					<i class="fa fa-chevron-circle-left fa-3x"></i>
				</button>
			</c:if>
			<c:if test="${president.termNumber != 45}">
				<button class="button" name="submit" value="${nextNumber}">
					<i class="fa fa-chevron-circle-right fa-3x"></i>
				</button>
			</c:if>
		</form>
	</div>
	<div id="term">
		<form>
			Go to term number:<input type="text" name="termNumber"> <input
				type="submit" value="Search">
			</form>
			<div id="filterForm">
				<form action="filter.do">
					Filter By Party <select name="filter">
						<option value="select">Select...</option>
						<option value="Whig">Whig</option>
						<option value="Republican">Republican</option>
						<option value="Democrat">Democrat</option>
					</select> <input type="submit" value="submit">
				</form>
			</div>
	</div>
	<!-- <input type="button" name="submit" value="next">
<input type="button" name="submit" value="previous"> -->

</body>
</html>