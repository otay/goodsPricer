package com.unify.service.discount;

import com.unify.service.util.Basket;

public interface Offer {
	
	String getDescription();
    double apply(Basket basket);

}
