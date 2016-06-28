package service.adm.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Currency;
import domain.adm.TypeUser;
import repository.adm.TypeUserDao;
import service.adm.TypeUserService;

@Service
public class TypeServiceServiceImpl implements TypeUserService{

	@Autowired
	private TypeUserDao typeuserdao;
	
	@Transactional
	public void agregarTypeUser(boolean existe, TypeUser typeuser) {
		if (existe == true){
			typeuserdao.actualizar(typeuser);
		}
		else {
			typeuserdao.agregar(typeuser);
		}
	}

	@Transactional
	public void borrarTypeUser(TypeUser typeuser) {
		TypeUser obj = (TypeUser) typeuserdao.getElemento(typeuser, typeuser.getId());
		typeuserdao.borrar(obj);
	}
	
	@Transactional
	public boolean validarTypeUser(TypeUser typeuser) {
		TypeUser cont = (TypeUser) typeuserdao.getElemento(typeuser, typeuser.getId());
		if (cont == null)
			return false;
		return true;
	}
	
	@Transactional
	public LinkedHashMap<String, String> cmbTypeUser() {
		LinkedHashMap<String, String> listTypeUser = new LinkedHashMap<String, String>();
		String sql = "Select a.id as id, a.descripcion as descripcion FROM TypeUser as a";
		List<Object[]> data = typeuserdao.listar(sql);
		listTypeUser.put("0", "Seleccione");
		if (data != null) {
			for (Object[] d : data) {
				listTypeUser.put(d[0].toString(), d[1].toString());
			}
		}
		return listTypeUser;
	}
	
	@Transactional
	public List<TypeUser> listarTypeUser() {
		List<TypeUser> listTypeUser = new LinkedList<TypeUser>();
		String sql = "Select a.id as id, a.descripcion as descripcion FROM TypeUser as a";
		List<Object[]> data = typeuserdao.listar(sql);
		if (data != null) {
			for (Object[] d : data) {
				listTypeUser.add(new TypeUser(Integer.parseInt( d[0].toString() ), d[1].toString()));
			}
		}
		return listTypeUser;
	}

	@Transactional
	public void saveTypeUser(TypeUser typeuser) {
		typeuserdao.saveTypeUser(typeuser);
	}

	@Transactional
	public void deleteTypeUser(int id) {
		typeuserdao.deleteTypeUser(id);
	}

	@Transactional(readOnly = true)
	public TypeUser getTypeUser(int id) {
		return typeuserdao.getTypeUser(id);
	}
	
	@Transactional(readOnly = true)
	public List<TypeUser> listTypeUser() {
		return typeuserdao.listTypeUser();
	}
	
}
