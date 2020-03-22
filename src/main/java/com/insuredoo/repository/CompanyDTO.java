package com.insuredoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insuredoo.model.Company;
import com.insuredoo.model.Product;

@Repository
public interface CompanyDTO extends CrudRepository<Company,Integer>{

	public Company findByCompanyName(String companyName);
}
