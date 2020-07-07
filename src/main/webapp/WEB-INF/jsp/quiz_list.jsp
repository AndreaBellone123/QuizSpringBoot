<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Lista Quiz </title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
  <div class="container">

  <h2>  Id Utente : ${sessionUser.id }  
   Username : ${sessionUser.username } 
  Password : ${sessionUser.password }  ||  Lista Quiz</h2>
  <table class="table table-striped">
   <thead>
    <th scope="row">#ID</th>
    <th scope="row">Titolo</th>
    <th scope="row">Tempo</th>
    <th scope="row">Codice Autore</th>
    <th scope="row">Modifica</th>
    <th scope="row">Elimina</th>
    <th scope="row"> Mostra Quiz </th>
    <th scope="row"> Mostra Domande </th>
    <th scope="row"> Inizia Quiz </th>



   </thead>
   <tbody>
    <c:forEach items="${quizList }" var="quiz" >
     <tr>
      <td>${quiz.id }</td>
      <td>${quiz.titolo }</td>
      <td>${quiz.tempo }</td>
      <td>${quiz.codice_autore }</td>
      <td>
       <spring:url value="/quiz/updateQuiz/${quiz.id }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button" >Modifica</a>
      </td>
      <td>
       <spring:url value="/quiz/deleteQuiz/${quiz.id }" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button" >Elimina</a>
      </td>
      <td>
        <spring:url value="/quiz/detQuiz/${quiz.id }" var="detURL" />
        <a class="btn btn-primary" href="${detURL }" role="button" >Mostra Dettagli</a>
      </td>

      <td>
        <spring:url value="/quiz/dettQuiz/${quiz.id }" var="dettURL" />
        <a class="btn btn-primary" href="${dettURL }" role="button" >Mostra Domande</a>
      </td>

      <td>
        <spring:url value="/quiz/startQuiz/${quiz.id }" var="startURL" />
        <a class="btn btn-primary" href="${startURL }" role="button" >Inizia Quiz</a>
      </td>

     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/quiz/addQuiz/" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button" >Aggiungi un quiz</a>

 </div>
</body>
</html>