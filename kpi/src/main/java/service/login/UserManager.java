 package service.login;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import domain.adm.TypeUser;
import domain.login.User;

public interface UserManager extends Serializable {

    public List<User> getUsers();
    public User val(String k, String p);
    public boolean addUser(User user);
    public User getUser(User user);
    public void deleteUser(String id);
    public boolean editUser(User user);
    public Map<String, String> obtenerDatos();

}