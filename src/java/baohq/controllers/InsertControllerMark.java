/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baohq.controllers;

import baohq.beans.JavaBean;
import baohq.dtos.RegistrationDTOMark;
import baohq.dtos.RegistrationErrorObject;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class InsertControllerMark extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "searchmark.jsp";
    private static final String INVALID = "insertmark.jsp";
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
            String markID = request.getParameter("txtMarkID");
            JavaBean beans = new JavaBean();
            RegistrationErrorObject errorObject = new RegistrationErrorObject();
            boolean valid = true;
            if(markID.length() == 0){
                valid = false;
                errorObject.setMarkIDError("MarkID can't be blank!");
            }
            if(valid){
                RegistrationDTOMark dTOMark = new RegistrationDTOMark(markID);
                beans.setdTOMark(dTOMark);
                if(beans.insertMark()){
                    url = SUCCESS;
                }else{
                    request.setAttribute("ERROR", "Insert Failed!");
                    url = INVALID;
                }
            }else{
                request.setAttribute("ERROR", errorObject);
            }
        } catch (Exception e) {
            log("Error at InsertControllerMark: " + e.getMessage());
            if(e.getMessage().contains("duplicate")){
                RegistrationErrorObject errorObject = new RegistrationErrorObject();
                errorObject.setMarkIDError("MarkID already existed!");
                url = INVALID;
                request.setAttribute("ERROR", errorObject);
            }
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
