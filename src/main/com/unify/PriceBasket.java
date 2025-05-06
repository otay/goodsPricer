package com.unify;

import java.util.Arrays;

import com.unify.service.PricingService;
import com.unify.service.discount.AppleOffer;
import com.unify.service.discount.SoupBreadOffer;
import com.unify.service.util.Basket;

public class PriceBasket {
	
	public static void main(String[] args) {
		if (args.length < 1) {
            System.err.println("Usage: PriceBasket item1 item2 ...");
            return;
        }
		
		Basket basket = new Basket();
		try {
			 for (String arg:args) {
				 basket.addItem(arg);
			 }
			 
			 PricingService service = new PricingService(
		                Arrays.asList(new AppleOffer(), new SoupBreadOffer())
		            );
			 service.calculateFinalPrice(basket);

		} catch (IllegalArgumentException e) {
            System.err.println("Problem occured when pricing the basket " + e.getMessage());
        }
	}

}
