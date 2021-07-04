package com.promotion.engine;

import com.promotion.engine.data.Cart;
import com.promotion.engine.promotions.IPromotion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Promotion engine, applies promotion to a cart
 */
public class PromotionEngine {

    @Autowired
    private List<IPromotion> promotions;

    /**
     * Applies the first available promotion.
     * Only one promotion at a time can be applied.
     *
     * @param cart the cart to check
     */
    public void applyValidPromotion(Cart cart) {

        for (IPromotion promotion : promotions) {
            if (promotion.isApplicable(cart)) {
                promotion.applyPromotion(cart);
                return;
            }
        }
    }

}

