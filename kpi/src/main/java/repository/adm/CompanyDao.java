package repository.adm;

import java.util.List;

import domain.adm.Company;

public interface CompanyDao {

	public List<Company> listCompany();
	public List<Company> listCompany(String id);
	public String listCompany_(String id);
	public List<Company> listCompany__(String id);
	public Company getCompanyRegion(String id);
	
	public void agregar(Object obj);
	public Object agregar_get(Object obj);
	public void actualizar(Object obj);
	public void borrar(Object obj);
	public List<Object[]> listar(String sql);
	public Object getElemento(Object obj, int id);
	public Object getElemento(Object obj, String id);
}
