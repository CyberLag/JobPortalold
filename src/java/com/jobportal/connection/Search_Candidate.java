/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobportal.connection;

import static com.jobportal.connection.Database.resultset;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 *
 * @author shuvo
 */
public class Search_Candidate {

    public static String[] name = new String[10000], email = new String[10000], customer_id = new String[10000], skills = new String[10000];
    public static int[] invited = new int[10000];
    private Statement statement;
    ResultSet result;
    int j;
    private String query;

    public Search_Candidate() {
        Arrays.fill(name, "");
        Arrays.fill(email, "");
        Arrays.fill(customer_id, "");
        Arrays.fill(skills, "");
        Arrays.fill(invited, 0);
    }

    public int Search(String skill,String job_id) throws SQLException {
        int i = 0;
        DatabaseMetaData dbmd = Database.connection.getMetaData();
        query = String.format("select * from customer where customer_id in (select customer_id from Customer_skill where skill_id in ( select skill_id from skill where lower(skill_name) like lower('%s%s')))", skill, "%");
        statement = Database.connection.createStatement();
        resultset = statement.executeQuery(query);
        while (resultset.next()) {
            name[++i] = resultset.getString("fullname");
            email[i] = resultset.getString("email");
            customer_id[i] = resultset.getInt("customer_id") + "";
            query = String.format("Select skill_name from skill where skill_id in(select skill_id from customer_skill where customer_id=%d)", resultset.getInt("customer_id"));
            statement = Database.connection.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                skills[i] += result.getString("skill_name") + " / ";
            }
            query = String.format("Select * from invited_jobs where job_id=%d and customer_id=%d", Integer.parseInt(job_id),resultset.getInt("customer_id"));
            statement = Database.connection.createStatement();
            result = statement.executeQuery(query);
            if (result.next()) {
                invited[i] =1;
            }
        }
        return i;
    }
}
