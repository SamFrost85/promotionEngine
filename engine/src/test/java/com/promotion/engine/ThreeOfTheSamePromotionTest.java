package com.promotion.engine;

import com.promotion.engine.data.Cart;
import com.promotion.engine.data.CartItem;
import com.promotion.engine.promotions.ThreeOfTheSamePromotion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ThreeOfTheSamePromotionTest {

    private ThreeOfTheSamePromotion promotion = new ThreeOfTheSamePromotion("A", new BigDecimal(50));

    @Test
    public void promotionIsValidTest() {
        var cart = generateTestCart("A", "C", "A", "A");
        Assertions.assertTrue(promotion.isApplicable(cart), "Promotion should be applicable");
    }

    @Test
    public void promotionIsNotValidTest() {
        var cart = generateTestCart("A", "C", "B", "A");
        Assertions.assertFalse(promotion.isApplicable(cart), "Promotion should not be applicable");
    }

    @Test
    public void promotionAppliedTest() {
        var cart = generateTestCart("A", "C", "A", "A");
        promotion.applyPromotion(cart);

        Assertions.fail("fix your test");
    }

    // simple cart generator
    private Cart generateTestCart(String... types) {
        var cart = new Cart();
        var items = new ArrayList<CartItem>();
        cart.setItems(items);

        for (String type : types) {
            items.add(new CartItem(type, new BigDecimal(50)));
        }

        return cart;
    }

}
