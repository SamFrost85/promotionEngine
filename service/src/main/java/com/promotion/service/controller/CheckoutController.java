package com.promotion.service.controller;

import com.promotion.service.dto.request.CheckoutRequest;
import com.promotion.service.dto.response.CheckoutResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Basic checkout controller.
 */
@RestController
public class CheckoutController {

    Logger log = LoggerFactory.getLogger(CheckoutController.class);

    /**
     * Handles @{@link CheckoutRequest} and returns @{@link CheckoutResponse}
     * @param request the request containing the cart list
     * @return the response containing the total
     */
    @GetMapping(value = "/checkout",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CheckoutResponse> checkoutCart(@RequestBody CheckoutRequest request) {

        log.debug("Received checkout request");

        CheckoutResponse response = new CheckoutResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
