package com.insuredoo.model;

import org.hibernate.validator.constraints.NotBlank;

public class SearchCriteria {
	
	@NotBlank(message = "value can't be empty!")
	String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
