
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";

    private static final String ADMIN_SEARCH_AVENGER = "search.jsp";
    private static final String ADMIN_SEARCH_MARK = "searchmark.jsp";
    private static final String ADMIN_SEARCH_MISSION = "searchmission.jsp";

    private static final String SETNEWMISSION = "SetMissionController";

    private static final String SHOWLIST_MISSION = "AllMissionController";
    private static final String SHOWLIST_AVENGER = "AllAvengerController";
    private static final String SEARCH = "SearchController";
    private static final String SEARCH_ADMIN_MARK = "SearchControllerMark";
    private static final String SEARCH_ADMIN_MISSION = "SearchControllerMission";
    private static final String INSERT = "InsertController";
    private static final String INSERT_MARK = "InsertControllerMark";
    private static final String INSERT_MISSION = "InsertControllerMission";
    private static final String SETMISSION = "setmission.jsp";
    private static final String DELETE = "DeleteController";
    private static final String DELETE_MARK = "DeleteControllerMark";
    private static final String DELETE_MISSION = "DeleteControllerMission";
    private static final String UPDATE = "UpdateController";
    private static final String UPDATE_MISSION = "UpdateControllerMission";


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
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("ShowAllListMission")) {
                url = SHOWLIST_MISSION;
            } else if (action.equals("ListAvenger")) {
                url = SHOWLIST_AVENGER;
            } else if (action.equals("Search")) {
                url = SEARCH;
            } else if (action.equals("Insert")) {
                url = INSERT;
            } else if (action.equals("InsertMark")) {
                url = INSERT_MARK;
            } else if (action.equals("InsertMission")) {
                url = INSERT_MISSION;
            } else if (action.equals("SetMission")) {
                url = SETMISSION;
            } else if (action.equals("SetNewMission")) {
                url = SETNEWMISSION;
            } else if (action.equals("Delete")) {
                url = DELETE;
            } else if (action.equals("Edit")) {
                url = UPDATE;
            } else if (action.equals("Update")) {
                url = UPDATE;
            } else if (action.equals("EditMission")) {
                url = UPDATE_MISSION;
            } else if (action.equals("UpdateMission")) {
                url = UPDATE_MISSION;
            } else if (action.equals("SearchAvenger")) {
                url = ADMIN_SEARCH_AVENGER;
            } else if (action.equals("SearchMark")) {
                url = ADMIN_SEARCH_MARK;
            } else if (action.equals("SearchMission")) {
                url = ADMIN_SEARCH_MISSION;
            } else if (action.equals("SearchMarkAdmin")) {
                url = SEARCH_ADMIN_MARK;
            } else if (action.equals("SearchMissionAdmin")) {
                url = SEARCH_ADMIN_MISSION;
            } else if (action.equals("DeleteMission")) {
                url = DELETE_MISSION;
            } else if (action.equals("DeleteMark")) {
                url = DELETE_MARK;
            } else {
                request.setAttribute("ERROR", "Action is not supported!");
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.getMessage());
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
