package repository.adm;

import java.util.List;

import domain.adm.TypeUser;

public interface TypeUserDao {
	
	public List<TypeUser> listTypeUser();
	public void saveTypeUser(TypeUser typeuser);
	public void deleteTypeUser(int id);
	public TypeUser getTypeUser(int id);
	
	// Tiene dos métodos repetidos debido a fusion de dos programadores, pendiente por eliminar los de arriba
	public void agregar(Object obj);
	public Object agregar_get(Object obj);
	public void actualizar(Object obj);
	public void borrar(Object obj);
	public List<Object[]> listar(String sql);
	public Object getElemento(Object obj, int id);
	public Object getElemento(Object obj, String id);
	
}
