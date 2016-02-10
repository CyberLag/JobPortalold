<%-- 
    Document   : profile
    Created on : May 13, 2015, 4:13:49 AM
    Author     : Al-Amin
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.DataInputStream"%>
<%@page import="oracle.net.aso.p"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.jobportal.connection.Database" %>


<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Candidates Single - Careers</title>

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
                Statement stmt2 = db1.connection.createStatement();
                Statement stmt3 = db1.connection.createStatement();

                ResultSet rs;
                ResultSet rs2;
                if(request.getParameter("customer_id")!=null)
                    session.setAttribute("id",request.getParameter("customer_id"));
                
                String query1 = "select * from customer where customer_id=" + session.getAttribute("id");
                String query2 = "select skill_id from customer_skill where customer_id=" + session.getAttribute("id");
                //out.print(query2);
                rs2 = stmt2.executeQuery(query2);
                //while(rs2.next())
                //{
                //    out.print(rs2.getString("skill_id")+".");
                //}

                rs = stmt.executeQuery(query1);

                rs.next();

//out.print(query3);
                String url = "profile.jsp?customer_id=" + rs.getString("customer_id");
                String img_dir = "img/" + rs.getString("customer_id") + ".jpg";
                Calendar now = Calendar.getInstance();
                int age = now.get(Calendar.YEAR);

                age -= rs.getInt("dob_year");
                //out.print(age);

                String mail_link = "mailto:" + rs.getString("email");
                String website_link = "http://" + rs.getString("customer_website");

        %>


        <div id="main-wrapper">
            <header id="header" class="header-style-1">
                <%@include file="include/header.jsp" %>
                <div class="header-page-title">
                    <div class="container">
                        <h1><%=rs.getString("fullname")%><br><small>Front-end Developer</small></h1>
                    </div>
                </div>
            </header> <!-- end #header -->
        </header> <!-- end #header -->

        <div id="page-content">
            <div class="container">
                <div class="row">
                    <div class="col-sm-4 page-sidebar">
                        <aside>
                            <div class="widget sidebar-widget white-container candidates-single-widget">
                                <div class="widget-content">
                                    <div class="thumb">
                                        <img src=<%=img_dir%> alt="">
                                    </div>

                                    <h5 class="bottom-line">Candidate Details</h5>

                                    <table>
                                        <tbody>
                                            <tr>
                                                <td>Name</td>
                                                <td><%=rs.getString("fullname")%>(<%=rs.getString("surname")%>)</td>
                                            </tr>

                                            <tr>
                                                <td>Age</td>
                                                <td><%=age%></td>
                                            </tr>

                                            <tr>
                                                <td>Location</td>
                                                <td><%=rs.getString("customer_location")%></td>
                                            </tr>

                                            <tr>
                                                <td>Dgree</td>
                                                <td><%=rs.getString("customer_degree")%></td>
                                            </tr>

                                            <tr>
                                                <td>Department</td>
                                                <td><%=rs.getString("customer_department")%></td>
                                            </tr>

                                            <tr>
                                                <td>Phone</td>
                                                <td><%=rs.getString("phone_mobile")%></td>
                                            </tr>

                                            <tr>
                                                <td>Fax</td>
                                                <td><%=rs.getString("phone_fax")%></td>
                                            </tr>

                                            <tr>
                                                <td>E-mail</td>
                                                <td><a href=<%=mail_link%> ><%=rs.getString("email")%></a></td>
                                            </tr>

                                            <tr>
                                                <td>Website</td>
                                                <td><a href=<%=website_link%> target="_blank" ><%=rs.getString("customer_website")%></a></td>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <h5 class="bottom-line">Professional Rating</h5>

                                    <table>
                                        <tbody>
                                            <tr>
                                                <td>Expertise</td>
                                                <td>
                                                    <ul class="stars">
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star-o"></i></li>
                                                        <li><i class="fa fa-star-o"></i></li>
                                                    </ul>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>Knowledge</td>
                                                <td>
                                                    <ul class="stars">
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star-o"></i></li>
                                                    </ul>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>Quality</td>
                                                <td>
                                                    <ul class="stars">
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                    </ul>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>Price</td>
                                                <td>
                                                    <ul class="stars">
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star-o"></i></li>
                                                        <li><i class="fa fa-star-o"></i></li>
                                                        <li><i class="fa fa-star-o"></i></li>
                                                    </ul>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>Services</td>
                                                <td>
                                                    <ul class="stars">
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star"></i></li>
                                                        <li><i class="fa fa-star-o"></i></li>
                                                    </ul>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </aside>
                    </div> <!-- end .page-sidebar -->

                    <div class="col-sm-8 page-content">
                        <div class="clearfix mb30 hidden-xs">
                            <a href="#" class="btn btn-gray pull-left">Back to Listings</a>
                            <div class="pull-right">
                                <a href="#" class="btn btn-gray">Previous</a>
                                <a href="#" class="btn btn-gray">Next</a>
                            </div>
                        </div>

                        <div class="candidates-item candidates-single-item">
                            <h6 class="title"><a href="#"><%=rs.getString("fullname")%></a></h6>
                            <span class="meta"><%=age%> Years Old - <%=rs.getString("customer_location")%></span>

                            <ul class="top-btns">
                                <li><a href="#" class="btn btn-gray fa fa-star"></a></li>
                            </ul>

                            <ul class="social-icons clearfix">
                                <li><a href="#" class="btn btn-gray fa fa-facebook"></a></li>
                                <li><a href="#" class="btn btn-gray fa fa-twitter"></a></li>
                                <li><a href="#" class="btn btn-gray fa fa-google-plus"></a></li>
                                <li><a href="#" class="btn btn-gray fa fa-dribbble"></a></li>
                                <li><a href="#" class="btn btn-gray fa fa-pinterest"></a></li>
                                <li><a href="#" class="btn btn-gray fa fa-linkedin"></a></li>
                            </ul>

                            <p><%=rs.getString("customer_details")%></p>

                            <ul class="list-unstyled">
                                <li><strong>Department:</strong> <%=rs.getString("customer_department")%></li>
                                <li><strong>Degree:</strong> <%=rs.getString("customer_degree")%></li>
                            </ul>

                            <h5>Skills</h5>
                            <%while (rs2.next()) {

                                    ResultSet rs3;
                                    String query3 = "select skill_name from skill where skill_id=" + rs2.getString("skill_id");
                                    //out.print(query3);
                                    rs3 = stmt3.executeQuery(query3);
                                    while (rs3.next()) {
                            %>
                            <div class="progress-bar toggle" data-progress="60">
                                <a href="#" class="progress-bar-toggle"></a>
                                <h6 class="progress-bar-title"><%=rs3.getString("skill_name")%></h6>
                                <div class="progress-bar-inner"><span></span></div>
                                <div class="progress-bar-content">

                                </div>
                            </div>
                            <%}
                                }%>

                            <hr>

                            <div class="clearfix">
                                <a href=<%=mail_link%> class="btn btn-default pull-left"><i class="fa fa-envelope-o"></i> Contact Me</a>

                                <ul class="social-icons pull-right">
                                    <li><span>Share</span></li>
                                    <li><a href="#" class="btn btn-gray fa fa-facebook"></a></li>
                                    <li><a href="#" class="btn btn-gray fa fa-twitter"></a></li>
                                    <li><a href="#" class="btn btn-gray fa fa-google-plus"></a></li>
                                </ul>
                            </div>
                        </div>


                    </div> <!-- end .page-content -->
                </div>
            </div> <!-- end .container -->
        </div> <!-- end #page-content -->

        <%
            } catch (Exception e) {
                out.println("Exception : " + e.getMessage() + "");
            }
        %>

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
