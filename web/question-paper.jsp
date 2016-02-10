<%-- 
    Document   : question-paper
    Created on : May 13, 2015, 9:19:49 PM
    Author     : Al-Amin
--%>


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
        <header id="header" class="header-style-1">
            <%@include file="include/header.jsp" %>
        </header>
        <%try {

                Database db1 = new Database();
                Statement stmt = db1.connection.createStatement();
                Statement stmt2 = db1.connection.createStatement();
                Statement stmt3 = db1.connection.createStatement();

                ResultSet rs, rs2, rs3;
                String customer_id = session.getAttribute("customer_id").toString();
                Calendar now = Calendar.getInstance();

                String query2 = "select max(job_id)+1 as mx from job";
                rs2 = stmt2.executeQuery(query2);
                rs2.next();
                String job_id = rs2.getString("mx");
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                String posting_date = now.get(Calendar.YEAR) + "-" + now.get(Calendar.MONTH) + "-" + now.get(Calendar.DATE);
                String validity = request.getParameter("year") + "-" + request.getParameter("month") + "-" + request.getParameter("day");
                String place_house = request.getParameter("place_house");
                String place_street = request.getParameter("place_street");
                String place_city = request.getParameter("place_city");
                String place_country = request.getParameter("place_country");
                String place_state = request.getParameter("place_state");
                String place_zipcode = request.getParameter("place_zipcode");
                String skill_name = request.getParameter("skill_name");
                String is_public = request.getParameter("is_public");
                String job_type = request.getParameter("job_type");
                String working_hours = request.getParameter("working_hours");
                String experience_needed = request.getParameter("experience_needed");
                if (experience_needed.startsWith("null")) {
                    experience_needed = "0";
                }
                if (experience_needed.length() == 0) {
                    experience_needed = "0";
                }

                String query = "insert into job (job_id,title,description,posting_date,validity,place_house,place_street,place_city,place_country,place_state,place_zipcode,is_public,job_type,experience_needed,working_hours) values (" + job_id + ",'" + title + "','" + description + "','" + posting_date + "','" + validity + "','" + place_house + "','" + place_street + "','" + place_city + "','" + place_country + "','" + place_state + "','" + place_zipcode + "'," + is_public + "," + job_type + "," + experience_needed + "," + working_hours + ")";
                //out.print(query);
                stmt.executeQuery(query);

                String S = request.getParameter("skill_name").toString();
                String[] arr = new String[110];
                arr = S.split(",");
                String query3 = "", skill_id = "";
                for (int i = 0; i < arr.length; i++) {
                    arr[i].trim();
                    arr[i].toUpperCase();

                    query3 = "select count(*) as cnt from skill where skill_name like '" + arr[i] + "'";
                    rs3 = stmt.executeQuery(query3);
                    rs3.next();
                    //out.print(rs.getString("cnt"));
                    if (!rs3.getString("cnt").startsWith("0")) {
                        //   out.print("PPP");
                        query3 = "select skill_id from skill where skill_name like '" + arr[i] + "'";
                        rs3 = stmt3.executeQuery(query3);
                        rs3.next();
                        skill_id = rs3.getString("skill_id");
                    } else {
                        query3 = "select max(skill_id)+1 as mx from skill";
                        rs3 = stmt3.executeQuery(query3);
                        rs3.next();
                        skill_id = rs3.getString("mx");
                        query3 = "insert into skill values(" + skill_id + ",'" + arr[i] + "')";
                        stmt.executeQuery(query3);
                    }

                    query3 = "insert into job_skill values(" + job_id + ",'" + skill_id + "')";
                    stmt3.executeQuery(query3);
                    //out.println("-"+arr[i]+"-");
                }

                query3 = "insert into posted_jobs values(" + customer_id + ",'" + job_id + "')";
                stmt3.executeQuery(query3);

                String tmpp = "http://localhost:8084/JobPortal/question-set-finish.jsp?job_id=" + job_id + "&ques_amount=0";

                if (request.getParameter("ques_amount") == null) {
                    response.sendRedirect(tmpp);
                }
                if (request.getParameter("ques_amount").startsWith("0")) {
                    response.sendRedirect(tmpp);
                }


        %>
        <div id="main-wrapper">
            <div id="page-content">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 page-content">
                            <ul class="form-steps four clearfix">

                                <li class="active">Questions</li>

                            </ul>

                            <div class="white-container sign-up-form">
                                <div>
                                    <h2>Fill up the fields</h2>

                                    <section>
                                        <%                                            int len = request.getParameter("ques_amount").length();
                                            int ques_amount = 0;
                                            for (int i = 0; i < len; i++) {
                                                ques_amount = (ques_amount * 10) + request.getParameter("ques_amount").charAt(i) - '0';
                                            }

                                            for (int i = 1; i <= ques_amount; i++) {

                                                String ans = "ans" + i;
                                                String ques = "ques" + i;
                                                String optionA = "optionA" + i;
                                                String optionB = "optionB" + i;
                                                String optionC = "optionC" + i;
                                                String optionD = "optionD" + i;

                                                //out.print(ques);

                                        %>
                                        <form method="post" action="question-set-finish.jsp">
                                            <h6 class="label">Question# <%=i%></h6>

                                            <div class="row">
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" required name=<%=ques%> placeholder=" type the question here">
                                                </div>
                                            </div>

                                            <h6 class="label">Options</h6>

                                            <div class="row">
                                                <div style="width: 4px; margin-top: 3px " class="col-sm-1">A.</div>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name=<%=optionA%> placeholder="OptionA" required>
                                                </div>
                                                <div style="width: 4px; margin-top: 3px " class="col-sm-1">B.</div>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name=<%=optionB%> placeholder="OptionB" required>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div style="width: 4px; margin-top: 3px " class="col-sm-1">C.</div>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name=<%=optionC%> placeholder="OptionC" required>
                                                </div>
                                                <div style="width: 4px; margin-top: 3px " class="col-sm-1">D.</div>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name=<%=optionD%> placeholder="OptionD" required>

                                                </div>
                                            </div>

                                            <h6 class="label">Answer</h6>

                                            <div class="radio-inline">
                                                <label><input name=<%=ans%> value="A" type="radio" required>A</label>
                                            </div>

                                            <div class="radio-inline">
                                                <label><input name=<%=ans%> value="B" type="radio" required>B</label>
                                            </div>

                                            <div class="radio-inline">
                                                <label><input name=<%=ans%> value="C" type="radio" required>C</label>
                                            </div>

                                            <div class="radio-inline">
                                                <label><input name=<%=ans%> value="D" type="radio" required>D</label>
                                            </div>
                                            <%}%>
                                    </section>


                                </div>

                                <hr class="mt60">

                                <div class="clearfix">
                                    <input type="hidden" name="customer_id" value=<%=customer_id%> >
                                    <input type="hidden" name="ques_amount" value=<%=ques_amount%> >
                                    <input type="hidden" name="job_id" value=<%=job_id%> >
                                    <button class="btn btn-default btn-large pull-right">Submit</button>
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