package com.company.controller;

import com.company.dto.request.CheckoutRequest;
import com.company.dto.response.CheckoutResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Basic checkout controller.
 */
@RestController
public class CheckoutController {

	/**
	 * Handles @{@link CheckoutRequest} and returns @{@link CheckoutResponse}
	 * @param request the request containing the cart list
	 * @return the response containing the total
	 */
	@PostMapping(value = "/checkout",
				produces = {MediaType.APPLICATION_JSON_VALUE},
				consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CheckoutResponse> checkoutCart(@RequestBody CheckoutRequest request) {
		var checkoutResponse = new CheckoutResponse();
		return new ResponseEntity<>(checkoutResponse, HttpStatus.OK);
	}
}
