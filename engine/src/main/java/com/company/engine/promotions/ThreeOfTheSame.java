package com.company.engine.promotions;

import com.company.engine.data.Cart;
import com.company.engine.data.CartItem;

/**
 * implements a three of a type promotion type
 */
public class ThreeOfTheSame implements IPromotion {

    /**
     * The specified type for this promotion
     */
    private final String type;

    public ThreeOfTheSame(String type) {
        this.type = type;
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

    }


}
