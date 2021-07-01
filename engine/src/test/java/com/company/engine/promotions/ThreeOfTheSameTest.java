package com.company.engine.promotions;

import com.company.engine.data.Cart;
import com.company.engine.data.CartItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ThreeOfTheSameTest {

    private String promotionAllowedType = "A";

    private ThreeOfTheSame promotion = new ThreeOfTheSame(promotionAllowedType, new BigDecimal("20"));


    // better test can be done usine parametrized Unit tests. Can implement if there is time.


    private Cart generateCart(String ...types ) {

        var cart = new Cart();
        var items = new ArrayList<CartItem>();
        for (String type: types) {
            items.add(new CartItem(type, new BigDecimal("50")));
        }
        cart.setItems(items);

        return cart;
    }

    @Test
    public void promotionApplicableTest() {
        var cart = generateCart("A", "A", "A", "B");

        Assertions.assertTrue(promotion.isApplicable(cart), "This promotion should be applicable");
    }

    @Test
    public void promotionNotApplicableTest()
    {
        var cart = generateCart("A", "B", "A", "B", "B");

        Assertions.assertFalse(promotion.isApplicable(cart), "This promotion should NOT be applicable");

        Assertions.assertFalse(promotion.isApplicable(null), "Empty cart no promotions");
    }

    @Test
    public void applyPromotion() {
        var cart = generateCart("A", "A", "A", "B", "B");
        promotion.applyPromotion(cart);

        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : cart.getItems()) {
            total = total.add(item.getPrice());
        }

        BigDecimal expected = new BigDecimal(230);
        Assertions.assertEquals(expected, total);
    }
}
