package com.company.engine.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CartTest {

    @Test
    public void testCartTotal() {

        var cart = generateCart("a", "b");

        Assertions.assertEquals(new BigDecimal(100), cart.getTotal());
    }
    private Cart generateCart(String ...types ) {

        var cart = new Cart();
        var items = new ArrayList<CartItem>();
        for (String type: types) {
            items.add(new CartItem(type, new BigDecimal("50")));
        }
        cart.setItems(items);

        return cart;
    }

}
