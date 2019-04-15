/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.tbl_shoesSize;

import java.io.Serializable;

/**
 *
 * @author vtkth
 */
public class tbl_shoesSizeDTO implements Serializable {

    private int id;
    private String shoesID;
    private String sizeID;
    private float price;
    private int quantity;

    public tbl_shoesSizeDTO() {
    }

    public tbl_shoesSizeDTO(int id, String shoesID, String sizeID, float price, int quantity) {
        this.id = id;
        this.shoesID = shoesID;
        this.sizeID = sizeID;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShoesID() {
        return shoesID;
    }

    public void setShoesID(String shoesID) {
        this.shoesID = shoesID;
    }

    public String getSizeID() {
        return sizeID;
    }

    public void setSizeID(String sizeID) {
        this.sizeID = sizeID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
