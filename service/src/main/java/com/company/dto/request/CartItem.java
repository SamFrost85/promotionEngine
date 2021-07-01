package com.company.dto.request;

import java.math.BigDecimal;

/**
 * Represents a cart item.
 * Contains the SKU id
 */
public class CartItem {

	/**
	 * The id representing the item
	 */
	private String skuId;

	private BigDecimal price;

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
