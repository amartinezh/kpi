package controller.dashboard;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import domain.adm.Company;
import domain.adm.Plan;
import domain.adm.Region;
import domain.session.session;
//import service.gestion.PlanService;
import service.kpi.KpiService;

@Controller
@RequestMapping("/indicadores")
@SessionAttributes({ "user_inicio" })
public class financesController {

	@Autowired
	private KpiService kpiService;
	
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
	
	@RequestMapping(value = "/menufinances", method = RequestMethod.GET)
	public String menuFinances(Model model, @RequestParam String t, @RequestParam String r3g, @RequestParam String op10) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			model.addAttribute("r3g",r3g);
			model.addAttribute("op10",op10);
			switch (Integer.parseInt(op10)) {
            	case 1: 
            		model.addAttribute("view","salesMonth");
            		break;
            	case 2: 
            		model.addAttribute("view","salesYear");
            		break;
            	case 3: 
            		model.addAttribute("view", "salesQuarterly");
            		break;
            	default:
            		break;
			}
			return "menu";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/financesYear", method = RequestMethod.GET)
	public String financesYear(Model model, @RequestParam String t, @RequestParam String op10) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			model.addAttribute("valor", kpiService.listSales((session) model.asMap().get("user_inicio")));
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
			return "salesYear";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/financesMonth", method = RequestMethod.GET)
	public String financesMonth(Model model, @RequestParam String t, @RequestParam String op10) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			
			((session) model.asMap().get("user_inicio")).setOp("M");
			// Lista
			model.addAttribute("valor", kpiService.listSalesMonth((session) model.asMap().get("user_inicio")));
			
			model.addAttribute("navegacion",
					"Region: " + r + " >> " +
					"Company: " + n + " >> " +
					"Currency: " + currencyService.getCurrency(((session) model.asMap().get("user_inicio")).getDash_moneda()).get(0).getDescripcion() + " >> " +
					(  ((session) model.asMap().get("user_inicio")).getDash_tasa()=="mvevap"?"Average":"Month Rate") +
					" >> Year: " + ((session) model.asMap().get("user_inicio")).getAnio() +
					" >> Month: " + Months.values()[Integer.parseInt(((session) model.asMap().get("user_inicio")).getMes())]
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
			model.addAttribute("elmes", Months.values()[Integer.parseInt(((session) model.asMap().get("user_inicio")).getMes())]);
			return "salesMonth";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/financesQuarterly", method = RequestMethod.GET)
	public String financesQuarterly(Model model, @RequestParam String t) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			model.addAttribute("valor", kpiService.listSalesQuarterly((session) model.asMap().get("user_inicio")));
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
			return "salesQuarterly";
		} else {
			return "redirect:/index/ingreso";
		}
	}
}
