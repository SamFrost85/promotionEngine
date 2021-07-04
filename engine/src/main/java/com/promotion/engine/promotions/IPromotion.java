package com.promotion.engine.promotions;

import com.promotion.engine.data.Cart;

public interface IPromotion {

    /**
     * Will check if a cart contains valid items to apply a promotion
     *
     * @param cart the cart to check for valid promotions
     * @return
     */
    boolean isApplicable(Cart cart);

    /**
     * Apply the promotion to the cart
     *
     * @param cart the cart to apply the promotion to
     */
    void applyPromotion(Cart cart);
}
