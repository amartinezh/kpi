package service.adm.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Company;
import domain.adm.Region;
import repository.adm.CompanyDao;
import service.adm.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	
	@Autowired
	private CompanyDao companyDao;
	
	@Transactional
	public void agregarCompany(boolean existe, Company company) {
		if (existe == true){
			companyDao.actualizar(company);
		}
		else {
			companyDao.agregar(company);
		}
	}

	@Transactional
	public void borrarCompany(Company company) {
		Company obj = (Company) companyDao.getElemento(company, company.getId());
		companyDao.borrar(obj);
	}
	
	@Transactional
	public boolean validarCompany(Company company) {
		Company cont = (Company) companyDao.getElemento(company, company.getId());
		if (cont == null)
			return false;
		return true;
	}
	
	@Transactional
	public LinkedHashMap<String, String> cmbCompany() {
		LinkedHashMap<String, String> listCompany = new LinkedHashMap<String, String>();
		String sql = "Select a.id as id, a.descripcion as descripcion FROM Company as a";
		List<Object[]> data = companyDao.listar(sql);
		listCompany.put("0", "Seleccione");
		if (data != null) {
			for (Object[] d : data) {
				listCompany.put(d[0].toString(), d[1].toString());
			}
		}
		return listCompany;
	}
	
	@Transactional
	public List<Company> listarCompany() {
		List<Company> listCompany = new LinkedList<Company>();
		String sql = "Select a.id as id, a.descripcion as descripcion, a.region_id as region_id FROM Company as a";
		List<Object[]> data = companyDao.listar(sql);
		if (data != null) {
			for (Object[] d : data) {
				listCompany.add(new Company(d[0].toString(), d[1].toString(), (Region) d[2] ));
			}
		}
		return listCompany;
	}
	
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
	
	public Company getCompanyRegion(String id){
		return companyDao.getCompanyRegion(id);
	}

	public Company getCompany(String id){
		return companyDao.getCompanyRegion(id);
	}
}
