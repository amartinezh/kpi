package repository.login.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Region;
import domain.adm.TypeUser;
import domain.login.User;
import repository.login.UserDao;
import service.adm.CompanyService;
import service.adm.RegionService;
import service.login.UserManager;

@Repository
public class JPAUserDao implements UserDao {

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		return em.createQuery("select p from User p").getResultList();
	}
	@Transactional()
	@SuppressWarnings("unchecked")
	public int pass(String id, String pass) {
		return em.createQuery("UPDATE User SET pass = '"+pass+"' WHERE id='"+id+"'").executeUpdate();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public User val(String k, String p) {
		List<User> results = em.createQuery(
				"select u from User u where u.id = '" + k + "' and u.pass = '"
						+ p + "'").getResultList();
		if (results.isEmpty())
			return null;
		else {
			return results.get(0);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addUser(User user) {
		if (em.find(User.class, user.getId()) == null) {
			em.persist(user);
			return true;
		} else {
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteUser(String id) {
		User user = em.find(User.class, id);
		if (user != null) {
			em.remove(user);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public User getUser(User user) {
		return (User) (em.find(User.class, user.getId()));
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean editUser(User user) {
		try {
			em.merge(user);
			return true;
		} catch (Exception ex) {
			return false;
		}
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
		//System.out.println("sql"+sql);
		return em.createQuery(sql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public String pass(String sql) {
		return em.createQuery(sql).toString();
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
