package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

public final class signup2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        ");
      out.write("\n");
      out.write("        ");

            //out.print(request.getParameter("fromlog"));
            try {
                //out.print("LLL");

                Database db1 = new Database();
                Statement stmt = db1.connection.createStatement();
                ResultSet rs;
                    //stmt.executeQuery("insert into skill values(1,'C++')");

                //out.print(request.getParameter("flag"));
                if (request.getParameter("is_image_selected") == null && !request.getParameter("password1").toString().equals(request.getParameter("password2").toString())) {
                    response.sendRedirect("http://localhost:8084/JobPortal/signup1.jsp");
                }
                if (request.getParameter("is_image_selected") == null && request.getParameter("email").toString().length() <= 4) {
                    response.sendRedirect("http://localhost:8084/JobPortal/signup1.jsp");
                }
                if (request.getParameter("is_image_selected") == null && request.getParameter("password1").toString().length() <= 0) {
                    response.sendRedirect("http://localhost:8084/JobPortal/signup1.jsp");
                }
                //out.print("customer_id");
                //out.print(request.getParameter("is_image_selected").toString());

                if (request.getParameter("is_image_selected") != null) {
                    rs = stmt.executeQuery("select max(customer_id) as mx from customer");
                } else {
                    rs = stmt.executeQuery("select max(customer_id)+1 as mx from customer");
                }
                String customer_id = "";
                while (rs.next()) {
                    customer_id = rs.getString("mx");
                }
                //out.println(customer_id);
                if (!(customer_id.compareTo("1") >= 0 && customer_id.compareTo("999999") <= 999999)) {
                    customer_id = "1";
                }

                String fullname = request.getParameter("fullname");
                String surname = request.getParameter("surname");
                String address_house = request.getParameter("address_house");
                String address_street = request.getParameter("address_street");
                String address_city = request.getParameter("address_city");
                String address_state = request.getParameter("address_state");
                String address_country = request.getParameter("address_country");
                String address_zipcode = request.getParameter("address_zipcode");
                String phone_mobile = request.getParameter("phone_mobile");
                String phone_work = request.getParameter("phone_work");
                String phone_fax = request.getParameter("phone_fax");
                String dob_day = request.getParameter("dob_day");
                String dob_month = request.getParameter("dob_month");
                String dob_year = request.getParameter("dob_year");
                String gender = request.getParameter("gender");
                String nationality = request.getParameter("nationality");
                String email1 = request.getParameter("email");
                String password1 = request.getParameter("password1");
                String customer_location = request.getParameter("customer_location");
                String customer_department = request.getParameter("customer_department");
                String customer_degree = request.getParameter("customer_degree");
                String customer_website = request.getParameter("customer_website");
                String customer_university = request.getParameter("customer_university");
                String customer_university_location = request.getParameter("customer_university_location");
                String customer_details = request.getParameter("customer_details");
                String job_type=request.getParameter("job_type");
                String working_hours=request.getParameter("working_hours");
                String experience=request.getParameter("experience");
                

                String query1 = "insert into customer (customer_id,fullname,surname,address_house,address_street,address_city,address_state,"
                        + "address_country,address_zipcode,phone_mobile,phone_work,phone_fax,dob_day,dob_month,dob_year,gender,nationality,"
                        + "email,password,customer_location,customer_department,customer_degree,customer_website,customer_university,"
                        + "customer_university_location,customer_details,job_type,working_hours,experience) values(" 
                        + customer_id + ",'" + fullname + "','" + surname + "','" + address_house + "','" + address_street + "','"
                        + address_city + "','" + address_state + "','" + address_country + "','" + address_zipcode + "','" + phone_mobile + "','" + phone_work + "','" + phone_fax + "','" + dob_day
                        + "','" + dob_month + "','" + dob_year + "','" + gender + "','" + nationality + "','" + email1 + "','" + password1 + "','" + customer_location + "','" + customer_department + "','" + customer_degree + "','"
                        + customer_website + "','" + customer_university + "','" + customer_university_location + "','" + customer_details + "',0,0,0)";

                //out.print(query1);
                if (request.getParameter("is_image_selected") == null) {
                   stmt.executeQuery(query1);
                }

        
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
    String mail = request.getParameter("email"), pass = request.getParameter("password");
    int new_comer = 0;
    Login lgn = new Login();
    if (request.getRequestURI().endsWith("profile.jsp") && !request.getRequestURI().endsWith("-profile.jsp")) {
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
                String sense = request.getRequestURI();
                if (!sense.toLowerCase().contains("profile.jsp") && !sense.toLowerCase().contains("homepage.jsp") && !sense.toLowerCase().contains("signup") && !sense.toLowerCase().contains("aboutus.jsp")) {
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
      out.write("        <div class=\"header-login\">\n");
      out.write("            <a href=\"\" class=\"btn btn-link\">Admin Panel</a>\n");
      out.write("            <div>\n");
      out.write("                <form action=\"admin-panel.jsp\" method=\"post\">\n");
      out.write("                    <input type=\"text\" name=\"user\" class=\"form-control\" placeholder=\"User\">\n");
      out.write("                    <input type=\"password\"  name=\"password\" class=\"form-control\" placeholder=\"Password\">\n");
      out.write("                    <input name=\"attempt\" value=\"yes\" style=\"display:none\">\n");
      out.write("                    <input type=\"submit\" class=\"btn btn-default\" value=\"Login\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
      out.write("                                <li class=\"completed\">Step 1</li>\n");
      out.write("                                <li class=\"active\">Step 2</li>\n");
      out.write("                                <li>Finish</li>\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                            <div class=\"white-container sign-up-form\">\n");
      out.write("                                <div>\n");
      out.write("                                    <h2>Your Photo</h2>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    ");
                                                                //out.print((request.getRequestURL()).toString());
                                        if (request.getParameter("is_image_selected") == null || !request.getParameter("is_image_selected").startsWith("yes")) {
                //request.setAttribute("is_image_selected","yes");
                                    
      out.write("\n");
      out.write("                                    <form method=\"POST\" action=\"signup2.jsp?is_image_selected=yes\" enctype=\"multipart/form-data\" style=\"width: 110px; padding-top: 5px; height: 65px;\">\n");
      out.write("                                        ");

                                            String saveFile = new String();
                                            String contentType = request.getContentType();
                                            if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
                                                DataInputStream in = new DataInputStream(request.getInputStream());

                                                int formDataLength = request.getContentLength();
                                                byte dataBytes[] = new byte[formDataLength];
                                                int byteRead = 0;
                                                int totalBytesRead = 0;

                                                while (totalBytesRead < formDataLength) {
                                                    byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
                                                    totalBytesRead += byteRead;
                                                }
                                                String file = new String(dataBytes);

                                                saveFile = file.substring(file.indexOf("filename=\"") + 10);
                                                saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
                                                saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));

                                                int lastIndex = contentType.lastIndexOf("=");

                                                String boundary = contentType.substring(lastIndex + 1, contentType.length());

                                                int pos;

                                                pos = file.indexOf("filename=\"");
                                                pos = file.indexOf("\n", pos) + 1;
                                                pos = file.indexOf("\n", pos) + 1;
                                                pos = file.indexOf("\n", pos) + 1;

                                                int boundaryLocation = file.indexOf(boundary, pos) - 4;

                                                int startPos = ((file.substring(0, pos)).getBytes()).length;
                                                int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

                                                Statement stmt2 = db.connection.createStatement();
                                                ResultSet rs2;
                                                rs2 = stmt2.executeQuery("select max(customer_id) as mx from customer");
                                                rs2.next();
                                                out.println("OOOO" + rs2.getString("mx"));
                                                saveFile = "C:/Users/Al-Amin/Documents/NetBeansProjects/JobPortal/web/img/" + rs2.getString("mx") + ".jpg";
                                                //saveFile = "C:/uploadDir2/" + saveFile;
                                                //out.print(saveFile);
                                                File ff = new File(saveFile);

                                                try {
                                                    FileOutputStream fileOut = new FileOutputStream(ff);
                                                    fileOut.write(dataBytes, startPos, (endPos - startPos));
                                                    fileOut.flush();
                                                    fileOut.close();

                                                } catch (Exception e) {
                                                    out.println(e);
                                                }

                                            }
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                        <input type=\"file\" name=\"file\" value=\"\" /><br>\n");
      out.write("                                        <input type=\"hidden\" name=\"is_image_selected\" value=\"yes\">\n");
      out.write("\n");
      out.write("                                        <input type=\"submit\" value=\"Upload\" name=\"submit\" />\n");
      out.write("                                    </form>\n");
      out.write("                                    ");

                                    } else {

                                        String saveFile = new String();
                                        String contentType = request.getContentType();
                                        if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
                                            DataInputStream in = new DataInputStream(request.getInputStream());

                                            int formDataLength = request.getContentLength();
                                            byte dataBytes[] = new byte[formDataLength];
                                            int byteRead = 0;
                                            int totalBytesRead = 0;

                                            while (totalBytesRead < formDataLength) {
                                                byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
                                                totalBytesRead += byteRead;
                                            }
                                            String file = new String(dataBytes);

                                            saveFile = file.substring(file.indexOf("filename=\"") + 10);
                                            saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
                                            saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));

                                            int lastIndex = contentType.lastIndexOf("=");

                                            String boundary = contentType.substring(lastIndex + 1, contentType.length());

                                            int pos;

                                            pos = file.indexOf("filename=\"");
                                            pos = file.indexOf("\n", pos) + 1;
                                            pos = file.indexOf("\n", pos) + 1;
                                            pos = file.indexOf("\n", pos) + 1;

                                            int boundaryLocation = file.indexOf(boundary, pos) - 4;

                                            int startPos = ((file.substring(0, pos)).getBytes()).length;
                                            int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

                                            Statement stmt2 = db.connection.createStatement();
                                            ResultSet rs2;
                                            rs2 = stmt2.executeQuery("select max(customer_id) as mx from customer");
                                            rs2.next();

                                            saveFile = "C:/Users/Al-Amin/Documents/NetBeansProjects/JobPortal/web/img/" + rs2.getString("mx") + ".jpg";
                                            //saveFile = "C:/uploadDir2/" + saveFile;
                                            //out.print(saveFile);
                                            File ff = new File(saveFile);

                                            try {
                                                FileOutputStream fileOut = new FileOutputStream(ff);
                                                fileOut.write(dataBytes, startPos, (endPos - startPos));
                                                fileOut.flush();
                                                fileOut.close();

                                            } catch (Exception e) {
                                                out.println(e);
                                            }

                                        }

                                    
      out.write("\n");
      out.write("                                    Image Selected.\n");
      out.write("                                    <form method=\"get\">\n");
      out.write("                                        <input type=\"hidden\" name=\"is_image_selected\" value=\"no\">\n");
      out.write("                                        <button type=\"submit\">reset</button>\n");
      out.write("\n");
      out.write("                                    </form>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            <form action=\"signupfinish.jsp\" method=\"POST\">\n");
      out.write("                                <div class=\"white-container sign-up-form\">\n");
      out.write("                                    <div>\n");
      out.write("                                        <h2>2. A Little bit more about you</h2>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <section>\n");
      out.write("\n");
      out.write("                                            <h6 class=\"label\">Your Current Location</h6>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"customer_location\" placeholder=\"Location\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <h6 class=\"label\">About You</h6>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-sm-10\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"customer_details\" placeholder=\"About You in 200 words\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </section>\n");
      out.write("                                        <section>\n");
      out.write("\n");
      out.write("                                            <h6 class=\"label\">Your Educational Qualification</h6>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"customer_department\" placeholder=\"Department\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"customer_degree\" placeholder=\"Highest Degree Acquired\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"customer_university\" placeholder=\"University\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"customer_university_location\" placeholder=\"University Location\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </section>\n");
      out.write("                                        <section>\n");
      out.write("                                            <h6 class=\"label\">Your Skills</h6>\n");
      out.write("\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"skill_name\" placeholder=\"Write Your Skills, Separated by commas(,)\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </section>\n");
      out.write("                                        <section>\n");
      out.write("                                            <h6 class=\"label\">If You are a job seeker</h6>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <select name=\"job_type\">\n");
      out.write("                                                        <option value=\"0\">Job Type</option>\n");
      out.write("                                                        <option value=\"1\">None</option>\n");
      out.write("                                                        <option value=\"2\">Front End</option>\n");
      out.write("                                                        <option value=\"3\">Back End</option>\n");
      out.write("                                                        <option value=\"4\">Both</option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <select name=\"working_hours\">\n");
      out.write("                                                        <option value=\"0\">Working Hours</option>\n");
      out.write("                                                        <option value=\"1\">1</option>\n");
      out.write("                                                        <option value=\"2\">2</option>\n");
      out.write("                                                        <option value=\"3\">3</option>\n");
      out.write("                                                        <option value=\"4\">4</option>\n");
      out.write("                                                        <option value=\"5\">5</option>\n");
      out.write("                                                        <option value=\"6\">6</option>\n");
      out.write("                                                        <option value=\"7\">7</option>\n");
      out.write("                                                        <option value=\"8\">8(fulltime)</option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                                <div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"number\" class=\"form-control\" name=\"experience\" placeholder=\"Your working experience(in years)\" default=\"0\">\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        </section>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <hr class=\"mt60\">\n");
      out.write("                                    <input type=\"hidden\" name=\"customer_id\" value=");
      out.print(customer_id);
      out.write(">\n");
      out.write("                                    <div class=\"clearfix\">\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-default btn-large pull-right\">Finish</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div> <!-- end .page-content -->\n");
      out.write("                    </div>\n");
      out.write("                </div> <!-- end .container -->\n");
      out.write("            </div> <!-- end #page-content -->\n");
      out.write("\n");
      out.write("\n");
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
