package com.unify;

import com.unify.service.PricingService;
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
			 
			 PricingService service = new PricingService();
			 
			 System.out.println(service.priceBasket(basket));
		} catch (IllegalArgumentException e) {
            System.err.println("Problem occured when pricing the basket " + e.getMessage());
        }
	}

}
