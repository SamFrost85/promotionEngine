package com.promotion.engine.promotions;

import com.promotion.engine.AbstractTest;
import com.promotion.engine.data.Cart;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class NumberOfTheSamePromotionTest extends AbstractTest {

    private NumberOfTheSamePromotion threeOfA = new NumberOfTheSamePromotion("A", new BigDecimal(20), 3);
    private NumberOfTheSamePromotion twoOfB = new NumberOfTheSamePromotion("B", new BigDecimal(15), 2);

    @Test
    public void promotionIsValidTest() {
        var cart = generateTestCart("A", "C", "A", "A");
        assertTrue(threeOfA.isApplicable(cart), "Promotion should be applicable");
        cart = generateTestCart("A", "C", "B", "B");
        assertTrue(twoOfB.isApplicable(cart), "Promotion should be applicable");
    }

    @Test
    public void promotionIsNotValidTest() {
        var cart = generateTestCart("A", "C", "B", "A");
        assertFalse(threeOfA.isApplicable(cart), "Promotion should not be applicable");
        assertFalse(twoOfB.isApplicable(cart), "Promotion should not be applicable");
    }

    @Test
    public void testEmptyCart() {
        var emptyCart = new Cart();
        assertFalse(threeOfA.isApplicable(null), "Promotion should not be applicable");
        assertFalse(threeOfA.isApplicable(emptyCart), "Promotion should not be applicable for empty cart");

        emptyCart.setItems(new ArrayList<>());
        assertFalse(threeOfA.isApplicable(emptyCart), "Promotion should not be applicable for empty cartItems list");
    }

    @Test
    public void promotionAppliedTest() {
        var cart = generateTestCart("A", "C", "A", "A");
        threeOfA.applyPromotion(cart);
        BigDecimal expectedTotal = new BigDecimal(180); // 50 each minus 20 discount
        assertEquals(expectedTotal, cart.getTotal(), "The total applied is not correct");
    }


}
