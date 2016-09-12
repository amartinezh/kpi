package repository.adm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.CfgDistri;
import repository.adm.CfgDistriDao;

@Repository
public class CfgDaoDistriImpl implements CfgDistriDao {

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CfgDistri> getCfg(String indicador) {
		return em.createQuery("SELECT C FROM CfgDistri as C WHERE C.indicador = '"+indicador+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CfgDistri> getListCfg() {
		return em.createQuery("SELECT C FROM CfgDistri as C order by C.indicador").getResultList();
	}
}