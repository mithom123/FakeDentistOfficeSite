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
public class Procedure {
    String procCode;
    String procName;
    String procDesc;
    double cost;
    /**Getter for the procCode variable*/
    public String getProcCode() {
        return procCode;
    }
    /**Getter for the procName variable*/
    public String getProcName() {
        return procName;
    }
    /**Getter for the procDesc variable*/
    public String getProcDesc() {
        return procDesc;
    }
    /**Getter for the cost variable*/
    public double getCost() {
        return cost;
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
    public void selectDB(String code) {
        try {
            String sql = "SELECT * FROM Procedures WHERE procCode = '" + code + "'";
            Statement stmt = connectDB();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                procCode = rs.getString("procCode");
                procName = rs.getString("procName");
                procDesc = rs.getString("procDesc");
                cost = Double.parseDouble(rs.getString("cost"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Inserts all of the input variables into the database*/
    public void InsertDB(String code, String name, String desc, double procCost) {
        try {
            String sql = "INSERT INTO Procedures VALUES ('" + code + "', '" +
                    name + "', '" + desc + "', '" + procCost + "')";
            Statement stmt = connectDB();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Deletes all of the information of the logged in dentist*/
    public void deleteDB() {
        try {
            String sql = "DELETE FROM Procedures WHERE procCode = '" + procCode + "'";
            Statement stmt = connectDB();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
