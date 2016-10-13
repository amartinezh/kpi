package repository.kpi.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.adm.Cfg;
import domain.adm.CfgDistri;
import domain.kpi.Distri;
import domain.kpi.reporteDistri;
import domain.session.session;
import repository.kpi.DistriDao;
import service.adm.CfgDistriService;
import service.adm.CfgService;

@Repository
public class DistriDaoImpl implements DistriDao {

	@PersistenceContext
	private EntityManager em = null;

	@Autowired
	private CfgDistriService cfgService;
	
	private enum Indicadores {
		VEN005, VEN008, VEN010, VEN011, VEN012, VEN013;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	// listSales //////////////////////////////////////////////////////////////////////////////////
	// listSales //////////////////////////////////////////////////////////////////////////////////
	// listSales //////////////////////////////////////////////////////////////////////////////////
	// listSales //////////////////////////////////////////////////////////////////////////////////
	// listSales //////////////////////////////////////////////////////////////////////////////////
	// listSales //////////////////////////////////////////////////////////////////////////////////
	// listSales //////////////////////////////////////////////////////////////////////////////////
	// listSales //////////////////////////////////////////////////////////////////////////////////

	public List<reporteDistri> listSales(session ses) {
		List<reporteDistri> valor = new LinkedList<reporteDistri>();
		List<CfgDistri> indicadores = cfgService.getListCfg();
		java.math.BigDecimal promMvevalRealAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal promMvevpePresupuestadoAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		
		java.math.BigDecimal anioAntReal = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal anioAntPres = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		
		java.math.BigDecimal valorMesReal = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal valorMesPresupuesto = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		
		String sql="";
		if (!ses.getDash_nia().equals("Todas")){
			sql = " AND k.mvecia='"+ses.getDash_nia()+"' ";
		}
		if (!ses.getDash_region().equals("Todas")){
			sql += " AND k.mvereg='"+ses.getDash_region()+"' ";
		}
		String operacion_primer_campo="";
		String operacion_segundo_campo="";
		String filtro="";
		// Lee todos los indicadores de la base de datos
		for (CfgDistri cfg : indicadores) {
			
			if (cfg.getOperacion().equals("AV2")){
				 operacion_primer_campo="avg";
				 operacion_segundo_campo="max";
			}
			else{
				operacion_primer_campo=cfg.getOperacion();
				operacion_segundo_campo=cfg.getOperacion();
			}
			
			// Se interpretan diferente ciertos indicadores, se toma el máximo pero si la bandera mverid es 1
			//if ( cfg.getIndicador().equals("VEN004") || cfg.getIndicador().equals("VEN005") || cfg.getIndicador().equals("VEN006") || cfg.getIndicador().equals("VEN007") || cfg.getIndicador().equals("VEN008") || cfg.getIndicador().equals("VEN009") || cfg.getIndicador().equals("VEN010") || cfg.getIndicador().equals("VEN012") || cfg.getIndicador().equals("VEN013") || cfg.getIndicador().equals("VEN014") || cfg.getIndicador().equals("VEN015") || cfg.getIndicador().equals("VEN016") || cfg.getIndicador().equals("VEN017")){
			//	operacion_primer_campo="max";
			//	filtro = " AND k.mverid='1' ";
			//}
			//else{
			//	filtro = "";
			//}
			operacion_primer_campo="max";
			filtro = " AND k.mverid='1' ";
			// Va a la base de datos y toma para cada indicador
			@SuppressWarnings("unchecked")
			List<Object[]> result = em
					.createQuery(
							"Select k.mveano as mveano, k.mvemes as mvemes, k.mvedes as mvedes, "+operacion_primer_campo+"(k."+ses.getDash_tasa()+") as mveval, "+operacion_segundo_campo+"(k.mvevpe) as mvevpe"
									+ " From Distri as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ filtro
									+ sql
									+ " AND k.mveano='"+ses.getAnio()+"' "
									+ " GROUP BY k.mveano , k.mvemes, k.mvedes"
									+ " ORDER BY k.mvedes, k.mveano , k.mvemes asc")
					.getResultList();

			// Se crea un objeto lista para almacenar todo año (solo la línea del indicador)
			List<Distri> list = new LinkedList<Distri>();
			
			// Se inician los 12 meses
			for (int i = 0; i < 12; i++) {
				list.add(new Distri("2015", "" + (i + 1)));
			}
			int meses=0;
			// Se va colocando cada mes en la hoja de resultado
			for (Object[] r : result) {
				list.get(Integer.parseInt(r[1].toString())-1).setMveval(
							new BigDecimal(r[3].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN));
				list.get(Integer.parseInt(r[1].toString())-1).setMvevpe(
						new BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));

				list.get(1).setMvedes(r[2].toString());

				promMvevalRealAnoActual=promMvevalRealAnoActual.add(new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
					
				valorMesReal=new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				valorMesPresupuesto=new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				meses++;
			}
			// Se le quita el mes en curso para el total y el promedio
			meses--;
			meses=(meses==0?1:meses);
			
			promMvevalRealAnoActual=promMvevalRealAnoActual.subtract(valorMesReal);
			promMvevalRealAnoActual=promMvevalRealAnoActual.divide(new BigDecimal(meses), 2, RoundingMode.HALF_UP);
			
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.subtract(valorMesPresupuesto);
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.divide(new BigDecimal(meses), 2, RoundingMode.HALF_UP);
			
			// Se obtiene el promedio del año anterior por cada línea generada
			
		    @SuppressWarnings("unchecked")
		    List<Object[]> prom = em
					.createQuery(
							"Select k.mveano as mveano, "+operacion_primer_campo+"(k."+ses.getDash_tasa()+") as mveval, "+operacion_segundo_campo+"(k.mvevpe) as mvevpe"
									+ " From Distri as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ filtro
									+ " and mveano = " + (Integer.parseInt(ses.getAnio()) - 1)
									+ sql
									//+ " AND k.mvecia='"+ses.getDash_nia()+"' "
									+ " GROUP BY k.mveano"
									+ " ORDER BY k.mveano asc")
					.getResultList();
				
		    if (prom.size() > 0){
				anioAntReal = new java.math.BigDecimal(prom.get(0)[1].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				anioAntPres = new java.math.BigDecimal(prom.get(0)[2].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			}
			else{
				anioAntReal = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				anioAntPres = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			}
			
			// Se va agregando a la hoja de reporte cada línea para luego ser mostrada en la vista
			// llega tal cual se mostrará
		    
			if (list.get(1).getMvedes() != null){
				valor.add(new reporteDistri(list.get(1).getMvedes(), cfg.getIndicador(), 
						cfg.getUnidad(), "Actual", "Budget",
						anioAntReal,
						anioAntPres,
						promMvevalRealAnoActual, 
						promMvevpePresupuestadoAnoActual,
						new ArrayList<Distri>(list),cfg.getTipo(),
						(cfg.getOperacion().equals("AV2")?"AVG":cfg.getOperacion())
						));
			}
			promMvevalRealAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			promMvevpePresupuestadoAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		}
		return valor;
	}
	
	// listSalesMonth //////////////////////////////////////////////////////////////////////////////////
	// listSalesMonth //////////////////////////////////////////////////////////////////////////////////
	// listSalesMonth //////////////////////////////////////////////////////////////////////////////////
	// listSalesMonth //////////////////////////////////////////////////////////////////////////////////
	// listSalesMonth //////////////////////////////////////////////////////////////////////////////////
	// listSalesMonth //////////////////////////////////////////////////////////////////////////////////
	// listSalesMonth //////////////////////////////////////////////////////////////////////////////////
	// listSalesMonth //////////////////////////////////////////////////////////////////////////////////
	// listSalesMonth //////////////////////////////////////////////////////////////////////////////////

	public List<reporteDistri> listSalesMonth(session ses) {
		List<reporteDistri> valor = new LinkedList<reporteDistri>();
		List<CfgDistri> indicadores = cfgService.getListCfg();
		java.math.BigDecimal promMvevalRealAnoActual = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal promMvevpePresupuestadoAnoActual = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		java.math.BigDecimal anioAntReal = new java.math.BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal anioAntPres = new java.math.BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		String sql="";
		if (!ses.getDash_nia().equals("Todas")){
			sql = " AND k.mvecia='"+ses.getDash_nia()+"' ";
		}
		if (!ses.getDash_region().equals("Todas")){
			sql += " AND k.mvereg='"+ses.getDash_region()+"' ";
		}
		//sql += " AND k.mvemes='"+ses.getMes()+"' ";
		// Lee todos los indicadores de la base de datos
		String operacion_primer_campo="";
		String operacion_segundo_campo="";
		String filtro="";
		for (CfgDistri cfg : indicadores) {
			System.out.println("Operación:"+cfg.getOperacion());
			if (cfg.getOperacion().equals("AV2")){
				 operacion_primer_campo="avg";
				 operacion_segundo_campo="max";
			}
			else{
				operacion_primer_campo=cfg.getOperacion();
				operacion_segundo_campo=cfg.getOperacion();
			}
			
			// Se interpretan diferente ciertos indicadores, se toma el máximo pero si la bandera mverid es 1
			//if ( cfg.getIndicador().equals("VEN004") || cfg.getIndicador().equals("VEN005") || cfg.getIndicador().equals("VEN006") || cfg.getIndicador().equals("VEN007") || cfg.getIndicador().equals("VEN008") || cfg.getIndicador().equals("VEN009") || cfg.getIndicador().equals("VEN010") || cfg.getIndicador().equals("VEN012") || cfg.getIndicador().equals("VEN013") || cfg.getIndicador().equals("VEN014") || cfg.getIndicador().equals("VEN015") || cfg.getIndicador().equals("VEN016") || cfg.getIndicador().equals("VEN017")){
			//	operacion_primer_campo="max";
			//	filtro = " AND k.mverid='1' ";
			//}
			//else{
			//	filtro = "";
			//}
			operacion_primer_campo="max";
			filtro = " AND k.mverid='1' ";
			
			// Va a la base de datos y toma para cada indicador
			@SuppressWarnings("unchecked")
			List<Object[]> result = em
					.createQuery(
							"Select k.mveano as mveano, k.mvemes as mvemes, k.mvedes as mvedes, "+operacion_primer_campo+"(k."+ses.getDash_tasa()+") as mveval, "+operacion_segundo_campo+"(k.mvevpe) as mvevpe"
									+ " From Distri as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ filtro
									+ sql
									+ " AND k.mveano='"+ses.getAnio()+"' "
									+ " AND k.mvemes='"+ses.getMes()+"' "
									+ " GROUP BY k.mveano , k.mvemes, k.mvedes"
									+ " ORDER BY k.mvedes, k.mveano , k.mvemes asc")
					.getResultList();

			// Se crea un objeto lista para almacenar todo año (solo la línea del indicador)
			List<Distri> list = new LinkedList<Distri>();
			
			// Se inician los 12 meses
			//for (int i = 0; i < 12; i++) {
			//	list.add(new Kpi("2015", "" + (i + 1)));
			//}
			list.add(new Distri("2000", ses.getMes() ));
			System.out.println("Tamaño"+list.size());
			int meses=0;
			// Se va colocando cada mes en la hoja de resultado
			for (Object[] r : result) {
				
				// Valor Budget
				list.get(0).setMveval(
						new BigDecimal(r[3].toString()).setScale(8,	BigDecimal.ROUND_HALF_EVEN));

				// Valor Budget
				list.get(0).setMvevpe(
						new BigDecimal(r[4].toString()).setScale(8, BigDecimal.ROUND_HALF_EVEN));

				list.get(0).setMvedes(r[2].toString());

				//promMvevalRealAnoActual=promMvevalRealAnoActual.add(new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				//promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				
				meses++;
			}
			
			/* meses=(meses==0?1:meses);
			
			// Se le quita el mes actual al promedio anual Actual
			
			
			
			promMvevalRealAnoActual=promMvevalRealAnoActual.divide(new BigDecimal(meses), 2, RoundingMode.HALF_UP);
			
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.divide(new BigDecimal(meses), 2, RoundingMode.HALF_UP);
			//System.out.println(promMveval.toString());
			
			*/
			
			// Se obtiene el promedio del año anterior por cada línea generada
			System.out.println("Mirará año anterior:");
		    @SuppressWarnings("unchecked")
		    List<Object[]> prom = em
					.createQuery(
							"Select k.mveano as mveano, "+operacion_primer_campo+"(k."+ses.getDash_tasa()+") as mveval, "+operacion_segundo_campo+"(k.mvevpe) as mvevpe"
									+ " From Distri as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ filtro
									+ " and mveano = " + (Integer.parseInt(ses.getAnio()) - 1)
									//+ sql
									+ " AND k.mvecia='"+ses.getDash_nia()+"' "
									+ " GROUP BY k.mveano"
									+ " ORDER BY k.mveano asc")
					.getResultList();
		    
		    if (prom.size() > 0){
		    	//System.out.println("-----------"+prom.get(0)[0].toString()+"----------------------");
				anioAntReal = new java.math.BigDecimal(prom.get(0)[1].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				anioAntPres = new java.math.BigDecimal(prom.get(0)[2].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			}
			else{
				anioAntReal = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				anioAntPres = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			}
		    
		    // Tenia /2, se debe promediar
		    String operacion[] = new String [2];
		    if (cfg.getOperacion().equals("SUM")){
		    	operacion[0]="(sum(k."+ses.getMoneda()+"))";
		    	operacion[1]="(sum(k.mvevpe))";
		    }
		    else{
		    	if (cfg.getOperacion().equals("AV2")){
		    		operacion[0]="(avg(k."+ses.getMoneda()+"))";
		    		operacion[1]="(max(k.mvevpe))";
		    	}
		    	else{
		    		operacion[0]="(avg(k."+ses.getMoneda()+"))";
		    		operacion[1]="(avg(k.mvevpe))";
		    	}
		    }
		    	
		    // Se obtiene el promedio del PRESENTE año por cada línea generada, todo el año
		    @SuppressWarnings("unchecked")
		    List<Object[]> promAnioActual = em
					.createQuery(
							"Select k.mveano as mveano, "+operacion[0]+" as mveval, "+operacion[1]+" as mvevpe"
									+ " From Distri as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ filtro
									+ " and mveano = " + (Integer.parseInt(ses.getAnio()))
									+ " AND k.mvemes<="+ses.getMes()+" "
									+ sql
									+ " GROUP BY k.mveano"
									+ " ORDER BY k.mveano asc")
					.getResultList();
		    
		    if (promAnioActual.size() > 0){
		    	promMvevalRealAnoActual = new java.math.BigDecimal(promAnioActual.get(0)[1].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		    	promMvevpePresupuestadoAnoActual = new java.math.BigDecimal(promAnioActual.get(0)[2].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		    	//promMvevalRealAnoActual=promMvevalRealAnoActual.subtract(valorMesReal);
		    	
			}
			else{
				promMvevalRealAnoActual = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				promMvevpePresupuestadoAnoActual = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			}
		    
		    //promMvevalRealAnoActual=promMvevalRealAnoActual.subtract(new java.math.BigDecimal( ses.getMes()).setScale(3, BigDecimal.ROUND_HALF_EVEN)    );
			promMvevalRealAnoActual=promMvevalRealAnoActual.divide(new BigDecimal(ses.getMes()), 2, RoundingMode.HALF_UP);
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.divide(new BigDecimal(ses.getMes()), 2, RoundingMode.HALF_UP);
			
			
			// Se va agregando a la hoja de reporte cada línea para luego ser mostrada en la vista
			// llega tal cual se mostrará
		    
			if (list.get(0).getMvedes() != null){
				valor.add(new reporteDistri(list.get(0).getMvedes(), cfg.getIndicador(), 
						cfg.getUnidad(), "Actual", "Budget",
						anioAntReal,
						anioAntPres,
						promMvevalRealAnoActual, 
						promMvevpePresupuestadoAnoActual,
						new ArrayList<Distri>(list),cfg.getTipo(),
						(cfg.getOperacion().equals("AV2")?"AVG":cfg.getOperacion())));
			}
			promMvevalRealAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			promMvevpePresupuestadoAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		}
		return valor;
	}
		
	// listSalesQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listSalesQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listSalesQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listSalesQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listSalesQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listSalesQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listSalesQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listSalesQuarterly //////////////////////////////////////////////////////////////////////////////////

	public List<reporteDistri> listSalesQuarterly(session ses) {
		List<reporteDistri> valor = new LinkedList<reporteDistri>();
		List<CfgDistri> indicadores = cfgService.getListCfg();
		java.math.BigDecimal promMvevalRealAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal promMvevpePresupuestadoAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		
		java.math.BigDecimal anioAntReal = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal anioAntPres = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		
		java.math.BigDecimal promedioActualQ1 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal promedioActualQ2 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal promedioActualQ3 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal promedioActualQ4 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		
		java.math.BigDecimal promedioBudgetQ1 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal promedioBudgetQ2 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal promedioBudgetQ3 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal promedioBudgetQ4 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		
		java.math.BigDecimal valorMesActual = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal valorMesBudget = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		
		
		int mesesQ1=0,mesesQ2=0,mesesQ3=0,mesesQ4=0;
		int Q1=0,Q2=0,Q3=0,Q4=0;
		
		String sql="";
		if (!ses.getDash_nia().equals("Todas")){
			sql = " AND k.mvecia='"+ses.getDash_nia()+"' ";
		}
		if (!ses.getDash_region().equals("Todas")){
			sql += " AND k.mvereg='"+ses.getDash_region()+"' ";
		}
		String operacion_primer_campo="";
		String operacion_segundo_campo="";
		String filtro="";
		// Lee todos los indicadores de la base de datos
		for (CfgDistri cfg : indicadores) {

			System.out.println("Operación:"+cfg.getOperacion()+"Indicador:"+cfg.getIndicador());
			if (cfg.getOperacion().equals("AV2")){
				 operacion_primer_campo="avg";
				 operacion_segundo_campo="max";
			}
			else{
				operacion_primer_campo=cfg.getOperacion();
				operacion_segundo_campo=cfg.getOperacion();
			}
			
			// Se interpretan diferente ciertos indicadores, se toma el máximo pero si la bandera mverid es 1
			//if ( cfg.getIndicador().equals("VEN004") || cfg.getIndicador().equals("VEN005") || cfg.getIndicador().equals("VEN006") || cfg.getIndicador().equals("VEN007") || cfg.getIndicador().equals("VEN008") || cfg.getIndicador().equals("VEN009") || cfg.getIndicador().equals("VEN010") || cfg.getIndicador().equals("VEN012") || cfg.getIndicador().equals("VEN013") || cfg.getIndicador().equals("VEN014") || cfg.getIndicador().equals("VEN015") || cfg.getIndicador().equals("VEN016") || cfg.getIndicador().equals("VEN017")){
			//	operacion_primer_campo="max";
			//	filtro = " AND k.mverid='1' ";
			//}
			//else{
			//	filtro = "";
			//}
			
			operacion_primer_campo="max";
			filtro = " AND k.mverid='1' ";
			
			// Va a la base de datos y toma para cada indicador
			@SuppressWarnings("unchecked")
			List<Object[]> result = em
					.createQuery(
							"Select k.mveano as mveano, k.mvemes as mvemes, k.mvedes as mvedes, "+operacion_primer_campo+"(k."+ses.getDash_tasa()+") as mveval, "+operacion_segundo_campo+"(k.mvevpe) as mvevpe"
									+ " From Distri as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ filtro
									+ sql
									+ " AND k.mveano='"+ses.getAnio()+"' "
									+ " GROUP BY k.mveano , k.mvemes, k.mvedes"
									+ " ORDER BY k.mvedes, k.mveano , k.mvemes asc")
					.getResultList();

			// Se crea un objeto lista para almacenar todo año (solo la línea del indicador)
			List<Distri> list = new LinkedList<Distri>();
			
			// Se inician los 12 meses
			for (int i = 0; i < 4; i++) {
				list.add(new Distri("2015", "" + (i + 1)));
			}
			// Se va colocando cada mes en la hoja de resultado
			for (Object[] r : result) {
				int Mes=Integer.parseInt(r[1].toString())-1;
				System.out.println("Mes: "+Mes);
				if (Mes <= 3){
					promedioActualQ1=promedioActualQ1.add(new java.math.BigDecimal(r[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN));
					promedioBudgetQ1=promedioBudgetQ1.add(new java.math.BigDecimal(r[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN));
					valorMesActual=new java.math.BigDecimal(r[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN);
					valorMesBudget=new java.math.BigDecimal(r[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN);
					mesesQ1++;
					Q1=1;
				}else{
					if (Mes > 3 && Mes <= 6){
						promedioActualQ2=promedioActualQ2.add(new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
						promedioBudgetQ2=promedioBudgetQ2.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
						valorMesActual=new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
						valorMesBudget=new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
						mesesQ2++;
						Q2=1;
					}
					else{
						if (Mes > 6 && Mes <= 9){
							promedioActualQ3=promedioActualQ3.add(new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
							promedioBudgetQ3=promedioBudgetQ3.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
							valorMesActual=new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
							valorMesBudget=new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
							mesesQ3++;
							Q3=1;
						}
						else{
							promedioActualQ4=promedioActualQ4.add(new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
							promedioBudgetQ4=promedioBudgetQ4.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
							valorMesActual=new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
							valorMesBudget=new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
							mesesQ4++;
							Q4=1;
						}
					}
				}
				list.get(1).setMvedes(r[2].toString());

				//promMvevalRealAnoActual=promMvevalRealAnoActual.add(new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				//promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				
			}
			
			promMvevalRealAnoActual=promMvevalRealAnoActual.add(promedioActualQ1);
			promMvevalRealAnoActual=promMvevalRealAnoActual.add(promedioActualQ2);
			promMvevalRealAnoActual=promMvevalRealAnoActual.add(promedioActualQ3);
			promMvevalRealAnoActual=promMvevalRealAnoActual.add(promedioActualQ4);
			
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(promedioBudgetQ1);
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(promedioBudgetQ2);
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(promedioBudgetQ3);
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(promedioBudgetQ4);
			
			//sesQ1--;mesesQ2--;mesesQ3--;mesesQ4--;
			mesesQ1=(mesesQ1==0?1:mesesQ1);
			mesesQ2=(mesesQ2==0?1:mesesQ2);
			mesesQ3=(mesesQ3==0?1:mesesQ3);
			mesesQ4=(mesesQ4==0?1:mesesQ4);
			
			System.out.println("Cantidad Meses:"+mesesQ1);
			promedioActualQ1=promedioActualQ1.divide(new BigDecimal(mesesQ1), 2, RoundingMode.HALF_UP);
			promedioActualQ2=promedioActualQ2.divide(new BigDecimal(mesesQ2), 2, RoundingMode.HALF_UP);
			promedioActualQ3=promedioActualQ3.divide(new BigDecimal(mesesQ3), 2, RoundingMode.HALF_UP);
			promedioActualQ4=promedioActualQ4.divide(new BigDecimal(mesesQ4), 2, RoundingMode.HALF_UP);
			
			promedioBudgetQ1=promedioBudgetQ1.divide(new BigDecimal( (mesesQ1) ), 2, RoundingMode.HALF_UP);
			promedioBudgetQ2=promedioBudgetQ2.divide(new BigDecimal(mesesQ2), 2, RoundingMode.HALF_UP);
			promedioBudgetQ3=promedioBudgetQ3.divide(new BigDecimal(mesesQ3), 2, RoundingMode.HALF_UP);
			promedioBudgetQ4=promedioBudgetQ4.divide(new BigDecimal(mesesQ4), 2, RoundingMode.HALF_UP);
			
			list.get(0).setMveval(promedioActualQ1);
			list.get(1).setMveval(promedioActualQ2);
			list.get(2).setMveval(promedioActualQ3);
			list.get(3).setMveval(promedioActualQ4);
			
			list.get(0).setMvevpe(promedioBudgetQ1);
			list.get(1).setMvevpe(promedioBudgetQ2);
			list.get(2).setMvevpe(promedioBudgetQ3);
			list.get(3).setMvevpe(promedioBudgetQ4);
			
			System.out.println("El q2:"+promMvevalRealAnoActual);
			
			int totalQ=Q1+Q2+Q3+Q4;
			totalQ=(totalQ==0?1:totalQ);
			
			promMvevalRealAnoActual=promMvevalRealAnoActual.subtract(valorMesActual);
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.subtract(valorMesBudget);
			
			promMvevalRealAnoActual=promMvevalRealAnoActual.divide(new BigDecimal(Integer.parseInt(ses.getMes())-1), 2, RoundingMode.HALF_UP);
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.divide(new BigDecimal(Integer.parseInt(ses.getMes())-1), 2, RoundingMode.HALF_UP);
			
			// Se obtiene el promedio del año anterior por cada línea generada
			// 8QX5CL
		    @SuppressWarnings("unchecked")
		    List<Object[]> prom = em
					.createQuery(
							"Select k.mveano as mveano, "+operacion_primer_campo+"(k."+ses.getDash_tasa()+") as mveval, "+operacion_segundo_campo+"(k.mvevpe) as mvevpe"
									+ " From Distri as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ filtro
									+ " and mveano = " + (Integer.parseInt(ses.getAnio()) - 1)
									
									+ sql
									//+ " AND k.mvecia='"+ses.getDash_nia()+"' "
									+ " GROUP BY k.mveano"
									+ " ORDER BY k.mveano asc")
					.getResultList();
				
		    if (prom.size() > 0){
		    	//System.out.println("-----------"+prom.get(0)[0].toString()+"----------------------");
				anioAntReal = new java.math.BigDecimal(prom.get(0)[1].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				anioAntPres = new java.math.BigDecimal(prom.get(0)[2].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			}
			else{
				anioAntReal = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				anioAntPres = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			}
			
			// Se va agregando a la hoja de reporte cada línea para luego ser mostrada en la vista
			// llega tal cual se mostrará
		    
			if (list.get(1).getMvedes() != null){
				valor.add(new reporteDistri(list.get(1).getMvedes(), cfg.getIndicador(), 
						cfg.getUnidad(), "Actual", "Budget",
						anioAntReal,
						anioAntPres,
						promMvevalRealAnoActual, 
						promMvevpePresupuestadoAnoActual,
						new ArrayList<Distri>(list),cfg.getTipo(),
						(cfg.getOperacion().equals("AV2")?"AVG":cfg.getOperacion())));
			}
			promMvevalRealAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			promMvevpePresupuestadoAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			
			promedioActualQ1 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			promedioActualQ2 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			promedioActualQ3 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			promedioActualQ4 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			
			promedioBudgetQ1 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			promedioBudgetQ2 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			promedioBudgetQ3 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			promedioBudgetQ4 = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			
			mesesQ1=0;mesesQ2=0;mesesQ3=0;mesesQ4=0;
			Q1=0;Q2=0;Q3=0;Q4=0;
		}
		return valor;
	}
	
	// //////////////////////////////////////////////////////////////////////////////////
	// listSalesDrill////////////////////////////////////////////////////////////////////
	// listSalesDrill////////////////////////////////////////////////////////////////////
	// listSalesDrill////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////////

	public List<reporteDistri> listSalesDrill(session ses) {
		List<reporteDistri> valor = new LinkedList<reporteDistri>();
		java.math.BigDecimal promedio = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal anioAntReal = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal anioAntPres = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal ultimoValor = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		List<java.math.BigDecimal> totales = new LinkedList<java.math.BigDecimal>();
		
		for (int i = 0; i < 12; i++) {
			totales.add(promedio);
		}
		String sql="";
		if (!ses.getDash_nia().equals("Todas")){
			sql = " AND k.mvecia='"+ses.getDash_nia()+"' ";
		}
		if (!ses.getDash_region().equals("Todas")){
			sql += " AND k.mvereg='"+ses.getDash_region()+"' ";
		}
		//if (ses.getOp().equals("M")){
		//	sql += " AND k.mvemes='"+ses.getMes()+"' ";
		//}
		
		String operacion[] = new String [2];
		String filtro="";
		System.out.println("Operacion:"+ses.getOp());
		
		/*if (ses.getOp().equals("-")){
    	operacion[0]="(sum(k."+ses.getMoneda()+"))";
    	operacion[1]="(sum(k.mvevpe))";
    }
    else{
    	operacion[0]="(avg(k."+ses.getMoneda()+"))";
    	operacion[1]="(avg(k.mvevpe))";
    }*/
	
	operacion[0]="("+ses.getOp3r()+"(k."+ses.getMoneda()+"))";
	operacion[1]="("+ses.getOp3r()+"(k.mvevpe))";
	
	    System.out.println("Operación drill: "+ses.getIndicador_drill());
	    //if ( ses.getIndicador_drill().equals("VEN004") || ses.getIndicador_drill().equals("VEN005") || ses.getIndicador_drill().equals("VEN006") || ses.getIndicador_drill().equals("VEN007") || ses.getIndicador_drill().equals("VEN008") || ses.getIndicador_drill().equals("VEN009") || ses.getIndicador_drill().equals("VEN010") || ses.getIndicador_drill().equals("VEN012") || ses.getIndicador_drill().equals("VEN013") || ses.getIndicador_drill().equals("VEN014") || ses.getIndicador_drill().equals("VEN015") || ses.getIndicador_drill().equals("VEN016")|| ses.getIndicador_drill().equals("VEN017")){
	    //	operacion[0]="(max(k."+ses.getMoneda()+"))";
		//	filtro = " AND k.mverid='' ";
		//}
		//else{
		//	filtro = "";
		//}
	    filtro = " AND k.mverid='' ";
		@SuppressWarnings("unchecked")
		List<Object[]> result = em
		.createQuery(
				"Select k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+", k.mveano as mveano, k.mvemes as mvemes, k.mvedes as mvedes, "+operacion[0]+" as mveval, "+operacion[1]+" as mvevpe"
						+ " From Distri as k where k.mveind = '"
						+ ses.getIndicador_drill()
						+ "' "
						+ filtro
						+ sql
						+ " AND k.mveano='"+ses.getAnio()+"' "
						+ " GROUP BY k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+",  k.mveano , k.mvemes, k.mvedes, k."+ses.getCampo_descripcion()
						+ " ORDER BY k."+ses.getCampo_descripcion()+", k."+ses.getCampo_llave()+", k.mvedes, k.mveano , k.mvemes asc")
		.getResultList();

		List<Distri> list = new LinkedList<Distri>();
		
		int x=0;
		int meses=0;boolean primeraLinea=true;
		while (x<result.size()){
			meses=1;
			// Se inician los 12 meses
			list = new LinkedList<Distri>();
			for (int i = 0; i < 12; i++) {
				list.add(new Distri("2015", "" + (i + 1)));
			}
			ultimoValor = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			//System.out.println(x+ " Actual: " + result.get(x)[0].toString() + " Anterior: " + result.get( (x==0?x:x-1)   )[0].toString() + " " );
			// Va comparando el nombre del indicador que está en la posición 0
			// Éste if compara si cambia el codigo del indicador, la idea es detectar los cambios como una ruptura
			// Si es igual arranca con un while para ir recogiendo todos los meses, el problema que resuleve es 
			// en el SQL llegan a manera de filas todos los meses
			if (  result.get(x)[0].toString().equals(result.get( (x==0?x:x-1)   )[0].toString())  ){
				while( result.get(x)[0].toString().equals(result.get( (x==0?x:x-1)   )[0].toString()) ){
					//System.out.println("Entro al while ["+x+"] - "+result.get(x)[0].toString());
					list.get(Integer.parseInt(result.get(x)[3].toString())-1).setMveval(new BigDecimal(result.get(x)[5].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN));
					list.get(Integer.parseInt(result.get(x)[3].toString())-1).setMvevpe(new BigDecimal(result.get(x)[6].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
					promedio=promedio.add(new java.math.BigDecimal(result.get(x)[5].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
					ultimoValor=new java.math.BigDecimal(result.get(x)[5].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
					totales.set((Integer.parseInt(result.get(x)[3].toString())+1), totales.get(Integer.parseInt(result.get(x)[3].toString())+1).add(new java.math.BigDecimal(result.get(x)[5].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN)));
					x++;meses++;
					if (x==result.size())
						break;
				}
				x--;
			}
			// Si no es igual el else monta el primero (deb ser enero) luego de la ruptura y arranca
			// de nuevo con otro while para agregar todos los meses mientras el registro sea igual.
			else{
				list.get(Integer.parseInt(result.get(x)[3].toString())-1).setMveval(new BigDecimal(result.get(x)[5].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN));
				list.get(Integer.parseInt(result.get(x)[3].toString())-1).setMvevpe(new BigDecimal(result.get(x)[6].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				promedio=promedio.add(new java.math.BigDecimal(result.get(x)[5].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				ultimoValor=new java.math.BigDecimal(result.get(x)[5].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				totales.set(Integer.parseInt(result.get(x)[3].toString())+1, totales.get(Integer.parseInt(result.get(x)[3].toString())+1).add(new java.math.BigDecimal(result.get(x)[5].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN)));
				x++;
				if (x==result.size())
					break;
				while( result.get(x)[0].toString().equals(result.get( (x==0?x:x-1)   )[0].toString()) ){
					//System.out.println("Entro al while2 ["+x+"] - "+result.get(x)[0].toString());
					list.get(Integer.parseInt(result.get(x)[3].toString())-1).setMveval(new BigDecimal(result.get(x)[5].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN));
					list.get(Integer.parseInt(result.get(x)[3].toString())-1).setMvevpe(new BigDecimal(result.get(x)[6].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
					promedio=promedio.add(new java.math.BigDecimal(result.get(x)[5].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
					ultimoValor=new java.math.BigDecimal(result.get(x)[5].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
					totales.set(Integer.parseInt(result.get(x)[3].toString())+1, totales.get(Integer.parseInt(result.get(x)[3].toString())+1).add(new java.math.BigDecimal(result.get(x)[5].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN)));
					x++;meses++;
					if (x==result.size())
						break;
				}
				x--;
			}
			
			// Se calcula el promedio del año actual, se resta el último mes registrado para
			// No tenerlo en cuenta
			if (primeraLinea){ meses-=2; primeraLinea=false;}
			else meses--;
			meses=(meses==0?1:meses);
			promedio=promedio.subtract(ultimoValor);
			promedio=promedio.divide(new BigDecimal(meses), 2, RoundingMode.HALF_UP);
			totales.set(1, totales.get(1).add(promedio));
			
			//Se obtiene el promedio del año anterior por cada línea generada
			System.out.println("Esto: "+list.get(0));
			if (!ses.getCampo_llave().equals("mvecli")){
				@SuppressWarnings("unchecked")
				List<Object[]> promedioAnioAnterior = em
				.createQuery(
						"Select k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+", k.mveano as mveano, "+operacion[0]+" as mveval, "+operacion[1]+" as mvevpe"
								+ " From Distri as k where k."+ses.getCampo_llave()+" = '"
								+ result.get(x)[0].toString()
								+ "'  "
								+ filtro
								+ sql
								+ " AND k.mveano='"+(Integer.parseInt(ses.getAnio())-1)+"' "
								+ " GROUP BY k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+",  k.mveano , k."+ses.getCampo_descripcion()
								+ " ORDER BY k."+ses.getCampo_descripcion()+", k."+ses.getCampo_llave()+", k.mveano  asc")
				.getResultList();
				if (promedioAnioAnterior.size() > 0){
					anioAntReal = new java.math.BigDecimal(promedioAnioAnterior.get(0)[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
					anioAntPres = new java.math.BigDecimal(promedioAnioAnterior.get(0)[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				}
				else{
					anioAntReal = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
					anioAntPres = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				}
			}
		    
		    totales.set(0, totales.get(0).add(anioAntReal));
		    //System.out.println("totlaes"+totales);
			valor.add(new reporteDistri(result.get(x)[0].toString(), result.get(x)[1].toString(), 
					"", "Actual", "Budget",
					anioAntReal, 
					anioAntPres,
					promedio, 
					promedio,
					new ArrayList<Distri>(list),"",""));
			x++;
			promedio = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
		}
		if (ses.getOp().equals("p")){
			for(int i=0; i < totales.size(); i++){
				System.out.println("Totales: "+totales.get(i));
				if (totales.get(i).compareTo(new java.math.BigDecimal(0).setScale(0, RoundingMode.HALF_UP))>=0)
					totales.set(i, totales.get(i).divide(new java.math.BigDecimal(valor.size()).setScale(3, BigDecimal.ROUND_HALF_EVEN),2, RoundingMode.HALF_UP));
			}
	    }
		ses.setTotales(totales);
		return valor;
	}

	// //////////////////////////////////////////////////////////////////////////////////
	// listSalesDrillMonth //////////////////////////////////////////////////////////////
	// listSalesDrillMonth //////////////////////////////////////////////////////////////
	// listSalesDrillMonth //////////////////////////////////////////////////////////////
	// listSalesDrillMonth //////////////////////////////////////////////////////////////
	// listSalesDrillMonth //////////////////////////////////////////////////////////////
	// listSalesDrillMonth //////////////////////////////////////////////////////////////
	// listSalesDrillMonth //////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////////

		public List<reporteDistri> listSalesDrillMonth(session ses) {
			List<reporteDistri> valor = new LinkedList<reporteDistri>();
			java.math.BigDecimal promedio = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			java.math.BigDecimal promMvevalRealAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			java.math.BigDecimal promMvevpePresupuestadoAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			
			java.math.BigDecimal anioAntReal = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			java.math.BigDecimal anioAntPres = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			
			String sql="";
			if (!ses.getDash_nia().equals("Todas")){
				sql = " AND k.mvecia='"+ses.getDash_nia()+"' ";
			}
			if (!ses.getDash_region().equals("Todas")){
				sql += " AND k.mvereg='"+ses.getDash_region()+"' ";
			}
			
			String operacion[] = new String [2];
			String filtro="";
			System.out.println("Operacion:"+ses.getOp());
			
			/*if (ses.getOp().equals("-")){
	    	operacion[0]="(sum(k."+ses.getMoneda()+"))";
	    	operacion[1]="(sum(k.mvevpe))";
	    }
	    else{
	    	operacion[0]="(avg(k."+ses.getMoneda()+"))";
	    	operacion[1]="(avg(k.mvevpe))";
	    }*/
		
		operacion[0]="("+ses.getOp3r()+"(k."+ses.getMoneda()+"))";
    	operacion[1]="("+ses.getOp3r()+"(k.mvevpe))";
    	
		    System.out.println("Operación: "+ses.getIndicador_drill());
		    /*if ( ses.getIndicador_drill().equals("VEN004") || ses.getIndicador_drill().equals("VEN005") || ses.getIndicador_drill().equals("VEN006") || ses.getIndicador_drill().equals("VEN007") || ses.getIndicador_drill().equals("VEN008") || ses.getIndicador_drill().equals("VEN009") || ses.getIndicador_drill().equals("VEN010") || ses.getIndicador_drill().equals("VEN012") || ses.getIndicador_drill().equals("VEN013") || ses.getIndicador_drill().equals("VEN014") || ses.getIndicador_drill().equals("VEN015") || ses.getIndicador_drill().equals("VEN016") || ses.getIndicador_drill().equals("VEN017")){
		    	operacion[0]="(max(k."+ses.getMoneda()+"))";
				filtro = " AND k.mverid='' ";
			}
			else{
				filtro = "";
			}*/
		    filtro = " AND k.mverid='' ";
			// Se trae todo de la base de datos filtrando por la llave seleccionada
			@SuppressWarnings("unchecked")
			List<Object[]> result = em
			.createQuery(
					"Select k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+", k.mveano as mveano, k.mvemes as mvemes, "+operacion[0]+" as mveval, "+operacion[1]+" as mvevpe"
							+ " From Distri as k where k.mveind = '"
							+ ses.getIndicador_drill()
							+ "'"
							+ filtro
							+ sql
							+ " AND k.mvemes='"+ses.getMes()+"' "
							+ " AND k.mveano='"+ses.getAnio()+"' "
							+ " GROUP BY k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+",  k.mveano , k.mvemes, k."+ses.getCampo_descripcion()
							+ " ORDER BY k."+ses.getCampo_descripcion()+", k."+ses.getCampo_llave()+", k.mveano , k.mvemes asc")
			.getResultList();

			List<Distri> list = new LinkedList<Distri>();
			
			//System.out.println("Tamaño "+list.size());
			// Se va colocando cada registro en la hoja de resultado
			for (Object[] r : result) {
				list = new LinkedList<Distri>();
				list.add(new Distri("2000", ses.getMes() ));
				
				list.get(0).setMveval(
						new BigDecimal(r[4].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN));

				list.get(0).setMvevpe(
						new BigDecimal(r[5].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
			
	 			//Se obtiene el promedio del año anterior por cada línea generada
				
				if (!ses.getCampo_llave().equals("mvecli")){
					@SuppressWarnings("unchecked")
					List<Object[]> promedioAnioAnterior = em
					.createQuery(
							"Select k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+", k.mveano as mveano, "+operacion[0]+" as mveval, "+operacion[1]+" as mvevpe"
									+ " From Distri as k where k.mveind = '"
									+ ses.getIndicador_drill()
									+ "'"
									+ " AND k."+ses.getCampo_llave()+" = '"
									+ r[0].toString()
									+ "' "
									+ filtro
									+ sql
									+ " AND k.mveano='"+(Integer.parseInt(ses.getAnio())-1)+"' "
									+ " GROUP BY k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+",  k.mveano , k."+ses.getCampo_descripcion()
									+ " ORDER BY k."+ses.getCampo_descripcion()+", k."+ses.getCampo_llave()+", k.mveano  asc")
					.getResultList();
				    
				    if (promedioAnioAnterior.size() > 0){
						anioAntReal = new java.math.BigDecimal(promedioAnioAnterior.get(0)[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
						anioAntPres = new java.math.BigDecimal(promedioAnioAnterior.get(0)[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
					}
					else{
						anioAntReal = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
						anioAntPres = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
					}
				}
			    // Se obtiene el promedio del PRESENTE año por cada línea generada, todo el año
			    System.out.println("Esto: "+list.get(0));
				if (!ses.getCampo_llave().equals("mvecli")){
				    @SuppressWarnings("unchecked")
				    List<Object[]> promedioAnio = em
							.createQuery(
									"Select k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+", k.mveano as mveano, "+operacion[0]+" as mveval, "+operacion[1]+" as mvevpe"
											+ " From Distri as k where k.mveind = '"
											+ ses.getIndicador_drill()
											+ "'"
											+ " AND k."+ses.getCampo_llave()+" = '"
											+ r[0].toString()
											+ "' "
											+ filtro
											+ sql
											+ " AND k.mveano='"+ses.getAnio()+"' "
											+ " GROUP BY k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+",  k.mveano, k."+ses.getCampo_descripcion()
											+ " ORDER BY k."+ses.getCampo_descripcion()+", k."+ses.getCampo_llave()+", k.mveano  asc")
							.getResultList();
				    
				    if (promedioAnio.size() > 0){
				    	promMvevalRealAnoActual= new java.math.BigDecimal(promedioAnio.get(0)[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				    	//System.out.println("-----------"+promMvevalRealAnoActual+"----------------------");
					}
					else{
						promMvevalRealAnoActual = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
					}
				}
				
				// Se va agregando a la hoja de reporte cada línea para luego ser mostrada en la vista
				// llega tal cual se mostrará se soloca aquí
				//if (list.get(0).getMvedes() != null){
					valor.add(new reporteDistri(r[0].toString(), r[1].toString(), 
							"", "Actual", "Budget",
							anioAntReal,
							anioAntPres,
							promMvevalRealAnoActual, 
							promMvevpePresupuestadoAnoActual,
							new ArrayList<Distri>(list),"",""));
				//}
			}
			return valor;
		}

		// //////////////////////////////////////////////////////////////////////////////////
		// listSalesDrillQuarterly //////////////////////////////////////////////////////////
		// listSalesDrillQuarterly //////////////////////////////////////////////////////////
		// listSalesDrillQuarterly //////////////////////////////////////////////////////////
		// listSalesDrillQuarterly //////////////////////////////////////////////////////////
		// listSalesDrillQuarterly //////////////////////////////////////////////////////////
		// listSalesDrillQuarterly //////////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////////////////////////////////

		public List<reporteDistri> listSalesDrillQuarterly(session ses) {
			List<reporteDistri> valor = new LinkedList<reporteDistri>();
			java.math.BigDecimal promedioReal = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			
			java.math.BigDecimal anioAntReal = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			java.math.BigDecimal anioAntPres = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			
			java.math.BigDecimal totalAverageActual = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			
			List<java.math.BigDecimal> totales = new LinkedList<java.math.BigDecimal>();
			
			for (int i = 0; i < 6; i++) {
				totales.add(totalAverageActual);
			}
			
			String sql="";
			if (!ses.getDash_nia().equals("Todas")){
				sql = " AND k.mvecia='"+ses.getDash_nia()+"' ";
			}
			if (!ses.getDash_region().equals("Todas")){
				sql += " AND k.mvereg='"+ses.getDash_region()+"' ";
			}
			
			String operacion[] = new String [2];
			String filtro;
			System.out.println("Operacion:"+ses.getOp());
		    
			/*if (ses.getOp().equals("-")){
	    	operacion[0]="(sum(k."+ses.getMoneda()+"))";
	    	operacion[1]="(sum(k.mvevpe))";
	    }
	    else{
	    	operacion[0]="(avg(k."+ses.getMoneda()+"))";
	    	operacion[1]="(avg(k.mvevpe))";
	    }*/
		
		operacion[0]="("+ses.getOp3r()+"(k."+ses.getMoneda()+"))";
    	operacion[1]="("+ses.getOp3r()+"(k.mvevpe))";
    	
		    System.out.println("Operación: "+ses.getIndicador_drill());
		    /*if ( ses.getIndicador_drill().equals("VEN004") || ses.getIndicador_drill().equals("VEN005") || ses.getIndicador_drill().equals("VEN006") || ses.getIndicador_drill().equals("VEN007") || ses.getIndicador_drill().equals("VEN008") || ses.getIndicador_drill().equals("VEN009") || ses.getIndicador_drill().equals("VEN010") || ses.getIndicador_drill().equals("VEN012") || ses.getIndicador_drill().equals("VEN013") || ses.getIndicador_drill().equals("VEN014") || ses.getIndicador_drill().equals("VEN015") || ses.getIndicador_drill().equals("VEN016")|| ses.getIndicador_drill().equals("VEN017")){
		    	operacion[0]="(max(k."+ses.getMoneda()+"))";
				filtro = " AND k.mverid='' ";
			}
			else{
				filtro = "";
			}*/
		    filtro = " AND k.mverid='' ";
			// Se trae todo de la base de datos filtrando por la llave seleccionada
			@SuppressWarnings("unchecked")
			List<Object[]> result = em
			.createQuery(
					"Select k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+", k.mveano as mveano, k.mvemes as mvemes, "+operacion[0]+" as mveval, "+operacion[1]+" as mvevpe"
							+ " From Distri as k where k.mveind = '"
							+ ses.getIndicador_drill()
							+ "' "
							+ filtro
							+ sql
							+ " AND k.mveano='"+ses.getAnio()+"' "
							+ " GROUP BY k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+",  k.mveano , k.mvemes, k."+ses.getCampo_descripcion()
							+ " ORDER BY k."+ses.getCampo_descripcion()+", k."+ses.getCampo_llave()+", k.mveano , k.mvemes asc")
			.getResultList();

			int quarterly=2;
			
			// Lista para cada linea del treMap, hay una por cada renglón
			List<BigDecimal> valor_row = new LinkedList<BigDecimal>();
			TreeMap<String, String> valor_row_rotulos = new TreeMap<String, String>();
			java.math.BigDecimal valor_tri = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			TreeMap<String, List<BigDecimal>> tm = new TreeMap<String, List<BigDecimal>>();
			
			// Se va colocando cada mes en la hoja de resultado
			for (Object[] r : result) {
				valor_row = new LinkedList<BigDecimal>();
				for (int i = 0; i < 6; i++) {
					valor_row.add( new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN));
				}
				// Primero se obtiene el promedio del año anterior
				if (!ses.getCampo_llave().equals("mvecli")){
					@SuppressWarnings("unchecked")
				    List<Object[]> promedioAnio = em
							.createQuery(
									"Select k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+", k.mveano as mveano, "+operacion[0]+" as mveval, "+operacion[1]+" as mvevpe"
											+ " From Distri as k where k."+ses.getCampo_llave()+" = '"
											+ r[0].toString()
											+ "'  "
											+ filtro
											+ sql
											+ " AND k.mveano='"+(Integer.parseInt(ses.getAnio())-1)+"' "
											+ " GROUP BY k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+",  k.mveano, k."+ses.getCampo_descripcion()
											+ " ORDER BY k."+ses.getCampo_descripcion()+", k."+ses.getCampo_llave()+", k.mveano  asc")
							.getResultList();
				    
				    if (promedioAnio.size() > 0){
				    	anioAntReal= new java.math.BigDecimal(promedioAnio.get(0)[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
					}
					else{
						anioAntReal = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
					}
				}
				
				// Primero se obtiene el mes que contiene el registro consultado
				int Mes=Integer.parseInt(r[3].toString())-1;
				if (Mes <= 2){
					quarterly=2;
				}else{
					if (Mes > 2 && Mes <= 5){
						quarterly=3;
					}
					else{
						if (Mes > 5 && Mes <= 8){
							quarterly=4;
						}
						else{
							quarterly=5;
						}
					}
				}
				if (Mes != Integer.parseInt(ses.getMes())-1){
					// Mira si ya estaba en el HasTree
					if (tm.get(r[0].toString()) != null){
						
						// Toma lo que trae el trimestre y lo acumula con el valor del mes que llega
						valor_row=tm.get(r[0].toString()); // Toma todos los trimestres que tiene esa key, ejemplo BA para bodegas
						valor_tri=tm.get(r[0].toString()).get(quarterly+1); // y toma el valor del trimestre específico
						valor_tri=valor_tri.add(new java.math.BigDecimal(r[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN));
						// Lo agrega en la lista que corresponde al todo el año, trimestre por trimestre
						valor_row.set(quarterly+1, valor_tri);
						
						// Ésta línea guarda el Mes, que se usa para promediar
						valor_row.set(0, new BigDecimal(r[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN));
						
						// Se tiene en otro treMap las descripciones debido a que son String y el de valores el BigDecimal
						valor_row_rotulos.put(r[0].toString(), r[1].toString());
						valor_row.set(1, anioAntReal);
						
						if (Mes != Integer.parseInt(ses.getMes())-1){
							promedioReal=promedioReal.add(valor_row.get(2));
							valor_row.set(2, valor_tri);
						}
						
						//System.out.println("Modificando: "+r[0].toString()+" con:"+valor_row);
						tm.put(r[0].toString(), valor_row);
						valor_row=tm.get(r[0].toString());
						//System.out.println("Quedando: "+valor_row);
						
					}
					else{
						valor_row.set(quarterly+1, new BigDecimal(r[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN));
						
						// Ésta línea guarda el Mes, que se usa para promediar
						valor_row.set(0, new BigDecimal(r[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN));
						valor_row.set(1, anioAntReal);
						
						if (Mes != Integer.parseInt(ses.getMes())-1){
							promedioReal=new BigDecimal(r[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN);
							valor_row.set(2, promedioReal);
						}
						//System.out.println("EEEEsto es: "+valor_row.get(quarterly));
						tm.put(r[0].toString(), valor_row);
						
						
						valor_row_rotulos.put(r[0].toString(), r[1].toString());
						//System.out.println(r[0].toString()+": Creando: "+" con:"+valor_row);
						valor_row=tm.get(r[0].toString());
						//System.out.println(r[0].toString()+": Quedando: "+valor_row);
					}
					System.out.println(valor_row);
				}
			}
			// Se crea un objeto lista para almacenar todo año (solo la línea del indicador)
			List<Distri> list = new LinkedList<Distri>();
			
			// Se inician los 12 meses
			//for (int i = 0; i < 4; i++) {
			//	list.add(new Kpi("2015", "" + (i + 1)));
			//}
			
			java.math.BigDecimal mes_por_mes = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			for(java.util.Map.Entry<String, List<BigDecimal>> entry : tm.entrySet()) {
				  String key = entry.getKey();
				  List<BigDecimal> value = entry.getValue();
				  //System.out.println(key + " => " + value);
				 
				  list = new LinkedList<Distri>();
					
				  // Se inician los 12 meses
				  for (int i = 0; i < 4; i++) {
					  list.add(new Distri("2015", "" + (i + 1)));
				  }
				  valor_row=tm.get(key);
				  
				  System.out.println("es:"+valor_row.get(1).toString());
				  // Se modifican los valores para promediarlos
				  valor_row.set(1, valor_row.get(1).divide(valor_row.get(0), 2, RoundingMode.HALF_UP));
				  
				  valor_row.set(2, valor_row.get(2).divide(valor_row.get(0), 2, RoundingMode.HALF_UP));
				  // Se colocan los totales del promedio anño anterior y actual, el anterior sale de un SQL
				  // mientras que el que esta en la posición 1 sale sumando todos los meses y dividiendo por los meses
				  // el mes por cada fila se guarda en la posición 1
				  totales.set(0,totales.get(0).add( valor_row.get(1)  ) );
				  totales.set(1,totales.get(1).add( valor_row.get(2)  ) );
				  int c=0;
				  for (int i=3; i< valor_row.size(); i++) {
					  list.get(c).setMveval(   valor_row.get(i).divide(valor_row.get(0), 2, RoundingMode.HALF_UP)   ); // Agrega cada reglón como saldrá en la vista
					  totales.set(i-1,totales.get(i-1).add(list.get(c).getMveval())); // Totales de cada columna
					  c++;
				  }
				  
				  valor.add(new reporteDistri(key, valor_row_rotulos.get(key), 
							"", "Actual", "Budget",
							value.get(1),
							anioAntPres,
							value.get(2), 
							value.get(2), // No se usa el presupuestado
							new ArrayList<Distri>(list),"",""));
			}
			if (ses.getOp().equals("p")){
				for(int i=0; i < totales.size(); i++){
					if (totales.get(i).compareTo(new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN))>=0)
						totales.set(i, totales.get(i).divide(new java.math.BigDecimal(valor.size()).setScale(3, BigDecimal.ROUND_HALF_EVEN)));
				}
		    }
			ses.setTotales(totales);
			
			return valor;
		}

		// //////////////////////////////////////////////////////////////////////////////////

		
		
}
