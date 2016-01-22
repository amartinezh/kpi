package service.adm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.adm.Company;
import repository.adm.CompanyDao;
import service.adm.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	
	@Autowired
	private CompanyDao companyDao;
	
	
	public List<Company> listCompany() {		
		return companyDao.listCompany();
	}
	
	public List<Company> listCompany(String id) {		
		return companyDao.listCompany(id);
	}
	
	public String listCompany_(String id) {		
		return companyDao.listCompany_(id);
	}
	
	public List<Company> listCompany__(String id){
		return companyDao.listCompany__(id);
	}

}
