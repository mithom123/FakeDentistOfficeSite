/******************************************************************************
 * Mitchell Thomason
 * Java 3
 * Final Project
 *****************************************************************************/
package Business;

import java.sql.*;

/**
 *
 * @author rstho
 */
public class Appointment {
    String apptDateTime;
    String patId;
    String dentId;
    String procCode;
    /**Getter for the apptDateTime variable*/
    public String getApptDateTime() {
        return apptDateTime;
    }
    /**Getter for the patId variable*/
    public String getPatId() {
        return patId;
    }
    /**Getter for the dentId variable*/
    public String getDentId() {
        return dentId;
    }
    /**Getter for the procCode variable*/
    public String getProcCode() {
        return procCode;
    }
    /**Connects to the database and sends the created statement to the calling method*/
    private Statement connectDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:ucanaccess://E:" +
                    "\\DentistOfficeACCDB.accdb");
            Statement stmt = conn.createStatement();
            return stmt;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    /**Pulls the appointment information out of the database either by the patId or the dentId depending on the logged in user and sets the information to the variables*/
    public void selectDB(String id) {
        try {
            String sql = "";
            if (id.startsWith("A")) {
                sql = "SELECT * FROM Appointments WHERE patId = '" + id + "'";
            } else if (id.startsWith("D")) {
                sql = "SELECT * FROM Appointments WHERE dentId = '" + id + "'";
            }
            Statement stmt = connectDB();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                apptDateTime = rs.getString("apptDateTime");
                patId = rs.getString("patId");
                dentId = rs.getString("dentId");
                procCode = rs.getString("procCode");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Inserts all of the input variables into the database*/
    public void InsertDB(String dateTime, String pat, String dent, String proc) {
        try {
            String sql = "INSERT INTO Appointments VALUES ('" + dateTime + "', '" +
                    pat + "', '" + dent + "', '" + proc + "')";
            Statement stmt = connectDB();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Updates the database with all of the input variables where the patId of the logged in patient*/
    public void updateDB(String dateTime, String pat, String dent, String proc) {
        try {
            String sql = "UPDATE Appointments SET apptDateTime = '" + dateTime + "', patId = '"
                    + pat + "', dentId = '" + dent + "', procCode = '" +
                    proc + "' WHERE patId = '" + pat + "'";
            Statement stmt = connectDB();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Deletes all of the information of the logged in dentist*/
    public void deleteDB() {
        try {
            String sql = "DELETE FROM Appointments WHERE patId = " + patId;
            Statement stmt = connectDB();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Pulls any appointment from the database with the same dateTime and dentId as was input*/
    public void checkAvailability(String dateTime, String dId) {
        try {
            String sql = "SELECT * FROM Appointments WHERE apptDateTime = '" + dateTime + "' AND dentId = '" + dId + "'";
            Statement stmt = connectDB();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                apptDateTime = rs.getString("apptDateTime");
                patId = rs.getString("patId");
                dentId = rs.getString("dentId");
                procCode = rs.getString("procCode");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
