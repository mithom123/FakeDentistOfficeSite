/******************************************************************************
 * Mitchell Thomason
 * Java 3
 * Final Project
 *****************************************************************************/
package Business;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author mitho
 */
public class AppointmentList {
    private int count = 0;
    public ArrayList<Appointment> aArr = new ArrayList<>();
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
    /**Finds all of the appointments of the dentist and puts them in an arrayList*/
    public void findAppointments(String id) {
        try {
            count = 0;
            String sql = "SELECT patId FROM Appointments WHERE dentId = '" + id + "'";
            Statement stmt = connectDB();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Appointment a1 = new Appointment();
                a1.selectDB(rs.getString("patId"));
                aArr.add(a1);
                count++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
