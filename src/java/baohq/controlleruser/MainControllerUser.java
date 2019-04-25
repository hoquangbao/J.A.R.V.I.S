/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.controlleruser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class MainControllerUser extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String USER_SEARCH_AVENGER = "searchforuser.jsp";
    private static final String USER_SEARCH_MISSION = "searchmissionuser.jsp";
    private static final String USER_SEARCH_MARK = "searchmarkuser.jsp";

    private static final String SEARCH_USER = "SearchControllerUser";
    private static final String LIST_AVENGER = "AllListAvengerUser";
    private static final String LIST_MISSION = "AllListMissionUser";
    private static final String SEARCHMISSION_USER = "SearchMissionControllerUser";
    private static final String SEARCHMARK_USER = "SearchMarkControllerUser";

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
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (action.equals("Search ")) {
                url = SEARCH_USER;
            } else if (action.equals("SearchUser")) {
                url = USER_SEARCH_AVENGER;
            } else if (action.equals("AllListAvenger")) {
                url = LIST_AVENGER;
            } else if (action.equals("AllListMission")) {
                url = LIST_MISSION;
            } else if (action.equals("SearchMission")) {
                url = USER_SEARCH_MISSION;
            } else if (action.equals("SearchMissionUser")) {
                url = SEARCHMISSION_USER;
            } else if (action.equals("Search Mark")) {
                url = SEARCHMARK_USER;
            } else if (action.equals("SearchMark")) {
                url = USER_SEARCH_MARK;
            } else {
                request.setAttribute("ERROR", "Action not suppport");
            }
        } catch (Exception e) {
            log("Error at MainControllerUser : " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
