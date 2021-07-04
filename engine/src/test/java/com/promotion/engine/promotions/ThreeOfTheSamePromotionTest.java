package com.promotion.engine.promotions;

import com.promotion.engine.AbstractTest;
import com.promotion.engine.data.Cart;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ThreeOfTheSamePromotionTest extends AbstractTest {

    private ThreeOfTheSamePromotion promotion = new ThreeOfTheSamePromotion("A", new BigDecimal(20));

    @Test
    public void promotionIsValidTest() {
        var cart = generateTestCart("A", "C", "A", "A");
        assertTrue(promotion.isApplicable(cart), "Promotion should be applicable");
    }

    @Test
    public void promotionIsNotValidTest() {
        var cart = generateTestCart("A", "C", "B", "A");
        assertFalse(promotion.isApplicable(cart), "Promotion should not be applicable");
    }

    @Test
    public void testEmptyCart() {
        var emptyCart = new Cart();
        assertFalse(promotion.isApplicable(null), "Promotion should not be applicable");
        assertFalse(promotion.isApplicable(emptyCart), "Promotion should not be applicable for empty cart");

        emptyCart.setItems(new ArrayList<>());
        assertFalse(promotion.isApplicable(emptyCart), "Promotion should not be applicable for empty cartItems list");
    }

    @Test
    public void promotionAppliedTest() {
        var cart = generateTestCart("A", "C", "A", "A");
        promotion.applyPromotion(cart);
        BigDecimal expectedTotal = new BigDecimal(180); // 50 each minus 20 discount
        assertEquals(expectedTotal, cart.getTotal(), "The total applied is not correct");
    }


}
