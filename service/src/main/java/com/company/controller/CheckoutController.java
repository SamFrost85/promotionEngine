package com.company.controller;

import com.company.dto.request.CheckoutRequest;
import com.company.dto.response.CheckoutResponse;
import com.company.engine.PromotionEngine;
import com.company.engine.data.Cart;
import com.company.engine.data.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Basic checkout controller.
 */
@RestController
public class CheckoutController {

	@Autowired
	private PromotionEngine promotionEngine;
	/**
	 * Handles @{@link CheckoutRequest} and returns @{@link CheckoutResponse}
	 * @param request the request containing the cart list
	 * @return the response containing the total
	 */
	@PostMapping(value = "/checkout",
				produces = {MediaType.APPLICATION_JSON_VALUE},
				consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CheckoutResponse> checkoutCart(@RequestBody CheckoutRequest request) {
		var checkoutResponse = 	applyCheckout(request);
		return new ResponseEntity<>(checkoutResponse, HttpStatus.OK);
	}

	private CheckoutResponse applyCheckout(CheckoutRequest request) {
		var cart = convertToInternalCart(request);
		promotionEngine.applyPromotions(cart);
		CheckoutResponse response = new CheckoutResponse();
		response.setTotal(cart.getTotal());
		return response;
	}

	private Cart convertToInternalCart(CheckoutRequest request) {
		Cart cart = new Cart();
		List<CartItem> items = request.getItems().stream()
				.map(item -> new CartItem(item.getSkuId(), item.getPrice()))
				.collect(Collectors.toList());

		cart.setItems(items);
		return  cart;
	}
}
