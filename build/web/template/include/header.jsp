<%-- 
    Document   : header
    Created on : May 4, 2015, 4:37:04 PM
    Author     : shuvo
--%>

<%@page import="com.jobportal.connection.Database"%>
<%@page import="com.jobportal.connection.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><%
    String email = "", password = "", attempt = request.getParameter("attempt"), login = "";
    String mail = request.getParameter("email"), pass = request.getParameter("password");
    int new_comer = 0;
    Login lgn = new Login();
    if (request.getRequestURI().endsWith("profile.jsp")) {
        String[] info = lgn.GetInfo(session.getAttribute("id") + "");
        mail = info[1];
        pass = info[2];
        out.print(mail + pass);
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
%>
<div class="header-top-bar">
    <div class="container">


        <%if (!login.equals("true")) {
                session.setAttribute("customer_id", "0");%>

        <!-- Header Register -->
        <div class="header-register">
            <a href="signup1.jsp" class="logoutbtn">Register</a>
            <div>
                <form action="#">
                    <input type="text" class="form-control" placeholder="Username">
                    <input type="email" class="form-control" placeholder="Email">
                    <input type="password" class="form-control" placeholder="Password">
                    <input type="submit" class="btn btn-default" value="Register">
                </form>
            </div>
        </div> <!-- end .header-register -->

        <!-- Header Login -->
        <div class="header-login">
            <a href="" class="btn btn-link">Login</a>
            <div>
                <form action="homepage.jsp" method="post">
                    <input type="email" name="email" class="form-control" placeholder="Email address">
                    <input type="password"  name="password" class="form-control" placeholder="Password">
                    <input name="attempt" value="yes" style="display:none">
                    <input type="submit" class="btn btn-default" value="Login">
                    <a href="#" class="btn btn-link">Forgot Password?</a>
                </form>
            </div>
        </div> <!-- end .header-login -->
        <%} else {
            session.setAttribute("customer_id", "" + lgn.Customer_Id(email, password));%> 
        <div class="header-login">
            <a href="homepage.jsp?attempt=no" class="logoutbtn">Logout</a>
        </div>
        <%}%>

    </div> <!-- end .container -->
</div> <!-- end .header-top-bar -->
<div class="header-nav-bar">
    <div class="container">

        <!-- Logo -->
        <div class="css-table logo">
            <div class="css-table-cell">
                <a href="index.html">
                    <img src="img/header-logo.png" alt="">
                </a> <!-- end .logo -->
            </div>
        </div>

        <!-- Mobile Menu Toggle -->
        <a href="#" id="mobile-menu-toggle"><span></span></a>

        <!-- Primary Nav -->
        <nav>
            <ul class="primary-nav">
                <li>
                    <a href="homepage.jsp">Home</a>
                </li>
                <li class="has-submenu">
                    <a href="jobs.html">Jobs</a>
                    <ul>
                        <li><a href="jobs.html">Applied Jobs</a></li>
                        <li><a href="jobs-single.html">Offered Jobs</a></li>
                    </ul>
                </li>
                <li><a href="">About Us</a></li>
            </ul>
        </nav>
    </div> <!-- end .container -->

    <div id="mobile-menu-container" class="container">
        <div class="login-register"></div>
        <div class="menu"></div>
    </div>
</div> <!-- end .header-nav-bar -->