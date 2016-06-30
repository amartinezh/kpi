package service.adm.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Nivel;
import repository.adm.NivelDao;
import service.adm.NivelService;

@Service
public class NivelServiceImpl implements NivelService {

	@Autowired
	private NivelDao nivelDao;
	
	@Transactional
	public void agregarNivel(boolean existe, Nivel nivel) {
		if (existe == true){
			nivelDao.actualizar(nivel);
		}
		else {
			nivelDao.agregar(nivel);
		}
	}

	@Transactional
	public void borrarNivel(Nivel nivel) {
		Nivel obj = (Nivel) nivelDao.getElemento(nivel, nivel.getId());
		nivelDao.borrar(obj);
	}
	
	@Transactional
	public boolean validarNivel(Nivel nivel) {
		Nivel cont = (Nivel) nivelDao.getElemento(nivel, nivel.getId());
		if (cont == null)
			return false;
		return true;
	}
	
	@Transactional
	public LinkedHashMap<String, String> cmbNivel() {
		LinkedHashMap<String, String> listNivel = new LinkedHashMap<String, String>();
		String sql = "Select a.id as id, a.descripcion as descripcion FROM Nivel as a";
		List<Object[]> data = nivelDao.listar(sql);
		listNivel.put("0", "Seleccione");
		if (data != null) {
			for (Object[] d : data) {
				listNivel.put(d[0].toString(), d[1].toString());
			}
		}
		return listNivel;
	}
	
	@Transactional
	public List<Nivel> listarNivel() {
		List<Nivel> listNivel = new LinkedList<Nivel>();
		String sql = "Select a.id as id, a.descripcion as descripcion FROM Nivel as a";
		List<Object[]> data = nivelDao.listar(sql);
		if (data != null) {
			for (Object[] d : data) {
				listNivel.add(new Nivel(Integer.parseInt( d[0].toString() ), d[1].toString()));
			}
		}
		return listNivel;
	}
	
	public List<Nivel> listNivel() {
		return nivelDao.listNivel();
	}
	
	public List<Nivel> getNivel(String id){
		return nivelDao.getNivel(id);
	}
	
	public Nivel getNivel_(String id){
		return nivelDao.getNivel_(Integer.parseInt(id));
	}
}
