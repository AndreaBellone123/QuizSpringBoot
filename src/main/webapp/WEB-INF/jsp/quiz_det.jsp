<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Domande</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
        rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
   
        <div class="container">
                <table>
                        <thead>
                                <th scope="row">#ID</th>
                                <th scope="row">Testo</th>
                        </thead>
                        <tbody>
                                <c:forEach items="${questionList }" var="question">
                                        <tr>
                                                <td>${question.id }</td>
                                                <td>${question.testo }</td>
                                        </tr>

                                        <td>
                                            <spring:url value="/quiz/deleteDomanda/${question.id }" var="deleteURL" />
                                            <a class="btn btn-primary" href="${deleteURL }" role="button" >Elimina</a>
                                           </td>
                                           
                                             <td>
                                            <spring:url value="/quiz/editDomanda/${question.id }" var="updateURL" />
                                            <a class="btn btn-primary" href="${updateURL }" role="button" >Modifica</a>
                                           </td>

                                           <td>
                                                <spring:url value="/quiz/showRisposte/${question.id }" var="showURL" />
                                                <a class="btn btn-primary" href="${showURL }" role="button" >Risposte</a>
                                               </td>

                                </c:forEach>

                              
                                                        </tbody>
                </table>

                <spring:url value="/quiz/list/" var="backURL" />
                <a class="btn btn-primary" href="${backURL }" role="button">
                        Indietro </a>

                        <spring:url value="/quiz/addDomanda/${quizList.id}" var="addURL" />
                        <a class="btn btn-primary" href="${addURL }" role="button">
                                Aggiungi Domanda </a>

                        

        </div>

</body>
</html>