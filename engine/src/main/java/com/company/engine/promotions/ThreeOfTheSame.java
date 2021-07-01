package com.company.engine.promotions;

import com.company.engine.data.Cart;
import com.company.engine.data.CartItem;

import java.math.BigDecimal;

/**
 * implements a three of a type promotion type
 */
public class ThreeOfTheSame implements IPromotion {

    /**
     * The specified type for this promotion
     */
    private final String type;
    private final BigDecimal discountSum;

    public ThreeOfTheSame(String type, BigDecimal discountSum) {
        this.type = type;
        this.discountSum = discountSum.negate();
    }

    @Override
    public boolean isApplicable(Cart cart) {
        if (cart == null || cart.getItems() == null || cart.getItems().isEmpty() ) {
            // log null cart here
            return false;
        }
        int itemCount = 0;
        for (CartItem item : cart.getItems()) {
            if(type.equals(item.getType())) {
                itemCount++;
            }
        }
        return itemCount >= 3;
    }

    @Override
    public void applyPromotion(Cart cart) {
        CartItem promotionItem = new CartItem(type, discountSum);
        cart.getItems().add(promotionItem);
    }


}
