package com.promotion.engine;

import com.promotion.engine.promotions.ThreeOfTheSamePromotion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreeOfTheSamePromotionTest {

    private ThreeOfTheSamePromotion promotion = new ThreeOfTheSamePromotion();

    @Test
    public void promotionIsValidTest() {
        Assertions.assertTrue(promotion.isApplicable(), "Promotion should be applicable");
    }

    @Test
    public void promotionIsNotValidTest() {
        Assertions.assertFalse(promotion.isApplicable(), "Promotion should not be applicable");
    }

    @Test
    public void promotionAppliedTest() {
        promotion.applyPromotion();

        Assertions.fail("fix your test");
    }

}
