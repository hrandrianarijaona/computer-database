package com.company.services;

import java.util.List;

import com.company.dao.CompanyDAO;
import com.company.om.Company;

/**
 * Classe singleton de service pour Company
 * @author hrandr
 *
 */
public class CompanyService {

	public static CompanyService cs = null;
	
	private CompanyService() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Sert à obtenir l'unique instance de CompanyService
	 * @return
	 */
	public static CompanyService getInstance(){
		if(cs==null)
			cs = new CompanyService();
		return cs;
	}
	
	/**
	 * Liste toute les Company dans la base de donnée
	 * @return
	 */
	public List<Company> getListCompany() {
		return CompanyDAO.getInstance().getListCompany();
	}
	
	/**
	 * Insert une companie dans la base
	 * @param cp
	 */
	public void insereCompany(Company cp) {
		CompanyDAO.getInstance().insereCompany(cp);
	}
	
	/**
	 * Recherche la company dans la base de donnée
	 * @param paramId l'id à rechercher
	 * @return L'objet Company
	 */
	public Company findCompanyById(int paramId){
		return CompanyDAO.getInstance().findCompanyById(paramId);
	}
	
	

}
