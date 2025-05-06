package com.unify.repository;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.unify.model.Product;

public class ProductRepositoryTest {
	
	@Test
    public void getProductShouldReturnAProduct() {
        Product apple = ProductRepository.getProduct("Apples");
        assertEquals("Apples", apple.getName());
        assertEquals(1.00, apple.getPrice());
    }
	
	
	@Test
    public void getUnknownProductShouldFail() {
 
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        	ProductRepository.getProduct("Unknown");
        });
        assertEquals("Unknown item: Unknown", exception.getMessage());
    }

}
