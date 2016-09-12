package domain.kpi;

import java.io.Serializable;

import javax.persistence.Column;

public class DistriPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column
	private String mveano;
	
	@Column
	private String mvemes;
	
	@Column
	private String mvereg;
	
	@Column
	private String mvecia;

	@Column
	private String mvecr2;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mveano == null) ? 0 : mveano.hashCode());
		result = prime * result + ((mvecia == null) ? 0 : mvecia.hashCode());
		result = prime * result + ((mvecr2 == null) ? 0 : mvecr2.hashCode());
		result = prime * result + ((mvemes == null) ? 0 : mvemes.hashCode());
		result = prime * result + ((mvereg == null) ? 0 : mvereg.hashCode());
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
		DistriPK other = (DistriPK) obj;
		if (mveano == null) {
			if (other.mveano != null)
				return false;
		} else if (!mveano.equals(other.mveano))
			return false;
		if (mvecia == null) {
			if (other.mvecia != null)
				return false;
		} else if (!mvecia.equals(other.mvecia))
			return false;
		if (mvecr2 == null) {
			if (other.mvecr2 != null)
				return false;
		} else if (!mvecr2.equals(other.mvecr2))
			return false;
		if (mvemes == null) {
			if (other.mvemes != null)
				return false;
		} else if (!mvemes.equals(other.mvemes))
			return false;
		if (mvereg == null) {
			if (other.mvereg != null)
				return false;
		} else if (!mvereg.equals(other.mvereg))
			return false;
		return true;
	}
	
	
	
}
