package service.login;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Company;
import domain.adm.Currency;
import domain.adm.TypeUser;
import domain.login.User;
import repository.login.UserDao;

@Component
public class SimpleUserManager implements UserManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UserDao userDao;

    @Transactional
	public void agregarUser(boolean existe, User user) {
		if (existe == true){
			userDao.actualizar(user);
		}
		else {
			userDao.agregar(user);
		}
	}

	@Transactional
	public void borrarUser(User user) {
		User obj = (User) userDao.getElemento(user, user.getId());
		userDao.borrar(obj);
	}
	
	@Transactional
	public boolean validarUser(User user) {
		User cont = (User) userDao.getElemento(user, user.getId());
		if (cont == null)
			return false;
		return true;
	}
	
	@Transactional
	public LinkedHashMap<String, String> cmbUser() {
		LinkedHashMap<String, String> listUser = new LinkedHashMap<String, String>();
		String sql = "Select a.id as id, a.type_id as type_id FROM User as a";
		List<Object[]> data = userDao.listar(sql);
		listUser.put("0", "Seleccione");
		if (data != null) {
			for (Object[] d : data) {
				listUser.put(d[0].toString(), d[1].toString());
			}
		}
		return listUser;
	}
	
	@Transactional
	public List<User> listarUser() {
		List<User> listUser = new LinkedList<User>();
		String sql = "Select a.id as id, a.type_id as type_id, a.comp_comp_id as comp_comp_id, a.curr_currency_id as curr_currency_id, , a.nivel_organico_id as nivel_organico_id FROM User as a";
		List<Object[]> data = userDao.listar(sql);
		if (data != null) {
			for (Object[] d : data) {
				listUser.add(new User(d[0].toString(), d[1].toString(), (TypeUser) d[2], (Company) d[3], (Currency) d[4] ));
			}
		}
		return listUser;
	}
    
    public void setUserDao(UserDao UserDao) {
        this.userDao = UserDao;
    }
    
    public List<User> getUsers() {
    	return userDao.getUserList();
    }

	public User val(String k, String p) {
		return userDao.val(k,p);
	}

	public boolean addUser(User user) {
		return userDao.addUser(user);
	}
	
	public void deleteUser(String id) {
		userDao.deleteUser(id);
	}

	public User getUser(User user) {
		return userDao.getUser(user);
	}
	
	public boolean editUser(User user) {
		return userDao.editUser(user);
	}

}