package com.promotion.engine.promotions;

import com.promotion.engine.data.Cart;

import java.math.BigDecimal;

/**
 * This promotion will have a specific type and a discount sum.
 * If three types of the items will be of the specified type then the discount will be generated.
 */
public final class ThreeOfTheSamePromotion implements IPromotion {

    /**
     * The specified type for this promotion
     */
    private final String type;

    /**
     * The sum to be discounted
     */
    private final BigDecimal discountSum;

    public ThreeOfTheSamePromotion(String type, BigDecimal discountSum) {
        this.type = type;
        this.discountSum = discountSum.negate();
    }

    @Override
    public boolean isApplicable(Cart cart) {
        return true;
    }

    @Override
    public void applyPromotion(Cart cart) {

    }
}
