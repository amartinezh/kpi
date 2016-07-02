package controller.adm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import domain.login.User;
import service.login.UserManager;
import service.adm.CompanyService;
import service.adm.CurrencyService;
import service.adm.NivelService;
import service.adm.TypeUserService;

@Controller
@RequestMapping("/user")
@SessionAttributes({ "user_inicio" })
public class UserController {

	@Autowired
	private UserManager user_ser;

	@Autowired
	private TypeUserService type;

	@Autowired
	private CompanyService company;

	@Autowired
	private CurrencyService currency;
	
	@Autowired
	private NivelService nivel;

	@RequestMapping(method = RequestMethod.GET)
	public String panel(Map<String, Object> model) {
		model.put("user", new User());
		model.put("listUser", user_ser.listarUser());
		model.put("cmbTypeUser", type.cmbTypeUser());
		model.put("cmbCompany", company.cmbCompany());
		model.put("cmbCurrency", currency.cmbCurrency());
		model.put("cmbNivel", nivel.cmbNivel());
		return "admin/user";
	}

	@RequestMapping(value = "agregar", method = RequestMethod.POST)
	public @ResponseBody String agregar(
			@RequestParam String id,
			@RequestParam String pass, 
			@RequestParam String type_,
			@RequestParam String comp_,
			@RequestParam String curr_,
			@RequestParam String nivel_,
			@RequestParam String opcion,
			Map<String, Object> model) {

		User obj = new User(id, pass, type.getTypeUser(Integer.parseInt(type_)), company.getCompany(comp_),  currency.getCurrency_(curr_), nivel.getNivel_(nivel_));
		obj.setPass(pass);
		// company.agregarUser(obj);
		if (user_ser.validarUser(obj)) {
			if (opcion.equals("Actualizar")) {
				user_ser.agregarUser(true, obj); // True: merge
				// return "semodifico";
				return "<span class='responsiveExpander'></span><a class='btn btn-success btn-circle btn-sx'"
						+ " onclick=\"con('"
						+ id
						+ "', '"
						+ obj.getType().getDescripcion()
						+ "', '"
						+ obj.getComp().getDescripcion()
						+ "', '"
						+ obj.getCurr().getDescripcion()
						+ "', '"
						+ obj.getNivel().getDescripcion()
						+ "', $(this)"
						+ ")\"><i class='fa fa-edit'></i></a> <a class='btn btn-danger btn-circle' onclick=\"borrar('"
						+ obj.getId()
						+ ", $(this)')\"><i class='fa fa-trash-o'></i></a><span class='responsiveExpander'></span><a class='fa fa-gear fa-3x fa-spin' onclick='pass('"+id+"', $(this))'></a>"
						+ ":::"
						+ obj.getId()
						+ ":::"
						+ obj.getType().getDescripcion()
						+ ":::"
						+ obj.getComp().getDescripcion()
						+ ":::"
						+ obj.getCurr().getDescripcion()
						+ ":::"
						+ obj.getNivel().getDescripcion();
			} else {
				return "yaestaperonosemodifico";
			}
		} else {
			user_ser.agregarUser(false, obj);
		}
		return "<span class='responsiveExpander'></span><a class='btn btn-success btn-circle btn-sx'"
			+ " onclick=\"con('"
			+ id
			+ "', '"
			+ obj.getType().getDescripcion()
			+ "', '"
			+ obj.getComp().getDescripcion()
			+ "', '"
			+ obj.getCurr().getDescripcion()
			+ "', '"
			+ obj.getNivel().getDescripcion()
			+ "', $(this)"
			+ ")\"><i class='fa fa-edit'></i></a> <a class='btn btn-danger btn-circle' onclick=\"borrar('"
			+ obj.getId()
			+ ", $(this)')\"><i class='fa fa-trash-o'></i></a><span class='responsiveExpander'></span><a class='fa fa-gear fa-3x fa-spin' onclick='pass('"+obj.getId()+"', $(this))'></a>"
			+ ":::"
			+ obj.getId()
			+ ":::"
			+ obj.getType().getDescripcion()
			+ ":::"
			+ obj.getComp().getDescripcion()
			+ ":::"
			+ obj.getCurr().getDescripcion()
			+ ":::"
			+ obj.getNivel().getDescripcion();
	}
	
	@RequestMapping(value = "pass", method = RequestMethod.POST)
	public @ResponseBody String pass(
			@RequestParam String id,
			@RequestParam String pass, 
			Map<String, Object> model) {

		User obj = new User();
		obj.setPass(pass);
		return String.valueOf( user_ser.pass(id, obj.getPass() ));
		
	}
	@RequestMapping(value = "cancelar", method = RequestMethod.POST)
	public @ResponseBody String cancelar(
			@RequestParam String id,
			@RequestParam String pass, 
			@RequestParam String type_,
			@RequestParam String comp_,
			@RequestParam String curr_,
			@RequestParam String nivel_,
			Map<String, Object> model) {
		if (!id.equals("0")) {
			String cad = "";
			System.out.print(cad);
			return "<span class='responsiveExpander'></span><a class='btn btn-success btn-circle btn-sx'"
				+ " onclick=\"con('"
				+ id
				+ "', '"
				+ type_
				+ "', $(this)"
				+ ")\"><i class='fa fa-edit'></i></a> <a class='btn btn-danger btn-circle' onclick=\"borrar('"
				+ id
				+ ", $(this)')\"><i class='fa fa-trash-o'></i></a><span class='responsiveExpander'></span>"
				+ ":::"
				+ id
				+ ":::"
				+ type_
				+ ":::"
				+ comp_
				+ ":::"
				+ curr_
				+ ":::"
				+ nivel_;
		} else {
			try {
				Integer.parseInt("a");
			} catch (Exception ex) {

			}
			return "";
		}
	}

	@RequestMapping(value = "borrar", method = RequestMethod.POST)
	public @ResponseBody String borrar(@RequestParam String documento,
			Map<String, Object> model) {
		user_ser.borrarUser(new User(documento));
		return "";
	}

}
