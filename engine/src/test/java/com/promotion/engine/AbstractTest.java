package com.promotion.engine;

import com.promotion.engine.data.Cart;
import com.promotion.engine.data.CartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Unit tests should implement this class and generic code should be included here.
 */
public abstract class AbstractTest {

    // simple cart generator
    protected Cart generateTestCart(String... types) {
        var cart = new Cart();
        var items = new ArrayList<CartItem>();
        cart.setItems(items);

        for (String type : types) {
            items.add(new CartItem(type, new BigDecimal(50)));
        }

        return cart;
    }

}
