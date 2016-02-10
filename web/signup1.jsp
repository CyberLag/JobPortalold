<%@page import="oracle.net.aso.p"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.jobportal.connection.Database" %>




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

        <%
            //out.print(request.getParameter("fromlog"));
            try {

                Database db1 = new Database();
                Statement stmt = db1.connection.createStatement();
       
        %>




        <div id="main-wrapper">

            <header id="header" class="header-style-1">
                <%@include file="include/header.jsp" %>
                <div class="header-page-title">
                    <div class="container">
                        <h1>Sign Up</h1>
                    </div>
                </div>
            </header> <!-- end #header -->

            <div id="page-content">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 page-content">
                            <ul class="form-steps four clearfix">
                                <li class="active">Step 1</li>
                                <li>Step 2</li>
                                <li>Finish</li>

                            </ul>
                            <form action="signup2.jsp" method="POST"> 
                                <div class="white-container sign-up-form">
                                    <div>
                                        <h2>1. Fill in your profile</h2>



                                        <section>
                                            <h6 class="bottom-line">Personal Info:</h6>

                                            <h6 class="label">Name</h6>

                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="fullname" placeholder="Name" required>
                                                </div>

                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="surname" placeholder="Surname" required>
                                                </div>
                                            </div>

                                            <h6 class="label">Date of Birth</h6>

                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <input type="text" class="day-input"  name="dob_day" placeholder="DD">	
                                                    <input type="text" class="month-input" name="dob_month" placeholder="MM">
                                                    <input type="text" class="year-input" name="dob_year" placeholder="YYYY">
                                                </div>
                                            </div>

                                            <h6 class="label">Phone</h6>

                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="phone_mobile" placeholder="Mobile">
                                                </div>

                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="phone_work" placeholder="Work">
                                                </div>

                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="phone_fax" placeholder="Fax">
                                                </div>
                                            </div>




                                            <h6 class="label">Address</h6>

                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" name="address_house" placeholder="House">
                                                </div>

                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control" name="address_street" placeholder="Street">
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <select name="address_country">
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
                                                    <input type="text" class="form-control" name="address_state" placeholder="State">
                                                </div>


                                                <div class="col-sm-3">
                                                    <input type="text" class="form-control" name="address_city" placeholder="City">
                                                </div>

                                                <div class="col-sm-3">
                                                    <input type="text" class="form-control" name="address_zipcode" placeholder="ZIP Code">
                                                </div>
                                            </div>

                                            <h6 class="label">Others</h6>

                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <select name="gender">
                                                        <option value="">Gender</option>
                                                        <option value="Male">Male</option>
                                                        <option value="Female">Female</option>
                                                        <option value="None">None</option>
                                                    </select>
                                                </div>

                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="nationality" placeholder="Nationality">
                                                </div>


                                            </div>

                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <input type="email" class="form-control" name="email" placeholder="E-mail" required="">
                                                </div>

                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="customer_website" placeholder="Website">
                                                </div>
                                            </div>

                                        </section>


                                        <section>
                                            <h6 class="bottom-line">Set Password:</h6>

                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <input type="password" name="password1" class="form-control" placeholder="Password" required>
                                                </div>

                                                <div class="col-sm-4">
                                                    <input type="password" class="form-control" name="password2" placeholder="Repeat Password"  required>
                                                </div>
                                            </div>
                                        </section>



                                    </div>
                                    <input type="hidden" name="flag" value="true">

                                    <hr class="mt60">

                                    <div class="clearfix">
                                        <button type="submit" class="btn btn-default btn-large pull-right">Continue to Step 2</button>
                                    </div>



                                </div>
                            </form>
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

    </body>
</html>


<%    } catch (Exception e) {
        out.println("Exception : " + e.getMessage() + "");
    }
%>