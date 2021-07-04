package com.promotion.engine.promotions;

import com.promotion.engine.data.Cart;
import com.promotion.engine.data.CartItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This promotion will have specific types, if bought together discount will apply
 */
public final class BulkPromotion implements IPromotion {

    Logger log = LoggerFactory.getLogger(BulkPromotion.class);
    /**
     * The specified type for this promotion
     */
    private final List<String> types;

    /**
     * The sum to be discounted
     */
    private final BigDecimal discountSum;

    public BulkPromotion(List<String> types, BigDecimal discountSum) {
        this.types = types;
        this.discountSum = discountSum.negate();
    }

    @Override
    public boolean isApplicable(Cart cart) {
        if (cart == null || cart.getItems() == null) {
            log.debug("null or empty cart");
            return false;
        }
        // not the best implementation, but lacking time to do it without a quadratic time.
        List<String> cartItems = new ArrayList<>();
        for (var item : cart.getItems()) {
            cartItems.add(item.getType());
        }

        for (var type : types) {
            if (!cartItems.contains(type)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void applyPromotion(Cart cart) {
        log.debug("Applying promotion of £{}", discountSum);
        CartItem promotionItem = new CartItem("Discount", discountSum);
        cart.getItems().add(promotionItem);
    }
}
