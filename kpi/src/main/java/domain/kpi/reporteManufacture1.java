package domain.kpi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class reporteManufacture1 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3040647131153329191L;
	
	private String ind;
	private String ind_cod;
	private String unidad;
	private String tipoUno;
	private String tipoDos;
	private BigDecimal promMvevalRealAnoAnt;
	private BigDecimal promMvevpePresupuestadoAnt;
	private BigDecimal promMvevalRealAnoActual; 
	private BigDecimal promMvevpePresupuestadoAnoActual;
	private List<Manufacture1> lista;
	private String tipo;
	private String operacion;
	
	
	public reporteManufacture1(String ind, String ind_cod, String unidad, String tipoUno, String tipoDos,
			BigDecimal promMvevalRealAnoAnt, BigDecimal promMvevpePresupuestadoAnt, BigDecimal promMvevalRealAnoActual,
			BigDecimal promMvevpePresupuestadoAnoActual, List<Manufacture1> lista, String tipo, String operacion) {
		super();
		this.ind = ind;
		this.ind_cod = ind_cod;
		this.unidad = unidad;
		this.tipoUno = tipoUno;
		this.tipoDos = tipoDos;
		this.promMvevalRealAnoAnt = promMvevalRealAnoAnt;
		this.promMvevpePresupuestadoAnt = promMvevpePresupuestadoAnt;
		this.promMvevalRealAnoActual = promMvevalRealAnoActual;
		this.promMvevpePresupuestadoAnoActual = promMvevpePresupuestadoAnoActual;
		this.lista = lista;
		this.tipo = tipo;
		this.operacion = operacion;
	}


	public String getInd() {
		return ind;
	}


	public void setInd(String ind) {
		this.ind = ind;
	}


	public String getInd_cod() {
		return ind_cod;
	}


	public void setInd_cod(String ind_cod) {
		this.ind_cod = ind_cod;
	}


	public String getUnidad() {
		return unidad;
	}


	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}


	public String getTipoUno() {
		return tipoUno;
	}


	public void setTipoUno(String tipoUno) {
		this.tipoUno = tipoUno;
	}


	public String getTipoDos() {
		return tipoDos;
	}


	public void setTipoDos(String tipoDos) {
		this.tipoDos = tipoDos;
	}


	public BigDecimal getPromMvevalRealAnoAnt() {
		return promMvevalRealAnoAnt;
	}


	public void setPromMvevalRealAnoAnt(BigDecimal promMvevalRealAnoAnt) {
		this.promMvevalRealAnoAnt = promMvevalRealAnoAnt;
	}


	public BigDecimal getPromMvevpePresupuestadoAnt() {
		return promMvevpePresupuestadoAnt;
	}


	public void setPromMvevpePresupuestadoAnt(BigDecimal promMvevpePresupuestadoAnt) {
		this.promMvevpePresupuestadoAnt = promMvevpePresupuestadoAnt;
	}


	public BigDecimal getPromMvevalRealAnoActual() {
		return promMvevalRealAnoActual;
	}


	public void setPromMvevalRealAnoActual(BigDecimal promMvevalRealAnoActual) {
		this.promMvevalRealAnoActual = promMvevalRealAnoActual;
	}


	public BigDecimal getPromMvevpePresupuestadoAnoActual() {
		return promMvevpePresupuestadoAnoActual;
	}


	public void setPromMvevpePresupuestadoAnoActual(BigDecimal promMvevpePresupuestadoAnoActual) {
		this.promMvevpePresupuestadoAnoActual = promMvevpePresupuestadoAnoActual;
	}


	public List<Manufacture1> getLista() {
		return lista;
	}


	public void setLista(List<Manufacture1> lista) {
		this.lista = lista;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getOperacion() {
		return operacion;
	}


	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
}
