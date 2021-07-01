package com.company.dto.request;

import com.company.dto.request.CartItem;

import java.util.List;

/**
 * Represents a checkout request
 */
public class CheckoutRequest {

    /**
     * List of cart items
     */
    private List<CartItem> items;

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
