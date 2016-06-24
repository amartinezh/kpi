package controller.adm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import domain.adm.TypeUser;
import service.adm.TypeUserService;

@Controller 
@RequestMapping("/typeuser")
@SessionAttributes({ "user_inicio" })
public class TypeUserController {

	@Autowired
	private TypeUserService typeuser;

	@RequestMapping(method = RequestMethod.GET)
	public String panel(Map<String, Object> model) {
		model.put("typeuser", new TypeUser());
		model.put("listTypeUser", typeuser.listarTypeUser());
		model.put("cmbTypeUser", typeuser.cmbTypeUser());
		return "admin/typeuser";
	}

	@RequestMapping(value = "agregar", method = RequestMethod.POST)
	public @ResponseBody String agregar(@RequestParam String id,
			@RequestParam String opcion,
			@RequestParam String descripcion, Map<String, Object> model) {
		
		TypeUser obj = new TypeUser(Integer.parseInt( id ), descripcion);
		//currency.agregarCurrency(obj);
		if (typeuser.validarTypeUser(obj)){
			if (opcion.equals("Actualizar")){
				typeuser.agregarTypeUser(true, obj); // True: merge
				//return "semodifico";
				return "<span class='responsiveExpander'></span><a class='btn btn-success btn-circle btn-sx'"
				+ " onclick=\"con('"
				+ id
				+ "', '"
				+ obj.getDescripcion()
				+ "', $(this)"
				+ ")\"><i class='fa fa-edit'></i></a> <a class='btn btn-danger btn-circle' onclick=\"borrar('"
				+ obj.getId()
				+ ", $(this)')\"><i class='fa fa-trash-o'></i></a><span class='responsiveExpander'></span>:::"
				+ descripcion;
			}
			else{
				return "yaestaperonosemodifico";
			}
		}
		else{
			typeuser.agregarTypeUser(false, obj);
		}
		return "<span class='responsiveExpander'></span><a class='btn btn-success btn-circle btn-sx'"
				+ " onclick=\"con('"
				+ id
				+ "', '"
				+ obj.getDescripcion()
				+ "', $(this)"
				+ ")\"><i class='fa fa-edit'></i></a> <a class='btn btn-danger btn-circle' onclick=\"borrar('"
				+ obj.getId()
				+ ", $(this)')\"><i class='fa fa-trash-o'></i></a><span class='responsiveExpander'></span>:::"
				+ descripcion;
	}

	@RequestMapping(value = "cancelar", method = RequestMethod.POST)
	public @ResponseBody String cancelar(@RequestParam String currency_id,
			@RequestParam String descripcion, Map<String, Object> model){
		if (!currency_id.equals("0")) {
			return "<span class='responsiveExpander'></span><a class='btn btn-success btn-circle btn-sx'"
					+ " onclick=\"con('"
					+ currency_id
					+ "', '"
					+ descripcion
					+ "', $(this)"
					+ ")\"><i class='fa fa-edit'></i></a>"
					+ " <a class='btn btn-danger btn-circle' onclick='borrar("
					+ currency_id
					+ ", $(this))'><i class='fa fa-trash-o'></i></a>"
					+ "<span class='responsiveExpander'></span>:::"
					+ descripcion + "";
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
		typeuser.borrarTypeUser(new TypeUser(Integer.parseInt( documento) ));
		return "";
	}
}
