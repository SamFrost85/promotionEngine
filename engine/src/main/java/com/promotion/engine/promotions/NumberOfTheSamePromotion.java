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
public final class NumberOfTheSamePromotion implements IPromotion {

    Logger log = LoggerFactory.getLogger(NumberOfTheSamePromotion.class);
    /**
     * The specified type for this promotion
     */
    private final String type;

    /**
     * The sum to be discounted
     */
    private final BigDecimal discountSum;

    /**
     * The sum to be discounted
     */
    private final int numberToApplyPromotion;

    public NumberOfTheSamePromotion(String type, BigDecimal discountSum, int numberToApplyPromotion) {
        this.type = type;
        this.discountSum = discountSum.negate();
        this.numberToApplyPromotion = numberToApplyPromotion;
    }

    @Override
    public boolean isApplicable(Cart cart) {
        if (cart == null || cart.getItems() == null) {
            log.debug("null or empty cart");
            return false;
        }
        var itemCount = cart.getItems().stream().filter(x -> type.equals(x.getType())).count();
        return itemCount >= numberToApplyPromotion;
    }

    @Override
    public void applyPromotion(Cart cart) {
        // if we want to be able to reapply the same promotion to the cart, it will suffice to check how many types
        // A are using the module and reapply the promotion until satisfied
        log.debug("Applying promotion of £{}", discountSum);
        CartItem promotionItem = new CartItem("Discount", discountSum);
        cart.getItems().add(promotionItem);
    }
}
