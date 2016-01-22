package service.adm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.TypeUser;
import repository.adm.TypeUserDao;
import service.adm.TypeUserService;

@Service
public class TypeServiceServiceImpl implements TypeUserService{

	@Autowired
	private TypeUserDao typeuserdao;

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
