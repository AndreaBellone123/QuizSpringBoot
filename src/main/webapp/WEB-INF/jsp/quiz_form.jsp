<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Quiz</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <spring:url value="/quiz/saveQuiz" var="saveURL" />
  <h2>Quiz</h2>
  <form:form modelAttribute="quizForm" method="post" action="${saveURL }" cssClass="form" >
   <form:hidden path="id"/>
   <div class="form-group">
    <label>Titolo</label>
    <form:input path="titolo" cssClass="form-control" id="titolo" />
   </div>
   <div class="form-group">
    <label>Tempo</label>
    <form:input path="tempo" cssClass="form-control" id="tempo" />
   </div>

   <div class="form-group">
    <label>Codice Autore</label>
    <form:input path="codice_autore" cssClass="form-control" id="codice_autore" />
   </div>
   <button type="submit" class="btn btn-primary">Salva</button>
  </form:form>
  
 </div>
</body>
</html>