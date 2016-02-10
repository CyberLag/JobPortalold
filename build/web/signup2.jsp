<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.DataInputStream"%>
<%@page import="oracle.net.aso.p"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.jobportal.connection.Database" %>

<%-- 
    Document   : signup2
    Created on : Apr 30, 2015, 8:19:33 PM
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
        <%-- <a href="mailto:shuvra.dev9@gmail.com?subject=sss&body=ssss" class="btn btn-default pull-left">Apply for this Job</a> --%>
        <%
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

        %>




        <div id="main-wrapper">

            <header id="header" class="header-style-1">
                <%@include file="include/header.jsp" %>
                <div class="header-page-title">
                    <div class="container">
                        <h1>Sign Up</h1>
                    </div>
                </div>
            </header> <!-- end #header -->

            <div id="page-content">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 page-content">
                            <ul class="form-steps four clearfix">
                                <li class="completed">Step 1</li>
                                <li class="active">Step 2</li>
                                <li>Finish</li>

                            </ul>
                            <div class="white-container sign-up-form">
                                <div>
                                    <h2>Your Photo</h2>


                                    <%                                                                //out.print((request.getRequestURL()).toString());
                                        if (request.getParameter("is_image_selected") == null || !request.getParameter("is_image_selected").startsWith("yes")) {
                //request.setAttribute("is_image_selected","yes");
                                    %>
                                    <form method="POST" action="signup2.jsp?is_image_selected=yes" enctype="multipart/form-data" style="width: 110px; padding-top: 5px; height: 65px;">
                                        <%
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
                                        %>

                                        <input type="file" name="file" value="" /><br>
                                        <input type="hidden" name="is_image_selected" value="yes">

                                        <input type="submit" value="Upload" name="submit" />
                                    </form>
                                    <%
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

                                    %>
                                    Image Selected.
                                    <form method="get">
                                        <input type="hidden" name="is_image_selected" value="no">
                                        <button type="submit">reset</button>

                                    </form>
                                    <%}%>
                                </div>
                            </div>
                            <%--end of image input section --%>
                            <form action="signupfinish.jsp" method="POST">
                                <div class="white-container sign-up-form">
                                    <div>
                                        <h2>2. A Little bit more about you</h2>



                                        <section>

                                            <h6 class="label">Your Current Location</h6>

                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="customer_location" placeholder="Location">
                                                </div>
                                            </div>

                                            <h6 class="label">About You</h6>

                                            <div class="row">
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="customer_details" placeholder="About You in 200 words">
                                                </div>
                                            </div>
                                        </section>
                                        <section>

                                            <h6 class="label">Your Educational Qualification</h6>

                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="customer_department" placeholder="Department">
                                                </div>

                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="customer_degree" placeholder="Highest Degree Acquired">
                                                </div>


                                            </div>
                                            <div class="row">

                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="customer_university" placeholder="University">
                                                </div>

                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="customer_university_location" placeholder="University Location">
                                                </div>

                                            </div>
                                        </section>
                                        <section>
                                            <h6 class="label">Your Skills</h6>

                                            <div class="row">

                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="skill_name" placeholder="Write Your Skills, Separated by commas(,)">
                                                </div>


                                            </div>
                                        </section>
                                        <section>
                                            <h6 class="label">If You are a job seeker</h6>
                                        <div class="row">
                                                <div class="col-sm-3">
                                                    <select name="job_type">
                                                        <option value="0">Job Type</option>
                                                        <option value="1">None</option>
                                                        <option value="2">Front End</option>
                                                        <option value="3">Back End</option>
                                                        <option value="4">Both</option>
                                                    </select>
                                                </div>
                                                <div class="col-sm-3">
                                                    <select name="working_hours">
                                                        <option value="0">Working Hours</option>
                                                        <option value="1">1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                        <option value="6">6</option>
                                                        <option value="7">7</option>
                                                        <option value="8">8(fulltime)</option>
                                                    </select>
                                                </div>

                                                <div class="col-sm-4">
                                                    <input type="number" class="form-control" name="experience" placeholder="Your working experience(in years)" default="0">
                                                </div>


                                        </div>
                                        </section>


                                    </div>

                                    <hr class="mt60">
                                    <input type="hidden" name="customer_id" value=<%=customer_id%>>
                                    <div class="clearfix">
                                        <button type="submit" class="btn btn-default btn-large pull-right">Finish</button>
                                    </div>
                                </div>
                            </form>
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


<%
    } catch (Exception e) {
        out.println("Exception : " + e.getMessage() + "");
    }
%>