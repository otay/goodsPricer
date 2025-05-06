package com.unify.service.util;

import java.util.ArrayList;
import java.util.List;

import com.unify.model.Product;
import com.unify.repository.ProductRepository;

public class Basket {
	
	private List<Product> goods = new ArrayList<>();
	
	public List<Product> getItems(){
		return goods;
	}
	
	// Add an item to the basket
	public List<Product> addItem(String item) {
		goods.add(new Product(item, ProductRepository.getProduct(item).getPrice()));
		return goods;
	}

	//calculate the price of all items of the basket
	public double priceBasket() {
		return goods.stream().mapToDouble(Product::getPrice).sum();
	}
}
