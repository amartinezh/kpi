package repository.adm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Nivel;
import repository.adm.NivelDao;

@Repository
public class NivelDaoImp implements NivelDao
{
	
	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Nivel> listNivel() {
		return em.createQuery("SELECT C FROM Nivel as C").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Nivel> getNivel(String id) {
		return em.createQuery("SELECT C FROM Nivel as C where C.id = '"+id+"'").getResultList();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Nivel getNivel_(int id) {
		return (Nivel) em.find(Nivel.class, id);
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
