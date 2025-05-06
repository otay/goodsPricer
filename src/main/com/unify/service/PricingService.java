package com.unify.service;

import java.util.List;

import com.unify.service.discount.Offer;
import com.unify.service.util.Basket;

public class PricingService {
	private final List<Offer> offers;

    public PricingService(List<Offer> offers) {
        this.offers = offers;
    }

	private double calculateTotalPrice(Basket basket) {
		return basket.priceBasket();
	}
	
	private double calculateTotalDiscount(Basket basket) {
		double total = 0.0;
		for(Offer offer:offers) {
			double discount = offer.apply(basket);
			if(discount >0.0) {
				System.out.println(offer.getDescription()+": -£"+ discount);
				total +=discount;
			}
		}
		if(total ==0.0) {
			System.out.println("(No offers available)");
		}
		return total;
	}
	
	public double calculateFinalPrice(Basket basket) {
		double subtotal = calculateTotalPrice(basket);
		System.out.println("Subtotal: £"+ subtotal);

		double discount = calculateTotalDiscount(basket);
		
		double finalPrice = subtotal-discount;
		
		System.out.println("Total price:" + finalPrice);
		
		return finalPrice;
	}
	
	
}
