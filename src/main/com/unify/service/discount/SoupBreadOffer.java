package com.unify.service.discount;

import com.unify.repository.ProductRepository;
import com.unify.service.util.Basket;

public class SoupBreadOffer implements Offer {

	@Override
	public String getDescription() {
		return "Buy 2 tins of soup and get a loaf of bread for half price";
	}

	@Override
	public double apply(Basket basket) {
		long soupCount = basket.getItems().stream().filter(
				i -> i.getName().equalsIgnoreCase("soup")
				).count();
        long breadCount = basket.getItems().stream().filter(
				i -> i.getName().equalsIgnoreCase("bread")
				).count();
        // find the number of bread loaf eligible to discount : (2soup, 1bread)
        long breadDiscounts = Math.min(soupCount / 2, breadCount);
        return breadDiscounts * ProductRepository.getProduct("bread").getPrice() * 0.5;
	}

}
