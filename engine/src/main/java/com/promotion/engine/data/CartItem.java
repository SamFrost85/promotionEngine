package com.promotion.engine.data;

import java.math.BigDecimal;

public class CartItem {

    private final String type;

    private final BigDecimal price;

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

}
