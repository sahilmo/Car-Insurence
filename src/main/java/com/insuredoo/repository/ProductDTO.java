package com.insuredoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.insuredoo.model.Product;

public interface ProductDTO extends CrudRepository<Product, Integer> {

	@Query(value="SELECT * FROM PRODUCT  WHERE amount LIKE %:val% or brands LIKE %:val% or model_from LIKE %:val% or model_to LIKE %:val% or product LIKE %:val% ",nativeQuery = true)
	public List<Product> findProducts(String val);
	//or brands = LIKE ?1% or model_from LIKE ?1% or model_to LIKE ?1% or product LIKE ?1% 
}
