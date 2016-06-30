package repository.adm;

import java.util.List;

import domain.adm.Nivel;

public interface NivelDao {
	
	public List<Nivel> listNivel();
	public List<Nivel> getNivel(String id);
	public Nivel getNivel_(int id);
	
	public void agregar(Object obj);
	public Object agregar_get(Object obj);
	public void actualizar(Object obj);
	public void borrar(Object obj);
	public List<Object[]> listar(String sql);
	public Object getElemento(Object obj, int id);
	public Object getElemento(Object obj, String id);
}
