
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

        <title>JobPortal - Careers</title>

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

                <%@include file="include/header.jsp" %>
                <%
                    try {
                        Database db1 = new Database();
                        Jobs hp = new Jobs();
                        int total = 0;
                        String info = request.getParameter("info"), title = "";
                        int flag = 0;
                        if (info != null) {
                            if (info.startsWith("a")) {
                                flag = 0;
                                title = "Applied Jobs";
                                total = hp.AppliedJobs((String) session.getAttribute("customer_id"));
                            } else {
                                flag = 1;
                                title = "Offered Jobs";
                                total = hp.OfferedJobs((String) session.getAttribute("customer_id"));
                            }
                        }

                %>
                <div class="header-page-title">
                    <div class="container">
                        <h1><%=title%></h1>
                    </div>
                </div>
            </header> <!-- end #header -->

            <div id="page-content" style="min-height: 300px">
                <div class="container">
                    <div class="row">
                        <div>

                            <div class="title-lines">
                                <h3> <%=title%> List</h3>
                            </div>
                            <%if (flag == 0) {%>
                            <%for (int i = 1; i <= total; ++i) {%>
                            <div class="latest-jobs-section white-container">
                                <div class="flexslider clearfix">
                                    <ul class="slides">
                                        <li>
                                            <div class="image">
                                                <img src="img/content/face-2.png" alt="">
                                                <a href="#" class="btn btn-default fa fa-search"></a>
                                                <a href="#" class="btn btn-default fa fa-link"></a>
                                            </div>

                                            <div class="content">
                                                <h6><%= hp.title[i]%></h6>
                                                <span class="location"><%= hp.house[i]%>,<%= hp.street[i]%>,<%= hp.city[i]%>,<%= hp.country[i]%></span>
                                                <span class="location"><%= hp.descrip[i]%></span>
                                            </div>

                                            <h5>Required Skills</h5>
                                            <div class="tab-content">
                                                <h6 class="tab-content"><%= hp.skills[i]%></h6>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div> <!-- end .latest-jobs-section -->
                            <% } %>
                            <%} else {
                                for (int i = 1; i <= total; ++i) {%>
                            <div class="latest-jobs-section white-container">
                                <div class="flexslider clearfix">
                                    <ul class="slides">
                                        <li>
                                            <div class="image">
                                                <img src="img/content/face-2.png" alt="">
                                                <a href="#" class="btn btn-default fa fa-search"></a>
                                                <a href="#" class="btn btn-default fa fa-link"></a>
                                            </div>

                                            <div class="content">
                                                <h6><%= hp.title[i]%></h6>
                                                <span class="location"><%= hp.house[i]%>,<%= hp.street[i]%>,<%= hp.city[i]%>,<%= hp.country[i]%></span>
                                                <span class="location"><%= hp.descrip[i]%></span>
                                            </div>

                                            <h5>Required Skills</h5>
                                            <div class="tab-content">
                                                <h6 class="tab-content"><%= hp.skills[i]%></h6>
                                            </div>
                                        </li>
                                        <li>
                                            <h5>Candidate List</h5>
                                            <%
                                                int n = hp.Applied_List(hp.job_id[i] + "");
                                                for (int j = 1; j <= n; ++j) {%>
                                            <div class="tab-content">
                                                <a href="customer-profile.jsp?profile_id=<%= hp.customer_id[j]%>" class="tab-content"><%= hp.name[j]%></a>
                                                <a href="mailto:" +<%= hp.email[j] %> class="btn btn-default pull-right"><i class="fa fa-envelope-o"></i> Contact Me</a>
                                            </div>
                                            <%}%>
                                            <br>
                                            <form action="search-candidate.jsp" method="post" >
                                                <input type="hidden" value="<%=hp.job_id[i]%>" name="job_id">
                                                <input type="submit" class="btn btn-default" value="Invite Candidates ?">
                                            </form>
                                        </li>
                                    </ul>
                                </div>
                            </div> <!-- end .latest-jobs-section -->
                            <% } %>

                            <%}%>
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
        <script>
            function logout() {
                document.getElementById("login").submit();
            }
        </script>
    </body>
</html>