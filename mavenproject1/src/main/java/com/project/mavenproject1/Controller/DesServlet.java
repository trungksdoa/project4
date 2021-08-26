/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.mavenproject1.Controller;

import com.project.mavenproject1.model.Decentralization;
import com.project.mavenproject1.model.Role;
import com.project.mavenproject1.model.Roles;
import com.project.mavenproject1.service.VwRoleDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trung
 */
public class DesServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            VwRoleDAO dao = new VwRoleDAO();
            request.setAttribute("listdate", dao.findAll());
            request.getRequestDispatcher("decentralization.jsp").forward(request, response);
//            HttpSession session = request.getSession();
//            if (null == session.getAttribute("idUser")) {
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//            } else {
//                int StaffId = (int) session.getAttribute("idUser");
//                if (StaffId == 3) {
//                 
//                } else {
//                    out.println("<script type=\"text/javascript\">");
//                    out.println("alert('You are not authorized to access this site');");
//                    out.println("location='IndexServlet';");
//                    out.println("</script>");
////                    response.sendRedirect("IndexServlet");
//                }
//            }
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
        VwRoleDAO dao = new VwRoleDAO();
        String[] Roleid = request.getParameterValues("roleId");
        String[] CancleOrder = request.getParameterValues("CancleOrder");
        String[] getCrudPrintInvoice = request.getParameterValues("getCrudPrintInvoice");
        String[] getViewReport = request.getParameterValues("getViewReport");
        String[] getManagerRevenueandexpenditure = request.getParameterValues("getManagerRevenueandexpenditure");
        String[] getManagerEmploy = request.getParameterValues("getManagerEmploy");
        String[] getManagerCustomer = request.getParameterValues("getManagerCustomer");
        String[] getDecentralizationid = request.getParameterValues("getDecentralizationid");//Khong lam gi ca :))
        for (int i = 0; i < Roleid.length; i++) {
            Roles roles = dao.findByRoleId(Integer.valueOf(Roleid[i]));
            if (roles != null) {
                Decentralization object = new Decentralization();
                object.setId(roles.getDecentralizationid());
                object.setCancelOrder(Boolean.valueOf(CancleOrder[i]));
                object.setCrudPrintInvoice(Boolean.valueOf(getCrudPrintInvoice[i]));
                object.setManagerCustomer(Boolean.valueOf(getManagerCustomer[i]));
                object.setManagerEmploy(Boolean.valueOf(getManagerEmploy[i]));
                object.setViewReport(Boolean.valueOf(getViewReport[i]));
                object.setManagerRevenueandexpenditure(Boolean.valueOf(getManagerRevenueandexpenditure[i]));
                Decentralization decentralization1 = dao.Update(object);
//                System.out.println(roles.getRoleid());
            }
        }
        response.sendRedirect("DestinationServlet");
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
