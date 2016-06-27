package repository.adm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Company;
import domain.adm.TypeUser;
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
			return em.createQuery(
					"SELECT C FROM Company as C where C.region_id = '" + id
							+ "'").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public String listCompany_(String id) {
		List<Company> l = em.createQuery(
				"SELECT C FROM Company as C where C.region_id = '" + id + "'")
				.getResultList();
		String res = "";
		for (int i = 0; i < l.size(); i++) {
			res += l.get(i).getId() + "---" + l.get(i).getDescripcion() + ";";
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Company> listCompany__(String id) {
		return em.createQuery(
				"SELECT C FROM Company as C where C.id = '" + id + "'")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Company getCompanyRegion(String id) {
		List<Company> results = em.createQuery(
				"SELECT C FROM Company as C where C.id = '" + id + "'")
				.getResultList();
		if (results.isEmpty())
			return null;
		else {
			return results.get(0);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Company getCompany(String id) {
		return (Company) em.find(Company.class, id);
	}

	// ///////////////////

	@Transactional(propagation = Propagation.REQUIRED)
	public void agregar(Object obj) {
		em.persist(obj);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Object agregar_get(Object obj) {
		em.persist(obj);
		em.flush();
		return obj;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void actualizar(Object obj) {
		em.merge(obj);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void borrar(Object obj) {
		em.remove(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> listar(String sql) {
		return em.createQuery(sql).getResultList();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Object getElemento(Object obj, int id) {
		return em.find(obj.getClass(), id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Object getElemento(Object obj, String id) {
		return em.find(obj.getClass(), id);
	}

}
