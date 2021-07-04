package com.promotion.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PromotionEngineTest extends AbstractTest {

    PromotionEngine engine = new PromotionEngine();

    @Test
    public void applyPromotionSuccessful() {
        var cart = generateTestCart("A", "A", "A",
                "B", "B", "B");

        engine.applyValidPromotion(cart);
        Assertions.fail("fix your test");
    }
}
