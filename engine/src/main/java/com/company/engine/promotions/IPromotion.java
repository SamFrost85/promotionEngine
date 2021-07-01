package com.company.engine.promotions;

import com.company.engine.data.Cart;

public interface IPromotion {

    boolean isApplicable (Cart cart);

    void applyPromotion (Cart cart);
}
