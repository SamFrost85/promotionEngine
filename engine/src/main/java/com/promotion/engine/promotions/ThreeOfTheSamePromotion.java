package com.promotion.engine.promotions;

import com.promotion.engine.data.Cart;
import com.promotion.engine.data.CartItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * This promotion will have a specific type and a discount sum.
 * If three types of the items will be of the specified type then the discount will be generated.
 */
public final class ThreeOfTheSamePromotion implements IPromotion {

    Logger log = LoggerFactory.getLogger(ThreeOfTheSamePromotion.class);
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
        if (cart == null || cart.getItems() == null) {
            log.debug("null or empty cart");
            return false;
        }
        var itemCount = cart.getItems().stream().filter(x -> type.equals(x.getType())).count();
        return itemCount >= 3;
    }

    @Override
    public void applyPromotion(Cart cart) {
        log.debug("Applying promotion of £{}", discountSum);
        CartItem promotionItem = new CartItem(type, discountSum);
        cart.getItems().add(promotionItem);
    }
}
