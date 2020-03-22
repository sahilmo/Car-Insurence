package com.insuredoo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuredoo.model.Product;
import com.insuredoo.repository.CompanyDTO;
import com.insuredoo.repository.ProductDTO;

@Service
public class ProductService {

	@Autowired
	private ProductDTO pDTO;
	
	@Autowired
	private CompanyDTO cDTO;
	
	public void saveCompany() {
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Products.csv"));
			br.readLine();
			String line = null;
			while ((line= br.readLine())!=null) {
				
				String [] data = line.split(",");
				
//				Product p = new Product();
//				p.setCompany( cDTO.findByCompanyName(data[0]));
//				p.setProduct(data[1]);
//				p.setAmount(Double.parseDouble(data[2]));	
//				p.setModelFrom(Integer.parseInt(data[3]));
//				p.setModelTo(Integer.parseInt(data[4]));
//				p.setBrands(data[5]);
//				
//				pDTO.save(p);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
