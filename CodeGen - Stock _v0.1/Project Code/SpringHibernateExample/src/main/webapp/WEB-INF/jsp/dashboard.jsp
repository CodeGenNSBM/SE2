<%-- 
    Document   : dashboard
    Created on : Jun 9, 2018, 7:24:48 PM
    Author     : Ruvin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="<c:url value="/resources/landing/img/logo.png"/>" />
        <title>Stock V0.0.1</title>
        <!-- Bootstrap core CSS-->
        <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/buttons/btn-buy-sell.css"/>" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="<c:url value="/resources/css/sb-admin.css"/>" rel="stylesheet">
        
        
        <script type="text/javascript">
      /**
       * Delay for a number of milliseconds
       */
      function popup1() {
        var myWindow1 = window.open("", "MsgWindow1", "width=500, height=300");
        myWindow1.document.write("<head><title>Sectors</title></head><body background=<c:url value="/resources/img/blue.jpg"/>><font color=white><h1><center><i>Sectors</i></center></h1>\n\
\n\
<br/><ul><li style=font-size:20px>There are 4 sectros available in here.</li><li style=font-size:20px>Around 25 stocks are available under these sectors.</li><li style=font-size:20px>Players can handle stocks easily with their sectors.</li></ul></font></body>");
      }
      
      function popup2() {
        var myWindow2 = window.open("", "MsgWindow2", "width=500, height=300");
        myWindow2.document.write("<head><title>Stocks</title></head><body background=<c:url value="/resources/img/yellow.jpg"/>><font color=white><h1><center><i>Stocks</i></center></h1>\n\
\n\
\n\
<br/><ul><li style=font-size:20px>There are around 25 stocks in here.</li><li style=font-size:20px>Those stocks are available under the sectors.</li><li style=font-size:20px>Players can buy new stocks and sell their own stocks through gameplay.</li></ul></font></body>");
      }
      
      function popup3() {
        var myWindow3 = window.open("", "MsgWindow3", "width=500, height=300");
        myWindow3.document.write("<head><title>Bidders</title></head><body background=<c:url value="/resources/img/green.jpg"/>><font color=white><h1><center><i>Bidders</i></center></h1>\n\
\n\
\n\
<br/><ul><li style=font-size:20px>This is a multiplayer game.</li><li style=font-size:20px>4 players can play this game on one gameplay.</li><li style=font-size:20px>Each player should play several rounds to win here.</li></ul></font></body>");
      }
      
      function popup4() {
        var myWindow4 = window.open("", "MsgWindow4", "width=500, height=300");
        myWindow4.document.write("<head><title>Analyzer</title></head><body background=<c:url value="/resources/img/red.jpg"/>><font color=white><h1><center><i>Analyzer</i></center></h1>\n\
\n\
\n\
<br/><ul><li style=font-size:20px>Player can analyze all game analysis data in single page.</li><li style=font-size:20px>Multiple analizers as palyer analyser and game analyzer.</ul></font></body>");
      }
    </script>
  
        <script src="<c:url value="/resources/js/js_controllers/DashboardController.js"/>"></script>
       
        
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
                                <a class="nav-link" data-toggle="modal" data-target="#exampleModal" >
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
                                <a href="dashboard">Dashboard</a>
                            </li>
                            <li class="breadcrumb-item active">Game Proceed</li>
                            <li></li><br>
                            <li><span class="label label-success" id="timer"></span></li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-sm-6 mb-3">
                                <div class="card text-white bg-primary o-hidden h-100">
                                    <div class="card-body">
                                        <div class="card-body-icon">
                                            <i class="fa fa-fw fa-comments"></i>
                                        </div>
                                        <div class="mr-5">4 Sectors Available</div>
                                    </div>
                                    <a class="card-footer text-white clearfix small z-1" onclick="popup1()" href="#">
                                        
                                        <span class="float-left">View Details</span>
                                        <span class="float-right">
                                            <i class="fa fa-angle-right"></i>
                                        </span>
                                            
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-3 col-sm-6 mb-3">
                                <div class="card text-white bg-warning o-hidden h-100">
                                    <div class="card-body">
                                        <div class="card-body-icon">
                                            <i class="fa fa-fw fa-list"></i>
                                        </div>
                                        <div class="mr-5">Around 25 Stocks!</div>
                                    </div>
                                    <a class="card-footer text-white clearfix small z-1" onclick="popup2()" href="#">
                                        <span class="float-left">View Details</span>
                                        <span class="float-right">
                                            <i class="fa fa-angle-right"></i>
                                        </span>
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-3 col-sm-6 mb-3">
                                <div class="card text-white bg-success o-hidden h-100">
                                    <div class="card-body">
                                        <div class="card-body-icon">
                                            <i class="fa fa-fw fa-shopping-cart"></i>
                                        </div>
                                        <div class="mr-5">4 Online Bidders!</div>
                                    </div>
                                    <a class="card-footer text-white clearfix small z-1" onclick="popup3()" href="#">
                                        <span class="float-left">View Details</span>
                                        <span class="float-right">
                                            <i class="fa fa-angle-right"></i>
                                        </span>
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-3 col-sm-6 mb-3">
                                <div class="card text-white bg-danger o-hidden h-100">
                                    <div class="card-body">
                                        <div class="card-body-icon">
                                            <i class="fa fa-fw fa-support"></i>
                                        </div>
                                        <div class="mr-5">Great Analyzer!</div>
                                    </div>
                                    <a class="card-footer text-white clearfix small z-1" onclick="popup4()" href="#">
                                        <span class="float-left">View Details</span>
                                        <span class="float-right">
                                            <i class="fa fa-angle-right"></i>
                                        </span>
                                    </a>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-12">
                                <h1>Money Gain...</h1>
                                <p>Press Join for start Stock V0.0.1 Money Maker </p>
                            </div>
                        </div>

                        <form class="form-horizontal" id="gameStarter">
