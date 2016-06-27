package service.adm;

import java.util.LinkedHashMap;
import java.util.List;

import domain.adm.Nivel;

public interface NivelService {

	public List<Nivel> listNivel();
	public List<Nivel> getNivel(String id);
	public Nivel getNivel_(String id);
	
	public void agregarNivel(boolean existe, Nivel nivel);
	public void borrarNivel(Nivel nivel);
	public boolean validarNivel(Nivel nivel);
	public List<Nivel> listarNivel();
	public LinkedHashMap<String, String> cmbNivel();
}