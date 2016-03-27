package repository.kpi.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.adm.CfgFinance;
import domain.kpi.Finance;
import domain.kpi.reporteFinance;
import domain.session.session;
import repository.kpi.FinancesDao;
import service.adm.CfgFinanceService;

@Repository
public class FinancesDaoImpl implements FinancesDao {

	@PersistenceContext
	private EntityManager em = null;

	@Autowired
	private CfgFinanceService  cfgFinanceService;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	// listFinances //////////////////////////////////////////////////////////////////////////////////
	// listFinances //////////////////////////////////////////////////////////////////////////////////
	// listFinances //////////////////////////////////////////////////////////////////////////////////
	// listFinances //////////////////////////////////////////////////////////////////////////////////
	// listFinances //////////////////////////////////////////////////////////////////////////////////
	// listFinances //////////////////////////////////////////////////////////////////////////////////

	public List<reporteFinance> listFinance(session ses) {
		List<reporteFinance> valor = new LinkedList<reporteFinance>();
		List<CfgFinance> indicadores = cfgFinanceService.getListCfg();
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
	
		// Lee todos los indicadores de la base de datos
		for (CfgFinance cfg : indicadores) {

			// Va a la base de datos y toma para cada indicador
			@SuppressWarnings("unchecked")
			List<Object[]> result = em
					.createQuery(
							"Select k.mveano as mveano, k.mvemes as mvemes, k.mvedes as mvedes, "+cfg.getOperacion()+"(k."+ses.getMoneda()+") as mveval, "+cfg.getOperacion()+"(k.mvevpe) as mvevpe"
									+ " From Finance as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ sql
									+ " AND k.mveano='"+ses.getAnio()+"' "
									+ " GROUP BY k.mveano , k.mvemes, k.mvedes"
									+ " ORDER BY k.mvedes, k.mveano , k.mvemes asc")
					.getResultList();

			// Se crea un objeto lista para almacenar todo año (solo la línea del indicador)
			List<Finance> list = new LinkedList<Finance>();
			
			// Se inician los 12 meses
			for (int i = 0; i < 12; i++) {
				list.add(new Finance("2015", "" + (i + 1)));
			}
			int meses=0;
			// Se va colocando cada mes en la hoja de resultado
			for (Object[] r : result) {
				list.get(Integer.parseInt(r[1].toString())-1).setMveval(
						new BigDecimal(r[3].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN));

				list.get(Integer.parseInt(r[1].toString())-1).setMvevpe(
						new BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));

				list.get(1).setMvedes(r[2].toString());

				//promMveval.add(new BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				//promMvevpe.add(new BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				
				//java.math.BigDecimal obj = new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				//java.math.BigDecimal obj2 = new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);//Aqui

				promMvevalRealAnoActual=promMvevalRealAnoActual.add(new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				// Arriba lo muestra, se suma y aqui muestra sero
				//System.out.println("Presp-->"+r[4].toString());
				//System.out.println(promMvevpePresupuestadoAnoActual.toString());
				
				meses++;
			}
			meses=(meses==0?1:meses);
			promMvevalRealAnoActual=promMvevalRealAnoActual.divide(new BigDecimal(meses), 2, RoundingMode.HALF_UP);
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.divide(new BigDecimal(meses), 2, RoundingMode.HALF_UP);
			//System.out.println(promMveval.toString());
			
			// Se obtiene el promedio del año anterior por cada línea generada
			
		    @SuppressWarnings("unchecked")
		    List<Object[]> prom = em
					.createQuery(
							"Select k.mveano as mveano, "+cfg.getOperacion()+"(k."+ses.getMoneda()+") as mveval, "+cfg.getOperacion()+"(k.mvevpe) as mvevpe"
									+ " From Finance as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
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
				valor.add(new reporteFinance(list.get(1).getMvedes(), cfg.getIndicador(), 
						cfg.getUnidad(), "Real", "Budgeted",
						anioAntReal,
						anioAntPres,
						promMvevalRealAnoActual, 
						promMvevpePresupuestadoAnoActual,
						new ArrayList<Finance>(list),cfg.getTipo()));
			}
			promMvevalRealAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			promMvevpePresupuestadoAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		}
		return valor;
	}
	
