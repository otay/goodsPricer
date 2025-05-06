package com.unify.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.unify.service.PricingService;
import com.unify.service.discount.AppleOffer;
import com.unify.service.discount.SoupBreadOffer;
import com.unify.service.util.Basket;

public class PricingServiceTest {
	@Test
    public void calculateTotalPriceWithDiscountNotApplied() {
        Basket basket = new Basket();
        basket.addItem("Bread");
        basket.addItem("Milk");
        PricingService service = new PricingService(Arrays.asList(new AppleOffer()));
        assertEquals(2.10, service.calculateFinalPrice(basket));//no discount as there is no apples in the basket
    }
	
	@Test
    public void calculateTotalPriceWithDiscountApplied() {
        Basket basket = new Basket();
        basket.addItem("Bread");
        basket.addItem("Milk");
        basket.addItem("Apples");
        basket.addItem("Soup");
        basket.addItem("Soup");
        PricingService service = new PricingService(Arrays.asList(new AppleOffer(), new SoupBreadOffer()));
        assertEquals(3.9000000000000004, service.calculateFinalPrice(basket));//0.65 +0.65 + (0.80 - 0.4) +1.30+(1 - 0.10) Apples -10% applied and bread - 50% applied
    }

}
