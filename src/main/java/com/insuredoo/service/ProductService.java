package com.insuredoo.service;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuredoo.model.Product;
import com.insuredoo.repository.CompanyDTO;
import com.insuredoo.repository.ProductDTO;
import com.opencsv.CSVReader;

@Service
public class ProductService {

	@Autowired
	private ProductDTO pDTO;
	
	@Autowired
	private CompanyDTO cDTO;
	
	public void saveProducts() {
		
		
		try {
			CSVReader  cr = new CSVReader(new FileReader("src/main/resources/Products.csv"));
			cr.readNext();
			String[] line = null;
			while ((line= cr.readNext())!=null) {
				Product p = new Product();
				p.setCompany( cDTO.findByCompanyName(line[0]));
				p.setProduct(line[1]);
				p.setAmount(Double.parseDouble(line[2]));	
				p.setModelFrom(Integer.parseInt(line[3]));
				p.setModelTo(Integer.parseInt(line[4]));
				p.setBrands(line[5]);
				p.setTax(Double.parseDouble(line[6]));
				pDTO.save(p);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
