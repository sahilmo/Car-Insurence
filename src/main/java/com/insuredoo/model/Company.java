package com.insuredoo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@SequenceGenerator(name="compSeq", initialValue=11, allocationSize=100)
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="compSeq")
	private int companyId;
	
	@Column(unique = true)
	private String companyName;	
	private String islamic;
	
	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "company")
	private List<Product> products;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIslamic() {
		return islamic;
	}

	public void setIslamic(String islamic) {
		this.islamic = islamic;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", islamic=" + islamic
				+ ", products=" + products + "]";
	}
	
	
	
}
