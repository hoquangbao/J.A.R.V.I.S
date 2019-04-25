/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.controllers;

import baohq.beans.JavaBean;
import baohq.dtos.RegistrationDTO_Mission;
import baohq.dtos.RegistrationErrorObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class SetMissionController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "searchmission.jsp";
    private static final String INVALID = "setmission.jsp";
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
            String missionID = request.getParameter("txtMissionID");
            String username = request.getParameter("txtUsername");
            RegistrationErrorObject errorObject = new RegistrationErrorObject();
            boolean valid = true;
            if(missionID.length() == 0){
                valid = false;
                errorObject.setMissionIDError("MissionID can't be blank!");
            }
            if(username.length() == 0){
                valid = false;
                errorObject.setUsernameError("AvengerID can't be blank!");
            }
            if(valid){
                JavaBean beans = new JavaBean();
                RegistrationDTO_Mission dtoMission = new RegistrationDTO_Mission(missionID, username);
                beans.setdTO_Mission(dtoMission);
                if(beans.setMission()){
                    url = SUCCESS;
                }else{
                    request.setAttribute("ERROR", "Set mission failed!");
                    url = INVALID;
                }
            }else{
                request.setAttribute("INVALID", errorObject);
            }
        } catch (Exception e) {
            log("Error at SetMissionController: " + e.getMessage());
        }finally{
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
