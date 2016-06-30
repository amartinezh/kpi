package repository.login;

import java.util.List;
import java.util.Map;

import domain.login.User;

public interface UserDao {

    public List<User> getUserList();
    public User val(String k, String p);
    public boolean addUser(User user);
    public void deleteUser(String id);
    public User getUser(User user);
    public boolean editUser(User user);
    public int pass(String id, String pass);
    
    public void agregar(Object obj);
	public Object agregar_get(Object obj);
	public void actualizar(Object obj);
	public void borrar(Object obj);
	public List<Object[]> listar(String sql);
	public Object getElemento(Object obj, int id);
	public Object getElemento(Object obj, String id);

}