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

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public User val(String k, String p) {
		List<User> results = em.createQuery(
				"select u from User u where u.id = '" + k + "' and u.pass = '"
						+ p + "'").getResultList();
		if (results.isEmpty())
			return null;
		else{
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

}
