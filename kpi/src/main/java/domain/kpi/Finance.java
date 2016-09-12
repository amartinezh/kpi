package domain.kpi;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(FinancePK.class)
@Table(name = "indfin", schema = "finances")
public class Finance {
	
	private static final long serialVersionUID = -9068113467850707780L;
	
	@Id
	@Column(name = "mveano")
	private String mveano; // Año de proceso
	
	@Id
	@Column(name = "mvemes")
	private String mvemes; // Mes de proceso
	
	@Id
	@Column(name = "mvereg")
	private String mvereg; // Region
	
	@Id
	@Column(name = "mvecia")
	private String mvecia; // Compañia
	
	@Column(name = "mvecin")
	private String mvecin; // Nombre Compañia
	
	@Column(name = "mveind")
	private String mveind; // ID. Indicador
	
	@Column(name = "mvedes")
	private String mvedes; // Descripcion Indicador
	
	@Column(name = "mverid")
	private String mverid; // Indicador Visualizar
	
	@Column(name = "mveval")
	private BigDecimal mveval; // Valor Indicador USD
	
	@Column(name = "mvevac")
	private BigDecimal mvevac; // Valor Indicador LOCAL
	
	@Column(name = "mvevap")
	private BigDecimal mvevap; // Valor Indicador USD PROMEDIO
	
	@Column(name = "mvevpe")
	private BigDecimal mvevpe; // Valor Indicador PRESUPUESTO

	public Finance(){
		
	}
	
	public String getMveano() {
		return mveano;
	}

	public String getMvemes() {
		return mvemes;
	}

	public void setMvemes(String mvemes) {
		this.mvemes = mvemes;
	}

	public String getMvereg() {
		return mvereg;
	}

	public void setMvereg(String mvereg) {
		this.mvereg = mvereg;
	}

	public String getMvecia() {
		return mvecia;
	}

	public void setMvecia(String mvecia) {
		this.mvecia = mvecia;
	}

	public String getMvecin() {
		return mvecin;
	}

	public void setMvecin(String mvecin) {
		this.mvecin = mvecin;
	}

	public String getMveind() {
		return mveind;
	}

	public void setMveind(String mveind) {
		this.mveind = mveind;
	}

	public String getMvedes() {
		return mvedes;
	}

	public void setMvedes(String mvedes) {
		this.mvedes = mvedes;
	}

	public String getMverid() {
		return mverid;
	}

	public void setMverid(String mverid) {
		this.mverid = mverid;
	}

	public BigDecimal getMveval() {
		return mveval;
	}

	public void setMveval(BigDecimal mveval) {
		this.mveval = mveval;
	}

	public BigDecimal getMvevac() {
		return mvevac;
	}

	public void setMvevac(BigDecimal mvevac) {
		this.mvevac = mvevac;
	}

	public BigDecimal getMvevap() {
		return mvevap;
	}

	public void setMvevap(BigDecimal mvevap) {
		this.mvevap = mvevap;
	}

	public BigDecimal getMvevpe() {
		return mvevpe;
	}

	public void setMvevpe(BigDecimal mvevpe) {
		this.mvevpe = mvevpe;
	}

	public void setMveano(String mveano) {
		this.mveano = mveano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mveano == null) ? 0 : mveano.hashCode());
		result = prime * result + ((mvecia == null) ? 0 : mvecia.hashCode());
		result = prime * result + ((mvecin == null) ? 0 : mvecin.hashCode());
		result = prime * result + ((mvedes == null) ? 0 : mvedes.hashCode());
		result = prime * result + ((mveind == null) ? 0 : mveind.hashCode());
		result = prime * result + ((mvemes == null) ? 0 : mvemes.hashCode());
		result = prime * result + ((mvereg == null) ? 0 : mvereg.hashCode());
		result = prime * result + ((mverid == null) ? 0 : mverid.hashCode());
		result = prime * result + ((mvevac == null) ? 0 : mvevac.hashCode());
		result = prime * result + ((mveval == null) ? 0 : mveval.hashCode());
		result = prime * result + ((mvevap == null) ? 0 : mvevap.hashCode());
		result = prime * result + ((mvevpe == null) ? 0 : mvevpe.hashCode());
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
		Finance other = (Finance) obj;
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
		if (mvecin == null) {
			if (other.mvecin != null)
				return false;
		} else if (!mvecin.equals(other.mvecin))
			return false;
		if (mvedes == null) {
			if (other.mvedes != null)
				return false;
		} else if (!mvedes.equals(other.mvedes))
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
		if (mvereg == null) {
			if (other.mvereg != null)
				return false;
		} else if (!mvereg.equals(other.mvereg))
			return false;
		if (mverid == null) {
			if (other.mverid != null)
				return false;
		} else if (!mverid.equals(other.mverid))
			return false;
		if (mvevac == null) {
			if (other.mvevac != null)
				return false;
		} else if (!mvevac.equals(other.mvevac))
			return false;
		if (mveval == null) {
			if (other.mveval != null)
				return false;
		} else if (!mveval.equals(other.mveval))
			return false;
		if (mvevap == null) {
			if (other.mvevap != null)
				return false;
		} else if (!mvevap.equals(other.mvevap))
			return false;
		if (mvevpe == null) {
			if (other.mvevpe != null)
				return false;
		} else if (!mvevpe.equals(other.mvevpe))
			return false;
		return true;
	}
	
	public Finance(String mveano, String mvemes) {
		this.mveano = mveano;
		this.mvemes = mvemes;
		this.mveval = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		this.mvevac = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);;
		this.mvevap = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);;
		this.mvevpe = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);;
	}
	
	public Finance(String mveano, String mvemes, BigDecimal mveval, BigDecimal mvevac, BigDecimal mvevap,
			BigDecimal mvevpe) {
		super();
		this.mveano = mveano;
		this.mvemes = mvemes;
		this.mveval = mveval;
		this.mvevac = mvevac;
		this.mvevap = mvevap;
		this.mvevpe = mvevpe;
	}

}
