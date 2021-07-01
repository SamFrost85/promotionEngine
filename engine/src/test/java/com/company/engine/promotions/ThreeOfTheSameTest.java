package com.company.engine.promotions;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ThreeOfTheSameTest {

    private String promotionAllowedType = "A";

    private ThreeOfTheSame promotion = new ThreeOfTheSame(promotionAllowedType);

    @Test
    public void promotionApplicableTest() {
        Assert.isTrue(promotion.isApplicable(), "This promotion should be applicable");
    }

    @Test
    public void promotionNotApplicableTest() {
        Assert.isTrue(!promotion.isApplicable(), "This promotion should NOT be applicable");
    }
}
