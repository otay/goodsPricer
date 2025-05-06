package com.unify.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.unify.service.PricingService;
import com.unify.service.util.Basket;

public class PricingServiceTest {
	@Test
    public void priceBasket() {
        Basket basket = new Basket();
        basket.addItem("Bread");
        basket.addItem("Milk");
        PricingService service = new PricingService();
        assertEquals(2.10, service.priceBasket(basket));
    }

}
