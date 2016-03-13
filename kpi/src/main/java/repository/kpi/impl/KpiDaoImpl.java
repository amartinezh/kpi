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

import domain.adm.Cfg;
import domain.kpi.Kpi;
import domain.kpi.reporte;
import domain.session.session;
import repository.kpi.KpiDao;
import service.adm.CfgService;

@Repository
public class KpiDaoImpl implements KpiDao {

	@PersistenceContext
	private EntityManager em = null;

	@Autowired
	private CfgService cfgService;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	// listSales //////////////////////////////////////////////////////////////////////////////////

	public List<reporte> listSales(session ses) {
		List<reporte> valor = new LinkedList<reporte>();
		List<Cfg> indicadores = cfgService.getListCfg();
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
		for (Cfg cfg : indicadores) {

			// Va a la base de datos y toma para cada indicador
			@SuppressWarnings("unchecked")
			List<Object[]> result = em
					.createQuery(
							"Select k.mveano as mveano, k.mvemes as mvemes, k.mvedes as mvedes, "+cfg.getOperacion()+"(k."+ses.getMoneda()+") as mveval, "+cfg.getOperacion()+"(k.mvevpe) as mvevpe"
									+ " From Kpi as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ sql
									+ " AND k.mveano='"+ses.getAnio()+"' "
									+ " GROUP BY k.mveano , k.mvemes, k.mvedes"
									+ " ORDER BY k.mvedes, k.mveano , k.mvemes asc")
					.getResultList();

			// Se crea un objeto lista para almacenar todo año (solo la línea del indicador)
			List<Kpi> list = new LinkedList<Kpi>();
			
			// Se inician los 12 meses
			for (int i = 0; i < 12; i++) {
				list.add(new Kpi("2015", "" + (i + 1)));
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
									+ " From Kpi as k where k.mveind = '"
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
				valor.add(new reporte(list.get(1).getMvedes(), cfg.getIndicador(), 
						cfg.getUnidad(), "Real", "Budgeted",
						anioAntReal,
						anioAntPres,
						promMvevalRealAnoActual, 
						promMvevpePresupuestadoAnoActual,
						new ArrayList<Kpi>(list),cfg.getTipo()));
			}
			promMvevalRealAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			promMvevpePresupuestadoAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		}
		return valor;
	}
	
	// listSalesMonth //////////////////////////////////////////////////////////////////////////////////

