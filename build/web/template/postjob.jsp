

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
                        <h1>Post a Job</h1>
                    </div>
                </div>
            </header> <!-- end #header -->

            <div id="page-content">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 page-content">
                            <h2>1. Fill in your job profile</h2>


                            <form action="question-paper.jsp" method="POST"> 

                                <div class="white-container sign-up-form">
                                    <div>
                                        <section>
                                            <h6 class="bottom-line">Make Your Job:</h6>

                                            <div class="radio-inline">
                                                <label><input type="radio" name="is_public">Public</label>
                                            </div>

                                            <div class="radio-inline">
                                                <label><input type="radio" name="is_public">Private</label>
                                            </div>
                                        </section>

                                        <section>
                                            <h6 class="bottom-line">Job Info:</h6>

                                            <h6 class="label">Job Title</h6>

                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="title" placeholder="Name" required>
                                                </div>
                                            </div>

                                            <h6 class="label">Job Description</h6>

                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <textarea name="description" rows="10" cols="20" required></textarea>
                                                </div>
                                            </div>

                                            <h6 class="label">Office</h6>

                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" name="place_house" placeholder="House" required>
                                                </div>

                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" name="place_street" placeholder="Street" required>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <select name="place_country">
                                                        <option value="">Country</option>
                                                        <option value="Bangladesh">Bangladesh</option>
                                                        <option value="Argentina">Argentina</option>
                                                        <option value="Brazil">Brazil</option>
                                                        <option value="Canada">Canada</option>
                                                        <option value="Denmark">Denmark</option>
                                                        <option value="England">England</option>
                                                    </select>
                                                </div>

                                                <div class="col-sm-3">
                                                    <input type="text" class="form-control" name="place_state" placeholder="State" required>
                                                </div>


                                                <div class="col-sm-3">
                                                    <input type="text" class="form-control" name="place_city" placeholder="City" required>
                                                </div>

                                                <div class="col-sm-3">
                                                    <input type="text" class="form-control" name="place_zipcode" placeholder="ZIP Code" required>
                                                </div>
                                            </div>

                                            <h6 class="label">Validity</h6>

                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <input type="number" min="1" max="31" class="form-control" name="day" placeholder="Day" required>
                                                </div>

                                                <div class="col-sm-3">
                                                    <input type="number"  min="1" max="12" class="form-control" name="month" placeholder="Month" required>
                                                </div>

                                                <div class="row">
                                                    <div class="col-sm-3">
                                                        <input type="number"  min="1" class="form-control" name="year" placeholder="Year" required>
                                                    </div>
                                                </div>



                                            </div>
                                            <h6 class="label">Skill Required</h6>

                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="skill_name" placeholder="EX: C++,..  seperated by comma">
                                                </div>
                                            </div>

                                            <h6 class="label">How many questions you want to set?</h6>

                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <input type="number" class="form-control" name="ques_amount" placeholder="Question Amount">
                                                </div>
                                            </div>

                                        </section>

                                    </div>
                                    <input type="hidden" name="flag" value="true">

                                    <hr class="mt60">

                                    <div class="clearfix">
                                        <button type="submit" class="btn btn-default btn-large pull-right">Next</button>
                                    </div>



                                </div>
                            </form>
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

