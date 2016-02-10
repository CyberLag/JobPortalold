
<%@page import="com.jobportal.connection.Database"%>
<%@page import="com.jobportal.connection.Login"%>
<%@page import="com.jobportal.connection.HomePage"%>
<%@page import="com.jobportal.connection.Jobs"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Homepage - Careers</title>

        <!-- Stylesheets -->
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic|Roboto+Condensed:400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/flexslider.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">
    </head>
    <body>
        <div id="main-wrapper">

            <header id="header" class="header-style-1">

                <%@include file="include/header.jsp" %>
                <%
                    HomePage hp = new HomePage();
                    int ljobs = hp.LatestJobs();
                    int pjobs = hp.PopularJobs();
                %>
                <div class="header-banner">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="header-banner-box register">
                                    <div class="counter-container">
                                        <ul class="counter clearfix">
                                            <li class="zero">0</li>
                                            <li>3</li>
                                            <li>5</li>
                                            <li>1</li>
                                            <li>0</li>
                                            <li>9</li>
                                        </ul>

                                        <div><span>Jobs</span></div>
                                    </div>

                                    <a href="jobs.jsp" class="btn btn-default">Apply For a Job</a>
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="header-banner-box post-job">
                                    <img src="img/verified.png" alt="">

                                    <a href="postjob.jsp" class="btn btn-red">Post a Job</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> <!-- end .header-banner -->
            </header> <!-- end #header -->

            <div id="page-content">
                <div class="container">
                    <div class="row">
                        <div>

                            <div class="title-lines">
                                <h3>Latest Jobs</h3>
                            </div>
                            <%for (int i = 1; i <= ljobs; ++i) {%>
                            <div class="latest-jobs-section white-container">
                                <div class="flexslider clearfix">
                                    <ul class="slides">
                                        <li>
                                            <div class="image">
                                                <img src="img/content/face-2.png" alt="">
                                                <a href="#" class="btn btn-default fa fa-search"></a>
                                                <a href="#" class="btn btn-default fa fa-link"></a>
                                            </div>

                                            <div class="content">
                                                <h6><%= hp.title[i]%></h6>
                                                <span class="location"><%= hp.house[i]%>,<%= hp.street[i]%>,<%= hp.city[i]%>,<%= hp.country[i]%></span>
                                                <p><%= hp.descrip[i]%><a  class="read-more"><br>Read More</a></p>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div> <!-- end .latest-jobs-section -->
                            <%}%>
                        </div> <!-- end .page-content -->

                        <div>
                            <div class="title-lines">
                                <h3>Popular Jobs</h3>
                            </div>
                            <%for (int i = ljobs+1; i <= pjobs; ++i) {%>
                            <div class="latest-jobs-section white-container">
                                <div class="flexslider clearfix">
                                    <ul class="slides">
                                        <li>
                                            <div class="image">
                                                <img src="img/content/face-2.png" alt="">
                                                <a href="#" class="btn btn-default fa fa-search"></a>
                                                <a href="#" class="btn btn-default fa fa-link"></a>
                                            </div>

                                            <div class="content">
                                                <h6><%= hp.title[i]%></h6>
                                                <span class="location"><%= hp.house[i]%>,<%= hp.street[i]%>,<%= hp.city[i]%>,<%= hp.country[i]%></span>
                                                <p><%= hp.descrip[i]%><a  class="read-more"><br>Read More</a></p>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div> <!-- end .latest-jobs-section -->
                            <%}%>
                        </div> <!-- end .page-content -->
                        
                    </div>
                </div> <!-- end .container -->
            </div> <!-- end #page-content -->
            <%@include file="include/footer.jsp" %>
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
        <script>
            function logout() {
                document.getElementById("login").submit();
            }
        </script>
    </body>
</html>