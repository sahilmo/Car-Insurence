package com.insuredoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insuredoo.model.Product;
import com.insuredoo.service.CompanyService;
import com.insuredoo.service.ProductService;

@Controller
public class LoadDataController {

	@Autowired
	private CompanyService cs;

	@Autowired
	private ProductService ps;

	int counter = 0;

	@GetMapping(path = "/")
	public String setDataInDB(Model model) {
		if (counter == 0) {
			cs.saveCompany();
			ps.saveProducts();
			counter++;
		}
		return "home";
	}

	@PostMapping("/find")
	@ResponseBody
	public List<Product> findProducts(@RequestParam String key) {
		System.out.println("KEY " + key);
		return ps.searchProducts(key);
	}

}
