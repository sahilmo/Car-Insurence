package com.insuredoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insuredoo.service.CompanyService;
import com.insuredoo.service.ProductService;

@RestController
public class LoadDataController {

	@Autowired
	private CompanyService cs;

	@Autowired
	private ProductService ps;

	@RequestMapping(path = "/")
	public void setDataInDB() {
		cs.saveCompany();
		ps.saveProducts();
	}

}
