<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Login Form</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <h2>Crea Utente</h2>
  <form:form modelAttribute="loginForm" method="post" cssClass="form" >
   <div class="form-group">
    <label>Username</label>
    <form:input path="username" cssClass="form-control" id="username" />
   </div>
   <div class="form-group">
    <label>Password</label>
    <form:input type="password" path="password" cssClass="form-control" id="password" />
   </div>
  
   <button class = "btn btn-primary"  type="submit" formaction="/user/accedi/">Accedi</button>
   <button class = "btn btn-primary"  type="submit" formaction="/user/registrati/">Registrati</button>

  </form:form>
 </div>
</body>
</html>