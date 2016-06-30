 package service.login;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import domain.login.User;

public interface UserManager extends Serializable {

    public List<User> getUsers();
    public User val(String k, String p);
    public boolean addUser(User user);
    public User getUser(User user);
    public void deleteUser(String id);
    public boolean editUser(User user);

    public void agregarUser(boolean existe, User user);
	public void borrarUser(User user);
	public boolean validarUser(User user);
	public List<User> listarUser();
	public LinkedHashMap<String, String> cmbUser();
	public int pass(String id, String pass);
}