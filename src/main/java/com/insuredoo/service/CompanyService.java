package com.insuredoo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuredoo.model.Company;
import com.insuredoo.repository.CompanyDTO;

@Service
public class CompanyService {

	@Autowired
	private CompanyDTO cDTO;
	
	
	public void saveCompany() {
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Takaful.csv"));
			br.readLine();
			String line = null;
			while ((line= br.readLine())!=null) {
				
				String [] data = line.split(",");
				Company c = new Company();
				c.setCompanyName(data[0]);
				c.setIslamic(data[1]);
				cDTO.save(c);
			}
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
