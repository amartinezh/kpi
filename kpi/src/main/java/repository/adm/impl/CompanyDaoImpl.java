package repository.adm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Company;
import repository.adm.CompanyDao;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Company> listCompany() {
		return em.createQuery("SELECT C FROM Company as C").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Company> listCompany(String id) {
		if (id.equals("Todas"))
			return em.createQuery("SELECT C FROM Company as C").getResultList();
		else
			return em.createQuery("SELECT C FROM Company as C where C.region_id = '"+id+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public String listCompany_(String id) {
		List<Company> l = em.createQuery("SELECT C FROM Company as C where C.region_id = '"+id+"'").getResultList();
		String res="";
		for (int i = 0; i <l.size(); i++) {
			res+=l.get(i).getId() + "---" + l.get(i).getDescripcion()+";";
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Company> listCompany__(String id) {
		return em.createQuery("SELECT C FROM Company as C where C.id = '"+id+"'").getResultList();
	}
}
