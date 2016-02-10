package org.apache.jsp.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.net.aso.p;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import com.jobportal.connection.Database;
import com.jobportal.connection.Database;
import com.jobportal.connection.Login;

public final class signup1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("\n");
      out.write("        <title>Sign Up - Careers</title>\n");
      out.write("\n");
      out.write("        <!-- Stylesheets -->\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic|Roboto+Condensed:400,700' rel='stylesheet' type='text/css'>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/flexslider.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/responsive.css\">\n");
      out.write("\n");
      out.write("        <!--[if IE 9]>\n");
      out.write("                <script src=\"js/media.match.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            //out.print(request.getParameter("fromlog"));
            try {

                Database db1 = new Database();
                Statement stmt = db1.connection.createStatement();


        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"main-wrapper\">\n");
      out.write("\n");
      out.write("            <header id=\"header\" class=\"header-style-1\">\n");
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
      out.write("\n");
      out.write("                <div class=\"header-page-title\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <h1>Sign Up</h1>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </header> <!-- end #header -->\n");
      out.write("\n");
      out.write("            <div id=\"page-content\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-12 page-content\">\n");
      out.write("                            <ul class=\"form-steps four clearfix\">\n");
      out.write("                                <li class=\"active\">Step 1</li>\n");
      out.write("                                <li>Step 2</li>\n");
      out.write("                                <li>Finish</li>\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                            <form action=\"signup2.jsp\" method=\"POST\"> \n");
      out.write("                                <div class=\"white-container sign-up-form\">\n");
      out.write("                                    <div>\n");
      out.write("                                        <h2>1. Fill in your profile</h2>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <section>\n");
      out.write("                                            <h6 class=\"bottom-line\">Personal Info:</h6>\n");
      out.write("\n");
      out.write("                                            <h6 class=\"label\">Name</h6>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"fullname\" placeholder=\"Name\" required>\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"surname\" placeholder=\"Surname\" required>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <h6 class=\"label\">Date of Birth</h6>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-sm-12\">\n");
      out.write("                                                    <input type=\"text\" class=\"day-input\"  name=\"dob_day\" placeholder=\"DD\">\t\n");
      out.write("                                                    <input type=\"text\" class=\"month-input\" name=\"dob_month\" placeholder=\"MM\">\n");
      out.write("                                                    <input type=\"text\" class=\"year-input\" name=\"dob_year\" placeholder=\"YYYY\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <h6 class=\"label\">Phone</h6>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"phone_mobile\" placeholder=\"Mobile\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"phone_work\" placeholder=\"Work\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"phone_fax\" placeholder=\"Fax\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            <h6 class=\"label\">Address</h6>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-sm-6\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"address_house\" placeholder=\"House\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-6\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"address_street\" placeholder=\"Street\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <select name=\"address_country\">\n");
      out.write("                                                        <option value=\"\">Country</option>\n");
      out.write("                                                        <option value=\"Bangladesh\">Bangladesh</option>\n");
      out.write("                                                        <option value=\"Argentina\">Argentina</option>\n");
      out.write("                                                        <option value=\"Brazil\">Brazil</option>\n");
      out.write("                                                        <option value=\"Canada\">Canada</option>\n");
      out.write("                                                        <option value=\"Denmark\">Denmark</option>\n");
      out.write("                                                        <option value=\"England\">England</option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"address_state\" placeholder=\"State\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"address_city\" placeholder=\"City\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"address_zipcode\" placeholder=\"ZIP Code\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <h6 class=\"label\">Others</h6>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"gender\" placeholder=\"Gender\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"nationality\" placeholder=\"Nationality\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"email\" class=\"form-control\" name=\"email\" placeholder=\"E-mail\" required=\"\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"customer_website\" placeholder=\"Website\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                        </section>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <section>\n");
      out.write("                                            <h6 class=\"bottom-line\">Set Password:</h6>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"password\" name=\"password1\" class=\"form-control\" placeholder=\"Password\" required>\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"password\" class=\"form-control\" name=\"password2\" placeholder=\"Repeat Password\"  required>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </section>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <input type=\"hidden\" name=\"flag\" value=\"true\">\n");
      out.write("\n");
      out.write("                                    <hr class=\"mt60\">\n");
      out.write("\n");
      out.write("                                    <div class=\"clearfix\">\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-default btn-large pull-right\">Continue to Step 2</button>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div> <!-- end .page-content -->\n");
      out.write("                    </div>\n");
      out.write("                </div> <!-- end .container -->\n");
      out.write("            </div> <!-- end #page-content -->\n");
      out.write("\n");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div> <!-- end #main-wrapper -->\n");
      out.write("\n");
      out.write("        <!-- Scripts -->\n");
      out.write("        <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\n");
      out.write("        <script>window.jQuery || document.write('<script src=\"js/jquery-1.11.0.min.js\"><\\/script>')</script>\n");
      out.write("        <script src=\"http://maps.google.com/maps/api/js?sensor=false&libraries=geometry&v=3.7\"></script>\n");
      out.write("        <script src=\"js/maplace.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.ba-outside-events.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.responsive-tabs.js\"></script>\n");
      out.write("        <script src=\"js/jquery.flexslider-min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.fitvids.js\"></script>\n");
      out.write("        <script src=\"js/jquery-ui-1.10.4.custom.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.inview.min.js\"></script>\n");
      out.write("        <script src=\"js/script.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
    } catch (Exception e) {
        out.println("Exception : " + e.getMessage() + "");
    }

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
