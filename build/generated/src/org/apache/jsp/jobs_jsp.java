package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.jobportal.connection.Jobs;
import com.jobportal.connection.Database;
import com.jobportal.connection.Database;
import com.jobportal.connection.Login;

public final class jobs_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/include/header.jsp");
    _jspx_dependants.add("/include/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <title>Jobs - Careers</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- Stylesheets -->\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic|Roboto+Condensed:400,700' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/flexslider.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/responsive.css\">\r\n");
      out.write("\r\n");
      out.write("        <!--[if IE 9]>\r\n");
      out.write("                <script src=\"js/media.match.min.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"main-wrapper\">\r\n");
      out.write("\r\n");
      out.write("            <header id=\"header\" class=\"header-style-1\">\r\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>");

    String email = "", password = "", attempt = request.getParameter("attempt"), login = "";
    String mail = request.getParameter("email"), pass = request.getParameter("password");
    int new_comer = 0;
    Login lgn = new Login();
    if (request.getRequestURI().endsWith("profile.jsp")&&!request.getRequestURI().endsWith("-profile.jsp")) {
        String[] info = lgn.GetInfo(session.getAttribute("id") + "");
        mail = info[1];
        pass = info[2];
       // out.print(mail + pass);
        new_comer = 1;
    }
    if (attempt != null) {
        if (attempt.equals("yes")) {
            Cookie email_ = new Cookie("email", mail);
            Cookie password_ = new Cookie("password", pass);
            email_.setMaxAge(60 * 24 * 60);
            password_.setMaxAge(60 * 24 * 60);
            response.addCookie(email_);
            response.addCookie(password_);
            Cookie cookie = null;
            Cookie[] cookies = null;
            cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    email = mail;
                    password = pass;
                }
                if (lgn.Login(email, password)) {
                    Cookie login_ = new Cookie("login", "true");
                    login_.setMaxAge(60 * 24 * 60);
                    response.addCookie(login_);
                    login = "true";
                } else {
                    Cookie login_ = new Cookie("login", "false");
                    login_.setMaxAge(60 * 24 * 60);
                    response.addCookie(login_);
                    login = "false";
                }
            }
        } else if (attempt.equals("no")) {
            Cookie email_ = new Cookie("email", "");
            Cookie password_ = new Cookie("password", "");
            Cookie login_ = new Cookie("login", "false");
            response.addCookie(email_);
            response.addCookie(password_);
            response.addCookie(login_);
            login = "false";
        }
    } else if (new_comer == 1) {
        Cookie email_ = new Cookie("email", mail);
        Cookie password_ = new Cookie("password", pass);
        email_.setMaxAge(60 * 24 * 60);
        password_.setMaxAge(60 * 24 * 60);
        response.addCookie(email_);
        response.addCookie(password_);
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                email = mail;
                password = pass;
            }
            if (lgn.Login(email, password)) {
                Cookie login_ = new Cookie("login", "true");
                login_.setMaxAge(60 * 24 * 60);
                response.addCookie(login_);
                login = "true";
            } else {
                Cookie login_ = new Cookie("login", "false");
                login_.setMaxAge(60 * 24 * 60);
                response.addCookie(login_);
                login = "false";
            }
        }
    } else {
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if ((cookie.getName()).compareTo("email") == 0) {
                    email = cookie.getValue();
                } else if ((cookie.getName()).compareTo("password") == 0) {
                    password = cookie.getValue();
                } else if ((cookie.getName()).compareTo("login") == 0) {
                    login = cookie.getValue();
                }
            }
        }
    }
    Database db = new Database();

      out.write("\n");
      out.write("<div class=\"header-top-bar\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
if (!login.equals("true")) {
                session.setAttribute("customer_id", "0");
                String sense=request.getRequestURI();
                if(!sense.toLowerCase().contains("profile.jsp")&&!sense.toLowerCase().contains("homepage.jsp")&&!sense.toLowerCase().contains("signup")&&!sense.toLowerCase().contains("aboutus.jsp")){
                  response.sendRedirect("http://localhost:8084/JobPortal/homepage.jsp");
                }
        
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Header Register -->\n");
      out.write("        <div class=\"header-register\">\n");
      out.write("            <a href=\"signup1.jsp\" class=\"logoutbtn\">Register</a>\n");
      out.write("            <div>\n");
      out.write("                <form action=\"#\">\n");
      out.write("                    <input type=\"text\" class=\"form-control\" placeholder=\"Username\">\n");
      out.write("                    <input type=\"email\" class=\"form-control\" placeholder=\"Email\">\n");
      out.write("                    <input type=\"password\" class=\"form-control\" placeholder=\"Password\">\n");
      out.write("                    <input type=\"submit\" class=\"btn btn-default\" value=\"Register\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div> <!-- end .header-register -->\n");
      out.write("\n");
      out.write("        <!-- Header Login -->\n");
      out.write("        <div class=\"header-login\">\n");
      out.write("            <a href=\"\" class=\"btn btn-link\">Login</a>\n");
      out.write("            <div>\n");
      out.write("                <form action=\"homepage.jsp\" method=\"post\">\n");
      out.write("                    <input type=\"email\" name=\"email\" class=\"form-control\" placeholder=\"Email address\">\n");
      out.write("                    <input type=\"password\"  name=\"password\" class=\"form-control\" placeholder=\"Password\">\n");
      out.write("                    <input name=\"attempt\" value=\"yes\" style=\"display:none\">\n");
      out.write("                    <input type=\"submit\" class=\"btn btn-default\" value=\"Login\">\n");
      out.write("                    <a href=\"#\" class=\"btn btn-link\">Forgot Password?</a>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div> <!-- end .header-login -->\n");
      out.write("        ");
} else {
            session.setAttribute("customer_id", "" + lgn.Customer_Id(email, password));
      out.write(" \n");
      out.write("        <div class=\"header-login\">\n");
      out.write("            <a href=\"homepage.jsp?attempt=no\" class=\"logoutbtn\">Logout</a>\n");
      out.write("        </div>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("    </div> <!-- end .container -->\n");
      out.write("</div> <!-- end .header-top-bar -->\n");
      out.write("<div class=\"header-nav-bar\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("        <!-- Logo -->\n");
      out.write("        <div class=\"css-table logo\">\n");
      out.write("            <div class=\"css-table-cell\">\n");
      out.write("                <a href=\"index.html\">\n");
      out.write("                    <img src=\"img/header-logo.png\" alt=\"\">\n");
      out.write("                </a> <!-- end .logo -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Mobile Menu Toggle -->\n");
      out.write("        <a href=\"#\" id=\"mobile-menu-toggle\"><span></span></a>\n");
      out.write("\n");
      out.write("        <!-- Primary Nav -->\n");
      out.write("        <nav>\n");
      out.write("            <ul class=\"primary-nav\">\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"homepage.jsp\">Home</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"has-submenu\">\n");
      out.write("                    <a >Jobs</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"applied_offered_jobs.jsp?info=applied\">Applied Jobs</a></li>\n");
      out.write("                        <li><a href=\"applied_offered_jobs.jsp?info=offered\">Offered Jobs</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"\">About Us</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </div> <!-- end .container -->\n");
      out.write("\n");
      out.write("    <div id=\"mobile-menu-container\" class=\"container\">\n");
      out.write("        <div class=\"login-register\"></div>\n");
      out.write("        <div class=\"menu\"></div>\n");
      out.write("    </div>\n");
      out.write("</div> <!-- end .header-nav-bar -->");
      out.write("\r\n");
      out.write("                <div class=\"header-page-title\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <h1>Available Jobs <small></small></h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </header> <!-- end #header -->\r\n");
      out.write("            ");

                String apply = request.getParameter("apply");
                Jobs jobs = new Jobs();
                if (apply != null) {
                    if (true) {
                        if (jobs.ApplyForJobs("" + session.getAttribute("customer_id"), apply)) {
            
      out.write("\r\n");
      out.write("            <div class=\"col-sm-12 page-content\">\r\n");
      out.write("                <div class=\"alert alert-info\">\r\n");
      out.write("                    <h6>You have applied for this job successfully</h6>\r\n");
      out.write("                    <a href=\"#\" class=\"close fa fa-times\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
 } else if (session.getAttribute("customer_id") == "0") {
      out.write("\r\n");
      out.write("            <div class=\"col-sm-12 page-content\">\r\n");
      out.write("                <div class=\"alert alert-error\">\r\n");
      out.write("                    <h6>Please login or register first </h6>\r\n");
      out.write("                    <a href=\"#\" class=\"close fa fa-times\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
} else {
      out.write("\r\n");
      out.write("            <div class=\"col-sm-12 page-content\">\r\n");
      out.write("                <div class=\"alert alert-error\">\r\n");
      out.write("                    <h6>Sorry.You applied for this job before.</h6>\r\n");
      out.write("                    <a href=\"#\" class=\"close fa fa-times\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
 }
                    }
                }
      out.write("\r\n");
      out.write("            <div id=\"page-content\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-sm-4 page-sidebar\">\r\n");
      out.write("                            <aside>\r\n");
      out.write("                                <div class=\"white-container mb0\">\r\n");
      out.write("                                    <div class=\"widget sidebar-widget jobs-search-widget\">\r\n");
      out.write("                                        <h5 class=\"widget-title\">Search</h5>\r\n");
      out.write("                                        <form action=\"jobs.jsp\">\r\n");
      out.write("                                            <div class=\"widget-content\">\r\n");
      out.write("                                                <span>Search by skill</span>\r\n");
      out.write("                                                <input type=\"text\"  name=\"skill\" class=\"form-control mt10\" placeholder=\"Skill\">\r\n");
      out.write("                                                <br>\r\n");
      out.write("                                                <input type=\"submit\" class=\"btn btn-default\" value=\"Search\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </aside>\r\n");
      out.write("                        </div> <!-- end .page-sidebar -->\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-sm-8 page-content\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"title-lines\">\r\n");
      out.write("                                <h3 class=\"mt0\">Available Jobs</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");

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
                            
      out.write("\r\n");
      out.write("                            ");
for (int i = 1; i <= total; ++i) {
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
                            
      out.write("\r\n");
      out.write("                            <div class=\"jobs-item with-thumb\">\r\n");
      out.write("                                <div class=\"clearfix visible-xs\"></div>\r\n");
      out.write("                                <div class=\"date\">");
      out.print(day);
      out.write("<span>");
      out.print(m[month]);
      out.write(',');
      out.print(year);
      out.write("</span></div>\r\n");
      out.write("                                <h6 class=\"title\"><a href=\"#\">");
      out.print( jobs.title[i]);
      out.write("</a></h6>\r\n");
      out.write("                                <span class=\"meta\">");
      out.print( jobs.house[i]);
      out.write(',');
      out.print( jobs.street[i]);
      out.write(',');
      out.print( jobs.city[i]);
      out.write(',');
      out.print( jobs.country[i]);
      out.write("</span>\r\n");
      out.write("\r\n");
      out.write("                                <ul class=\"top-btns\">\r\n");
      out.write("                                    <li><a href=\"#\" class=\"btn btn-gray fa fa-plus toggle\"></a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("\r\n");
      out.write("                                <p class=\"description\">");
      out.print( jobs.descrip[i]);
      out.write("<a href=\"#\" class=\"read-more\">Read More</a></p>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"content\">\r\n");
      out.write("                                    <p>");
      out.print( jobs.descrip[i]);
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("                                    <h5>Required Skills</h5>\r\n");
      out.write("                                    ");
l = 0;
                                        for (int jj = 0; jj < jobs.skills[i].length(); ++jj) {
                                            String ski = "";
                                            if (jobs.skills[i].charAt(jj) == '-') {
                                                ski = jobs.skills[i].substring(l, jj);
                                                l = jj + 1;
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"progress-bar toggle\" data-progress=\"100\">\r\n");
      out.write("                                        <h6 class=\"progress-bar-title\">");
      out.print(ski);
      out.write("</h6>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    ");
}
                                    
      out.write("\r\n");
      out.write("                                    ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <hr>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"clearfix\">\r\n");
      out.write("                                        <form method=\"post\" action=\"answer-paper.jsp\">\r\n");
      out.write("                                            <input style=\"display: none\" value=\"");
      out.print(jobs.job_id[i]);
      out.write("\" name=\"apply\">\r\n");
      out.write("                                            <input type=\"hidden\" name=\"job_id\" value=");
      out.print(jobs.job_id[i]);
      out.write(" >\r\n");
      out.write("                                            <input style=\"display: none\" value=\"");
      out.print(tag);
      out.write("\" name=\"skill\">\r\n");
      out.write("                                            ");
if (jobs.applied[i] == 0 && jobs.ques_flag[i] == 0) {
      out.write("\r\n");
      out.write("                                            <button class=\"btn btn-default pull-left\" type=\"submit\">Apply For This Job</button>\r\n");
      out.write("                                            ");
} else if (jobs.applied[i] == 0 && jobs.ques_flag[i] == 1) {
      out.write("\r\n");
      out.write("                                            <button class=\"btn btn-default pull-left\">Apply For This Job</button>\r\n");
      out.write("                                            ");
} else {
      out.write("\r\n");
      out.write("                                            <a class=\"btn btn-default pull-left\">You have already applied</a>\r\n");
      out.write("                                            ");
}
      out.write("\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                        </div> <!-- end .page-content -->\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div> <!-- end .container -->\r\n");
      out.write("            </div> <!-- end #page-content -->\r\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<footer id=\"footer\" >\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-3 col-md-4\">\n");
      out.write("                <div class=\"widget\">\n");
      out.write("                    <div class=\"widget-content\">\n");
      out.write("                        <img class=\"logo\" src=\"img/header-logo.png\" alt=\"\">\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. In, sunt illum dolore dolor vel perferendis nisi sequi laudantium porro blanditiis!</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"copyright\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <p>&copy; Copyright 2014 <a href=\"#\">Careers</a> | All Rights Reserved | Powered by <a href=\"#\">UOU Apps</a></p>\n");
      out.write("\n");
      out.write("            <ul class=\"footer-social\">\n");
      out.write("                <li><a href=\"#\" class=\"fa fa-facebook\"></a></li>\n");
      out.write("                <li><a href=\"#\" class=\"fa fa-twitter\"></a></li>\n");
      out.write("                <li><a href=\"#\" class=\"fa fa-linkedin\"></a></li>\n");
      out.write("                <li><a href=\"#\" class=\"fa fa-google-plus\"></a></li>\n");
      out.write("                <li><a href=\"#\" class=\"fa fa-pinterest\"></a></li>\n");
      out.write("                <li><a href=\"#\" class=\"fa fa-dribbble\"></a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer> <!-- end #footer -->\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div> <!-- end #main-wrapper -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Scripts -->\r\n");
      out.write("        <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\r\n");
      out.write("        <script>window.jQuery || document.write('<script src=\"js/jquery-1.11.0.min.js\"><\\/script>')</script>\r\n");
      out.write("        <script src=\"http://maps.google.com/maps/api/js?sensor=false&libraries=geometry&v=3.7\"></script>\r\n");
      out.write("        <script src=\"js/maplace.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.ba-outside-events.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.responsive-tabs.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.flexslider-min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.fitvids.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery-ui-1.10.4.custom.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.inview.min.js\"></script>\r\n");
      out.write("        <script src=\"js/script.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
