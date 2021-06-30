/******************************************************************************
 * Mitchell Thomason
 * Java 3
 * Final Project
 *****************************************************************************/

import Business.*;
import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rstho
 */
@WebServlet(urlPatterns = {"/AppointmentLookup"})
public class AppointmentLookup extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession ses1 = request.getSession();
        boolean patient = (boolean)ses1.getAttribute("patient");
        if (patient == true) {
            Patient p1 = (Patient)ses1.getAttribute("p1");
            Appointment a1 = new Appointment();
            a1.selectDB(p1.getPatId());
            RequestDispatcher rd = request.getRequestDispatcher("/patientAppt.jsp");
            boolean appointment;
            try {
                if (!(a1.getApptDateTime().equals(""))) {
                    ses1.setAttribute("a1", a1);
                    appointment = true;
                    ses1.setAttribute("appointment", appointment);
                    rd.forward(request, response);
                }
            }
            catch (NullPointerException e){
                appointment = false;
                ses1.setAttribute("appointment", appointment);
                rd.forward(request, response);
            }
            catch (Exception e) {
                System.out.println(e);
            }
            
        } else 
        {
            Dentist d1 = (Dentist)ses1.getAttribute("d1");
            Appointment a1 = new Appointment();
            a1.selectDB(d1.getId());
            RequestDispatcher rd = request.getRequestDispatcher("/dentistAppt.jsp");
            try {
                if (!(a1.getApptDateTime().equals(""))) {
                    ses1.setAttribute("a1", a1);
                    rd.forward(request, response);
                }
            }
            catch (NullPointerException e){
                rd.forward(request, response);
            }
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        out.println("In AppointmentLookup DoPost");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
