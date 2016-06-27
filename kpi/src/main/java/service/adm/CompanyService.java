package service.adm;

import java.util.LinkedHashMap;
import java.util.List;

import domain.adm.Company;
import domain.adm.Company;

public interface CompanyService {

	public List<Company> listCompany();
	public List<Company> listCompany(String id);
	public String listCompany_(String id);
	public List<Company> listCompany__(String id);
	public Company getCompany(String id);
	public Company getCompanyRegion(String id);
	
	public void agregarCompany(boolean existe, Company company);
	public void borrarCompany(Company company);
	public boolean validarCompany(Company company);
	public List<Company> listarCompany();
	public LinkedHashMap<String, String> cmbCompany();
}
