package com.insuredoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insuredoo.service.CompanyService;

@RestController
public class LoadDataController {

	@Autowired
	private CompanyService cs;
	
	@RequestMapping(path="/loadData")
	public void setDataInDB() {
		cs.saveCompany();
		
	}
	
}
