<%@page import="oracle.net.aso.p"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.jobportal.connection.Database" %>

<%-- 
    Document   : answer-finish
    Created on : May 18, 2015, 10:29:07 PM
    Author     : Al-Amin
--%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Exam Finished</title>

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
        <header id="header" class="header-style-1">
            <%@include file="include/header.jsp" %>
        </header>
        <%
            //out.print(request.getParameter("fromlog"));
            try {

                Database db1 = new Database();
                Statement stmt = db1.connection.createStatement();
                Statement stmt2 = db1.connection.createStatement();
                Statement stmt3 = db1.connection.createStatement();
                ResultSet rs, rs2, rs3;

                //String customer_id=request.getParameter("customer_id");
                String customer_id = (String) session.getAttribute("customer_id");
                String job_id = session.getAttribute("job_id").toString();

                int len = session.getAttribute("ques_amount").toString().length();
                int ques_amount = 0;
                for (int i = 0; i < len; i++) {
                    ques_amount = (ques_amount * 10) + session.getAttribute("ques_amount").toString().charAt(i) - '0';
                }

                //out.print(job_id);
                //out.print(customer_id);
                //out.print(ques_amount);
                String query = "select * from question where job_id=" + job_id;
                rs = stmt.executeQuery(query);

                int marks = 0;
                for (int i = 1; rs.next(); i++) {
                    String Customer_ans = request.getParameter("choice_" + i);
                    if (Customer_ans.substring(0, 1).equals(rs.getString("answer").substring(0, 1))) {
                        marks++;
                    }
                }

                String query2 = "insert into answer (job_id,customer_id,marks) values(" + job_id + "," + customer_id + "," + marks + ")";
                rs2 = stmt2.executeQuery(query2);

                String query3 = "insert into applied_jobs (job_id,customer_id) values(" + job_id + "," + customer_id + ")";
                rs3 = stmt3.executeQuery(query3);

        %>




        <div id="main-wrapper">

            <div id="page-content">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 page-content">
                            <ul class="form-steps four clearfix">


                                <li class="active">Finish</li>

                            </ul>

                            <div class="white-container sign-up-form">
                                <div>


                                    <section>
                                        <div class="alert alert-success">
                                            <h6>Congrats! You applied for this job successfully.</h6>
                                            <a href="#" class="close fa fa-times"></a>
                                        </div>
                                    </section>

                                </div>

                                <hr class="mt60">

                                <div class="clearfix">
                                    <form method="post" action="jobs.jsp">
                                        <input type="hidden" name="skill" value=<%=session.getAttribute("search")%> >
                                        <input type="hidden" name="customer_id" value=<%=customer_id%> >
                                        <button class="btn btn-default btn-large pull-right">Go to back page</button>
                                    </form>

                                </div>


                            </div>
                        </div> <!-- end .page-content -->
                    </div>
                </div> <!-- end .container -->
            </div> <!-- end #page-content -->
            <%    } catch (Exception e) {%>
            <div style="min-height: 300px;">
                <%out.println("Exception : " + e.getMessage() + "");%>
            </div>
            <%}
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


