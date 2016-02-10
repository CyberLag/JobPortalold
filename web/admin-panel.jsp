
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
                <div class="header-page-title">
                    <div class="container">
                        <h1>Admin Panel</h1>
                    </div>
                </div>
            </header> <!-- end #header -->


            <div id="page-content">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 page-content">
                            <ul class="form-steps four clearfix">
                                <li class="active">Set A Quetion Paper</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div id="page-content">
                <div class="container">
                    <div class="row">
                        <%
                            try {

                                if (request.getParameter("submit") != null) {
                                    String status = request.getParameter("submit") + "";
                                    if (status.endsWith("yes") && session.getAttribute("ques_set").equals("0")) {
                                        session.setAttribute("ques_set", "1");
                                        Database db1 = new Database();
                                        Statement stmt = db1.connection.createStatement();
                                        Statement stmt2 = db1.connection.createStatement();
                                        ResultSet rs;

                                        String query2 = "select max(ques_id) as max from admin_question";
                                        rs = stmt2.executeQuery(query2);
                                        int ques_id = 1;
                                        if (rs.next()) {
                                            ques_id = rs.getInt("max") + 1;
                                        }

                                        int len = request.getParameter("ques_amount").length();
                                        int ques_amount = 0;
                                        for (int i = 0; i < len; i++) {
                                            ques_amount = (ques_amount * 10) + request.getParameter("ques_amount").charAt(i) - '0';
                                        }
                                        //out.print(ques_amount);
                                        for (int i = 1; i <= ques_amount; i++) {
                                            String question = request.getParameter("ques" + i);
                                            String optionA = request.getParameter("optionA" + i);
                                            String optionB = request.getParameter("optionB" + i);
                                            String optionC = request.getParameter("optionC" + i);
                                            String optionD = request.getParameter("optionD" + i);
                                            String ans = request.getParameter("ans" + i);

                                            String query = "insert into admin_question (ques_id,question,option_A,option_B,option_C,option_D,answer) values(" + ques_id + ",'" + question + "','" + optionA + "','" + optionB + "','" + optionC + "','" + optionD + "','" + ans + "')";

                                            //out.println(query);
                                            stmt.executeQuery(query);
                                        }%>

                        <div class="col-sm-12 page-content">
                            <div class="alert alert-info">
                                <h6>Success !!! you created a question set.</h6>
                                <a href="#" class="close fa fa-times"></a>
                            </div>
                        </div>
                        <% } else {%>
                        <div class="col-sm-12 page-content">
                            <div class="alert alert-info">
                                <h6>you created a question set already</h6>
                            </div>
                        </div>
                        <% } %>
                        <div class="col-sm-12 page-content">
                            <b><a href="admin-panel.jsp" class="alert-info"> click here to create a new question set</a></b>
                        </div>
                        <% } else if (request.getParameter("ques_amount") != null) {
                            String amount = request.getParameter("ques_amount") + "";
                            if (amount.length() >= 1) {%>

                        <form method="post">
                            <input type="hidden" name="submit" value="yes">
                            <% int total = Integer.parseInt(amount);
                                for (int i = 1; i <= total; i++) {

                                    String ans = "ans" + i;
                                    String ques = "ques" + i;
                                    String optionA = "optionA" + i;
                                    String optionB = "optionB" + i;
                                    String optionC = "optionC" + i;
                                    String optionD = "optionD" + i;

                                                            //out.print(ques);

                            %>
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
                            <% }%>
                            <button class="btn btn-default btn-large pull-right">Submit</button>
                        </form>
                        <% }
                        } else {
                            session.setAttribute("ques_set", "0"); %>
                        <form>
                            <div class="widget-content">
                                <h5>
                                    <span>How many questions?</span><br><br>
                                    <input type="number"  name="ques_amount" min="1" max="1000" placeholder="Question Amount" required="">
                                    <br><br>
                                    <input type="submit" class="btn btn-default" value="submit">
                                </h5>
                            </div>
                        </form>
                    </div>

                    <% }
                        } catch (Exception e) {
                            response.sendRedirect("http://localhost:8084/JobPortal/homepage.jsp");
                        }
                    %>

                </div>
            </div>

            <div style="min-height: 300px;">
            </div>
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