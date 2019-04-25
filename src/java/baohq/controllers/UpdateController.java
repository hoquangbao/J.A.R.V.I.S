/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.controllers;

import baohq.beans.JavaBean;
import baohq.dtos.RegistrationDTO;
import baohq.dtos.RegistrationErrorObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class UpdateController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String UPDATE = "update.jsp";
    private static final String SUCCESS = "search.jsp";

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
            JavaBean beans = new JavaBean();
            if (action.equals("Edit")) {
                String id = request.getParameter("id");
                beans.setUsername(id);
                RegistrationDTO dto = beans.findLikeByPrimarykey();
                request.setAttribute("DTO", dto);
                url = UPDATE;
            } else if (action.equals("Update")) {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                String avengerName = request.getParameter("txtAvengerName");
                String fullname = request.getParameter("txtFullname");
                String dob = request.getParameter("txtDateOfBirth");
                Date dateOfBirth;
                if (dob.length() != 0) {
                    dateOfBirth = Date.valueOf(dob);
                } else {
                    dateOfBirth = null;
                }
                String role = request.getParameter("txtRole");
                boolean valid = true;
                RegistrationErrorObject errorObject = new RegistrationErrorObject();
                if (username.length() == 0) {
                    valid = false;
                    errorObject.setUsernameError("Username can't be blank!");
                }
                if (password.length() == 0) {
                    valid = false;
                    errorObject.setPasswordError("Password can't be blank!");
                }
                if (avengerName.length() == 0) {
                    valid = false;
                    errorObject.setAvengerNameError("AvengerName can't be blank!");
                }
                if (fullname.length() == 0) {
                    fullname = null;
                }
                if (role.length() == 0) {
                    valid = false;
                    errorObject.setRoleError("Role can't be blank!");
                }
                if (valid) {
                    RegistrationDTO dto = new RegistrationDTO(username, password, avengerName, fullname, role, dateOfBirth);
                    beans.setDto(dto);
                    if (beans.update()) {
                        url = SUCCESS;
                    } else {
                        request.setAttribute("ERROR", "Update Failed!");
                        url = UPDATE;
                    }
                } else {
                    request.setAttribute("INVALID", errorObject);
                }
            } else {
                request.setAttribute("ERROR", "Action not supported!");
            }
        } catch (Exception e) {
            log("Error at Controller: " + e.getMessage());
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
