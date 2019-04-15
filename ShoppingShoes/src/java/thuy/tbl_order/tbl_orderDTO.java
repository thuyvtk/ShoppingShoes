/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.tbl_order;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author vtkth
 */
public class tbl_orderDTO implements Serializable{
    private String orderID;
    private Date orderDate;
    private String custID;
    private float total;

    public tbl_orderDTO() {
    }

    public tbl_orderDTO(String orderID, Date orderDate, String custID, float total) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.custID = custID;
        this.total = total;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}
