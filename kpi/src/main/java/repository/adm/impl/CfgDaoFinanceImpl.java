package repository.adm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.CfgFinance;
import repository.adm.CfgDaoFinance;

@Repository
public class CfgDaoFinanceImpl implements CfgDaoFinance {

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CfgFinance> getCfg(String indicador) {
		return em.createQuery("SELECT C FROM Cfg as C WHERE C.indicador = '"+indicador+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CfgFinance> getListCfg() {
		return em.createQuery("SELECT C FROM Cfg as C").getResultList();
	}
}