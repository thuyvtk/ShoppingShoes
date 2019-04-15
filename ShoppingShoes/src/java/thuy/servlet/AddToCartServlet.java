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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thuy.cart.CartObject;
import thuy.tbl_shoes.Item;
import thuy.tbl_shoes.tbl_shoesDAO;
import thuy.tbl_shoesSize.tbl_shoesSizeDAO;
import thuy.tbl_shoesSize.tbl_shoesSizeDTO;

/**
 *
 * @author vtkth
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {

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

        String shoesID = request.getParameter("pk").trim();
        String lastSearch = request.getParameter("lastSearchValue").trim();
        String priceSizeValue = request.getParameter("cbSize");
        String url = "search?"
                    + "txtSearch=" 
                    + lastSearch;
        try {
            HttpSession session = request.getSession();

            tbl_shoesDAO dao = new tbl_shoesDAO();
            Item item = (Item) dao.getItemObj(shoesID);
            String[] split = priceSizeValue.split("-", 2);
            item.setPrice(Float.parseFloat(split[0]));
            item.setSize(split[1]);
            tbl_shoesSizeDAO shoesSizeDAO = new tbl_shoesSizeDAO();
            tbl_shoesSizeDTO shoesSizeDTO = shoesSizeDAO.getShoesSizeDTO(shoesID, split[1],true);
            item.setQuantity(shoesSizeDTO.getQuantity());

            CartObject cart = (CartObject) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartObject();
            }
            String message = cart.addItemToCart(item);
            session.setAttribute("MESSAGE_QUANTITY", message);
            session.setAttribute("CART", cart);
            url = "search?"
                    + "txtSearch=" + lastSearch;
        } catch (SQLException e) {
            log("SearchServlet _ SQL: " + e.getMessage());
        } catch (NamingException e) {
            log("RegisterServlet _ Class not found " + e.getMessage());
        } finally {
            response.sendRedirect(url);
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
