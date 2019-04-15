/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.tbl_shoesSize;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.NamingException;
import thuy.tbl_sizes.tbl_sizesDAO;
import thuy.utils.DBConnection;

/**
 *
 * @author vtkth
 */
public class tbl_shoesSizeDAO implements Serializable {

    public Map<String, Float> getPriceSize(String shoesID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "Select sizeID, price from tbl_shoesSize where shoesID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, shoesID);
                rs = stm.executeQuery();
                Map<String, Float> listPriceSize = new HashMap<>();
                tbl_sizesDAO tbl_sizesDAO = new tbl_sizesDAO();
                while (rs.next()) {
                    String sizeID = rs.getString("sizeID");
                    float price = rs.getFloat("price");

                    tbl_shoesSizeDAO shoesSizeDAO = new tbl_shoesSizeDAO();
                    tbl_shoesSizeDTO shoesSizeDTO = shoesSizeDAO.getShoesSizeDTO(shoesID, sizeID, false);

                    if (shoesSizeDTO.getQuantity() > 0) {
                        String size = tbl_sizesDAO.getSizeInfor(sizeID);
                        listPriceSize.put(size, price);
                    }
                }
                return listPriceSize;
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

    public tbl_shoesSizeDTO getShoesSizeDTO(String shoesId, String size, boolean flag) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "Select id,shoesID,sizeID,price,quantity from tbl_shoesSize where shoesID = ? and sizeID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, shoesId);
                if (flag) {
                    tbl_sizesDAO tbl_sizesDAO = new tbl_sizesDAO();
                    size = tbl_sizesDAO.getSizeId(size);
                }
                stm.setString(2, size);

                rs = stm.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    tbl_shoesSizeDTO dto = new tbl_shoesSizeDTO(id, shoesId, size, price, quantity);
                    return dto;
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

    public boolean updateQuantity(int id, int quantity) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "Update tbl_shoesSize set quantity = quantity - ? where id = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setInt(2, id);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

}
