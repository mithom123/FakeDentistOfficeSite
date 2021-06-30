/******************************************************************************
 * Mitchell Thomason
 * Java 3
 * Final Project
 *****************************************************************************/

import Business.*;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/EditAppointment"})
public class EditAppointment extends HttpServlet {

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
        Patient p1 = (Patient)ses1.getAttribute("p1");
        String dateTime = request.getParameter("dateTimeTb");
        String dId = request.getParameter("dentIDTb");
        String procCode = request.getParameter("procCodeTb");
        Appointment a1 = new Appointment();
        RequestDispatcher rd;
        try
        {
            a1 = (Appointment)ses1.getAttribute("a1");
            a1.checkAvailability(dateTime, dId);
            if (a1.getPatId().equals(p1.getPatId())) 
            {
                if (!a1.getProcCode().equals(procCode) || !a1.getDentId().equals(dId) || !a1.getApptDateTime().equals(dateTime)) {
                    a1.deleteDB();
                    a1.updateDB(dateTime, p1.getPatId(), dId, procCode);
                    rd = request.getRequestDispatcher("/patientHome.jsp");
                    rd.forward(request, response);
                }
                else
                {
                    rd = request.getRequestDispatcher("/appointmentExists.jsp");
                    rd.forward(request, response);
                }
            }
            else
            {
                ses1.setAttribute("a1", a1);
                rd = request.getRequestDispatcher("/appointmentError.jsp");
                rd.forward(request, response);
            }
        }
        catch (NullPointerException e)
        {
            a1.InsertDB(dateTime, p1.getPatId(), dId, procCode);
            rd = request.getRequestDispatcher("/appointmentSuccess.jsp");
            rd.forward(request, response);
        }
        catch (Exception e)
        {
            System.out.println(e);
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
