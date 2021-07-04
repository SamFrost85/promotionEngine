package com.promotion.engine.promotions;

import com.promotion.engine.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ThreeOfTheSamePromotionTest extends AbstractTest {

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


}
