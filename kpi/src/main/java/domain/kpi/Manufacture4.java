package domain.kpi;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(Manufacture1PK.class)
@Table(name = "indman4", schema = "man")
public class Manufacture4 {
	
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
	
	@Id
	@Column(name = "mvepce")
	private String mvepce; // Proceso
	
	@Column(name = "mvecln")
	private String mvecln; // Nombre Proceso
	
	@Id
	@Column(name = "mveind")
	private String mveind; // ID. Indicador
	
	@Column(name = "mvedes")
	private String mvedes; // Descripcion Indicador
	
	@Id
	@Column(name = "mvecen")
	private String mvecen; // Codigo Centro
	
	@Column(name = "mveced")
	private String mveced; // Nombre Centro Productivo
	
	@Id
	@Column(name = "mvepro")
	private String mvepro; // Código Producto
	
	@Column(name = "mveprn")
	private String mveprn; // Nombre Producto
	
	@Id
	@Column(name = "mvecal")
	private String mvecal; // Clase Artículo
	
	@Column(name = "mvecan")
	private String mvecan; // Nombre Clase Artículo
	
	@Id
	@Column(name = "mvetur")
	private String mvetur; // Turno
	
	@Column(name = "mvetud")
	private String mvetud; // Nombre Turno
	
	@Column(name = "mveval")
	private BigDecimal mveval; // Valor Indicador USD
	
	@Column(name = "mvevac")
	private BigDecimal mvevac; // Valor Indicador LOCAL
	
	@Column(name = "mverid")
	private String mverid; // Indicador Visualizar
	
	@Column(name = "mvevap")
	private BigDecimal mvevap; // Valor Indicador USD PROMEDIO
	
	@Column(name = "mvevpe")
	private BigDecimal mvevpe; // Valor Indicador PRESUPUESTO

	public Manufacture4(){
		
	}

	public String getMveano() {
		return mveano;
	}



	public void setMveano(String mveano) {
		this.mveano = mveano;
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



	public String getMvepce() {
		return mvepce;
	}



	public void setMvepce(String mvepce) {
		this.mvepce = mvepce;
	}



	public String getMvecln() {
		return mvecln;
	}



	public void setMvecln(String mvecln) {
		this.mvecln = mvecln;
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



	public String getMvecen() {
		return mvecen;
	}



	public void setMvecen(String mvecen) {
		this.mvecen = mvecen;
	}



	public String getMveced() {
		return mveced;
	}



	public void setMveced(String mveced) {
		this.mveced = mveced;
	}



	public String getMvepro() {
		return mvepro;
	}



	public void setMvepro(String mvepro) {
		this.mvepro = mvepro;
	}



	public String getMveprn() {
		return mveprn;
	}



	public void setMveprn(String mveprn) {
		this.mveprn = mveprn;
	}



	public String getMvecal() {
		return mvecal;
	}



	public void setMvecal(String mvecal) {
		this.mvecal = mvecal;
	}



	public String getMvecan() {
		return mvecan;
	}



	public void setMvecan(String mvecan) {
		this.mvecan = mvecan;
	}



	public String getMvetur() {
		return mvetur;
	}



	public void setMvetur(String mvetur) {
		this.mvetur = mvetur;
	}



	public String getMvetud() {
		return mvetud;
	}



	public void setMvetud(String mvetud) {
		this.mvetud = mvetud;
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



	public String getMverid() {
		return mverid;
	}



	public void setMverid(String mverid) {
		this.mverid = mverid;
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

	

	@Override
	public String toString() {
		return "Manufacture [mveano=" + mveano + ", mvemes=" + mvemes + ", mvereg=" + mvereg + ", mvecia=" + mvecia
				+ ", mvecin=" + mvecin + ", mvepce=" + mvepce + ", mvecln=" + mvecln + ", mveind=" + mveind
				+ ", mvedes=" + mvedes + ", mvecen=" + mvecen + ", mveced=" + mveced + ", mvepro=" + mvepro
				+ ", mveprn=" + mveprn + ", mvecal=" + mvecal + ", mvecan=" + mvecan + ", mvetur=" + mvetur
				+ ", mvetud=" + mvetud + ", mveval=" + mveval + ", mvevac=" + mvevac + ", mverid=" + mverid
				+ ", mvevap=" + mvevap + ", mvevpe=" + mvevpe + "]";
	}

	public Manufacture4(String mveano, String mvemes) {
		this.mveano = mveano;
		this.mvemes = mvemes;
		this.mveval = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		this.mvevac = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);;
		this.mvevap = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);;
		this.mvevpe = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);;
	}
	
	public Manufacture4(String mveano, String mvemes, BigDecimal mveval, BigDecimal mvevac, BigDecimal mvevap,
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
