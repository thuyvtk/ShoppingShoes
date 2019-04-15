/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thuy.tbl_account.RegistrationError;
import thuy.tbl_account.tbl_accountDAO;
import thuy.tbl_account.tbl_accountDTO;
import thuy.tbl_customer.tbl_customerDAO;
import thuy.tbl_customer.tbl_customerDTO;

/**
 *
 * @author vtkth
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    private final String LOGIN_PAGE = "login.html";
    private final String REGISTER_ERROR_PAGE = "register.jsp";

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
        PrintWriter out = response.getWriter();
        String url = REGISTER_ERROR_PAGE;
        RegistrationError errors = new RegistrationError();

        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String lastname = request.getParameter("txtLastname");
        String middleName = request.getParameter("txtMiddleName");
        String firstname = request.getParameter("txtFirstName");
        String address = request.getParameter("txtAddress");
        String phone = request.getParameter("txtPhone");

        tbl_customerDAO cusDAO = new tbl_customerDAO();
        tbl_accountDAO accountDAO = new tbl_accountDAO();
        try {

            boolean errFound = false;

            if (username.trim().length() < 6 || username.length() > 20) {
                errFound = true;
                errors.setUsernameLengthErr("Username lenght has 6 - 20 character!");
            }
            if (password.trim().length() < 6 || password.length() > 30) {
                errFound = true;
                errors.setPasswordLengthErr("Password lenght has 6 - 30 character!");
            }
            if (!confirm.trim().equals(password.trim())) {
                errFound = true;
                errors.setConfirmNotMatch("Confirm does not match password!");
            }
            if (lastname.trim().isEmpty()) {
                errFound = true;
                errors.setLastnameLenghtErr("Last name must not be blank!");
            }
            if (lastname.trim().length() > 15) {
                errFound = true;
                errors.setLastnameLenghtErr("Last name lenght has maximum 15 characters!");
            }
            if (middleName.trim().length() > 30) {
                errFound = true;
                errors.setLastnameLenghtErr("Middle name lenght has maximum 30 characters!");
            }
            if (firstname.trim().length() > 15) {
                errFound = true;
                errors.setLastnameLenghtErr("First name lenght has maximum 15 characters!");
            }
            if (address.trim().length() > 250) {
                errFound = true;
                errors.setAddressLenghtErr("Address lenght has maximum 250 characters!");
            }
            if (address.trim().isEmpty()) {
                errFound = true;
                errors.setAddressLenghtErr("Address must not be blank!");
            }
            if (!phone.trim().matches("^0\\d+$") || phone.trim().length() < 9 || phone.trim().length() > 11) {
                errFound = true;
                errors.setPhoneErr("Phone lenght has 9 - 11 digits and begin 0!");
            }

            String cusID = cusDAO.getCusIDInsert();
            tbl_customerDTO customerDTO = new tbl_customerDTO(cusID, lastname, middleName, firstname, address, phone, 1);
            request.setAttribute("CUSTOMER", customerDTO);
            
            tbl_accountDTO accountDTO = new tbl_accountDTO(username, password, cusID);
            request.setAttribute("ACCOUNT", accountDTO);
            request.setAttribute("CONFIRM", confirm);
            if (errFound) {
                request.setAttribute("REGISTER_ERROR", errors);
            } else {

                boolean insertCus = cusDAO.insertCustomer(customerDTO);

                boolean insertAccount = accountDAO.insertAccount(accountDTO);

                if (insertCus == true && insertAccount == true) {
                    url = LOGIN_PAGE;
                }
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate")) {
                errors.setDupplcateUsername(username + " is existed!");
            }
            log("RegisterServlet _ SQL " + e.getMessage());
            request.setAttribute("REGISTER_ERROR", errors);
        } catch (NamingException e) {
            log("RegisterServlet _ Class not found " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
