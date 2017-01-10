package repository.adm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.CfgManufacture1;
import repository.adm.CfgManufacture1Dao;

@Repository
public class CfgDaoManufacture1Impl implements CfgManufacture1Dao {

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CfgManufacture1> getCfg(String indicador) {
		return em.createQuery("SELECT C FROM CfgManufacture1 as C WHERE C.indicador = '"+indicador+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CfgManufacture1> getListCfg() {
		return em.createQuery("SELECT C FROM CfgManufacture1 as C order by C.indicador").getResultList();
	}
}