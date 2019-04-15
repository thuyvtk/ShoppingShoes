/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thuy.cart.CartObject;
import thuy.tbl_order.tbl_orderDAO;
import thuy.tbl_order.tbl_orderDTO;
import thuy.tbl_orderDetail.tbl_orderDetailDAO;
import thuy.tbl_orderDetail.tbl_orderDetailDTO;
import thuy.tbl_shoes.Item;
import thuy.tbl_shoes.tbl_shoesDAO;
import thuy.tbl_shoesSize.tbl_shoesSizeDAO;
import thuy.tbl_shoesSize.tbl_shoesSizeDTO;

/**
 *
 * @author vtkth
 */
@WebServlet(name = "ConfirmOrderServlet", urlPatterns = {"/ConfirmOrderServlet"})
public class ConfirmOrderServlet extends HttpServlet {

    private final String ERROR_PAGE = "errorPage.jsp";
    private final String SEARCH_PAGE = "searchPage.jsp";

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
        String url = ERROR_PAGE;
        try {
            HttpSession session = request.getSession(false);

            CartObject cart = (CartObject) session.getAttribute("CART");

            tbl_orderDTO orderDTO = (tbl_orderDTO) session.getAttribute("ORDER");
            orderDTO.setTotal(cart.getTotal());
            tbl_orderDAO orderDAO = new tbl_orderDAO();
            boolean resultOrder = orderDAO.insertOrder(orderDTO);

            boolean resultDetail = false;
            boolean updateShoes = false;
            boolean updateShoesSize = false;
            tbl_orderDetailDAO orderDetailDAO = new tbl_orderDetailDAO();
            tbl_shoesSizeDAO shoesSizeDAO = new tbl_shoesSizeDAO();
            Map<Item, Integer> items = cart.getItems();
            for (Map.Entry<Item, Integer> entry : items.entrySet()) {
                Item item = entry.getKey();
                tbl_shoesSizeDTO shoesSizeDTO = shoesSizeDAO.getShoesSizeDTO(item.getShoesID(), item.getSize(), true);
                tbl_orderDetailDTO dto = new tbl_orderDetailDTO("", shoesSizeDTO.getId(), entry.getValue(), item.getPrice(), item.getTotal(), orderDTO.getOrderID());
                tbl_shoesDAO tbl_shoesDAO = new tbl_shoesDAO();
                updateShoes = tbl_shoesDAO.updateQuantity(entry.getValue(), item.getShoesID());
                updateShoesSize = shoesSizeDAO.updateQuantity(shoesSizeDTO.getId(), entry.getValue());
                resultDetail = orderDetailDAO.insertOrderDetail(dto);
            }

            session.removeAttribute("CART");

            if (resultOrder == true && resultDetail == true && updateShoes == true && updateShoesSize == true) {
                url = SEARCH_PAGE;
            }
        } catch (SQLException e) {
            log("SearchServlet _ SQL: " + e.getMessage());
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
