package com.company.dto.request;

/**
 * Represents a cart item.
 * Contains the SKU id
 */
public class CartItem {

	/**
	 * The id representing the item
	 */
	private String skuId;

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
}
