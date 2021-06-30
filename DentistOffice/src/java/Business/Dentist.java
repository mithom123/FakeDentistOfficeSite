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
public class Dentist {
    /**Creates all of the necessary variables, one for each column in the Dentists table
     */
    String id;
    String passwd;
    String firstName;
    String lastName;
    String email;
    int office;
    /**Getter for the id variable*/
    public String getId() {
        return id;
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
    /**Getter for the email variable*/
    public String getEmail() {
        return email;
    }
    /**Getter for the office variable*/
    public int getOffice() {
        return office;
    }
    /**This method connects to the database and sends the created statement to the calling method*/
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
    /**Pulls the dentists information from the database and sets the variables equal to that information*/
    public void selectDB(String dentistId) {
        try {
            String sql = "SELECT * FROM Dentists WHERE id = '" + dentistId + "'";
            Statement stmt = connectDB();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                id = rs.getString("id");
                passwd = rs.getString("passwd");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                email = rs.getString("email");
                office = Integer.parseInt(rs.getString("office"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Inserts all of the input variables into the database*/
    public void InsertDB(String Id, String fName, String lName, String eMail, String office) {
        try {
            String sql = "INSERT INTO Dentists VALUES ('" + Id + "', '" +
                    fName + "', '" + lName + "', '" + 
                    eMail + "', '" + office + "')";
            Statement stmt = connectDB();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Updates the database with all of the input variables where the dentist id of the logged in dentist*/
    public void updateDB(String Id, String passwd, String fName, String lName, String eMail, String office) {
        try {
            String sql = "UPDATE Dentists SET id = '" + Id + "', passwd = '"
                    + passwd + "', firstName = '" + fName + "', lastName = '" +
                    lName + "', email = '" + eMail +
                    "', office = '" + office + "' WHERE id = '" + Id + "'";
            Statement stmt = connectDB();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Deletes all of the information of the logged in dentist*/
    public void deleteDB() {
        try {
            String sql = "DELETE FROM Dentists WHERE id = '" + id + "'";
            Statement stmt = connectDB();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
