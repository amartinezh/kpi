package controller.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import domain.session.session;
//import service.gestion.PlanService;
import service.kpi.FinancesService;;

@Controller
@RequestMapping("/finance")
@SessionAttributes({ "user_inicio" })
public class financesController {

	@Autowired
	private FinancesService financesService;
	
	@Autowired
	private service.adm.RegionService regionService;
	
	@Autowired
	private service.adm.CompanyService companyService;
	
	@Autowired
	private service.adm.CurrencyService currencyService;

	//@Autowired
	//private PlanService planService;
	
	private enum Months {
		January, February, March, April, May, June, July, August, September, October, November, December;
	}
	
	@RequestMapping(value = "/financeYear", method = RequestMethod.GET)
	public String financesYear(Model model, @RequestParam String t, @RequestParam String op10) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			model.addAttribute("valor", financesService.listFinance(((session) model.asMap().get("user_inicio"))));
			model.addAttribute("navegacion",
					"Region: " + r + " >> " +
					"Company: " + n + " >> " +
					"Currency: " + currencyService.getCurrency(((session) model.asMap().get("user_inicio")).getDash_moneda()).get(0).getDescripcion() + " >> " +
					(  ((session) model.asMap().get("user_inicio")).getDash_tasa()=="mvevap"?"Average":"Month Rate") +
					" >> Year: " + ((session) model.asMap().get("user_inicio")).getAnio()
					);
			
			model.addAttribute("regionList", regionService.getListRegion());
			//if (((session) model.asMap().get("user_inicio")).getDash_region().equals("Todas")){
				model.addAttribute("currencyList", currencyService.listCurrency());
			//}
			//else{
			//	model.addAttribute("currencyList", "0");
			//}
			
