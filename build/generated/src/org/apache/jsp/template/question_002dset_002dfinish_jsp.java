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

public final class question_002dset_002dfinish_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"main-wrapper\">\n");
      out.write("\n");
      out.write("            <header id=\"header\" class=\"header-style-1\">\n");
      out.write("                <div class=\"header-top-bar\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("\n");
      out.write("                        <!-- Header Language -->\n");
      out.write("                        <div class=\"header-language clearfix\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li class=\"active\"><a href=\"#\">En</a></li>\n");
      out.write("                                <li><a href=\"#\">Fr</a></li>\n");
      out.write("                                <li><a href=\"#\">De</a></li>\n");
      out.write("                                <li><a href=\"#\">It</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div> <!-- end .header-language -->\n");
      out.write("\n");
      out.write("                        <!-- Bookmarks -->\n");
      out.write("                        <a href=\"#\" class=\"btn btn-link bookmarks\">Bookmarks</a>\n");
      out.write("\n");
      out.write("                        <!-- Header Register -->\n");
      out.write("                        <div class=\"header-register\">\n");
      out.write("                            <a href=\"#\" class=\"btn btn-link\">Register</a>\n");
      out.write("                            <div>\n");
      out.write("                                <form action=\"#\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"Username\">\n");
      out.write("                                    <input type=\"email\" class=\"form-control\" placeholder=\"Email\">\n");
      out.write("                                    <input type=\"password\" class=\"form-control\" placeholder=\"Password\">\n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-default\" value=\"Register\">\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div> <!-- end .header-register -->\n");
      out.write("\n");
      out.write("                        <!-- Header Login -->\n");
      out.write("                        <div class=\"header-login\">\n");
      out.write("                            <a href=\"#\" class=\"btn btn-link\">Login</a>\n");
      out.write("                            <div>\n");
      out.write("                                <form action=\"#\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"Username\">\n");
      out.write("                                    <input type=\"password\" class=\"form-control\" placeholder=\"Password\">\n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-default\" value=\"Login\">\n");
      out.write("                                    <a href=\"#\" class=\"btn btn-link\">Forgot Password?</a>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div> <!-- end .header-login -->\n");
      out.write("\n");
      out.write("                    </div> <!-- end .container -->\n");
      out.write("                </div> <!-- end .header-top-bar -->\n");
      out.write("\n");
      out.write("                <div class=\"header-nav-bar\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("\n");
      out.write("                        <!-- Logo -->\n");
      out.write("                        <div class=\"css-table logo\">\n");
      out.write("                            <div class=\"css-table-cell\">\n");
      out.write("                                <a href=\"index.html\">\n");
      out.write("                                    <img src=\"img/header-logo.png\" alt=\"\">\n");
      out.write("                                </a> <!-- end .logo -->\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Mobile Menu Toggle -->\n");
      out.write("                        <a href=\"#\" id=\"mobile-menu-toggle\"><span></span></a>\n");
      out.write("\n");
      out.write("                        <!-- Primary Nav -->\n");
      out.write("                        <nav>\n");
      out.write("                            <ul class=\"primary-nav\">\n");
      out.write("                                <li class=\"has-submenu\">\n");
      out.write("                                    <a href=\"index.html\">Home</a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"index.html\">Home with Boxes</a></li>\n");
      out.write("                                        <li><a href=\"homepage-slider.html\">Home with Slider</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"has-submenu\">\n");
      out.write("                                    <a href=\"jobs.html\">Jobs</a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"jobs.html\">Jobs Listings</a></li>\n");
      out.write("                                        <li><a href=\"jobs-single.html\">Jobs Details</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"has-submenu\">\n");
      out.write("                                    <a href=\"candidates.html\">Candidates</a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"candidates.html\">Candidates Listings</a></li>\n");
      out.write("                                        <li><a href=\"candidates-sidebar.html\">Candidates Listings Sidebar</a></li>\n");
      out.write("                                        <li><a href=\"candidates-single.html\">Candidates Details</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"has-submenu\">\n");
      out.write("                                    <a href=\"about-us.html\">About Us</a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"partners.html\">Partners</a></li>\n");
      out.write("                                        <li><a href=\"contact-us.html\">Contact Us</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"active\"><a href=\"register.html\">Register</a></li>\n");
      out.write("                                <li><a href=\"shortcodes.html\">Shortcodes</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("                    </div> <!-- end .container -->\n");
      out.write("\n");
      out.write("                    <div id=\"mobile-menu-container\" class=\"container\">\n");
      out.write("                        <div class=\"login-register\"></div>\n");
      out.write("                        <div class=\"menu\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div> <!-- end .header-nav-bar -->\n");
      out.write("\n");
      out.write("                <div class=\"header-page-title\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <h1>Sign Up</h1>\n");
      out.write("\n");
      out.write("                        <ul class=\"breadcrumbs\">\n");
      out.write("                            <li><a href=\"#\">Home</a></li>\n");
      out.write("                            <li><a href=\"#\">Sign Up</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </header> <!-- end #header -->\n");
      out.write("\n");
      out.write("            <div id=\"page-content\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-12 page-content\">\n");
      out.write("                            <ul class=\"form-steps four clearfix\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <li class=\"active\">Finish</li>\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("\n");
      out.write("                            <div class=\"white-container sign-up-form\">\n");
      out.write("                                <div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <section>\n");
      out.write("                                        <div class=\"alert alert-success\">\n");
      out.write("                                            <h6>Question Paper Successfully Set!</h6>\n");
      out.write("                                            <a href=\"#\" class=\"close fa fa-times\"></a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </section>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <hr class=\"mt60\">\n");
      out.write("\n");
      out.write("                                <div class=\"clearfix\">\n");
      out.write("                                    <form method=\"post\" action=\"profile.jsp\">\n");
      out.write("                                        <button class=\"btn btn-default btn-large pull-right\">Go to My Profile</button>\n");
      out.write("                                    </form>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div> <!-- end .page-content -->\n");
      out.write("                    </div>\n");
      out.write("                </div> <!-- end .container -->\n");
      out.write("            </div> <!-- end #page-content -->\n");
      out.write("\n");
      out.write("            <footer id=\"footer\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-3 col-md-4\">\n");
      out.write("                            <div class=\"widget\">\n");
      out.write("                                <div class=\"widget-content\">\n");
      out.write("                                    <img class=\"logo\" src=\"img/header-logo.png\" alt=\"\">\n");
      out.write("                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. In, sunt illum dolore dolor vel perferendis nisi sequi laudantium porro blanditiis!</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-3 col-md-4\">\n");
      out.write("                            <div class=\"widget\">\n");
      out.write("                                <h6 class=\"widget-title\">Navigation</h6>\n");
      out.write("\n");
      out.write("                                <div class=\"widget-content\">\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-xs-6 col-sm-12 col-md-6\">\n");
      out.write("                                            <ul class=\"footer-links\">\n");
      out.write("                                                <li><a href=\"#\">Home</a></li>\n");
      out.write("                                                <li><a href=\"#\">Jobs</a></li>\n");
      out.write("                                                <li><a href=\"#\">Candidates</a></li>\n");
      out.write("                                                <li><a href=\"#\">Partners</a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-xs-6 col-sm-12 col-md-6\">\n");
      out.write("                                            <ul class=\"footer-links\">\n");
      out.write("                                                <li><a href=\"#\">About Us</a></li>\n");
      out.write("                                                <li><a href=\"#\">Contact Us</a></li>\n");
      out.write("                                                <li><a href=\"#\">Terms &amp; Conditions</a></li>\n");
      out.write("                                                <li><a href=\"#\">Privacy Policy</a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-3 col-md-2\">\n");
      out.write("                            <div class=\"widget\">\n");
      out.write("                                <h6 class=\"widget-title\">Follow Us</h6>\n");
      out.write("\n");
      out.write("                                <div class=\"widget-content\">\n");
      out.write("                                    <ul class=\"footer-links\">\n");
      out.write("                                        <li><a href=\"#\">Blog</a></li>\n");
      out.write("                                        <li><a href=\"#\">Twitter</a></li>\n");
      out.write("                                        <li><a href=\"#\">Facebook</a></li>\n");
      out.write("                                        <li><a href=\"#\">Youtube</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-3 col-md-2\">\n");
      out.write("                            <div class=\"widget\">\n");
      out.write("                                <h6 class=\"widget-title\">Popular Jobs</h6>\n");
      out.write("\n");
      out.write("                                <div class=\"widget-content\">\n");
      out.write("                                    <ul class=\"footer-links\">\n");
      out.write("                                        <li><a href=\"#\">Web Developer</a></li>\n");
      out.write("                                        <li><a href=\"#\">Web Designer</a></li>\n");
      out.write("                                        <li><a href=\"#\">UX Engineer</a></li>\n");
      out.write("                                        <li><a href=\"#\">Account Manager</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"copyright\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <p>&copy; Copyright 2014 <a href=\"#\">Careers</a> | All Rights Reserved | Powered by <a href=\"#\">UOU Apps</a></p>\n");
      out.write("\n");
      out.write("                        <ul class=\"footer-social\">\n");
      out.write("                            <li><a href=\"#\" class=\"fa fa-facebook\"></a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"fa fa-twitter\"></a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"fa fa-linkedin\"></a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"fa fa-google-plus\"></a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"fa fa-pinterest\"></a></li>\n");
      out.write("                            <li><a href=\"#\" class=\"fa fa-dribbble\"></a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </footer> <!-- end #footer -->\n");
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
    } 
            catch (Exception e) 
        {
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
