<%-- 
    Document   : question-paper
    Created on : May 13, 2015, 9:19:49 PM
    Author     : Al-Amin
--%>

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
    <%try {

            Database db = new Database();
            Statement stmt = db.connection.createStatement();


    %>
    <body>
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
                                        <%                                            
                                            
                                            int len = request.getParameter("ques_amount").length();
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
                                                       <form method="get" action="question-set-finish.jsp">
                                        <h6 class="label">Question# <%=i%></h6>

                                        <div class="row">
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name=<%=ques%> placeholder="type the question here">
                                            </div>
                                        </div>

                                        <h6 class="label">Options</h6>

                                        <div class="row">
                                            <div style="width: 4px; margin-top: 3px " class="col-sm-1">A.</div>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" name=<%=optionA%> placeholder="OptionA">
                                            </div>
                                            <div style="width: 4px; margin-top: 3px " class="col-sm-1">B.</div>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" name=<%=optionB%> placeholder="OptionB">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div style="width: 4px; margin-top: 3px " class="col-sm-1">C.</div>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" name=<%=optionC%> placeholder="OptionC">
                                            </div>
                                            <div style="width: 4px; margin-top: 3px " class="col-sm-1">D.</div>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" name=<%=optionD%> placeholder="OptionD">
                                                
                                            </div>
                                        </div>
                                        
                                        <h6 class="label">Answer</h6>
                                        
                                        <div class="radio-inline">
                                            <label><input name=<%=ans%> value="A" type="radio">A</label>
                                        </div>

                                        <div class="radio-inline">
                                            <label><input name=<%=ans%> value="B" type="radio">B</label>
                                        </div>

                                        <div class="radio-inline">
                                            <label><input name=<%=ans%> value="C" type="radio">C</label>
                                        </div>

                                        <div class="radio-inline">
                                            <label><input name=<%=ans%> value="D" type="radio">D</label>
                                        </div>
                                        <%}%>
                                    </section>


                                </div>

                                <hr class="mt60">

                                <div class="clearfix">
                                                    
                                                        <input type="hidden" name="ques_amount" value=<%=ques_amount%> >
                                                        <input type="hidden" name="job_id" value=<%=request.getParameter("job_id")%> >
                                                        <button class="btn btn-default btn-large pull-right">Submit</button>
                                                    </form>
							
	                        </div>
                            </div>
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


        <%    } catch (Exception e) {
                out.println("Exception : " + e.getMessage() + "");
            }
        %>
    </body>
</html>