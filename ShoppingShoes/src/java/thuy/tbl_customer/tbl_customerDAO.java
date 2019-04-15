/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.tbl_customer;

import java.io.Serializable;
import java.sql.Connection;
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
public class tbl_customerDAO implements Serializable {

    public boolean insertCustomer(tbl_customerDTO dto) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "Insert into tbl_customer(custID,lastName,middleName,firstName,address,phone,custLevel) "
                        + "values(?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getCustID());
                stm.setString(2, dto.getLastName());
                stm.setString(3, dto.getMiddleName());
                stm.setString(4, dto.getFirstname());
                stm.setString(5, dto.getAddress());
                stm.setString(6, dto.getPhone());
                stm.setInt(7, dto.getCustLevel());
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

    public String getLastCusID() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                ArrayList<Integer> listCusID = new ArrayList<>();
                String sql = "SELECT custID from tbl_customer";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String custID = rs.getString("custID");
                    listCusID.add(Integer.parseInt(custID.trim()));
                }
                if (!listCusID.isEmpty()) {
                    Collections.sort(listCusID);
                    return listCusID.get(listCusID.size() - 1) + "";
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

    public String getCusIDInsert() throws SQLException, NamingException {
            String lastId = getLastCusID();
            int temp = Integer.parseInt(lastId) + 1;
            return temp + "";
    }

    public tbl_customerDTO getCusomerInfor(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "Select *  from tbl_account A, tbl_customer C where A.custID = C.custID and A.username = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String cusID = rs.getString("custID");
                    String firstName = rs.getString("firstName");
                    String middleName = rs.getString("middleName");
                    String lastName = rs.getString("lastName");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    int custLevel = rs.getInt("custLevel");
                    tbl_customerDTO dto = new tbl_customerDTO(cusID, lastName, middleName, firstName, address, phone, custLevel);
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

    public String getFullname(String cusID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "Select firstName,middleName,lastName from tbl_customer where custID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, cusID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String firstName = rs.getString("firstName");
                    String middleName = rs.getString("middleName");
                    String lastName = rs.getString("lastName");
                    String fullname = firstName + " " + middleName + " " + lastName;
                    return fullname;
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
