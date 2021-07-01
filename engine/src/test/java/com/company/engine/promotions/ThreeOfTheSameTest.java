package com.company.engine.promotions;

import com.company.engine.data.Cart;
import com.company.engine.data.CartItem;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

public class ThreeOfTheSameTest {

    private String promotionAllowedType = "A";

    private ThreeOfTheSame promotion = new ThreeOfTheSame(promotionAllowedType);


    // better test can be done usine parametrized Unit tests. Can implement if there is time.


    @Test
    public void promotionApplicableTest() {
        var cart = new Cart();
        List<CartItem> items = Arrays.asList(new CartItem("A"), new CartItem("B"), new CartItem("A"), new CartItem("A"));
        cart.setItems(items);

        Assert.isTrue(promotion.isApplicable(cart), "This promotion should be applicable");
    }

    @Test
    public void promotionNotApplicableTest()
    {
        var cart = new Cart();
        List<CartItem> items = Arrays.asList(new CartItem("A"), new CartItem("B"), new CartItem("C"), new CartItem("A"));
        cart.setItems(items);

        Assert.isTrue(!promotion.isApplicable(cart), "This promotion should NOT be applicable");

        Assert.isTrue(!promotion.isApplicable(null), "Empty cart no promotions");
    }
}
