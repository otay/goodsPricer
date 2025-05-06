 package com.unify.repository;

import java.util.HashMap;
import java.util.Map;

import com.unify.model.Product;

public class ProductRepository {
	private static final Map<String, Product> products = new HashMap<>();

    static {
        products.put("soup", new Product("Soup", 0.65));
        products.put("bread", new Product("Bread", 0.80));
        products.put("milk", new Product("Milk", 1.30));
        products.put("apples", new Product("Apples", 1.00));
    }

    public static Product getProduct(String name) {
    	Product product = products.get(name.toLowerCase());
        if (product == null) throw new IllegalArgumentException("Unknown item: " + name);
        return product;
    }
}
