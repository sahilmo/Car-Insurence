package com.insuredoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.insuredoo.model.Product;

public interface ProductDTO extends CrudRepository<Product, Integer> {

	@Query(value="SELECT * FROM PRODUCT  WHERE amount LIKE %:val% or UPPER(brands) LIKE %:val% or model_from LIKE %:val% or model_to LIKE %:val% or UPPER(product) LIKE %:val% ",nativeQuery = true)
	public List<Product> findProducts(String val);
}
