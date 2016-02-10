
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
                        <h1>Available Jobs <small></small></h1>
                    </div>
                </div>
            </header> <!-- end #header -->
            <%
                String apply = request.getParameter("apply");
                Jobs jobs = new Jobs();
                if (apply != null) {
                    if (true) {
                        if (jobs.ApplyForJobs("" + session.getAttribute("customer_id"), apply)) {
            %>
            <div class="col-sm-12 page-content">
                <div class="alert alert-info">
                    <h6>You have applied for this job successfully</h6>
                    <a href="#" class="close fa fa-times"></a>
                </div>
            </div>
            <% } else if (session.getAttribute("customer_id") == "0") {%>
            <div class="col-sm-12 page-content">
                <div class="alert alert-error">
                    <h6>Please login or register first </h6>
                    <a href="#" class="close fa fa-times"></a>
                </div>
            </div>
            <%} else {%>
            <div class="col-sm-12 page-content">
                <div class="alert alert-error">
                    <h6>Sorry.You applied for this job before.</h6>
                    <a href="#" class="close fa fa-times"></a>
                </div>
            </div>
            <% }
                    }
                }%>
            <div id="page-content">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4 page-sidebar">
                            <aside>
                                <div class="white-container mb0">
                                    <div class="widget sidebar-widget jobs-search-widget">
                                        <h5 class="widget-title">Search</h5>
                                        <form action="jobs.jsp">
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
                                <h3 class="mt0">Available Jobs</h3>
                            </div>
                            <%
                                int total = 0;
                                int day = 0, month = 0, year = 0;
                                String sub, tag = request.getParameter("skill");
                                String m[] = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                                if (tag != null) {
                                    tag = tag.replaceAll("\\s+", "");
                                    if (tag.length() >= 1) {
                                        total = jobs.SearchJobs(tag, Integer.parseInt("" + session.getAttribute("customer_id")));
                                        session.setAttribute("search", tag);
                                    } else {
                                        total = jobs.SearchJobs("", Integer.parseInt("" + session.getAttribute("customer_id")));
                                    }

                                } else {
                                    total = jobs.SearchJobs("", Integer.parseInt("" + session.getAttribute("customer_id")));
                                }
                            %>
                            <%for (int i = 1; i <= total; ++i) {
                                    int j = 0, l = 0;
                                    for (int ii = 0; ii < jobs.pdate[i].length(); ++ii) {
                                        if (jobs.pdate[i].charAt(ii) == '-') {
                                            ++j;
                                            if (j == 1) {
                                                year = Integer.parseInt(jobs.pdate[i].substring(l, ii));
                                                l = ii + 1;
                                            } else if (j == 2) {
                                                month = Integer.parseInt(jobs.pdate[i].substring(l, ii));
                                                l = ii + 1;
                                            }
                                        } else if (ii == jobs.pdate[i].length() - 1) {
                                            day = Integer.parseInt(jobs.pdate[i].substring(l, ii + 1));
                                        }
                                    }
                            %>
                            <div class="jobs-item with-thumb">
                                <div class="clearfix visible-xs"></div>
                                <div class="date"><%=day%><span><%=m[month]%>,<%=year%></span></div>
                                <h6 class="title"><a href="#"><%= jobs.title[i]%></a></h6>
                                <span class="meta"><%= jobs.house[i]%>,<%= jobs.street[i]%>,<%= jobs.city[i]%>,<%= jobs.country[i]%></span>

                                <ul class="top-btns">
                                    <li><a href="#" class="btn btn-gray fa fa-plus toggle"></a></li>
                                </ul>

                                <p class="description"><%= jobs.descrip[i]%><a href="#" class="read-more">Read More</a></p>

                                <div class="content">
                                    <p><%= jobs.descrip[i]%></p>

                                    <h5>Required Skills</h5>
                                    <%l = 0;
                                        for (int jj = 0; jj < jobs.skills[i].length(); ++jj) {
                                            String ski = "";
                                            if (jobs.skills[i].charAt(jj) == '-') {
                                                ski = jobs.skills[i].substring(l, jj);
                                                l = jj + 1;%>

                                    <div class="progress-bar toggle" data-progress="100">
                                        <h6 class="progress-bar-title"><%=ski%></h6>
                                    </div>
                                    <%}
                                    %>
                                    <%}%>

                                    <hr>

                                    <div class="clearfix">
                                        <form method="post" action="answer-paper.jsp">
                                            <input style="display: none" value="<%=jobs.job_id[i]%>" name="apply">
                                            <input type="hidden" name="job_id" value=<%=jobs.job_id[i]%> >
                                            <input style="display: none" value="<%=tag%>" name="skill">
                                            <%if (jobs.applied[i] == 0 && jobs.ques_flag[i] == 0) {%>
                                            <button class="btn btn-default pull-left" type="submit">Apply For This Job</button>
                                            <%} else if (jobs.applied[i] == 0 && jobs.ques_flag[i] == 1) {%>
                                            <button class="btn btn-default pull-left">Apply For This Job</button>
                                            <%} else {%>
                                            <a class="btn btn-default pull-left">You have already applied</a>
                                            <%}%>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <%}%>
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