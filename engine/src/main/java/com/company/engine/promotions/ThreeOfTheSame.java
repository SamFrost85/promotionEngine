package com.company.engine.promotions;

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
    public boolean isApplicable() {

        return true;
    }
}
