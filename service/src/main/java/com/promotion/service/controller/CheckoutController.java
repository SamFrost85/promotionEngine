package com.promotion.service.controller;

import com.promotion.engine.PromotionEngine;
import com.promotion.engine.data.Cart;
import com.promotion.engine.data.CartItem;
import com.promotion.service.dto.request.CheckoutRequest;
import com.promotion.service.dto.response.CheckoutResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Basic checkout controller.
 */
@RestController
public class CheckoutController {

    private final Logger log = LoggerFactory.getLogger(CheckoutController.class);
    @Autowired
    private PromotionEngine promotionEngine;

    /**
     * Handles @{@link CheckoutRequest} and returns @{@link CheckoutResponse}
     *
     * @param request the request containing the cart list
     * @return the response containing the total
     */
    @GetMapping(value = "/checkout",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CheckoutResponse> checkoutCart(@RequestBody CheckoutRequest request) {

        log.debug("Received checkout request");
        var response = applyCheckout(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private CheckoutResponse applyCheckout(CheckoutRequest request) {
        var cart = convertToInternalCart(request);
        promotionEngine.applyValidPromotion(cart);
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
        return cart;
    }

}
