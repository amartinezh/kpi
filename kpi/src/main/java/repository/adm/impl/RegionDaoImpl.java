package repository.adm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Cfg;
import domain.adm.Region;
import repository.adm.CfgDao;
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
}