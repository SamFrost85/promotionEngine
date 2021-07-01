package com.company.engine.data;

import java.math.BigDecimal;

public class CartItem {

    private String type;

    private BigDecimal price;

    public CartItem(String type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
