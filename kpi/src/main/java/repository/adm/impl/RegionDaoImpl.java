package repository.adm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Region;
import repository.adm.RegionDao;

@Repository
public class RegionDaoImpl implements RegionDao {

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Region> getRegion(String region) {
		return em.createQuery("SELECT R FROM Region as R WHERE R.region_id = '"+region+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Region> getListRegion() {
		return em.createQuery("SELECT R FROM Region as R").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Region getRegion_(String region) {
		return (Region) em.createQuery("SELECT R FROM Region as R WHERE R.region_id = '"+region+"'").getResultList().get(0);
	}
	
	/////////////////////
	
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