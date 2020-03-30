package com.insuredoo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.insuredoo.model.AjaxResponseBody;
import com.insuredoo.model.Product;
import com.insuredoo.model.SearchCriteria;
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
	
	@PostMapping(path = "/find")
	public ResponseEntity<?> search(@Valid @RequestBody SearchCriteria search, Errors errors) throws Exception {
		AjaxResponseBody result = new AjaxResponseBody();
				if (search.getKeyword().isEmpty()) {
					result.setMsg("Nothing to search");
					return ResponseEntity.ok(result);
				}
		List<Product> products = ps.searchProducts(search.getKeyword().toUpperCase());

		// If error, just return a 400 bad request, along with the error message
		if (errors.hasErrors()) {
			result.setMsg(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(products);
		}
		if (products.isEmpty()) {
			result.setMsg("no products found!");
		} else {
			result.setMsg("success");
		}

		result.setResult(products);

		System.out.println(products.toString());

		return ResponseEntity.ok(result);
	}
	
//	@PostMapping("/find")
//	public String findProducts(Model model, @RequestParam String key) {
//		List<Product> products =  ps.searchProducts(key.toUpperCase());
//		model.addAttribute("products" ,products);
//		return "Home";
//	}
}
