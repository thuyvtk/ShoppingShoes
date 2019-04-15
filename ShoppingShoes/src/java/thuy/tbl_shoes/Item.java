/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.tbl_shoes;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author vtkth
 */
public class Item extends tbl_shoesDTO implements Serializable{
    private String size;
    private float price;
    private float total;

    public Item() {
    }

    public Item(String shoesID, String description, int quantity, Map<String, Float> listPriceSizes,String size, float price, float total) {
        super(shoesID, description, quantity, listPriceSizes);
        this.size = size;
        this.price = price;
        this.total = total;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
