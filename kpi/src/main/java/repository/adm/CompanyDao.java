package repository.adm;

import java.util.List;

import domain.adm.Company;
import domain.adm.Region;

public interface CompanyDao {

	public List<Company> listCompany();
	public List<Company> listCompany(String id);
	public String listCompany_(String id);
	public List<Company> listCompany__(String id);
	public Region getCompanyRegion(String id);
}
