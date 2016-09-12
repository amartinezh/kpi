package domain.kpi;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(DistriPK.class)
@Table(name = "inddis", schema = "dis")
public class Distri {
	
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
	
	@Column(name = "mvecli")
	private String mvecli; // Cliente
	
	@Column(name = "mvecln")
	private String mvecln; // Nombre Cliente
	
	@Column(name = "mvetic")
	private String mvetic; // Tipo Cliente
	
	@Column(name = "mvetin")
	private String mvetin; // Nombre Tipo
	
	@Column(name = "mveloc")
	private String mveloc; // Bodega/Localidad
	
	@Column(name = "mvelon")
	private String mvelon; // Nombre Bodega/Localidad
	
	@Column(name = "mvecr1")
	private String mvecr1; // Area Cliente   Ref1
	
	@Column(name = "mvecn1")
	private String mvecn1; // Nombre Area
	
	@Id
	@Column(name = "mvecr2")
	private String mvecr2; // Zona Cliente   Ref2
	
	@Column(name = "mvecn2")
	private String mvecn2; // Nombre Zona
	
	@Column(name = "mvecr3")
	private String mvecr3; // Region Cliente Ref3
	
	@Column(name = "mvecn3")
	private String mvecn3; // Nombre Region
	
	@Column(name = "mvecr4")
	private String mvecr4; // Local Cliente  Ref4
	
	@Column(name = "mvecn4")
	private String mvecn4; // Nombre Local
	
	@Column(name = "mvecr5")
	private String mvecr5; // Distrito Clien Ref5
	
	@Column(name = "mvecn5")
	private String mvecn5; // Nombre Distrito
	
	@Column(name = "mvesal")
	private String mvesal; // Vendedor
	
	@Column(name = "mvesan")
	private String mvesan; // Nombre Vendedor
	
	@Column(name = "mvepro")
	private String mvepro; // Codigo Producto
	
	@Column(name = "mveprn")
	private String mveprn; // Nombre Producto
	
	@Column(name = "mvecal")
	private String mvecal; // Clase Articulo
	
	@Column(name = "mvecan")
	private String mvecan; // Nombre Clase Articulo
	
	@Column(name = "mvesr1")
	private String mvesr1; // Tipo Articulo  Ref1
	
	@Column(name = "mvesn1")
	private String mvesn1; // Nombre Tipo
	
	@Column(name = "mvesr2")
	private String mvesr2; // Grupo Articulo Ref2
	
	@Column(name = "mvesn2")
	private String mvesn2; // Nombre Grupo
	
	@Column(name = "mvesr3")
	private String mvesr3; // Linea Articulo Ref3
	
	@Column(name = "mvesn3")
	private String mvesn3; // Nombre Linea
	
	@Column(name = "mvesr4")
	private String mvesr4; // Cate Articulo  Ref4
	
	@Column(name = "mvesn4")
	private String mvesn4; // Nombre Categoria 
	
	@Column(name = "mvesr5")
	private String mvesr5; // Marca Articulo Ref5
	
	@Column(name = "mvesn5")
	private String mvesn5; // Nombre Marca
	
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

