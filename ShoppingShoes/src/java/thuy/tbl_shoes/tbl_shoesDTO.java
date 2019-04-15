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
public class tbl_shoesDTO implements Serializable {

    private String shoesID;
    private String description;
    private int quantity;
    private Map<String, Float> listPriceSizes;

    public tbl_shoesDTO() {
    }

    public tbl_shoesDTO(String shoesID, String description, int quantity, Map<String, Float> listPriceSizes) {
        this.shoesID = shoesID;
        this.description = description;
        this.quantity = quantity;
        this.listPriceSizes = listPriceSizes;
    }

    public String getShoesID() {
        return shoesID;
    }

    public void setShoesID(String shoesID) {
        this.shoesID = shoesID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Map<String, Float> getListPriceSizes() {
        return listPriceSizes;
    }

    public void setListPriceSizes(Map<String, Float> listPriceSizes) {
        this.listPriceSizes = listPriceSizes;
    }

}
