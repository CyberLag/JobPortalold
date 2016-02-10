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
public class HomePage {

    public static String[] title = new String[10000], descrip = new String[100000], pdate = new String[100000], valid = new String[100000];
    public static String[] house = new String[10000], street = new String[100000], city = new String[100000], country = new String[100000];
    String query;
    Statement statement;
    ResultSet resultset;
    int i = 0;

    public HomePage() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DatabaseMetaData dbmd = Database.connection.getMetaData();
    }

    public int LatestJobs() throws SQLException {

        query = String.format("Select * from Job where is_public=1 order by posting_date asc");
        statement = Database.connection.createStatement();
        resultset = statement.executeQuery(query);
        while (resultset.next()) {
            ++i;
            title[i] = resultset.getString("title");
            descrip[i] = resultset.getString("description");
            pdate[i] = resultset.getString("posting_date");
            valid[i] = resultset.getString("validity");
            house[i] = resultset.getString("place_house");
            street[i] = resultset.getString("place_street");
            city[i] = resultset.getString("place_city");
            country[i] = resultset.getString("place_country");
        }
        return i;
    }

    public int PopularJobs() throws SQLException {

        query = String.format("Select * from Job where is_public=1 order by views desc");
        statement = Database.connection.createStatement();
        resultset = statement.executeQuery(query);
        while (resultset.next()) {
            ++i;
            title[i] = resultset.getString("title");
            descrip[i] = resultset.getString("description");
            pdate[i] = resultset.getString("posting_date");
            valid[i] = resultset.getString("validity");
            house[i] = resultset.getString("place_house");
            street[i] = resultset.getString("place_street");
            city[i] = resultset.getString("place_city");
            country[i] = resultset.getString("place_country");
        }
        return i;
    }
}
