<%-- 
    Document   : landing
    Created on : Jun 18, 2018, 10:29:58 AM
    Author     : Vishwa
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <script src="<c:url value="/resources/js/jquery.min.js"/>" type="text/javascript"></script>   
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="shortcut icon" href="<c:url value="/resources/landing/img/logo.png"/>" />
    <title>Stock Market Simulation Game v0.1</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/landing/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="<c:url value="/resources/landing/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/landing/css/landing1.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/landing/css/landing2.css"/>" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="<c:url value="/resources/landing/vendor/magnific-popup/magnific-popup.css"/>" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/landing/css/freelancer.min.css"/>" rel="stylesheet">

  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">Stock Market Simulation Game</a>
        <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
               <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="log">Login</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#portfolio">Help</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#about">About</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#contact">Credits</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Header -->
    <header class="masthead bg-primary text-white text-center">
      <div class="container">
          <img class="img-fluid mb-5 d-block mx-auto" src="<c:url value="/resources/landing/img/profile.png"/>" alt="">
        
       
        <a class="btn btn-xl btn-outline-light" href="log">Play Now</a>
                
        <hr class="star-light">
        <h2 class="font-weight-light mb-0">v0.1</h2>
      </div>
    </header>

    <!-- Portfolio Grid Section -->
    <section class="portfolio" id="portfolio">
      <div class="container">
        <h2 class="text-center text-uppercase text-secondary mb-0">Help</h2>
        <hr class="star-dark mb-5">
        <div class="row">
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-1">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
                <img class="img-fluid" src="<c:url value="/resources/landing/img/portfolio/login.jpg"/>" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-2">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
                <img class="img-fluid" src="<c:url value="/resources/landing/img/portfolio/home.jpg"/>" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-3">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
                <img class="img-fluid" src="<c:url value="/resources/landing/img/portfolio/buy.jpg"/>" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-4">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
                <img class="img-fluid" src="<c:url value="/resources/landing/img/portfolio/sell.jpg"/>" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-5">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
                <img class="img-fluid" src="<c:url value="/resources/landing/img/portfolio/analyser.jpg"/>" alt="">
            </a>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-6">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
                <img class="img-fluid" src="<c:url value="/resources/landing/img/portfolio/bank.jpg"/>" alt="">
            </a>
          </div>
        </div>
      </div>
    </section>

    <!-- About Section -->
    <section class="bg-primary text-white mb-0" id="about">
      <div class="container">
        <h2 class="text-center text-uppercase text-white">About</h2>
        <hr class="star-light mb-5">
        <div class="row">
          <div class="col-lg-4 ml-auto">
            <p class="lead">Stock market is a place where shares of pubic listed companies/stocks are traded.</p>
            <p class="lead">The primary market is where companies/stocks float shares to the general public in an initial public offering (IPO) to raise capital.</p>
          </div>
          <div class="col-lg-4 mr-auto">
            <p class="lead">A stock exchange facilitates brokers to trade company stocks and it is the meeting place of the stock buyers and sellers.</p>
            
            <p class="lead">This is a multiplayer online simulation of the stock market that engages players to play with exchanging stock rates.</p>
          </div>
        </div>
        
      </div>
    </section>

    <!-- Contact Section -->
    <section id="contact">
      <div class="container">
        <h2 class="text-center text-uppercase text-secondary mb-0">Credits</h2>
        <hr class="star-dark mb-5">
        <div class="row">
          <div class="col-lg-8 mx-auto">
            <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
            <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
            <h4><center>Group Name&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;CodeGen</center></h4>
            <br/>
            <div class="row">
                <div class="col-lg-1"></div>
        
                <div class="col-lg-8">
                    <h5>K A Ruvin Sawmith</h5>
                    <h5>W Sandun Thilanka</h5>
                    <h5>Kahanda Gamage Vishwa Madusanka</h5>
                    <h5>M Dinupama Thathsarani De Zoysa</h5>
                    <h5>Hewage Ayesh Ruwantha</h5>
                    <h5>H H N Gebriel</h5>
                    
                </div>
        
                <div class="col-lg-3">
                    <h5>16211327</h5>
                    <h5>16211101</h5>
                    <h5>16211145</h5>
                    <h5>16211322</h5>
                    <h5>16211324</h5>
                    <h5>16211208</h5>
        
          
                </div>
        <div class="col-lg-1">
        </div>
      </div>
            <br/>
            <img class="img-fluid mb-5 d-block mx-auto" src="<c:url value="/resources/landing/img/logo.png"/>" alt="">
          </div>
        </div>
      </div>
    </section>

    <!-- Footer -->
    <footer class="footer text-center">
      <div class="container">
        <div class="row">
          <div class="col-md-4 mb-5 mb-lg-0">
            
          </div>
          <div class="col-md-4 mb-5 mb-lg-0">
            <h4 class="text-uppercase mb-4">Share Us</h4>
            <ul class="list-inline mb-0">
              <li class="list-inline-item">
                <a class="btn btn-outline-light btn-social text-center rounded-circle" target="_blank" href="https://www.facebook.com/">
                  <i class="fa fa-fw fa-facebook"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a class="btn btn-outline-light btn-social text-center rounded-circle" target="_blank" href="https://plus.google.com">
                  <i class="fa fa-fw fa-google-plus"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a class="btn btn-outline-light btn-social text-center rounded-circle" target="_blank" href="https://twitter.com/?lang=en">
                  <i class="fa fa-fw fa-twitter"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a class="btn btn-outline-light btn-social text-center rounded-circle" target="_blank" href="https://lk.linkedin.com/">
                  <i class="fa fa-fw fa-linkedin"></i>
                </a>
              </li>
              
            </ul>
          </div>
          <div class="col-md-4">
            
          </div>
        </div>
      </div>
    </footer>

    <div class="copyright py-4 text-center text-white">
      <div class="container">
        <small>Copyright &copy; CodeGen 2018</small>
      </div>
    </div>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-to-top d-lg-none position-fixed ">
      <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
        <i class="fa fa-chevron-up"></i>
      </a>
    </div>

    <!-- Portfolio Modals -->

    <!-- Portfolio Modal 1 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-1">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Registration & Login</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="<c:url value="/resources/landing/img/portfolio/login_1.jpg"/>" alt="">
              <p class="mb-5">Register with a new account and log into the game with registered data.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Portfolio Modal 2 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-2">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Home</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="<c:url value="/resources/landing/img/portfolio/home_1.jpg"/>" alt="">
              <p class="mb-5" align="left">1) Select your playing type & join the game.<br/><br/>2) Start to play the game with buy new stocks or sell your stocks.</p>
              
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Portfolio Modal 3 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-3">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Buy Stocks</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="<c:url value="/resources/landing/img/portfolio/buy_1.jpg"/>" alt="">
              <p class="mb-5">Select suitable Stocks and Sectors and the amount of stocks for buying.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Portfolio Modal 4 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-4">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Sell Stocks</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="<c:url value="/resources/landing/img/portfolio/sell_1.jpg"/>" alt="">
              <p class="mb-5">Select your purchased Stocks and the selling amount of stocks for selling.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Portfolio Modal 5 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-5">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Analyzer</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="<c:url value="/resources/landing/img/portfolio/analyser_1.jpg"/>" alt="">
              <p class="mb-5">View your analysis data and current game analysis data to get help for your gaming.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Portfolio Modal 6 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-6">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2 class="text-secondary text-uppercase mb-0">Bank</h2>
              <hr class="star-dark mb-5">
              <img class="img-fluid mb-5" src="<c:url value="/resources/landing/img/portfolio/bank_1.jpg"/>" alt="">
              <p class="mb-5">View your current bank account details and your previous bank transactions.</p>
              <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                Close</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="<c:url value="/resources/landing/vendor/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/landing/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

    <!-- Plugin JavaScript -->
    <script src="<c:url value="/resources/landing/vendor/jquery-easing/jquery.easing.min.js"/>"></script>
    <script src="<c:url value="/resources/landing/vendor/magnific-popup/jquery.magnific-popup.min.js"/>"></script>

    <!-- Contact Form JavaScript -->
    <script src="<c:url value="/resources/landing/js/jqBootstrapValidation.js"/>"></script>
    <script src="<c:url value="/resources/landing/js/contact_me.js"/>"></script>

    <!-- Custom scripts for this template -->
    <script src="<c:url value="/resources/landing/js/freelancer.min.js"/>"></script>

  </body>

</html>

