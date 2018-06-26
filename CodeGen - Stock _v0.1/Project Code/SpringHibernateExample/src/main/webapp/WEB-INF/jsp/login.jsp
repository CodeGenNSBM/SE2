<%-- 
    Document   : login
    Created on : May 26, 2018, 9:11:56 PM
    Author     : Ruvin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      <script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript"></script>   
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="<c:url value="/resources/landing/img/logo.png"/>" />
  <title>Stock V0.0.1</title>
  <!-- Bootstrap core CSS-->
      <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="<c:url value="/resources/css/sb-admin.css"/>" rel="stylesheet">
  <script src="<c:url value="/resources/js/js_controllers/UserController.js"/>"></script>
  </head>
    
       <body class="bg-dark">
       
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <label for="exampleInputUser1">User Name</label>
            <input class="form-control" id="uname" type="text"  placeholder="Enter Username">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" id="password" type="password" placeholder="Password">
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember Password</label>
            </div>
          </div>
            <a class="btn btn-primary btn-block" id="login"  >Login</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="sign">Register an Account</a>
          
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
  <!-- Core plugin JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>"></script>



</body>
    
</html>
