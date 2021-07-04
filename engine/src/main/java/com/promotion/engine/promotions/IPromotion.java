package com.promotion.engine.promotions;

import com.promotion.engine.data.Cart;

public interface IPromotion {

    boolean isApplicable(Cart cart);

    void applyPromotion(Cart cart);
}
