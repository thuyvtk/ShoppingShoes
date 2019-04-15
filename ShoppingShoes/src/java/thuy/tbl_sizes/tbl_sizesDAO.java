/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.tbl_sizes;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import thuy.utils.DBConnection;

/**
 *
 * @author vtkth
 */
public class tbl_sizesDAO implements Serializable {

    public String getSizeInfor(String sizeID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "Select sizes, country from tbl_sizes where id = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, sizeID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int size = rs.getInt("sizes");
                    String country = rs.getString("country");
                    return size + " - " + country;
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

    public String getSizeId(String size) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "Select id from tbl_sizes where sizes = ? and country = ?";
                stm = con.prepareStatement(sql);
                String[] split = size.split("-", 2);
                stm.setString(1, split[0].trim());
                stm.setString(2, split[1].trim());
                rs = stm.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("id");
                    return id;
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
}
