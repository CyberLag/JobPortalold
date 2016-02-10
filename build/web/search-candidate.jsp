
<%@page import="com.jobportal.connection.Search_Candidate"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.jobportal.connection.Jobs"%>
<%@page import="com.jobportal.connection.Database"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Jobs - Careers</title>

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
                <div class="header-page-title">
                    <div class="container">
                        <h1>Desired Candidate List <small></small></h1>
                    </div>
                </div>
            </header> <!-- end #header -->
            <%
                String j_id = request.getParameter("job_id"), skill = request.getParameter("skill"), invite = request.getParameter("invite");
                int total = 0;
                if (j_id != null && j_id.length() >= 1) {
                    session.setAttribute("job_id", j_id);
                }

                //out.print(request.getParameter("fromlog"));
                try {
                    Database db1 = new Database();
                    Search_Candidate search = new Search_Candidate();
                    if (invite != null) {
                        if (invite.length() > 1) {
                            if (invite.equals("true")) {
                                Jobs jobs = new Jobs();
                                jobs.InviteForJobs(request.getParameter("customer_id"), session.getAttribute("job_id") + "");
            %>
            <div class="col-sm-12 page-content">
                <div class="alert alert-info">
                    <h6>Invitation sent to <%=request.getParameter("customer_name")%> successfully !</h6>
                    <a href="" class="close fa fa-times"></a>
                </div>
            </div>
            <%}
                    }
                }
                if (skill != null) {
                    if (skill.length() >= 1) {
                        total = search.Search(skill, session.getAttribute("job_id") + "");
                    }
                } else {
                    total = search.Search("", session.getAttribute("job_id") + "");
                    skill = "";
                }
            %>
            <div id="page-content">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4 page-sidebar">
                            <aside>
                                <div class="white-container mb0">
                                    <div class="widget sidebar-widget jobs-search-widget">
                                        <h5 class="widget-title">Search</h5>
                                        <form >
                                            <div class="widget-content">
                                                <span>Search by skill</span>
                                                <input type="text"  name="skill" class="form-control mt10" placeholder="Skill">
                                                <br>
                                                <input type="submit" class="btn btn-default" value="Search">
                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </aside>
                        </div> <!-- end .page-sidebar -->

                        <div class="col-sm-8 page-content">
                            <div class="title-lines">
                                <h3 class="mt0">Candidate List</h3>
                                <%                                    for (int i = 1; i <= total; ++i) {
                                %>
                                <div class="jobs-item with-thumb">
                                    <div class="clearfix visible-xs"></div>
                                    <h6 class="title"><a href="#"><%= search.name[i]%></a></h6>
                                    <ul class="top-btns">
                                        <li><a href="#" class="btn btn-gray fa fa-plus toggle"></a></li>
                                    </ul>

                                    <p class="description"><%= Search_Candidate.email[i]%><a href="#" class="read-more"><br>Skills</a></p>

                                    <div class="content">
                                        <div class="row">
                                            <%int l = 0;
                                                for (int jj = 0; jj < search.skills[i].length(); ++jj) {
                                                    String ski = "";
                                                    if (search.skills[i].charAt(jj) == '/') {
                                                        ski = search.skills[i].substring(l, jj);
                                                        l = jj + 1;%>

                                            <div class="col-lg-4 col-md-4 col-sm-6 ">
                                                <div class="progress-circle" data-progress="75">
                                                    <b><%=ski%></b>
                                                </div>
                                            </div>
                                            <% }
                                                }%>
                                            <div class="clearfix">
                                                <form method="post">
                                                    <input class="hidden" name="invite" value="true" >
                                                    <input class="hidden" name="customer_name" value="<%=search.name[i]%>" >
                                                    <input class="hidden" name="customer_id" value="<%=search.customer_id[i]%>" >
                                                    <input class="hidden" name="job_id" value="<%=session.getAttribute("job_id")%>" >
                                                    <%if (search.invited[i] != 1) {%>
                                                    <input  class="btn btn-default pull-left" type="submit" value="Invite Him For This Job" >
                                                    <%} else {%>
                                                    <input  class="btn btn-default pull-left"  value="Invited Already" >
                                                    <a href="mailto:" +<%= search.email[i]%> class="btn btn-default pull-right"><i class="fa fa-envelope-o"></i> Contact Me</a>
                                                    <%}%>
                                                </form>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                                <%}
                                    } catch (Exception e) {
                                    }%>
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