/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.tbl_shoes;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import thuy.tbl_shoesSize.tbl_shoesSizeDAO;
import thuy.utils.DBConnection;

/**
 *
 * @author vtkth
 */
public class tbl_shoesDAO implements Serializable {

    public List<tbl_shoesDTO> listSearchShoes;

    public List<tbl_shoesDTO> getListSearchShoes() {
        return listSearchShoes;
    }

    public void searchShoes(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "Select shoesID,description,quantity from tbl_shoes where description like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String shoesID = rs.getString("shoesID");
                    String description = rs.getString("description");
                    int quantity = rs.getInt("quantity");
                    tbl_shoesSizeDAO tbl_shoesSizeDAO = new tbl_shoesSizeDAO();
                    Map<String, Float> listSizes = tbl_shoesSizeDAO.getPriceSize(shoesID);
                    tbl_shoesDTO dto = new tbl_shoesDTO(shoesID, description, quantity, listSizes);

                    if (!listSizes.isEmpty()) {
                        if (this.listSearchShoes == null) {
                            listSearchShoes = new ArrayList<>();
                        }
                        listSearchShoes.add(dto);
                    }

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
    } // search

    public tbl_shoesDTO getItemObj(String shoesID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "Select description,quantity from tbl_shoes where shoesID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, shoesID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    //listSize = getListSize(shoesID);
                    String description = rs.getString("description");
                    int quantity = rs.getInt("quantity");
                    tbl_shoesSizeDAO tbl_shoesSizeDAO = new tbl_shoesSizeDAO();
                    Map<String, Float> listSizes = tbl_shoesSizeDAO.getPriceSize(shoesID);
                    Item item = new Item(shoesID, description, quantity, listSizes, "", 0, 0);
                    return item;
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
    
    public boolean updateQuantity(int quantity, String shoesID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBConnection.makeConnection();
            if (con!=null) {
                String sql = "Update tbl_shoes set quantity = quantity - ? where shoesID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setString(2, shoesID);
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
