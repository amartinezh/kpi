package domain.kpi;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class Manufacture1PK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column
	private String mveano;
	
	@Column
	private String mvemes;
	
	@Column
	private String mvereg;
	
	@Column
	private String mvecia;
	
	@Column(name = "mvepce")
	private String mvepce; // Proceso
	
	@Column(name = "mveind")
	private String mveind; // ID. Indicador
	
	@Column(name = "mvecen")
	private String mvecen; // Codigo Centro
	
	@Column(name = "mvepro")
	private String mvepro; // Código Producto
	
	@Column(name = "mvecal")
	private String mvecal; // Clase Artículo
	
	@Column(name = "mvetur")
	private String mvetur; // Turno

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mveano == null) ? 0 : mveano.hashCode());
		result = prime * result + ((mvecal == null) ? 0 : mvecal.hashCode());
		result = prime * result + ((mvecen == null) ? 0 : mvecen.hashCode());
		result = prime * result + ((mvecia == null) ? 0 : mvecia.hashCode());
		result = prime * result + ((mveind == null) ? 0 : mveind.hashCode());
		result = prime * result + ((mvemes == null) ? 0 : mvemes.hashCode());
		result = prime * result + ((mvepce == null) ? 0 : mvepce.hashCode());
		result = prime * result + ((mvepro == null) ? 0 : mvepro.hashCode());
		result = prime * result + ((mvereg == null) ? 0 : mvereg.hashCode());
		result = prime * result + ((mvetur == null) ? 0 : mvetur.hashCode());
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
		Manufacture1PK other = (Manufacture1PK) obj;
		if (mveano == null) {
			if (other.mveano != null)
				return false;
		} else if (!mveano.equals(other.mveano))
			return false;
		if (mvecal == null) {
			if (other.mvecal != null)
				return false;
		} else if (!mvecal.equals(other.mvecal))
			return false;
		if (mvecen == null) {
			if (other.mvecen != null)
				return false;
		} else if (!mvecen.equals(other.mvecen))
			return false;
		if (mvecia == null) {
			if (other.mvecia != null)
				return false;
		} else if (!mvecia.equals(other.mvecia))
			return false;
		if (mveind == null) {
			if (other.mveind != null)
				return false;
		} else if (!mveind.equals(other.mveind))
			return false;
		if (mvemes == null) {
			if (other.mvemes != null)
				return false;
		} else if (!mvemes.equals(other.mvemes))
			return false;
		if (mvepce == null) {
			if (other.mvepce != null)
				return false;
		} else if (!mvepce.equals(other.mvepce))
			return false;
		if (mvepro == null) {
			if (other.mvepro != null)
				return false;
		} else if (!mvepro.equals(other.mvepro))
			return false;
		if (mvereg == null) {
			if (other.mvereg != null)
				return false;
		} else if (!mvereg.equals(other.mvereg))
			return false;
		if (mvetur == null) {
			if (other.mvetur != null)
				return false;
		} else if (!mvetur.equals(other.mvetur))
			return false;
		return true;
	}
}