			model.addAttribute("companyList", companyService.listCompany(((session) model.asMap().get("user_inicio")).getDash_region()));
			model.addAttribute("r3g", ((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("c1a", ((session) model.asMap().get("user_inicio")).getDash_nia());
			model.addAttribute("cur", ((session) model.asMap().get("user_inicio")).getDash_moneda());
			model.addAttribute("tas", ((session) model.asMap().get("user_inicio")).getDash_tasa());
			model.addAttribute("anio",((session) model.asMap().get("user_inicio")).getAnio());
			return "finance/financeYear";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/financeMonth", method = RequestMethod.GET)
	public String financesMonth(Model model, @RequestParam String t, @RequestParam String op10) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			
			((session) model.asMap().get("user_inicio")).setOp("M");
			// Lista
			model.addAttribute("valor", financesService.listFinanceMonth((session) model.asMap().get("user_inicio")));
			
			model.addAttribute("navegacion",
					"Region: " + r + " >> " +
					"Company: " + n + " >> " +
					"Currency: " + currencyService.getCurrency(((session) model.asMap().get("user_inicio")).getDash_moneda()).get(0).getDescripcion() + " >> " +
					(  ((session) model.asMap().get("user_inicio")).getDash_tasa()=="mvevap"?"Average":"Month Rate") +
					" >> Year: " + ((session) model.asMap().get("user_inicio")).getAnio() +
					" >> Month: " + Months.values()[Integer.parseInt(((session) model.asMap().get("user_inicio")).getMes())-1]
					);
			
			model.addAttribute("regionList", regionService.getListRegion());
			model.addAttribute("currencyList", currencyService.listCurrency());
			
			model.addAttribute("op10",op10);
			model.addAttribute("companyList", companyService.listCompany(((session) model.asMap().get("user_inicio")).getDash_region()));
			model.addAttribute("r3g", ((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("c1a", ((session) model.asMap().get("user_inicio")).getDash_nia());
			model.addAttribute("cur", ((session) model.asMap().get("user_inicio")).getDash_moneda());
			model.addAttribute("tas", ((session) model.asMap().get("user_inicio")).getDash_tasa());
			model.addAttribute("anio",((session) model.asMap().get("user_inicio")).getAnio());
			model.addAttribute("mes",((session) model.asMap().get("user_inicio")).getMes());
			model.addAttribute("elmes", Months.values()[Integer.parseInt(((session) model.asMap().get("user_inicio")).getMes())-1]);
			return "finance/financeMonth";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/financeQuarterly", method = RequestMethod.GET)
	public String financesQuarterly(Model model, @RequestParam String t) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			model.addAttribute("valor", financesService.listFinanceQuarterly(((session) model.asMap().get("user_inicio"))));
			model.addAttribute("navegacion",
					"Region: " + r + " >> " +
					"Company: " + n + " >> " +
					"Currency: " + currencyService.getCurrency(((session) model.asMap().get("user_inicio")).getDash_moneda()).get(0).getDescripcion() + " >> " +
					(  ((session) model.asMap().get("user_inicio")).getDash_tasa()=="mvevap"?"Average":"Month Rate") +
					" >> Year: " + ((session) model.asMap().get("user_inicio")).getAnio()
					);
			
			model.addAttribute("regionList", regionService.getListRegion());
			model.addAttribute("currencyList", currencyService.listCurrency());
			
			model.addAttribute("companyList", companyService.listCompany(((session) model.asMap().get("user_inicio")).getDash_region()));
			model.addAttribute("r3g", ((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("c1a", ((session) model.asMap().get("user_inicio")).getDash_nia());
			model.addAttribute("cur", ((session) model.asMap().get("user_inicio")).getDash_moneda());
			model.addAttribute("tas", ((session) model.asMap().get("user_inicio")).getDash_tasa());
			model.addAttribute("anio",((session) model.asMap().get("user_inicio")).getAnio());
			return "/finance/financeQuarterly";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	// /////////////////////////////////////////////////////////////////////////////////
	// / Método del controlador para cambiar la vista cuando seleccione
	// diferente moneda
	// /////////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/cia", method = RequestMethod.POST)
	public String cia(@RequestParam String r3g, @RequestParam String c1a,
			Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			((session) model.asMap().get("user_inicio")).setDash_region(r3g);
			((session) model.asMap().get("user_inicio")).setDash_nia(c1a);
			return "dashboard";
		} else {
			return "redirect:/index/ingreso";
		}
	}

	// /////////////////////////////////////////////////////////////////////////////////
	// / Método del controlador para cambiar la vista cuando seleccione
	// diferente moneda
	// /////////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/moneda", method = RequestMethod.POST)
	public String agrega(@RequestParam String m3r, @RequestParam String t4s4,
			Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			if (m3r.equals("0")) {
				if (t4s4.equals("p")){
					((session) model.asMap().get("user_inicio")).setMoneda("mvevap");
					((session) model.asMap().get("user_inicio")).setDash_tasa("mvevap");
				}
				else{
					((session) model.asMap().get("user_inicio")).setMoneda("mveval");
					((session) model.asMap().get("user_inicio")).setDash_tasa("mveval");
				}
				((session) model.asMap().get("user_inicio")).setDash_moneda("0");
				return "dashboard";
			} else if (m3r.equals("1")) {
				((session) model.asMap().get("user_inicio")).setDash_moneda("1");
				((session) model.asMap().get("user_inicio")).setMoneda("mvevac");
				((session) model.asMap().get("user_inicio")).setDash_tasa("mvevac");
				return "dashboard";
			} else {
				return "redirect:/index/ingreso";
			}
		} else {
			return "redirect:/index/ingreso";
		}
	}

	// /////////////////////////////////////////////////////////////////////////////////
	// / Método del controlador para cambiar la vista cuando seleccione
	// diferente tasa
	// /////////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/tasa", method = RequestMethod.POST)
	public String tasa(@RequestParam String t4s4, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			System.out.println("Opción"+t4s4);
			if (t4s4.equals("p")) {
				((session) model.asMap().get("user_inicio")).setMoneda("mvevap");
				((session) model.asMap().get("user_inicio")).setDash_tasa("mvevap");
				return "dashboard";
			} else if (t4s4.equals("m")) {
				((session) model.asMap().get("user_inicio")).setMoneda("mveval");
				((session) model.asMap().get("user_inicio")).setDash_tasa("mveval");
				return "dashboard";
			} else {
				return "redirect:/index/ingreso";
			}
		} else {
			return "redirect:/index/ingreso";
		}
	}

	// /////////////////////////////////////////////////////////////////////////////////
	// / Método del controlador para cambiar la vista cuando seleccione
	// diferente Año
	// /////////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/anio", method = RequestMethod.POST)
	public String anio(@RequestParam String anio, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			((session) model.asMap().get("user_inicio")).setAnio(anio);
			return "dashboard";
		} else {
			return "redirect:/index/ingreso";
		}
	}

	// /////////////////////////////////////////////////////////////////////////////////
	// / Método del controlador para cambiar la vista cuando seleccione
	// diferente Año
	// /////////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/mes", method = RequestMethod.POST)
	public String mes(@RequestParam String mes, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			((session) model.asMap().get("user_inicio")).setMes(mes);
			return "salesMonth";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/chartjs", method = RequestMethod.GET)
	public String chartjs(@RequestParam String i, @RequestParam String indicador, @RequestParam String p, @RequestParam String op, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			//model.addAttribute("valor", kpiService.listKip((session) model.asMap().get("user_inicio")));
			model.addAttribute("i",i);
			model.addAttribute("p",p);
			model.addAttribute("op",op);
			model.addAttribute("indicador",indicador);
			return "chartjs";
		} else {
			return "redirect:/index/ingreso";
		}
	}
}
