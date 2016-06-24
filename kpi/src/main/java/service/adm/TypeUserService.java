package service.adm;

import java.util.LinkedHashMap;
import java.util.List;

import domain.adm.Currency;
import domain.adm.TypeUser;

public interface TypeUserService {
	
	public void saveTypeUser(TypeUser typeuser);
	public List<TypeUser> listTypeUser();
	public TypeUser getTypeUser(int id);
	public void deleteTypeUser(int id);
	
	// Pendiente por eliminar los métodos repetidos de arriba
	public void agregarTypeUser(boolean existe, TypeUser typeuser);
	public void borrarTypeUser(TypeUser typeuser);
	public boolean validarTypeUser(TypeUser typeuser);
	public List<TypeUser> listarTypeUser();
	public LinkedHashMap<String, String> cmbTypeUser();
	
}
