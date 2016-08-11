package domain.kpi;

import java.io.Serializable;

import javax.persistence.Column;

public class DistriPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column
	private int mveano;
	
	@Column
	private int mvemes;
	
	@Column
	private int mvereg;
	
	@Column
	private int mvecia;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mveano;
		result = prime * result + mvecia;
		result = prime * result + mvemes;
		result = prime * result + mvereg;
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
		if (mveano != other.mveano)
			return false;
		if (mvecia != other.mvecia)
			return false;
		if (mvemes != other.mvemes)
			return false;
		if (mvereg != other.mvereg)
			return false;
		return true;
	}

	
	
}
