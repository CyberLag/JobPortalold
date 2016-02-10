package com.jobportal.connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static com.jobportal.connection.Database.resultset;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 *
 * @author shuvo
 */
public class Jobs {

    public static String[] email=new String[10000],title = new String[10000], descrip = new String[10000], pdate = new String[10000], valid = new String[10000];
    public static String[] house = new String[10000], street = new String[10000], city = new String[10000], country = new String[10000];
    private Statement statement;
    public static String[] skills = new String[100000], name = new String[1000];
    public static int[] job_id = new int[1000000], applied = new int[100000], ques_flag = new int[100000], customer_id = new int[1000];
    ResultSet result;
    int j;
    private String query;

    public Jobs() {
        Arrays.fill(email, "");
        Arrays.fill(title, "");
        Arrays.fill(descrip, "");
        Arrays.fill(pdate, "");
        Arrays.fill(valid, "");
        Arrays.fill(house, "");
        Arrays.fill(street, "");
        Arrays.fill(city, "");
        Arrays.fill(country, "");
        Arrays.fill(skills, " ");
        Arrays.fill(name, " ");
        Arrays.fill(job_id, 0);
        Arrays.fill(customer_id, 0);
    }

    public int SearchJobs(String tag, int customer_id) throws SQLException {
        int i = 0;
        DatabaseMetaData dbmd = Database.connection.getMetaData();
        if (tag.length() != 0) {
            query = String.format("Select * from Job where job_id in (select job_id from job_skill where skill_id in (select skill_id from skill where lower(skill_name) like lower('%s') )) order by posting_date asc", "%" + tag + "%");
        } else {
            query = String.format("Select * from Job order by posting_date asc");
        }
        statement = Database.connection.createStatement();
        resultset = statement.executeQuery(query);
        while (resultset.next()) {
            ++i;
            job_id[i] = resultset.getInt("job_id");
            title[i] = resultset.getString("title");
            descrip[i] = resultset.getString("description");
            pdate[i] = resultset.getString("posting_date");
            valid[i] = resultset.getString("validity");
            house[i] = resultset.getString("place_house");
            street[i] = resultset.getString("place_street");
            city[i] = resultset.getString("place_city");
            country[i] = resultset.getString("place_country");
            query = String.format("Select skill_name from skill where skill_id in(select skill_id from job_skill where job_id=%d)", resultset.getInt("job_id"));
            statement = Database.connection.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                skills[i] += result.getString("skill_name") + '-';
            }
            //to check if he is applied for thsi job before
            query = String.format("Select customer_id from Applied_jobs where job_id=%d and customer_id = %d", resultset.getInt("job_id"), customer_id);
            statement = Database.connection.createStatement();
            result = statement.executeQuery(query);
            if (result.next()) {
                applied[i] = 1;
            } else {
                applied[i] = 0;
            }
            //to check if the job has mcQ question
            query = String.format("Select * from Question where job_id=%d", resultset.getInt("job_id"));
            statement = Database.connection.createStatement();
            result = statement.executeQuery(query);
            if (result.next()) {
                ques_flag[i] = 1;
            } else {
                ques_flag[i] = 0;
            }

        }
        return i;
    }

    public boolean ApplyForJobs(String customer_id, String job_id) throws SQLException {
        DatabaseMetaData dbmd = Database.connection.getMetaData();
        try {
            query = String.format("insert into applied_jobs (customer_id,job_id) values (%d,%d)", Integer.parseInt(customer_id), Integer.parseInt(job_id));
            statement = Database.connection.createStatement();
            resultset = statement.executeQuery(query);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public int AppliedJobs(String customer_id) throws SQLException {
        int i = 0;
        DatabaseMetaData dbmd = Database.connection.getMetaData();
        try {
            query = String.format("Select * from Job where job_id in (select job_id from applied_jobs where customer_id=%d )", Integer.parseInt(customer_id));
            statement = Database.connection.createStatement();
            resultset = statement.executeQuery(query);
            while (resultset.next()) {
                ++i;
                job_id[i] = resultset.getInt("job_id");
                title[i] = resultset.getString("title");
                descrip[i] = resultset.getString("description");
                pdate[i] = resultset.getString("posting_date");
                house[i] = resultset.getString("place_house");
                street[i] = resultset.getString("place_street");
                city[i] = resultset.getString("place_city");
                country[i] = resultset.getString("place_country");
                query = String.format("Select skill_name from skill where skill_id in(select skill_id from job_skill where job_id=%d)", resultset.getInt("job_id"));
                statement = Database.connection.createStatement();
                result = statement.executeQuery(query);
                while (result.next()) {
                    skills[i] += result.getString("skill_name") + "/";
                }
            }
            return i;
        } catch (Exception e) {
        }
        return 0;
    }

    public int OfferedJobs(String customer_id) throws SQLException {
        int i = 0;
        DatabaseMetaData dbmd = Database.connection.getMetaData();
        try {
            query = String.format("Select * from Job where job_id in (select job_id from Posted_jobs where customer_id=%d )", Integer.parseInt(customer_id));
            statement = Database.connection.createStatement();
            resultset = statement.executeQuery(query);
            while (resultset.next()) {
                ++i;
                job_id[i] = resultset.getInt("job_id");
                title[i] = resultset.getString("title");
                descrip[i] = resultset.getString("description");
                pdate[i] = resultset.getString("posting_date");
                house[i] = resultset.getString("place_house");
                street[i] = resultset.getString("place_street");
                city[i] = resultset.getString("place_city");
                country[i] = resultset.getString("place_country");
                query = String.format("Select skill_name from skill where skill_id in(select skill_id from job_skill where job_id=%d)", resultset.getInt("job_id"));
                statement = Database.connection.createStatement();
                result = statement.executeQuery(query);
                while (result.next()) {
                    skills[i] += result.getString("skill_name") + " / ";
                }
            }
            return i;
        } catch (Exception e) {
        }
        return 0;
    }

    public int Applied_List(String id) throws SQLException {
        int i = 0;
        DatabaseMetaData dbmd = Database.connection.getMetaData();
        try {
            query = String.format("Select * from Customer  where customer_id in (select customer_id  from Applied_jobs where job_id=%d )", Integer.parseInt(id));
            statement = Database.connection.createStatement();
            resultset = statement.executeQuery(query);
            while (resultset.next()) {
                ++i;
                customer_id[i] = resultset.getInt("customer_id");
                name[i] = resultset.getString("fullname");
                email[i] = resultset.getString("email");
            }
            return i;
        } catch (NumberFormatException | SQLException e) {
        }
        return 0;
    }

    public boolean InviteForJobs(String customer_id, String job_id) throws SQLException {
        DatabaseMetaData dbmd = Database.connection.getMetaData();
        try {
            query = String.format("delete from INVITED_JOBS where customer_id=%d and job_id =%d ", Integer.parseInt(customer_id), Integer.parseInt(job_id));
            statement = Database.connection.createStatement();
            resultset = statement.executeQuery(query);
            query = String.format("insert into INVITED_JOBS (customer_id,job_id) values (%d,%d)", Integer.parseInt(customer_id), Integer.parseInt(job_id));
            statement = Database.connection.createStatement();
            resultset = statement.executeQuery(query);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
