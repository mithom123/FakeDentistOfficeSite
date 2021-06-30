/******************************************************************************
 * Mitchell Thomason
 * Java 3
 * Final Project
 *****************************************************************************/

import Business.Dentist;
import Business.Patient;
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
@WebServlet(urlPatterns = {"/info"})
public class info extends HttpServlet {

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
        String passwd = request.getParameter("pswdTb");
        String fName = request.getParameter("fNameTb");
        String lName = request.getParameter("lNameTb");
        String eMail = request.getParameter("emailTb");
        if (patient == true) {
            String addr = request.getParameter("addrTb");
            String insCo = request.getParameter("insCoTb");
            Patient p1 = (Patient)ses1.getAttribute("p1");
            p1.updateDB(p1.getPatId(), passwd, fName, lName, addr, eMail, insCo);
            p1.selectDB(p1.getPatId());
            RequestDispatcher rd = request.getRequestDispatcher("/patientHome.jsp");
            rd.forward(request, response);
        } else {
            String office = request.getParameter("officeTb");
            Dentist d1 = (Dentist)ses1.getAttribute("d1");
            d1.updateDB(d1.getId(), passwd, fName, lName, eMail, office);
            d1.selectDB(d1.getId());
            RequestDispatcher rd = request.getRequestDispatcher("/dentistHome.jsp");
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
