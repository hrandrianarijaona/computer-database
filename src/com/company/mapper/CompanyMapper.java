package com.company.mapper;

import com.company.dto.CompanyDTO;
import com.company.om.Company;

public class CompanyMapper {

	private CompanyMapper() {
		// TODO Auto-generated constructor stub
	}
	
	public static Company mapCompany(CompanyDTO cdto){
		Long id = Long.parseLong(cdto.getId());
		Company company = Company.getCompanyBuilder().id(id).name(cdto.getName()).build();
		return company;
	}

}