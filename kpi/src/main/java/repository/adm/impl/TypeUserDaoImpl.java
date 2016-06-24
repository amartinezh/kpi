package repository.adm.impl;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.TypeUser;
import repository.adm.TypeUserDao;

@Repository
public class TypeUserDaoImpl implements TypeUserDao {

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<TypeUser> listTypeUser() {
		List<Object[]> resultados = em.createQuery(
				"SELECT U.id, U.descripcion FROM TypeUser as U ORDER BY U.id")
				.getResultList();
		List<TypeUser> list = new LinkedList<TypeUser>();
		for (Object[] obj : resultados) {
			list.add(new TypeUser(Integer.parseInt(obj[0].toString()), obj[1]
					.toString()));
		}
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void saveTypeUser(TypeUser typeuser) {
		if (typeuser.getId() == 0) {
			em.persist(typeuser);
		} else {
			em.merge(typeuser);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteTypeUser(int id) {
		TypeUser typeuserResul = em.find(TypeUser.class, id);
		if (typeuserResul != null) {
			em.remove(typeuserResul);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public TypeUser getTypeUser(int id) {
		return (TypeUser) em.find(TypeUser.class, id);
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