	// //////////////////////////////////////////////////////////////////////////////////
	
	// listFinanceMonth //////////////////////////////////////////////////////////////////////////////////
	// listFinanceMonth //////////////////////////////////////////////////////////////////////////////////
	// listFinanceMonth //////////////////////////////////////////////////////////////////////////////////
	// listFinanceMonth //////////////////////////////////////////////////////////////////////////////////
	// listFinanceMonth //////////////////////////////////////////////////////////////////////////////////
	// listFinanceMonth //////////////////////////////////////////////////////////////////////////////////
	// listFinanceMonth //////////////////////////////////////////////////////////////////////////////////
	// listFinanceMonth //////////////////////////////////////////////////////////////////////////////////
	// listFinanceMonth //////////////////////////////////////////////////////////////////////////////////

	public List<reporteFinance> listFinanceMonth(session ses) {
		List<reporteFinance> valor = new LinkedList<reporteFinance>();
		List<CfgFinance> indicadores = cfgFinanceService.getListCfg();
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
		//sql += " AND k.mvemes='"+ses.getMes()+"' ";
		// Lee todos los indicadores de la base de datos
		for (CfgFinance cfg : indicadores) {

			// Va a la base de datos y toma para cada indicador
			@SuppressWarnings("unchecked")
			List<Object[]> result = em
					.createQuery(
							"Select k.mveano as mveano, k.mvemes as mvemes, k.mvedes as mvedes, "+cfg.getOperacion()+"(k."+ses.getMoneda()+") as mveval, "+cfg.getOperacion()+"(k.mvevpe) as mvevpe"
									+ " From Finance as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ sql
									+ " AND k.mveano='"+ses.getAnio()+"' "
									+ " AND k.mvemes='"+ses.getMes()+"' "
									+ " GROUP BY k.mveano , k.mvemes, k.mvedes"
									+ " ORDER BY k.mvedes, k.mveano , k.mvemes asc")
					.getResultList();

			// Se crea un objeto lista para almacenar todo año (solo la línea del indicador)
			List<Finance> list = new LinkedList<Finance>();
			
			// Se inician los 12 meses
			//for (int i = 0; i < 12; i++) {
			//	list.add(new Finance("2015", "" + (i + 1)));
			//}
			list.add(new Finance("2000", ses.getMes() ));
			System.out.println("Tamaño"+list.size());
			int meses=0;
			// Se va colocando cada mes en la hoja de resultado
			for (Object[] r : result) {
				list.get(0).setMveval(
						new BigDecimal(r[3].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN));

				list.get(0).setMvevpe(
						new BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));

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
			
		    @SuppressWarnings("unchecked")
		    List<Object[]> prom = em
					.createQuery(
							"Select k.mveano as mveano, "+cfg.getOperacion()+"(k."+ses.getMoneda()+") as mveval, "+cfg.getOperacion()+"(k.mvevpe) as mvevpe"
									+ " From Finance as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ " and mveano = " + (Integer.parseInt(ses.getAnio()) - 1)
									//+ sql
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
		    
		    String operacion[] = new String [2];
		    if (cfg.getOperacion().equals("SUM")){
		    	operacion[0]="(sum(k."+ses.getMoneda()+")/2)";
		    	operacion[1]="(sum(k.mvevpe)/2)";
		    }
		    else{
		    	operacion[0]="(avg(k."+ses.getMoneda()+"))";
		    	operacion[1]="(avg(k.mvevpe))";
		    }
		    	
		    // Se obtiene el promedio del PRESENTE año por cada línea generada, todo el año
		    @SuppressWarnings("unchecked")
		    List<Object[]> promAnioActual = em
					.createQuery(
							"Select k.mveano as mveano, "+operacion[0]+" as mveval, "+operacion[1]+" as mvevpe"
									+ " From Finance as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ " and mveano = " + (Integer.parseInt(ses.getAnio()))
									+ " AND k.mvemes<"+ses.getMes()+" "
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
		    
		    
			
			// Se va agregando a la hoja de reporte cada línea para luego ser mostrada en la vista
			// llega tal cual se mostrará
		    
			if (list.get(0).getMvedes() != null){
				valor.add(new reporteFinance(list.get(0).getMvedes(), cfg.getIndicador(), 
						cfg.getUnidad(), "Actual", "Budget",
						anioAntReal,
						anioAntPres,
						promMvevalRealAnoActual, 
						promMvevpePresupuestadoAnoActual,
						new ArrayList<Finance>(list),cfg.getTipo()));
			}
			promMvevalRealAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			promMvevpePresupuestadoAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		}
		return valor;
	}
		
	// listFinanceQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listFinanceQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listFinanceQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listFinanceQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listFinanceQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listFinanceQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listFinanceQuarterly //////////////////////////////////////////////////////////////////////////////////
	// listFinanceQuarterly //////////////////////////////////////////////////////////////////////////////////

	public List<reporteFinance> listFinanceQuarterly(session ses) {
		List<reporteFinance> valor = new LinkedList<reporteFinance>();
		List<CfgFinance> indicadores = cfgFinanceService.getListCfg();
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
		
		java.math.BigDecimal valorMesActualQ1 = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal valorMesBudgetQ1 = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal valorMesActualQ2 = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal valorMesBudgetQ2 = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal valorMesActualQ3 = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal valorMesBudgetQ3 = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal valorMesActualQ4 = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		java.math.BigDecimal valorMesBudgetQ4 = new java.math.BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		
		int mesesQ1=0,mesesQ2=0,mesesQ3=0,mesesQ4=0;
		int Q1=0,Q2=0,Q3=0,Q4=0;
		
		String sql="";
		if (!ses.getDash_nia().equals("Todas")){
			sql = " AND k.mvecia='"+ses.getDash_nia()+"' ";
		}
		if (!ses.getDash_region().equals("Todas")){
			sql += " AND k.mvereg='"+ses.getDash_region()+"' ";
		}
	
		// Lee todos los indicadores de la base de datos
		for (CfgFinance cfg : indicadores) {

			// Va a la base de datos y toma para cada indicador
			@SuppressWarnings("unchecked")
			List<Object[]> result = em
					.createQuery(
							"Select k.mveano as mveano, k.mvemes as mvemes, k.mvedes as mvedes, "+cfg.getOperacion()+"(k."+ses.getMoneda()+") as mveval, "+cfg.getOperacion()+"(k.mvevpe) as mvevpe"
									+ " From Finance as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ sql
									+ " AND k.mveano='"+ses.getAnio()+"' "
									+ " GROUP BY k.mveano , k.mvemes, k.mvedes"
									+ " ORDER BY k.mvedes, k.mveano , k.mvemes asc")
					.getResultList();

			// Se crea un objeto lista para almacenar todo año (solo la línea del indicador)
			List<Finance> list = new LinkedList<Finance>();
			
			// Se inician los 12 meses
			for (int i = 0; i < 4; i++) {
				list.add(new Finance("2015", "" + (i + 1)));
			}
			// Se va colocando cada mes en la hoja de resultado
			for (Object[] r : result) {
				int Mes=Integer.parseInt(r[1].toString())-1;
				if (Mes <= 3){
					promedioActualQ1=promedioActualQ1.add(new java.math.BigDecimal(r[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN));
					promedioBudgetQ1=promedioBudgetQ1.add(new java.math.BigDecimal(r[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN));
					valorMesActualQ1=new java.math.BigDecimal(r[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN);
					valorMesBudgetQ1=new java.math.BigDecimal(r[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN);
					mesesQ1++;
					Q1=1;
				}else{
					if (Mes > 3 && Mes <= 6){
						promedioActualQ2=promedioActualQ2.add(new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
						promedioBudgetQ2=promedioBudgetQ2.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
						valorMesActualQ2=new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
						valorMesBudgetQ2=new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
						mesesQ2++;
						Q2=1;
					}
					else{
						if (Mes > 6 && Mes <= 9){
							promedioActualQ3=promedioActualQ3.add(new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
							promedioBudgetQ3=promedioBudgetQ3.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
							valorMesActualQ3=new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
							valorMesBudgetQ3=new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
							mesesQ3++;
							Q3=1;
						}
						else{
							promedioActualQ4=promedioActualQ4.add(new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
							promedioBudgetQ4=promedioBudgetQ4.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
							valorMesActualQ4=new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
							valorMesBudgetQ4=new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
							mesesQ4++;
							Q4=1;
						}
					}
				}
				list.get(1).setMvedes(r[2].toString());

				//promMvevalRealAnoActual=promMvevalRealAnoActual.add(new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				//promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				
			}
			mesesQ1--;mesesQ2--;mesesQ3--;mesesQ4--;
			mesesQ1=(mesesQ1==0?1:mesesQ1);
			mesesQ2=(mesesQ2==0?1:mesesQ2);
			mesesQ3=(mesesQ3==0?1:mesesQ3);
			mesesQ4=(mesesQ4==0?1:mesesQ4);
			
			promedioActualQ1=promedioActualQ1.subtract(valorMesActualQ1);
			promedioActualQ2=promedioActualQ2.subtract(valorMesActualQ2);
			promedioActualQ3=promedioActualQ3.subtract(valorMesActualQ3);
			promedioActualQ4=promedioActualQ4.subtract(valorMesActualQ4);
			
			promedioBudgetQ1=promedioBudgetQ1.subtract(valorMesBudgetQ1);
			promedioBudgetQ2=promedioBudgetQ2.subtract(valorMesBudgetQ2);
			promedioBudgetQ3=promedioBudgetQ3.subtract(valorMesBudgetQ3);
			promedioBudgetQ4=promedioBudgetQ4.subtract(valorMesBudgetQ4);
			
			promedioActualQ1=promedioActualQ1.divide(new BigDecimal(mesesQ1), 2, RoundingMode.HALF_UP);
			promedioActualQ2=promedioActualQ2.divide(new BigDecimal(mesesQ2), 2, RoundingMode.HALF_UP);
			promedioActualQ3=promedioActualQ3.divide(new BigDecimal(mesesQ3), 2, RoundingMode.HALF_UP);
			promedioActualQ4=promedioActualQ4.divide(new BigDecimal(mesesQ4), 2, RoundingMode.HALF_UP);
			
			promedioBudgetQ1=promedioBudgetQ1.divide(new BigDecimal(mesesQ1), 2, RoundingMode.HALF_UP);
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
			
			promMvevalRealAnoActual=promMvevalRealAnoActual.add(promedioActualQ1);
			promMvevalRealAnoActual=promMvevalRealAnoActual.add(promedioActualQ2);
			promMvevalRealAnoActual=promMvevalRealAnoActual.add(promedioActualQ3);
			promMvevalRealAnoActual=promMvevalRealAnoActual.add(promedioActualQ4);
			
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(promedioBudgetQ1);
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(promedioBudgetQ2);
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(promedioBudgetQ3);
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(promedioBudgetQ4);

			int totalQ=Q1+Q2+Q3+Q4;
			totalQ=(totalQ==0?1:totalQ);
			promMvevalRealAnoActual=promMvevalRealAnoActual.divide(new BigDecimal(totalQ), 2, RoundingMode.HALF_UP);
			promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.divide(new BigDecimal(totalQ), 2, RoundingMode.HALF_UP);
			
			// Se obtiene el promedio del año anterior por cada línea generada
			
		    @SuppressWarnings("unchecked")
		    List<Object[]> prom = em
					.createQuery(
							"Select k.mveano as mveano, "+cfg.getOperacion()+"(k."+ses.getMoneda()+") as mveval, "+cfg.getOperacion()+"(k.mvevpe) as mvevpe"
									+ " From Finance as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
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
				valor.add(new reporteFinance(list.get(1).getMvedes(), cfg.getIndicador(), 
						cfg.getUnidad(), "Actual", "Budget",
						anioAntReal,
						anioAntPres,
						promMvevalRealAnoActual, 
						promMvevpePresupuestadoAnoActual,
						new ArrayList<Finance>(list),cfg.getTipo()));
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
	

}
