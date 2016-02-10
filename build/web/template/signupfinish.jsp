
<%@page import="oracle.net.aso.p"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.jobportal.connection.Database" %>




<%-- 
    Document   : signupfinish
    Created on : May 4, 2015, 1:20:02 AM
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
                //out.print("LLL");

                Database db1 = new Database();
                Statement stmt = db1.connection.createStatement();
                ResultSet rs;
                    //stmt.executeQuery("insert into skill values(1,'C++')");

                    //out.print(request.getParameter("flag"));
                //if(request.getParameter("flag").startsWith("true"))
                //request.setAttribute("flag", "false");
                //else
                //{
                //response.sendRedirect("http://localhost:8084/JobPortal/signup1.jsp");
                //}
                //out.print("customer_id");
                String customer_id = request.getParameter("customer_id");
                String customer_location = request.getParameter("customer_location");
                String customer_department = request.getParameter("customer_department");
                String customer_degree = request.getParameter("customer_degree");
                String customer_university = request.getParameter("customer_university");
                String customer_university_location = request.getParameter("customer_university_location");
                String customer_details = request.getParameter("customer_details");

                String query1 = "update customer set customer_location='" + customer_location + "', customer_department='" + customer_department + "', customer_degree='" + customer_degree + "', customer_university='" + customer_university + "', customer_university_location='" + customer_university_location + "', customer_details='" + customer_details + "' where customer_id=" + customer_id;
                stmt.executeQuery(query1);

                String S = request.getParameter("skill_name").toString();
                String[] arr = new String[110];
                arr = S.split(",");
                String query2 = "", query3 = "", skill_id = "";
                for (int i = 0; i < arr.length; i++) {
                    arr[i].trim();
                    arr[i].toUpperCase();

                    query3 = "select count(*) as cnt from skill where skill_name like '" + arr[i] + "'";
                    rs = stmt.executeQuery(query3);
                    rs.next();
                    //out.print(rs.getString("cnt"));
                    if (!rs.getString("cnt").startsWith("0")) {
                        //   out.print("PPP");
                        query3 = "select skill_id from skill where skill_name like '" + arr[i] + "'";
                        rs = stmt.executeQuery(query3);
                        rs.next();
                        skill_id = rs.getString("skill_id");
                    } else {
                        query3 = "select max(skill_id)+1 as mx from skill";
                        rs = stmt.executeQuery(query3);
                        rs.next();
                        skill_id = rs.getString("mx");
                        query3 = "insert into skill values(" + skill_id + ",'" + arr[i] + "')";
                        stmt.executeQuery(query3);
                    }

                    query2 = "insert into customer_skill values(" + customer_id + ",'" + skill_id + "')";
                    stmt.executeQuery(query2);
                    //out.println("-"+arr[i]+"-");
                }

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
                                <li class="completed">Step 1</li>
                                <li class="completed">Step 2</li>
                                <li class="active">Finish</li>

                            </ul>

                            <div class="white-container sign-up-form">
                                <div>


                                    <section>
                                        <div class="alert alert-success">
                                            <h6>Congrats! Your account is ready.</h6>
                                            <a href="#" class="close fa fa-times"></a>
                                        </div>
                                    </section>

                                </div>

                                <hr class="mt60">

                                <div class="clearfix">
                                    <form method="post" action="profile.jsp">
                                        <input type="hidden" name="customer_id" value=<%=customer_id%> >
                                        <button class="btn btn-default btn-large pull-right">View My Profile</button>
                                    </form>

                                </div>
                            </div>
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


<%
    } catch (Exception e) {
        out.println("Exception : " + e.getMessage() + "");
    }
%>