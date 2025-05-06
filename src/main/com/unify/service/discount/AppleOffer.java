package com.unify.service.discount;

import com.unify.repository.ProductRepository;
import com.unify.service.util.Basket;

public class AppleOffer implements Offer {
	private static final double DISCOUNT = 0.10;

	@Override
	public String getDescription() {
		return "Apples have a 10% discount off their normal price this week";
	}

	@Override
	public double apply(Basket basket) {
		long apples = basket.getItems().stream().filter(
				i -> i.getName().equalsIgnoreCase("apples")
				).count();
        return apples * ProductRepository.getProduct("apples").getPrice() * DISCOUNT;
	}

}
