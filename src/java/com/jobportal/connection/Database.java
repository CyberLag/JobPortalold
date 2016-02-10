/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobportal.connection;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shuvo
 */
public class Database{

    public static Connection connection;
    public static ResultSet resultset;
    public static String query;

    public Database() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jobportal", "sust");
            DatabaseMetaData dbmd = connection.getMetaData();
        } catch (SQLException ex) {
        }
    }
}
