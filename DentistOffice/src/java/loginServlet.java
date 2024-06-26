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
 * 
 */
@WebServlet(urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

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
        String id = request.getParameter("idTb");
        String pswd = request.getParameter("pswdTb");
        RequestDispatcher rd;
        boolean patient;
        if (id.startsWith("A")) {
            Patient p1 = new Patient();
            p1.selectDB(id);
            if (p1.getPasswd().equals(pswd)) {
                patient = true;
                ses1.setAttribute("p1", p1);
                ses1.setAttribute("patient", patient);
                rd = request.getRequestDispatcher("/patientHome.jsp");
                rd.forward(request, response);
            } else {
                rd = request.getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            }
        } else if (id.startsWith("D")) {
            Dentist d1 = new Dentist();
            d1.selectDB(id);
            if (d1.getPasswd().equals(pswd)) {
                patient = false;
                ses1.setAttribute("d1", d1);
                ses1.setAttribute("patient", patient);
                rd = request.getRequestDispatcher("/dentistHome.jsp");
                rd.forward(request, response);
            }else {
                rd = request.getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            }
        } else {
            rd = request.getRequestDispatcher("/error.jsp");
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
