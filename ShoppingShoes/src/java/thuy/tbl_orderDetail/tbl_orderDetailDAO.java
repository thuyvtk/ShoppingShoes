/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.tbl_orderDetail;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import thuy.utils.DBConnection;

/**
 *
 * @author vtkth
 */
public class tbl_orderDetailDAO implements Serializable {

    public boolean insertOrderDetail(tbl_orderDetailDTO dto) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "Insert tbl_orderDetail(productID,quantity,unitPrice,total,orderID) values(?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, dto.getProductID());
                stm.setInt(2, dto.getQuantity());
                stm.setFloat(3, dto.getUnitPrice());
                stm.setFloat(4, dto.getTotal());
                stm.setString(5, dto.getOrderID());
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
