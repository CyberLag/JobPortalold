package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.sql.Date;
import java.io.FileOutputStream;
import java.io.File;
import java.io.DataInputStream;
import oracle.net.aso.p;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import com.jobportal.connection.Database;
import com.jobportal.connection.Database;
import com.jobportal.connection.Login;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Candidates Single - Careers</title>\n");
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
                
                
            out.print(session.getAttribute("customer_id"));

                Database db1 = new Database();
                Statement stmt = db1.connection.createStatement();
                Statement stmt2 = db1.connection.createStatement();
                Statement stmt3 = db1.connection.createStatement();

                ResultSet rs;
                ResultSet rs2;
                if (request.getParameter("customer_id") != null) {
                    session.setAttribute("id", request.getParameter("customer_id"));
                }
                
                     

                String query1 = "select * from customer where customer_id=" + session.getAttribute("id");
                String query2 = "select skill_id from customer_skill where customer_id=" + session.getAttribute("id");
                //out.print(query2);
                rs2 = stmt2.executeQuery(query2);
                //while(rs2.next())
                //{
                //    out.print(rs2.getString("skill_id")+".");
                //}

                rs = stmt.executeQuery(query1);

                rs.next();

//out.print(query3);
                String url = "profile.jsp?customer_id=" + rs.getString("customer_id");
                String img_dir = "img/" + rs.getString("customer_id") + ".jpg";
                Calendar now = Calendar.getInstance();
                int age = now.get(Calendar.YEAR);

                age -= rs.getInt("dob_year");
                //out.print(age);

                String mail_link = "mailto:" + rs.getString("email");
                String website_link = "http://" + rs.getString("customer_website");

        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"main-wrapper\">\n");
      out.write("            <header id=\"header\" class=\"header-style-1\">\n");
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
    if (request.getRequestURI().endsWith("profile.jsp")) {
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
      out.write("                        <h1>");
      out.print(rs.getString("fullname"));
      out.write("<br><small>");
if (rs.getInt("job_type") == 2) {
      out.write("Front-end Developer");
} else if (rs.getInt("job_type") == 3) {
      out.write("Back-end Developer");
}
      out.write("</small></h1>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </header> <!-- end #header -->\n");
      out.write("        </header> <!-- end #header -->\n");
      out.write("\n");
      out.write("        <div id=\"page-content\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-4 page-sidebar\">\n");
      out.write("                        <aside>\n");
      out.write("                            <div class=\"widget sidebar-widget white-container candidates-single-widget\">\n");
      out.write("                                <div class=\"widget-content\">\n");
      out.write("                                    <div class=\"thumb\">\n");
      out.write("                                        <img src=");
      out.print(img_dir);
      out.write(" alt=\"\">\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <h5 class=\"bottom-line\">Candidate Details</h5>\n");
      out.write("\n");
      out.write("                                    <table>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>Name</td>\n");
      out.write("                                                <td>");
      out.print(rs.getString("fullname"));
      out.write('(');
      out.print(rs.getString("surname"));
      out.write(")</td>\n");
      out.write("                                            </tr>\n");
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>Age</td>\n");
      out.write("                                                <td>");
      out.print(age);
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>Location</td>\n");
      out.write("                                                <td>");
      out.print(rs.getString("customer_location"));
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>Dgree</td>\n");
      out.write("                                                <td>");
      out.print(rs.getString("customer_degree"));
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>Department</td>\n");
      out.write("                                                <td>");
      out.print(rs.getString("customer_department"));
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>Phone</td>\n");
      out.write("                                                <td>");
      out.print(rs.getString("phone_mobile"));
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>Fax</td>\n");
      out.write("                                                <td>");
      out.print(rs.getString("phone_fax"));
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>E-mail</td>\n");
      out.write("                                                <td><a href=");
      out.print(mail_link);
      out.write(' ');
      out.write('>');
      out.print(rs.getString("email"));
      out.write("</a></td>\n");
      out.write("                                            </tr>\n");
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>Website</td>\n");
      out.write("                                                <td><a href=");
      out.print(website_link);
      out.write(" target=\"_blank\" >");
      out.print(rs.getString("customer_website"));
      out.write("</a></td>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("\n");
      out.write("                                    <h5 class=\"bottom-line\">Professional Rating</h5>\n");
      out.write("\n");
      out.write("                                    <table>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");
for (int j = 0; j < 5; j++) {
                                                    String str = "";
                                                    int stars = 0;
                                                    if (j == 0) {
                                                        str = "Expertise";
                                                        stars = rs.getInt("customer_expertise");
                                                    } else if (j == 1) {
                                                        str = "Knowledge";
                                                        stars = rs.getInt("customer_knowledge");
                                                    } else if (j == 2) {
                                                        str = "Quality";
                                                        stars = rs.getInt("customer_quality");
                                                    } else if (j == 3) {
                                                        str = "Price";
                                                        stars = rs.getInt("customer_price");
                                                    } else if (j == 4) {
                                                        str = "Services";
                                                        stars = rs.getInt("customer_services");
                                                    }

                                            
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>");
      out.print(str);
      out.write("</td>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <ul class=\"stars\">\n");
      out.write("                                                        \n");
      out.write("                                                        ");
for(int jj=1;jj<=5;jj++){
                                                         if(jj<=stars){   
                                                        
      out.write("\n");
      out.write("                                                        <li><i class=\"fa fa-star\"></i></li>\n");
      out.write("                                                        ");
}else{
      out.write("\n");
      out.write("                                                        <li><i class=\"fa fa-star-o\"></i></li>\n");
      out.write("                                                        ");
}
                                                        }
      out.write("\n");
      out.write("                                                    </ul>\n");
      out.write("                                                </td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </aside>\n");
      out.write("                    </div> <!-- end .page-sidebar -->\n");
      out.write("\n");
      out.write("                    <div class=\"col-sm-8 page-content\">\n");
      out.write("                        <div class=\"clearfix mb30 hidden-xs\">\n");
      out.write("                            <a href=\"#\" class=\"btn btn-gray pull-left\">Back to Listings</a>\n");
      out.write("                            <div class=\"pull-right\">\n");
      out.write("                                <a href=\"#\" class=\"btn btn-gray\">Previous</a>\n");
      out.write("                                <a href=\"#\" class=\"btn btn-gray\">Next</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"candidates-item candidates-single-item\">\n");
      out.write("                            <h6 class=\"title\"><a href=\"#\">");
      out.print(rs.getString("fullname"));
      out.write("</a></h6>\n");
      out.write("                            <span class=\"meta\">");
      out.print(age);
      out.write(" Years Old - ");
      out.print(rs.getString("customer_location"));
      out.write("</span>\n");
      out.write("\n");
      out.write("                            <ul class=\"top-btns\">\n");
      out.write("                                <li><a href=\"#\" class=\"btn btn-gray fa fa-star\"></a></li>\n");
      out.write("                            </ul>\n");
      out.write("\n");
      out.write("                            <ul class=\"social-icons clearfix\">\n");
      out.write("                                <li><a href=\"#\" class=\"btn btn-gray fa fa-facebook\"></a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"btn btn-gray fa fa-twitter\"></a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"btn btn-gray fa fa-google-plus\"></a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"btn btn-gray fa fa-dribbble\"></a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"btn btn-gray fa fa-pinterest\"></a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"btn btn-gray fa fa-linkedin\"></a></li>\n");
      out.write("                            </ul>\n");
      out.write("\n");
      out.write("                            <p>");
      out.print(rs.getString("customer_details"));
      out.write("</p>\n");
      out.write("\n");
      out.write("                            <ul class=\"list-unstyled\">\n");
      out.write("                                <li><strong>Department:</strong> ");
      out.print(rs.getString("customer_department"));
      out.write("</li>\n");
      out.write("                                <li><strong>Degree:</strong> ");
      out.print(rs.getString("customer_degree"));
      out.write("</li>\n");
      out.write("                                <li><strong>Working Hours:</strong> ");
      out.print(rs.getString("working_hours"));
      out.write("</li>\n");
      out.write("                                <li><strong>Experience:</strong> ");
      out.print(rs.getString("experience"));
      out.write(" Years</li>\n");
      out.write("                            </ul>\n");
      out.write("\n");
      out.write("                            <h5>Skills</h5>\n");
      out.write("                            ");
while (rs2.next()) {

                                    ResultSet rs3;
                                    String query3 = "select skill_name from skill where skill_id=" + rs2.getString("skill_id");
                                    //out.print(query3);
                                    rs3 = stmt3.executeQuery(query3);
                                    while (rs3.next()) {
                            
      out.write("\n");
      out.write("                            <div class=\"progress-bar toggle\" data-progress=\"60\">\n");
      out.write("                                <a href=\"#\" class=\"progress-bar-toggle\"></a>\n");
      out.write("                                <h6 class=\"progress-bar-title\">");
      out.print(rs3.getString("skill_name"));
      out.write("</h6>\n");
      out.write("                                <div class=\"progress-bar-inner\"><span></span></div>\n");
      out.write("                                <div class=\"progress-bar-content\">\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            ");
}
                                }
      out.write("\n");
      out.write("\n");
      out.write("                            <hr>\n");
      out.write("\n");
      out.write("                            <div class=\"clearfix\">\n");
      out.write("                                <a href=");
      out.print(mail_link);
      out.write(" class=\"btn btn-default pull-left\"><i class=\"fa fa-envelope-o\"></i> Contact Me</a>\n");
      out.write("\n");
      out.write("                                <ul class=\"social-icons pull-right\">\n");
      out.write("                                    <li><span>Share</span></li>\n");
      out.write("                                    <li><a href=\"#\" class=\"btn btn-gray fa fa-facebook\"></a></li>\n");
      out.write("                                    <li><a href=\"#\" class=\"btn btn-gray fa fa-twitter\"></a></li>\n");
      out.write("                                    <li><a href=\"#\" class=\"btn btn-gray fa fa-google-plus\"></a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div> <!-- end .page-content -->\n");
      out.write("                </div>\n");
      out.write("            </div> <!-- end .container -->\n");
      out.write("        </div> <!-- end #page-content -->\n");
      out.write("\n");
      out.write("        ");

            } catch (Exception e) {
                out.println("Exception : " + e.getMessage() + "");
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
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
      out.write("    </div> <!-- end #main-wrapper -->\n");
      out.write("\n");
      out.write("    <!-- Scripts -->\n");
      out.write("    <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\n");
      out.write("    <script>window.jQuery || document.write('<script src=\"js/jquery-1.11.0.min.js\"><\\/script>')</script>\n");
      out.write("    <script src=\"http://maps.google.com/maps/api/js?sensor=false&libraries=geometry&v=3.7\"></script>\n");
      out.write("    <script src=\"js/maplace.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.ba-outside-events.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.responsive-tabs.js\"></script>\n");
      out.write("    <script src=\"js/jquery.flexslider-min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.fitvids.js\"></script>\n");
      out.write("    <script src=\"js/jquery-ui-1.10.4.custom.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.inview.min.js\"></script>\n");
      out.write("    <script src=\"js/script.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
