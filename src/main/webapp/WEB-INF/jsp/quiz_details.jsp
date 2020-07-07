<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Form Quiz</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

 <div class="container">
  <h2>Quiz</h2>

   <div class="form-group">

    <label>Id</label>

    <p>  ${quizDetails.id } </p>   

    <label>Titolo</label>

    
    <p>  ${quizDetails.titolo } </p>

    <label>Tempo</label>

   <p>  ${quizDetails.tempo } </p>   

   <label>Codice Autore</label>

   <p>  ${quizDetails.codice_autore } </p>  
   
   
   <spring:url value="/quiz/list/" var="backURL" />
   <a class="btn btn-primary" href="${backURL }" role="button" > Indietro </a>

   </div>  
 </div>

</body>
</html>