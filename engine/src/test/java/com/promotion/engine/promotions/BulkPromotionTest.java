package com.promotion.engine.promotions;

import com.promotion.engine.AbstractTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BulkPromotionTest extends AbstractTest {


    @Test
    public void promotionIsValidTest() {
        List<String> validTypes = Arrays.asList("C", "D");
        IPromotion promotion = new BulkPromotion(validTypes, new BigDecimal(15));

        var cart = generateTestCart("A", "C", "D", "B");
        assertTrue(promotion.isApplicable(cart), "Promotion should be applicable");
    }


}
