package org.apache.jsp.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.jobportal.connection.Database;
import com.jobportal.connection.Login;
import com.jobportal.connection.HomePage;
import com.jobportal.connection.Jobs;
import com.jobportal.connection.Database;
import com.jobportal.connection.Login;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/template/include/header.jsp");
    _jspx_dependants.add("/template/include/footer.jsp");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\r\n");
      out.write("        <title>Homepage - Careers</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- Stylesheets -->\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic|Roboto+Condensed:400,700' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/flexslider.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/responsive.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"main-wrapper\">\r\n");
      out.write("\r\n");
      out.write("            <header id=\"header\" class=\"header-style-1\">\r\n");
      out.write("\r\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>");

    String email = "", password = "", attempt = request.getParameter("attempt"), login = "";
    Login lgn = new Login();
    if (attempt != null) {
        if (attempt.equals("yes")) {
            Cookie email_ = new Cookie("email", request.getParameter("email"));
            Cookie password_ = new Cookie("password", request.getParameter("password"));
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
                    email = request.getParameter("email");
                    password = request.getParameter("password");
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
      out.write("                    <a href=\"jobs.html\">Jobs</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"jobs.html\">Applied Jobs</a></li>\n");
      out.write("                        <li><a href=\"jobs-single.html\">Offered Jobs</a></li>\n");
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
      out.write("                ");

                    HomePage hp = new HomePage();
                    int ljobs = hp.LatestJobs();
                    int pjobs = hp.PopularJobs();
                
      out.write("\r\n");
      out.write("                <div class=\"header-banner\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-sm-6\">\r\n");
      out.write("                                <div class=\"header-banner-box register\">\r\n");
      out.write("                                    <div class=\"counter-container\">\r\n");
      out.write("                                        <ul class=\"counter clearfix\">\r\n");
      out.write("                                            <li class=\"zero\">0</li>\r\n");
      out.write("                                            <li>3</li>\r\n");
      out.write("                                            <li>5</li>\r\n");
      out.write("                                            <li>1</li>\r\n");
      out.write("                                            <li>0</li>\r\n");
      out.write("                                            <li>9</li>\r\n");
      out.write("                                        </ul>\r\n");
      out.write("\r\n");
      out.write("                                        <div><span>Jobs</span></div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <a href=\"jobs.jsp\" class=\"btn btn-default\">Apply For a Job</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"col-sm-6\">\r\n");
      out.write("                                <div class=\"header-banner-box post-job\">\r\n");
      out.write("                                    <img src=\"img/verified.png\" alt=\"\">\r\n");
      out.write("\r\n");
      out.write("                                    <a href=\"postjob.jsp\" class=\"btn btn-red\">Post a Job</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div> <!-- end .header-banner -->\r\n");
      out.write("            </header> <!-- end #header -->\r\n");
      out.write("\r\n");
      out.write("            <div id=\"page-content\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"title-lines\">\r\n");
      out.write("                                <h3>Latest Jobs</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");
for (int i = 1; i <= ljobs; ++i) {
      out.write("\r\n");
      out.write("                            <div class=\"latest-jobs-section white-container\">\r\n");
      out.write("                                <div class=\"flexslider clearfix\">\r\n");
      out.write("                                    <ul class=\"slides\">\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                            <div class=\"image\">\r\n");
      out.write("                                                <img src=\"img/content/face-2.png\" alt=\"\">\r\n");
      out.write("                                                <a href=\"#\" class=\"btn btn-default fa fa-search\"></a>\r\n");
      out.write("                                                <a href=\"#\" class=\"btn btn-default fa fa-link\"></a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"content\">\r\n");
      out.write("                                                <h6>");
      out.print( hp.title[i]);
      out.write("</h6>\r\n");
      out.write("                                                <span class=\"location\">");
      out.print( hp.house[i]);
      out.write(',');
      out.print( hp.street[i]);
      out.write(',');
      out.print( hp.city[i]);
      out.write(',');
      out.print( hp.country[i]);
      out.write("</span>\r\n");
      out.write("                                                <p>");
      out.print( hp.descrip[i]);
      out.write("<a  class=\"read-more\"><br>Read More</a></p>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div> <!-- end .latest-jobs-section -->\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                        </div> <!-- end .page-content -->\r\n");
      out.write("\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <div class=\"title-lines\">\r\n");
      out.write("                                <h3>Popular Jobs</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");
for (int i = ljobs+1; i <= pjobs; ++i) {
      out.write("\r\n");
      out.write("                            <div class=\"latest-jobs-section white-container\">\r\n");
      out.write("                                <div class=\"flexslider clearfix\">\r\n");
      out.write("                                    <ul class=\"slides\">\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                            <div class=\"image\">\r\n");
      out.write("                                                <img src=\"img/content/face-2.png\" alt=\"\">\r\n");
      out.write("                                                <a href=\"#\" class=\"btn btn-default fa fa-search\"></a>\r\n");
      out.write("                                                <a href=\"#\" class=\"btn btn-default fa fa-link\"></a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"content\">\r\n");
      out.write("                                                <h6>");
      out.print( hp.title[i]);
      out.write("</h6>\r\n");
      out.write("                                                <span class=\"location\">");
      out.print( hp.house[i]);
      out.write(',');
      out.print( hp.street[i]);
      out.write(',');
      out.print( hp.city[i]);
      out.write(',');
      out.print( hp.country[i]);
      out.write("</span>\r\n");
      out.write("                                                <p>");
      out.print( hp.descrip[i]);
      out.write("<a  class=\"read-more\"><br>Read More</a></p>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div> <!-- end .latest-jobs-section -->\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                        </div> <!-- end .page-content -->\r\n");
      out.write("                        \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div> <!-- end .container -->\r\n");
      out.write("            </div> <!-- end #page-content -->\r\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<footer id=\"footer\">\n");
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
      out.write("        <script>\r\n");
      out.write("            function logout() {\r\n");
      out.write("                document.getElementById(\"login\").submit();\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
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
