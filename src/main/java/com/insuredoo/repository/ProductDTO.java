package com.insuredoo.repository;

import org.springframework.data.repository.CrudRepository;

import com.insuredoo.model.Product;

public interface ProductDTO extends CrudRepository<Product,Integer>{
	

}
