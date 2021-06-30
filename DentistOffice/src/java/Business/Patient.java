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
public class Patient {
    String patId;
    String passwd;
    String firstName;
    String lastName;
    String addr;
    String email;
    String insCo;
    /**Getter for the patId variable*/
    public String getPatId() {
        return patId;
    }
    /**Getter for the passwd variable*/
    public String getPasswd() {
        return passwd;
    }
    /**Getter for the firstName variable*/
    public String getFirstName() {
        return firstName;
    }
    /**Getter for the lastName variable*/
    public String getLastName() {
        return lastName;
    }
    /**Getter for the addr variable*/
    public String getAddr() {
        return addr;
    }
    /**Getter for the email variable*/
    public String getEmail() {
        return email;
    }
    /**Getter for the insCo variable*/
    public String getInsCo() {
        return insCo;
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
    public void selectDB(String patientId) {
        try {
            String sql = "SELECT * FROM Patients WHERE patId = '" + patientId + "'";
            Statement stmt = connectDB();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                patId = rs.getString("patId");
                passwd = rs.getString("passwd");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                addr = rs.getString("addr");
                email = rs.getString("email");
                insCo = rs.getString("insCo");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Inserts all of the input variables into the database*/
    public void InsertDB(String Id, String passwd, String fName, String lName, String address, String eMail, String insComp) {
        try {
            String sql = "INSERT INTO Patients VALUES ('" + Id + "', '" +
                    passwd + "', '" + fName + "', '" + lName + "', '" + 
                    address + "', '" + eMail + "', '" + insComp + "')";
            Statement stmt = connectDB();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Updates the database with all of the input variables where the patId of the logged in patient*/
    public void updateDB(String Id, String passwd, String fName, String lName, String address, String eMail, String insComp) {
        try {
            String sql = "UPDATE Patients SET patId = '" + Id + "', passwd = '"
                    + passwd + "', firstName = '" + fName + "', lastName = '" +
                    lName + "', addr = '" + address + "', email = '" + eMail +
                    "', insCo = '" + insComp + "' WHERE patId = '" + Id + "'";
            Statement stmt = connectDB();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Deletes all of the information of the logged in dentist*/
    public void deleteDB() {
        try {
            String sql = "DELETE FROM Patients WHERE patId = " + patId;
            Statement stmt = connectDB();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
