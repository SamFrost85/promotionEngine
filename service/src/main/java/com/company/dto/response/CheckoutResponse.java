package com.company.dto.response;

import java.math.BigDecimal;

/**
 * The response to be sent back when requesting a checkout.
 */
public class CheckoutResponse {

    /**
     * The total to be paid
     */
    private BigDecimal total;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
