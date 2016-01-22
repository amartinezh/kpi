package domain.adm;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="plan", schema="gestion")
public class Plan implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "plan_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gestion.plan_plan_id_seq")
	@SequenceGenerator(name="gestion.plan_plan_id_seq", sequenceName="gestion.plan_plan_id_seq", allocationSize=1)
	private int plan_id;
	
	@Column(name = "indicador")
	private String indicador;
	
	@Column(name = "fecha")
	private java.util.Date fecha;
	
	@Column(name = "problema_encontrado")
	private String problema_encontrado;
	
	@Column(name = "impacto_discrepancia")
	private String impacto_discrepancia;
	
	@Column(name = "plan_accion")
	private String plan_accion;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "responsable")
	private String responsable;
	
	@Column(name = "resultado_esperado")
	private String resultado_esperado;
	
	@Column(name = "fecha_compromiso")
	private java.util.Date fecha_compromiso;
	
	@Column(name = "estado")
	private String estado;
	
	public Plan(int plan_id) {
		super();
		this.plan_id = plan_id;
	}

	public Plan(int plan_id, String indicador, Date fecha, String problema_encontrado, String impacto_discrepancia,
			String plan_accion, String tipo, String responsable, String resultado_esperado, Date fecha_compromiso,
			String estado) {
		//super();
		this.plan_id = plan_id;
		this.indicador = indicador;
		this.fecha = fecha;
		this.problema_encontrado = problema_encontrado;
		this.impacto_discrepancia = impacto_discrepancia;
		this.plan_accion = plan_accion;
		this.tipo = tipo;
		this.responsable = responsable;
		this.resultado_esperado = resultado_esperado;
		this.fecha_compromiso = fecha_compromiso;
		this.estado = estado;
	}

	public Plan() {
		// TODO Auto-generated constructor stub
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public String getIndicador() {
		return indicador;
	}

	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public String getProblema_encontrado() {
		return problema_encontrado;
	}

	public void setProblema_encontrado(String problema_encontrado) {
		this.problema_encontrado = problema_encontrado;
	}

	public String getImpacto_discrepancia() {
		return impacto_discrepancia;
	}

	public void setImpacto_discrepancia(String impacto_discrepancia) {
		this.impacto_discrepancia = impacto_discrepancia;
	}

	public String getPlan_accion() {
		return plan_accion;
	}

	public void setPlan_accion(String plan_accion) {
		this.plan_accion = plan_accion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getResultado_esperado() {
		return resultado_esperado;
	}

	public void setResultado_esperado(String resultado_esperado) {
		this.resultado_esperado = resultado_esperado;
	}

	public java.util.Date getFecha_compromiso() {
		return fecha_compromiso;
	}

	public void setFecha_compromiso(java.util.Date fecha_compromiso) {
		this.fecha_compromiso = fecha_compromiso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Plan [plan_id=" + plan_id + ", indicador=" + indicador + ", fecha=" + fecha + ", problema_encontrado="
				+ problema_encontrado + ", impacto_discrepancia=" + impacto_discrepancia + ", plan_accion="
				+ plan_accion + ", tipo=" + tipo + ", responsable=" + responsable + ", resultado_esperado="
				+ resultado_esperado + ", fecha_compromiso=" + fecha_compromiso + ", estado=" + estado + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((fecha_compromiso == null) ? 0 : fecha_compromiso.hashCode());
		result = prime * result + ((impacto_discrepancia == null) ? 0 : impacto_discrepancia.hashCode());
		result = prime * result + ((indicador == null) ? 0 : indicador.hashCode());
		result = prime * result + ((plan_accion == null) ? 0 : plan_accion.hashCode());
		result = prime * result + plan_id;
		result = prime * result + ((problema_encontrado == null) ? 0 : problema_encontrado.hashCode());
		result = prime * result + ((responsable == null) ? 0 : responsable.hashCode());
		result = prime * result + ((resultado_esperado == null) ? 0 : resultado_esperado.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Plan other = (Plan) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (fecha_compromiso == null) {
			if (other.fecha_compromiso != null)
				return false;
		} else if (!fecha_compromiso.equals(other.fecha_compromiso))
			return false;
		if (impacto_discrepancia == null) {
			if (other.impacto_discrepancia != null)
				return false;
		} else if (!impacto_discrepancia.equals(other.impacto_discrepancia))
			return false;
		if (indicador == null) {
			if (other.indicador != null)
				return false;
		} else if (!indicador.equals(other.indicador))
			return false;
		if (plan_accion == null) {
			if (other.plan_accion != null)
				return false;
		} else if (!plan_accion.equals(other.plan_accion))
			return false;
		if (plan_id != other.plan_id)
			return false;
		if (problema_encontrado == null) {
			if (other.problema_encontrado != null)
				return false;
		} else if (!problema_encontrado.equals(other.problema_encontrado))
			return false;
		if (responsable == null) {
			if (other.responsable != null)
				return false;
		} else if (!responsable.equals(other.responsable))
			return false;
		if (resultado_esperado == null) {
			if (other.resultado_esperado != null)
				return false;
		} else if (!resultado_esperado.equals(other.resultado_esperado))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	

}
