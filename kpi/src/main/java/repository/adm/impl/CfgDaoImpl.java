package repository.adm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Cfg;
import repository.adm.CfgDao;

@Repository
public class CfgDaoImpl implements CfgDao {

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cfg> getCfg(String indicador) {
		return em.createQuery("SELECT C FROM Cfg as C WHERE C.indicador = '"+indicador+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cfg> getListCfg() {
		return em.createQuery("SELECT C FROM Cfg as C order by C.indicador").getResultList();
	}
}