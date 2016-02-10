
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
            try 
            {
                   // out.print("LLL");

                Database db = new Database();
                Statement stmt = db.connection.createStatement();
                Statement stmt2 = db.connection.createStatement();
                ResultSet rs;
                
                String query2="delete from question where job_id="+request.getParameter("job_id");
                stmt2.executeQuery(query2);

                int len = request.getParameter("ques_amount").length();
                int ques_amount = 0;
                for (int i = 0; i < len; i++) {
                    ques_amount = (ques_amount * 10) + request.getParameter("ques_amount").charAt(i) - '0';
                }
                //out.print(ques_amount);
                for(int i=1;i<=ques_amount;i++)
                {
                    
                    String job_id=request.getParameter("job_id");
                    String question=request.getParameter("ques"+i);
                    String optionA=request.getParameter("optionA"+i);
                    String optionB=request.getParameter("optionB"+i);
                    String optionC=request.getParameter("optionC"+i);
                    String optionD=request.getParameter("optionD"+i);
                    String ans=request.getParameter("ans"+i);
                    
                    
                    
                    String query="insert into question (job_id,question,option_A,option_B,option_C,option_D,answer) values("+job_id+",'"+question+"','"+optionA+"','"+optionB+"','"+optionC+"','"+optionD+"','"+ans+"')";
                    
                    //out.println(query);
                    
                    stmt.executeQuery(query);
                }

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
                                            <h6>Question Paper Successfully Set!</h6>
                                            <a href="#" class="close fa fa-times"></a>
                                        </div>
                                    </section>

                                </div>

                                <hr class="mt60">

                                <div class="clearfix">
                                    <form method="post" action="profile.jsp">
                                        <button class="btn btn-default btn-large pull-right">Go to My Profile</button>
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

    </body>
</html>


<%    } 
            catch (Exception e) 
        {
       out.println("Exception : " + e.getMessage() + "");
    }
%>