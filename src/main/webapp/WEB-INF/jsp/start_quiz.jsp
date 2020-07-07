<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz: ${quiz.id }</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Quiz: ${quiz.titolo } - Utente: ${utente.username}</h2>

		<c:if test="${not empty param.index}">
			<c:set var="i" value="${param.index}" />
		</c:if>
		<c:if test="${empty param.index}">
			<c:set var="i" value="${0}" />
		</c:if>
		<c:if test="${param.index < 0}">
			<c:set var="i" value="${numDomande - 1}" />
		</c:if>
		<c:if test="${param.index >= numDomande}">
			<c:set var="i" value="${0}" />
		</c:if>

		<br> <br>
		<h3>${questionList[i].testo }</h3>

		<table class="table table-striped">
			<c:set var="rispostaList"
				value="${mappaRisposte[questionList[i].testo]}" />
			<c:forEach items="${rispostaList }" var="risposta">
				<tr>
					<td><label for="${risposta.testo}">${risposta.testo}</label> <input
						type="radio" id="${risposta.testo}" name="risposta"
						value="${risposta.testo}"></td>
				</tr>
			</c:forEach>
		</table>
		<spring:url value="/quiz/startQuiz/${quiz.id}" var="startURL" />
		<form:form modelAttribute="startForm" method="get"
			action="${startURL }" cssClass="form" style="float:left;">
			<input type="hidden" name="index" value="${i-1}" />
			<button type="submit" class="btn btn-primary">Indietro</button>
		</form:form>
		<form:form modelAttribute="startForm" method="get"
			action="${startURL }" cssClass="form">
			<input type="hidden" name="index" value="${i+1}" />
			<button type="submit" class="btn btn-primary"
				style="margin-left: 10px;">Avanti</button>
		</form:form>
		<br style="clear: both;">
		<spring:url value="/quiz/list/" var="showURL" />
		<a class="btn btn-primary" href="${showURL }" role="button">Termina</a>
	</div>
</body>
</html>