	public List<reporte> listSalesMonth(session ses) {
		List<reporte> valor = new LinkedList<reporte>();
		List<Cfg> indicadores = cfgService.getListCfg();
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
		for (Cfg cfg : indicadores) {

			// Va a la base de datos y toma para cada indicador
			@SuppressWarnings("unchecked")
			List<Object[]> result = em
					.createQuery(
							"Select k.mveano as mveano, k.mvemes as mvemes, k.mvedes as mvedes, "+cfg.getOperacion()+"(k."+ses.getMoneda()+") as mveval, "+cfg.getOperacion()+"(k.mvevpe) as mvevpe"
									+ " From Kpi as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ sql
									+ " AND k.mveano='"+ses.getAnio()+"' "
									+ " AND k.mvemes='"+ses.getMes()+"' "
									+ " GROUP BY k.mveano , k.mvemes, k.mvedes"
									+ " ORDER BY k.mvedes, k.mveano , k.mvemes asc")
					.getResultList();

			// Se crea un objeto lista para almacenar todo año (solo la línea del indicador)
			List<Kpi> list = new LinkedList<Kpi>();
			
			// Se inician los 12 meses
			//for (int i = 0; i < 12; i++) {
			//	list.add(new Kpi("2015", "" + (i + 1)));
			//}
			list.add(new Kpi("2000", ses.getMes() ));
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
				promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
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
									+ " From Kpi as k where k.mveind = '"
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
		    
		    // Se obtiene el promedio del PRESENTE año por cada línea generada, todo el año
			
		    @SuppressWarnings("unchecked")
		    List<Object[]> promAnioActual = em
					.createQuery(
							"Select k.mveano as mveano, "+cfg.getOperacion()+"(k."+ses.getMoneda()+") as mveval, "+cfg.getOperacion()+"(k.mvevpe) as mvevpe"
									+ " From Kpi as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ " and mveano = " + (Integer.parseInt(ses.getAnio()))
									+ sql
									+ " GROUP BY k.mveano"
									+ " ORDER BY k.mveano asc")
					.getResultList();
		    
		    if (promAnioActual.size() > 0){
		    	promMvevalRealAnoActual= new java.math.BigDecimal(promAnioActual.get(0)[1].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			}
			else{
				promMvevalRealAnoActual = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
				anioAntPres = new java.math.BigDecimal(0).setScale(3, BigDecimal.ROUND_HALF_EVEN);
			}
		    
		    
			
			// Se va agregando a la hoja de reporte cada línea para luego ser mostrada en la vista
			// llega tal cual se mostrará
		    
			if (list.get(0).getMvedes() != null){
				valor.add(new reporte(list.get(0).getMvedes(), cfg.getIndicador(), 
						cfg.getUnidad(), "Real", "Budgeted",
						anioAntReal,
						anioAntPres,
						promMvevalRealAnoActual, 
						promMvevpePresupuestadoAnoActual,
						new ArrayList<Kpi>(list),cfg.getTipo()));
			}
			promMvevalRealAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			promMvevpePresupuestadoAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		}
		return valor;
	}
		
	// listSalesQuarterly //////////////////////////////////////////////////////////////////////////////////

	public List<reporte> listSalesQuarterly(session ses) {
		List<reporte> valor = new LinkedList<reporte>();
		List<Cfg> indicadores = cfgService.getListCfg();
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
		for (Cfg cfg : indicadores) {

			// Va a la base de datos y toma para cada indicador
			@SuppressWarnings("unchecked")
			List<Object[]> result = em
					.createQuery(
							"Select k.mveano as mveano, k.mvemes as mvemes, k.mvedes as mvedes, "+cfg.getOperacion()+"(k."+ses.getMoneda()+") as mveval, "+cfg.getOperacion()+"(k.mvevpe) as mvevpe"
									+ " From Kpi as k where k.mveind = '"
									+ cfg.getIndicador()
									+ "' "
									+ sql
									+ " AND k.mveano='"+ses.getAnio()+"' "
									+ " GROUP BY k.mveano , k.mvemes, k.mvedes"
									+ " ORDER BY k.mvedes, k.mveano , k.mvemes asc")
					.getResultList();

			// Se crea un objeto lista para almacenar todo año (solo la línea del indicador)
			List<Kpi> list = new LinkedList<Kpi>();
			
			// Se inician los 12 meses
			for (int i = 0; i < 4; i++) {
				list.add(new Kpi("2015", "" + (i + 1)));
			}
			int meses=0;
			// Se va colocando cada mes en la hoja de resultado
			for (Object[] r : result) {
				int Mes=Integer.parseInt(r[1].toString())-1;
				if (Mes <= 3){
					list.get(0).setMveval(list.get(0).getMveval().add(
							new BigDecimal(r[3].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN)));
					list.get(0).setMvevpe(list.get(0).getMvevpe().add(
							new BigDecimal(r[4].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN)));
				}else{
					if (Mes > 3 && Mes <= 6){
						list.get(1).setMveval(list.get(0).getMveval().add(
								new BigDecimal(r[3].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN)));
						list.get(1).setMvevpe(list.get(0).getMvevpe().add(
								new BigDecimal(r[4].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN)));
					}
					else{
						if (Mes > 6 && Mes <= 9){
							list.get(2).setMveval(list.get(0).getMveval().add(
									new BigDecimal(r[3].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN)));
							list.get(2).setMvevpe(list.get(0).getMvevpe().add(
									new BigDecimal(r[4].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN)));
						}
						else{
							list.get(3).setMveval(list.get(0).getMveval().add(
									new BigDecimal(r[3].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN)));
							list.get(3).setMvevpe(list.get(0).getMvevpe().add(
									new BigDecimal(r[4].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN)));
						}
					}
				}
				list.get(1).setMvedes(r[2].toString());

				promMvevalRealAnoActual=promMvevalRealAnoActual.add(new java.math.BigDecimal(r[3].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				promMvevpePresupuestadoAnoActual=promMvevpePresupuestadoAnoActual.add(new java.math.BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
				
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
									+ " From Kpi as k where k.mveind = '"
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
				valor.add(new reporte(list.get(1).getMvedes(), cfg.getIndicador(), 
						cfg.getUnidad(), "Real", "Budgeted",
						anioAntReal,
						anioAntPres,
						promMvevalRealAnoActual, 
						promMvevpePresupuestadoAnoActual,
						new ArrayList<Kpi>(list),cfg.getTipo()));
			}
			promMvevalRealAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			promMvevpePresupuestadoAnoActual = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		}
		return valor;
	}
	
	// //////////////////////////////////////////////////////////////////////////////////

	public List<reporte> listSalesDrill(session ses) {
		List<reporte> valor = new LinkedList<reporte>();
		java.math.BigDecimal promedio = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		String sql="";
		if (!ses.getDash_nia().equals("Todas")){
			sql = " AND k.mvecia='"+ses.getDash_nia()+"' ";
		}
		if (!ses.getDash_region().equals("Todas")){
			sql += " AND k.mvereg='"+ses.getDash_region()+"' ";
		}
		if (ses.getOp().equals("M")){
			sql += " AND k.mvemes='"+ses.getMes()+"' ";
		}
		
		@SuppressWarnings("unchecked")
		List<Object[]> result = em
		.createQuery(
				"Select k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+", k.mveano as mveano, k.mvemes as mvemes, k.mvedes as mvedes, sum(k."+ses.getMoneda()+") as mveval, sum(k.mvevpe) as mvevpe"
						+ " From Kpi as k where k.mveind = '"
						+ ses.getIndicador_drill()
						+ "' "
						+ sql
						+ " AND k.mveano='"+ses.getAnio()+"' "
						+ " GROUP BY k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+",  k.mveano , k.mvemes, k.mvedes, k."+ses.getCampo_descripcion()
						+ " ORDER BY k."+ses.getCampo_descripcion()+", k."+ses.getCampo_llave()+", k.mvedes, k.mveano , k.mvemes asc")
		.getResultList();

		List<Kpi> list = new LinkedList<Kpi>();
		
		int x=0;
		while (x<result.size()){
			
			// Se inician los 12 meses
			list = new LinkedList<Kpi>();
			for (int i = 0; i < 12; i++) {
				list.add(new Kpi("2015", "" + (i + 1)));
			}
			//System.out.println(x+ " Actual: " + result.get(x)[0].toString() + " Anterior: " + result.get( (x==0?x:x-1)   )[0].toString() + " " );
			// Va comparando el nombre del indicador que está en la posición 0
			// Éste if compara si cambia el codigo del indicador, la idea es detectar los cambios como una ruptura
			// Si es igual arranca con un while para ir recogiendo todos los meses, el problema que resuleve es 
			// en el SQL llegan a manera de filas todos los meses
			if (  result.get(x)[0].toString().equals(result.get( (x==0?x:x-1)   )[0].toString())  ){
				while( result.get(x)[0].toString().equals(result.get( (x==0?x:x-1)   )[0].toString()) ){
					System.out.println("Entro al while ["+x+"] - "+result.get(x)[0].toString());
					list.get(Integer.parseInt(result.get(x)[3].toString())-1).setMveval(new BigDecimal(result.get(x)[5].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN));
					list.get(Integer.parseInt(result.get(x)[3].toString())-1).setMvevpe(new BigDecimal(result.get(x)[6].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
					promedio=promedio.add(new java.math.BigDecimal(result.get(x)[5].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
					x++;
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
				x++;
				if (x==result.size())
					break;
				while( result.get(x)[0].toString().equals(result.get( (x==0?x:x-1)   )[0].toString()) ){
					System.out.println("Entro al while2 ["+x+"] - "+result.get(x)[0].toString());
					list.get(Integer.parseInt(result.get(x)[3].toString())-1).setMveval(new BigDecimal(result.get(x)[5].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN));
					list.get(Integer.parseInt(result.get(x)[3].toString())-1).setMvevpe(new BigDecimal(result.get(x)[6].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
					promedio=promedio.add(new java.math.BigDecimal(result.get(x)[5].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));
					x++;
					if (x==result.size())
						break;
				}
				x--;

			}
			valor.add(new reporte(result.get(x)[0].toString(), result.get(x)[1].toString(), 
					"", "Real", "Budgeted",
					promedio, 
					promedio,
					promedio, 
					promedio,
					new ArrayList<Kpi>(list),""));
			
			x++;
			promedio = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		}
		System.out.println("cantidadMesesResultantes: "+x);
		
	      
		return valor;
	}

	// //////////////////////////////////////////////////////////////////////////////////
	
	// //////////////////////////////////////////////////////////////////////////////////

		public List<reporte> listSalesDrillMonth(session ses) {
			List<reporte> valor = new LinkedList<reporte>();
			java.math.BigDecimal promedio = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
			String sql="";
			if (!ses.getDash_nia().equals("Todas")){
				sql = " AND k.mvecia='"+ses.getDash_nia()+"' ";
			}
			if (!ses.getDash_region().equals("Todas")){
				sql += " AND k.mvereg='"+ses.getDash_region()+"' ";
			}
			//if (ses.getOp().equals("M")){
			sql += " AND k.mvemes='"+ses.getMes()+"' ";
			//}
			
			@SuppressWarnings("unchecked")
			List<Object[]> result = em
			.createQuery(
					"Select k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+", k.mveano as mveano, k.mvemes as mvemes, k.mvedes as mvedes, sum(k."+ses.getMoneda()+") as mveval, sum(k.mvevpe) as mvevpe"
							+ " From Kpi as k where k.mveind = '"
							+ ses.getIndicador_drill()
							+ "' "
							+ sql
							+ " AND k.mveano='"+ses.getAnio()+"' "
							+ " GROUP BY k."+ses.getCampo_llave()+", k."+ses.getCampo_descripcion()+",  k.mveano , k.mvemes, k.mvedes, k."+ses.getCampo_descripcion()
							+ " ORDER BY k."+ses.getCampo_descripcion()+", k."+ses.getCampo_llave()+", k.mvedes, k.mveano , k.mvemes asc")
			.getResultList();

			List<Kpi> list = new LinkedList<Kpi>();
			list.add(new Kpi("2000", ses.getMes() ));
			System.out.println("Tamaño"+list.size());
			int meses=0;
			// Se va colocando cada registro en la hoja de resultado
			for (Object[] r : result) {
				list.get(0).setMveval(
						new BigDecimal(r[3].toString()).setScale(3,	BigDecimal.ROUND_HALF_EVEN));

				list.get(0).setMvevpe(
						new BigDecimal(r[4].toString()).setScale(3, BigDecimal.ROUND_HALF_EVEN));

				list.get(0).setMvedes(r[2].toString());

				meses++;
			}
			meses=(meses==0?1:meses);
			
			return valor;
		}

		// //////////////////////////////////////////////////////////////////////////////////

}
