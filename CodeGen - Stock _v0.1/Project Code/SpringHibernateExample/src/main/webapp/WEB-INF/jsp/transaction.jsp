<%-- 
    Document   : viewstocks
    Created on : Jun 15, 2018, 10:24:43 AM
    Author     : Vishwa
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript"></script>   
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
  <script src="<c:url value="/resources/js/js_controllers/TransactionController.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/resources/js/js_controllers/BankDetailController.js"/>" type="text/javascript"></script>
    </head>
<c:choose>
        <c:when test="${not empty user}">
    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <a class="navbar-brand" href="dashboard">Stock Market Simulation Game</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="" data-original-title="Dashboard">
                                <a class="nav-link" href="dashboard">
                                    <i class="fa fa-fw fa-dashboard"></i>
                                    <span class="nav-link-text">Dashboard</span>
                                </a>
                            </li>
                            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="" data-original-title="Charts">
                                <a class="nav-link" href="broker">
                                    
                                    <i class="fa fa-fw fa-sitemap"></i>
                                    <span class="nav-link-text">Stocks</span>
                                </a>
                            </li>
                            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="" data-original-title="Tables">
                                <a class="nav-link" href="analyzers">
                                    
                                    <i class="fa fa-fw fa-area-chart"></i>
                                    <span class="nav-link-text">Analyzer</span>
                                </a>
                            </li>
                            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="" data-original-title="Components">
                                <a class="nav-link" href="transaction">
                                    <i class="fa fa-fw fa-table"></i>
                                    <span class="nav-link-text">Bank</span>
                                </a>
                            </li>
                </ul>
                <ul class="navbar-nav sidenav-toggler">
                    <li class="nav-item">
                        <a class="nav-link text-center" id="sidenavToggler">
                            <i class="fa fa-fw fa-angle-left"></i>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown">
                                <span class="label label-success"></span>
                                <p><font color="white" size="4px">Timer&nbsp;&nbsp;:&nbsp;&nbsp;</font></p>
                            </li>
                            <li class="nav-item dropdown">
                                 <%-- <span class="label label-success" id="timer"></span>--%>
                                <p ><font color="white" size="4px" id="timer">- - : - -</font></p>
                            </li>
                            <li class="nav-item dropdown">
                                <span class="label label-success"></span>
                                <p><font color="white" size="4px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></p>
                            </li>
                    
                    <li class="nav-item">
                        <form class="form-inline my-2 my-lg-0 mr-lg-2">
                            <div class="input-group">
                                <input class="form-control" type="text" placeholder="Search for...">
                                <span class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                        </form>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
                            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="content-wrapper">
            <div class="container-fluid">
                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="#">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item active">Transaction</li>
                </ol>
                <!-- Example DataTables Card-->
                <div class="form-group">
                      <div class="col-md-8">
                          <button id="refresh" class="btn btn-primary">Refresh</button>                          
                      </div>
                  </div>
                <div class="form-group">
                    <label class="col-md-6 control-label" for="selectbasic">Account Available Balance</label>
                    <div class="col-md-6">
                        <input id="txtAvailableBalance" name="textinput" type="text" placeholder="" class="form-control input-md" disabled="">                          
                    </div>
                    <label class="col-md-6 control-label" for="selectbasic">Total Deposit Balance</label>
                    <div class="col-md-6">
                        <input id="txtDepositBalance" name="textinput" type="text" placeholder="" class="form-control input-md" disabled="">                          
                    </div>
                    <label class="col-md-6 control-label" for="selectbasic">Total Withdraw Balance</label>
                    <div class="col-md-6">
                        <input id="txtWithdrawBalance" name="textinput" type="text" placeholder="" class="form-control input-md" disabled="">                          
                    </div>
                </div>
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i> Account Transaction</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Sender or Receiver</th>                  
                                        <th>Type</th>
                                        <th>Date</th>
                                        <th>Amount</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Sender or Receiver</th>                  
                                        <th>Type</th>
                                        <th>Date</th>
                                        <th>Amount</th>
                                        <th>Status</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                </div>
            </div>
            <!-- /.container-fluid-->
            <!-- /.content-wrapper-->
            <footer class="sticky-footer">
                <div class="container">
                    <div class="text-center">
                        <small>Copyright © CodeGen 2018</small>
                    </div>
                </div>
            </footer>
            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fa fa-angle-up"></i>
            </a>
            <!-- Logout Modal-->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                            </div>
                            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                            <div class="modal-footer">
                                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                <a class="btn btn-primary" href="signout" id="signoff">Logout</a>
                            </div>
                        </div>
                    </div>
                </div>
            
            <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
    <!-- Core plugin JavaScript-->
    <script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>"></script>
    <!-- Custom scripts for all pages-->
    <script src="<c:url value="/resources/js/sb-admin.min.js"/>"></script>
        </div>
    </body>
 </c:when>    
    <c:otherwise>
        
        <div id="content">
           <jsp:include page="${request.contextPath}/log"></jsp:include>
        </div>
           
        

    </c:otherwise>
</c:choose>
</html>