	public Distri(){
		
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

	public String getMvecli() {
		return mvecli;
	}

	public void setMvecli(String mvecli) {
		this.mvecli = mvecli;
	}

	public String getMvecln() {
		return mvecln;
	}

	public void setMvecln(String mvecln) {
		this.mvecln = mvecln;
	}

	public String getMvetic() {
		return mvetic;
	}

	public void setMvetic(String mvetic) {
		this.mvetic = mvetic;
	}

	public String getMvetin() {
		return mvetin;
	}

	public void setMvetin(String mvetin) {
		this.mvetin = mvetin;
	}

	public String getMveloc() {
		return mveloc;
	}

	public void setMveloc(String mveloc) {
		this.mveloc = mveloc;
	}

	public String getMvelon() {
		return mvelon;
	}

	public void setMvelon(String mvelon) {
		this.mvelon = mvelon;
	}

	public String getMvecr1() {
		return mvecr1;
	}

	public void setMvecr1(String mvecr1) {
		this.mvecr1 = mvecr1;
	}

	public String getMvecn1() {
		return mvecn1;
	}

	public void setMvecn1(String mvecn1) {
		this.mvecn1 = mvecn1;
	}

	public String getMvecr2() {
		return mvecr2;
	}

	public void setMvecr2(String mvecr2) {
		this.mvecr2 = mvecr2;
	}

	public String getMvecn2() {
		return mvecn2;
	}

	public void setMvecn2(String mvecn2) {
		this.mvecn2 = mvecn2;
	}

	public String getMvecr3() {
		return mvecr3;
	}

	public void setMvecr3(String mvecr3) {
		this.mvecr3 = mvecr3;
	}

	public String getMvecn3() {
		return mvecn3;
	}

	public void setMvecn3(String mvecn3) {
		this.mvecn3 = mvecn3;
	}

	public String getMvecr4() {
		return mvecr4;
	}

	public void setMvecr4(String mvecr4) {
		this.mvecr4 = mvecr4;
	}

	public String getMvecn4() {
		return mvecn4;
	}

	public void setMvecn4(String mvecn4) {
		this.mvecn4 = mvecn4;
	}

	public String getMvecr5() {
		return mvecr5;
	}

	public void setMvecr5(String mvecr5) {
		this.mvecr5 = mvecr5;
	}

	public String getMvecn5() {
		return mvecn5;
	}

	public void setMvecn5(String mvecn5) {
		this.mvecn5 = mvecn5;
	}

	public String getMvesal() {
		return mvesal;
	}

	public void setMvesal(String mvesal) {
		this.mvesal = mvesal;
	}

	public String getMvesan() {
		return mvesan;
	}

	public void setMvesan(String mvesan) {
		this.mvesan = mvesan;
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

	public String getMvesr1() {
		return mvesr1;
	}

	public void setMvesr1(String mvesr1) {
		this.mvesr1 = mvesr1;
	}

	public String getMvesn1() {
		return mvesn1;
	}

	public void setMvesn1(String mvesn1) {
		this.mvesn1 = mvesn1;
	}

	public String getMvesr2() {
		return mvesr2;
	}

	public void setMvesr2(String mvesr2) {
		this.mvesr2 = mvesr2;
	}

	public String getMvesn2() {
		return mvesn2;
	}

	public void setMvesn2(String mvesn2) {
		this.mvesn2 = mvesn2;
	}

	public String getMvesr3() {
		return mvesr3;
	}

	public void setMvesr3(String mvesr3) {
		this.mvesr3 = mvesr3;
	}

	public String getMvesn3() {
		return mvesn3;
	}

	public void setMvesn3(String mvesn3) {
		this.mvesn3 = mvesn3;
	}

	public String getMvesr4() {
		return mvesr4;
	}

	public void setMvesr4(String mvesr4) {
		this.mvesr4 = mvesr4;
	}

	public String getMvesn4() {
		return mvesn4;
	}

	public void setMvesn4(String mvesn4) {
		this.mvesn4 = mvesn4;
	}

	public String getMvesr5() {
		return mvesr5;
	}

	public void setMvesr5(String mvesr5) {
		this.mvesr5 = mvesr5;
	}

	public String getMvesn5() {
		return mvesn5;
	}

	public void setMvesn5(String mvesn5) {
		this.mvesn5 = mvesn5;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Kpi [mveano=" + mveano + ", mvemes=" + mvemes + ", mvereg=" + mvereg + ", mvecia=" + mvecia
				+ ", mvecin=" + mvecin + ", mveind=" + mveind + ", mvedes=" + mvedes + ", mvecli=" + mvecli
				+ ", mvecln=" + mvecln + ", mvetic=" + mvetic + ", mvetin=" + mvetin + ", mveloc=" + mveloc
				+ ", mvelon=" + mvelon + ", mvecr1=" + mvecr1 + ", mvecn1=" + mvecn1 + ", mvecr2=" + mvecr2
				+ ", mvecn2=" + mvecn2 + ", mvecr3=" + mvecr3 + ", mvecn3=" + mvecn3 + ", mvecr4=" + mvecr4
				+ ", mvecn4=" + mvecn4 + ", mvecr5=" + mvecr5 + ", mvecn5=" + mvecn5 + ", mvesal=" + mvesal
				+ ", mvesan=" + mvesan + ", mvepro=" + mvepro + ", mveprn=" + mveprn + ", mvecal=" + mvecal
				+ ", mvecan=" + mvecan + ", mvesr1=" + mvesr1 + ", mvesn1=" + mvesn1 + ", mvesr2=" + mvesr2
				+ ", mvesn2=" + mvesn2 + ", mvesr3=" + mvesr3 + ", mvesn3=" + mvesn3 + ", mvesr4=" + mvesr4
				+ ", mvesn4=" + mvesn4 + ", mvesr5=" + mvesr5 + ", mvesn5=" + mvesn5 + ", mveval=" + mveval
				+ ", mvevac=" + mvevac + ", mverid=" + mverid + ", mvevap=" + mvevap + ", mvevpe=" + mvevpe + "]";
	}

	public Distri(String mveano, String mvemes) {
		this.mveano = mveano;
		this.mvemes = mvemes;
		this.mveval = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);
		this.mvevac = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);;
		this.mvevap = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);;
		this.mvevpe = new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN);;
	}
	
	public Distri(String mveano, String mvemes, BigDecimal mveval, BigDecimal mvevac, BigDecimal mvevap,
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
