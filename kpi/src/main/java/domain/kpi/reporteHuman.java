package domain.kpi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class reporteHuman implements Serializable{

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
	private List<Human> lista;
	private String tipo;
	
	public reporteHuman(String ind, String ind_cod, String unidad, String tipoUno, String tipoDos,
			BigDecimal promMvevalRealAnoAnt, BigDecimal promMvevpePresupuestadoAnt, BigDecimal promMvevalRealAnoActual,
			BigDecimal promMvevpePresupuestadoAnoActual, List<Human> lista, String tipo) {
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
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ind == null) ? 0 : ind.hashCode());
		result = prime * result + ((ind_cod == null) ? 0 : ind_cod.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		result = prime * result + ((promMvevalRealAnoActual == null) ? 0 : promMvevalRealAnoActual.hashCode());
		result = prime * result + ((promMvevalRealAnoAnt == null) ? 0 : promMvevalRealAnoAnt.hashCode());
		result = prime * result
				+ ((promMvevpePresupuestadoAnoActual == null) ? 0 : promMvevpePresupuestadoAnoActual.hashCode());
		result = prime * result + ((promMvevpePresupuestadoAnt == null) ? 0 : promMvevpePresupuestadoAnt.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((tipoDos == null) ? 0 : tipoDos.hashCode());
		result = prime * result + ((tipoUno == null) ? 0 : tipoUno.hashCode());
		result = prime * result + ((unidad == null) ? 0 : unidad.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		reporteHuman other = (reporteHuman) obj;
		if (ind == null) {
			if (other.ind != null)
				return false;
		} else if (!ind.equals(other.ind))
			return false;
		if (ind_cod == null) {
			if (other.ind_cod != null)
				return false;
		} else if (!ind_cod.equals(other.ind_cod))
			return false;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		if (promMvevalRealAnoActual == null) {
			if (other.promMvevalRealAnoActual != null)
				return false;
		} else if (!promMvevalRealAnoActual.equals(other.promMvevalRealAnoActual))
			return false;
		if (promMvevalRealAnoAnt == null) {
			if (other.promMvevalRealAnoAnt != null)
				return false;
		} else if (!promMvevalRealAnoAnt.equals(other.promMvevalRealAnoAnt))
			return false;
		if (promMvevpePresupuestadoAnoActual == null) {
			if (other.promMvevpePresupuestadoAnoActual != null)
				return false;
		} else if (!promMvevpePresupuestadoAnoActual.equals(other.promMvevpePresupuestadoAnoActual))
			return false;
		if (promMvevpePresupuestadoAnt == null) {
			if (other.promMvevpePresupuestadoAnt != null)
				return false;
		} else if (!promMvevpePresupuestadoAnt.equals(other.promMvevpePresupuestadoAnt))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (tipoDos == null) {
			if (other.tipoDos != null)
				return false;
		} else if (!tipoDos.equals(other.tipoDos))
			return false;
		if (tipoUno == null) {
			if (other.tipoUno != null)
				return false;
		} else if (!tipoUno.equals(other.tipoUno))
			return false;
		if (unidad == null) {
			if (other.unidad != null)
				return false;
		} else if (!unidad.equals(other.unidad))
			return false;
		return true;
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

	public List<Human> getLista() {
		return lista;
	}

	public void setLista(List<Human> lista) {
		this.lista = lista;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
