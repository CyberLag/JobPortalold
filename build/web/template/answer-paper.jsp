

<%-- 
    Document   : signup1
    Created on : Apr 30, 2015, 8:19:33 PM
    Author     : Al-Amin
--%>



<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Sign Up - Careers</title>

        <!-- Stylesheets -->
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic|Roboto+Condensed:400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/flexslider.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">

        <!--[if IE 9]>
                <script src="js/media.match.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <div id="main-wrapper">

            <header id="header" class="header-style-1">
                <%@include file="include/header.jsp" %>
                <div class="header-nav-bar">
                    <div id="mobile-menu-container" class="container">
                        <div class="login-register"></div>
                        <div class="menu"></div>
                    </div>
                </div> <!-- end .header-nav-bar -->

                <div class="header-page-title">
                    <div class="container">
                        <h1>Apply For This Job</h1>
                    </div>
                </div>
            </header> <!-- end #header -->

            <div id="page-content">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 page-content">
                            <h3>Answer the following questions to apply for this job:</h3>
                            <%for (int i = 1; i <= 4; ++i) {%>
                            <div class="jobs-item with-thumb">
                                <h6 class="title"><%=i%>. How many giants in clash of clan?</h6>
                                <label><input type="radio" name="choice_<%=i%>">5</label><br>
                                <label><input type="radio" name="choice_<%=i%>">6</label><br>
                                <label><input type="radio" name="choice_<%=i%>">7</label><br>
                                <label><input type="radio" name="choice_<%=i%>">8</label><br>
                            </div>
                            <%}%>
                        </div> <!-- end .page-content -->
                    </div>
                </div> <!-- end .container -->
            </div> <!-- end #page-content -->

        </div> <!-- end #main-wrapper -->

        <!-- Scripts -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
        <script src="http://maps.google.com/maps/api/js?sensor=false&libraries=geometry&v=3.7"></script>
        <script src="js/maplace.min.js"></script>
        <script src="js/jquery.ba-outside-events.min.js"></script>
        <script src="js/jquery.responsive-tabs.js"></script>
        <script src="js/jquery.flexslider-min.js"></script>
        <script src="js/jquery.fitvids.js"></script>
        <script src="js/jquery-ui-1.10.4.custom.min.js"></script>
        <script src="js/jquery.inview.min.js"></script>
        <script src="js/script.js"></script>

    </body>
</html>

