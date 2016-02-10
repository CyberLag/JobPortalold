package com.jobportal.connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shuvo
 */
public class Login {

    public static String name;
    String query;
    Statement statement;
    ResultSet resultset;
    int i = 0;

    public Login() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

    }

    public boolean Login(String email, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Database db = new Database();
        DatabaseMetaData dbmd = Database.connection.getMetaData();
        if (email == null || password == null) {
            return false;
        }
        query = String.format("Select * from Customer where email='%s' and password='%s'", email, password);
        statement = Database.connection.createStatement();
        resultset = statement.executeQuery(query);
        while (resultset.next()) {
            name = resultset.getString("fullname");
            return true;
        }
        return false;

    }

    public int Customer_Id(String email, String password) throws SQLException {

        DatabaseMetaData dbmd = Database.connection.getMetaData();
        query = String.format("Select customer_id from Customer where email='%s' and password='%s'", email, password);
        statement = Database.connection.createStatement();
        resultset = statement.executeQuery(query);
        while (resultset.next()) {
            return resultset.getInt("customer_id");
        }
        return 0;

    }

    public String[] GetInfo(String id) throws SQLException {
        String[] info = new String[3];
        DatabaseMetaData dbmd = Database.connection.getMetaData();
        query = String.format("Select * from Customer where customer_id=%d", Integer.parseInt(id));
        statement = Database.connection.createStatement();
        resultset = statement.executeQuery(query);
        while (resultset.next()) {
            info[1] = resultset.getString("email");
            info[2] = resultset.getString("password");
        }
        return info;
    }
}
