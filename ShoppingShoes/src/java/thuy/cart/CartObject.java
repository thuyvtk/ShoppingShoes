/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuy.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import thuy.tbl_shoes.Item;

/**
 *
 * @author vtkth
 */
public class CartObject implements Serializable {

    private Map<Item, Integer> items;

    public CartObject() {
    }

    public CartObject(Map<Item, Integer> items) {
        this.items = items;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Item, Integer> items) {
        this.items = items;
    }

    public String addItemToCart(Item dto) {
        if (this.items == null) {
            items = new HashMap<>();
        }
        Item removeItem = null;
        int quantity = 1;
        for (Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            if (dto.getShoesID().equals(item.getShoesID()) && dto.getSize().equals(item.getSize())) {
                if (entry.getValue() + 1 <= dto.getQuantity() ) {
                    quantity = entry.getValue() + 1;
                    removeItem = item;
                } else {
                    return dto.getDescription() +" is not valid about quantity!";
                }
            }
        }
        if (removeItem != null) {
            this.items.remove(removeItem);
        }

        this.items.put(dto, quantity);
        return null;
    }

    public void removeItemFromCart(String shoesID, String size) {
        if (this.items == null) {
            return;
        }
        List<Item> listItemRemove = new ArrayList<>();
        for (Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            if (shoesID.equals(item.getShoesID()) && size.equals(item.getSize())) {
                listItemRemove.add(item);
            }
        }
        for (Item item : listItemRemove) {
            this.items.remove(item);
        }
        if (this.items.isEmpty()) {
            items = null;
        }
    }

    public float getTotal() {
        float total = 0;
        for (Entry<Item, Integer> entry : items.entrySet()) {
            total += entry.getKey().getTotal();
        }
        return total;
    }

}