<fieldset>

<!-- Form Name #5c73f1 -->


<!-- Multiple Radios <h6><b>Playet Type :</b></h6>-->
<br/>

<h5 for="radios">Player Type :</h5>

<div class="row">
        <div class="col-lg-1">
          
        </div>
    
    <div class="col-lg-2">
          <div class="radio">
    <label for="radios-0">
      <input name="radios" id="radios-0" value="1" type="radio">
      Self Player
    </label>
	</div>
          
        </div>
    <div class="col-lg-2">
          <div class="radio">
    <label for="radios-1">
      <input name="radios" id="radios-1" value="2" type="radio">
      Machine Player
    </label>
	</div>
          
        </div>
    
    <div class="col-lg-6">
          <div id="hidder">
  <label class="col-md-6 control-label" for="singlebutton"></label>
  <div class="col-md-6">
      <a  name="singlebutton" class="btn btn-primary" id="start" >Join Game</a>
  </div>
    </div>
        </div>
   
    
</div>





<div class="row">
        <div class="col-lg-5">
          
          
          
        </div>
    <div class="col-lg-4">
          
          <!-- Button -->


          
        </div>
</div>

</fieldset>
</form>
      
      <hr>
      <h3 style="color:black; text-align:center;">Play Game</h3>
      <br/>
      <div class="row">
          <div class="col-lg-3">
          
        </div>
        <div class="col-lg-4">
           
          <a  class="buttonbuy" id="play1" >Buy Stocks</a>
        </div>
          <div class="col-lg-4">
          
          <a  class="buttonsell" id="play2" >Sell Stocks</a>
          
        </div>
      </div>
      <br/>

                        
                        <!--
                        
                        <div class="row">
                            <div id = "chartContainer" style = "height: 100px; width: 50%;" />
                        </div>

                    </div>
                        -->

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
                <!-- Bootstrap core JavaScript-->
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
