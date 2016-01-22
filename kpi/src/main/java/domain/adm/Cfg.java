package domain.adm;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import domain.login.User;

@Entity
@Table(name="cfg", schema="gestion")
public class Cfg implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "indicador")
    private String indicador;
		
	@Column(name = "operacion")
	private String operacion;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "division")
	private String division;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "unidad")
	private String unidad;
	
	@Column(name = "tipo")
	private String tipo;
	
	public Cfg() {
		// TODO Auto-generated constructor stub
	}

	public String getIndicador() {
		return indicador;
	}

	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cfg [indicador=" + indicador + ", operacion=" + operacion + ", area=" + area + ", division=" + division
				+ ", descripcion=" + descripcion + ", unidad=" + unidad + ", tipo=" + tipo + "]";
	}

	

}
