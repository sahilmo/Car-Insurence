package com.insuredoo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String product;
	private double amount;
	private int modelFrom;
	private int modelTo;
	private String brands;
	private double tax;
	
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getModelFrom() {
		return modelFrom;
	}

	public void setModelFrom(int modelFrom) {
		this.modelFrom = modelFrom;
	}

	public int getModelTo() {
		return modelTo;
	}

	public void setModelTo(int modelTo) {
		this.modelTo = modelTo;
	}

	public String getBrands() {
		return brands;
	}

	public void setBrands(String brands) {
		this.brands = brands;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
