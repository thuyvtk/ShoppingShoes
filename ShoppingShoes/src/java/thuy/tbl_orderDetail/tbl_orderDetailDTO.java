/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.tbl_orderDetail;

import java.io.Serializable;

/**
 *
 * @author vtkth
 */
public class tbl_orderDetailDTO implements Serializable {

    private String id;
    private int productID;
    private int quantity;
    private float unitPrice;
    private float total;
    private String orderID;

    public tbl_orderDetailDTO() {
    }

    public tbl_orderDetailDTO(String id, int productID, int quantity, float unitPrice, float total, String orderID) {
        this.id = id;
        this.productID = productID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
        this.orderID = orderID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

}
