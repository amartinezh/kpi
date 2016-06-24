package controller.adm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import domain.adm.Company;
import service.adm.CompanyService;
import service.adm.RegionService;

@Controller 
@RequestMapping("/company")
@SessionAttributes({ "user_inicio" })
public class CompanyController {

	@Autowired
	private CompanyService company;
	
	@Autowired
	private RegionService region;

	@RequestMapping(method = RequestMethod.GET)
	public String panel(Map<String, Object> model) {
		model.put("company", new Company());
		model.put("listCompany", company.listarCompany());
		model.put("cmbRegion", region.cmbRegion());
		
		return "admin/company";
	}

	@RequestMapping(value = "agregar", method = RequestMethod.POST)
	public @ResponseBody String agregar(@RequestParam String company_id,
			@RequestParam String opcion,
			@RequestParam String region_id,
			@RequestParam String descripcion, Map<String, Object> model) {
		
		Company obj = new Company(company_id, descripcion, region.getRegion_(region_id));
		//company.agregarCompany(obj);
		if (company.validarCompany(obj)){
			if (opcion.equals("Actualizar")){
				company.agregarCompany(true, obj); // True: merge
				//return "semodifico";
				return "<span class='responsiveExpander'></span><a class='btn btn-success btn-circle btn-sx'"
				+ " onclick=\"con('"
				+ company_id
				+ "', '"
				+ obj.getDescripcion()
				+ "', $(this)"
				+ ")\"><i class='fa fa-edit'></i></a> <a class='btn btn-danger btn-circle' onclick=\"borrar('"
				+ obj.getId()
				+ ", $(this)')\"><i class='fa fa-trash-o'></i></a><span class='responsiveExpander'></span>:::"
				+ descripcion
				+ ":::"+obj.getRegion_id().getRegion_id();
			}
			else{
				return "yaestaperonosemodifico";
			}
		}
		else{
			company.agregarCompany(false, obj);
		}
		return "<span class='responsiveExpander'></span><a class='btn btn-success btn-circle btn-sx'"
				+ " onclick=\"con('"
				+ company_id
				+ "', '"
				+ obj.getDescripcion()
				+ "', $(this)"
				+ ")\"><i class='fa fa-edit'></i></a> <a class='btn btn-danger btn-circle' onclick=\"borrar('"
				+ obj.getId()
				+ ", $(this)')\"><i class='fa fa-trash-o'></i></a><span class='responsiveExpander'></span>:::"
				+ descripcion
				+ ":::"+obj.getRegion_id().getRegion_id();
	}

	@RequestMapping(value = "cancelar", method = RequestMethod.POST)
	public @ResponseBody String cancelar(@RequestParam String company_id,
			@RequestParam String descripcion, Map<String, Object> model){
		if (!company_id.equals("0")) {
			String cad = "";
			System.out.print(cad);
			return "<span class='responsiveExpander'></span><a class='btn btn-success btn-circle btn-sx'"
					+ " onclick=\"con('"
					+ company_id
					+ "', '"
					+ descripcion
					+ "', $(this)"
					+ ")\"><i class='fa fa-edit'></i></a>"
					+ " <a class='btn btn-danger btn-circle' onclick='borrar("
					+ company_id
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
		company.borrarCompany(new Company(documento) );
		return "";
	}

}
