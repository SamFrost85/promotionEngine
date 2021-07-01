package com.company.engine;

import com.company.engine.data.Cart;
import com.company.engine.promotions.IPromotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * Promotion engine, applies promotion to a cart
 */
public class PromotionEngine {

    @Autowired
    private List<IPromotion> promotions;

    /**
     * Applies the first available promotion
     * @param cart
     */
    public void applyPromotions(Cart cart) {

        for (IPromotion promotion : promotions) {
            if (promotion.isApplicable(cart)) {
                promotion.applyPromotion(cart);
                return;
            }
        }
    }

}
