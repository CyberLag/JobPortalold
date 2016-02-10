<%@page import="javax.websocket.Session"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.DataInputStream"%>
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
        <%try {

            Database db1 = new Database();
            Statement stmt = db1.connection.createStatement();
            Statement stmt2 = db1.connection.createStatement();
            Statement stmt3 = db1.connection.createStatement();
            
            
            ResultSet rs,rs2,rs3;
            String customer_id=session.getAttribute("customer_id").toString();
            String job_id=request.getParameter("job_id");
            session.setAttribute("job_id",job_id);
            
            //out.print(customer_id);
           // out.print(job_id);
            
            String query2="select count(*) from question where job_id="+job_id;
            rs2=stmt2.executeQuery(query2);
            rs2.next(); 
            
            session.setAttribute("ques_amount", rs2.getInt("count(*)"));
            
            if(rs2.getInt("count(*)")==0){
              response.sendRedirect("http://localhost:8084/JobPortal/answer-finish.jsp");
            }
            
            
            
            String query="select * from question where job_id="+job_id;
            rs=stmt.executeQuery(query);
            
            String query3="select title from job where job_id="+job_id;
            rs3=stmt3.executeQuery(query3);
            rs3.next();
            
            
            
    %> 
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
                        <form method="post" action="answer-finish.jsp">
                        <div class="col-sm-12 page-content">
                            <h3>Answer the following questions to apply for <%=rs3.getString("title")%>:</h3>
                            <%for (int i = 1; rs.next() ; i++) {%>
                            <div class="jobs-item with-thumb">
                                <h6 class="title"><%=i%>. <%=rs.getString("question")%></h6>
                                <label><input type="radio" name="choice_<%=i%>" value="A"><%=rs.getString("option_A")%></label><br>
                                <label><input type="radio" name="choice_<%=i%>" value="B"><%=rs.getString("option_B")%></label><br>
                                <label><input type="radio" name="choice_<%=i%>" value="C"><%=rs.getString("option_C")%></label><br>
                                <label><input type="radio" name="choice_<%=i%>" value="D"><%=rs.getString("option_D")%></label><br>
                            </div>
                            <%}%>
                            <button class="btn btn-default btn-large pull-right">Submit</button>
                             
                        </div> <!-- end .page-content -->
                        </form>
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
      <%    } catch (Exception e) {
                out.println("Exception : " + e.getMessage() + "");
            }
        %>
</html>

