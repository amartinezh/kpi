package repository.adm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.CfgHuman;
import repository.adm.CfgHumanDao;

@Repository
public class CfgDaoHumanImpl implements CfgHumanDao {

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CfgHuman> getCfg(String indicador) {
		return em.createQuery("SELECT C FROM CfgHuman as C WHERE C.indicador = '"+indicador+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CfgHuman> getListCfg() {
		return em.createQuery("SELECT C FROM CfgHuman as C").getResultList();
	}
}