/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.tbl_order;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.naming.NamingException;
import thuy.utils.DBConnection;

/**
 *
 * @author vtkth
 */
public class tbl_orderDAO implements Serializable {

    public String getLastOrderID() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                ArrayList<Integer> listOrderID = new ArrayList<>();
                String sql = "SELECT orderID FROM tbl_order";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String orderId = rs.getString("orderID");
                    listOrderID.add(Integer.parseInt(orderId));
                }
                if (!listOrderID.isEmpty()) {
                    Collections.sort(listOrderID);
                    return listOrderID.get(listOrderID.size() - 1)+"";
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public tbl_orderDTO generateOrderDTO(String cusID) throws SQLException, NamingException {
        String orderId = (Integer.parseInt(getLastOrderID()) + 1) + "";
        Date currentDate = getCurrentDate();
        tbl_orderDTO dto = new tbl_orderDTO(orderId, currentDate, cusID, 0);
        return dto;
    }

    public Date getCurrentDate() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "SELECT GETDATE() as currentDate";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    Date currentDate = rs.getDate("currentDate");
                    return currentDate;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
    
    public boolean insertOrder(tbl_orderDTO dto) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBConnection.makeConnection();
            if (con!=null) {
                String sql = "Insert into tbl_order(orderID,orderDate,custID,total) values(?,?,?,?)";
                stm = con.prepareStatement(sql);
                
                stm.setString(1, dto.getOrderID());
                System.out.println(dto.getOrderID());
                stm.setDate(2, dto.getOrderDate());
                System.out.println(dto.getOrderDate());
                stm.setString(3, dto.getCustID());
                System.out.println(dto.getCustID());
                stm.setFloat(4, dto.getTotal());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm!=null) {
                stm.close();
            }
            if (con!=null) {
                con.close();
            }
        }
        return false;
    }

}
