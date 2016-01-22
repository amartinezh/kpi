package repository.gestion;

import java.util.List;

import javax.persistence.Query;

public interface RepositorioDao {
	
	public void agregar(Object obj);
	public Object agregar_get(Object obj);
	public void actualizar(Object obj);
	public void borrar(Object obj);
	public List<Object[]> listar(String sql);
	public Query listarObjeto(String sql);
	public Object getElemento(Object obj, int id);
	public Object getElemento(Object obj, String id);
}
