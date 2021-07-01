package com.company.engine.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    List<CartItem> items;

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        if (items != null) {
            return items.stream()
                    .map(x -> x.getPrice())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return BigDecimal.ZERO;
    }
}
