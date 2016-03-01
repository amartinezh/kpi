package domain.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import domain.kpi.Kpi;;;

@SuppressWarnings("serial")
public class session implements Serializable{

	private String usuario;
	private int tipoUsuario;		
	private Map<String, String> cpias;
	private Map<String, String> levels;
	private Map<String, String>	centers;
	private Map<String, String> currencys;
	private String moneda;
	private String indicador;
	private String interfaz;
	private String dash_region;
	private String dash_nia;
	private String dash_moneda;
	private String dash_tasa;
	private String campo_llave; // para filtrar
	private String campo_descripcion; // para filtrar
	private String valor; // del filtro para el drill
	private String indicador_drill; // del filtro para el drill
	private String anio;
	private String mes;
	
	public session(){
		java.util.Calendar c = java.util.Calendar.getInstance();
		setAnio(Integer.toString(c.get(java.util.Calendar.YEAR)));
	}
	
	public session(String moneda, String dash_region, String dash_nia, String dash_moneda, String dash_tasa) {
		super();
		this.moneda = moneda;
		this.dash_region = dash_region;
		this.dash_nia = dash_nia;
		this.dash_moneda = dash_moneda;
		this.dash_tasa = dash_tasa;
		java.util.Calendar c = java.util.Calendar.getInstance();
		setAnio(Integer.toString(c.get(java.util.Calendar.YEAR)));
		setMes(Integer.toString(c.get(java.util.Calendar.MONTH)));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anio == null) ? 0 : anio.hashCode());
		result = prime * result + ((campo_descripcion == null) ? 0 : campo_descripcion.hashCode());
		result = prime * result + ((campo_llave == null) ? 0 : campo_llave.hashCode());
		result = prime * result + ((centers == null) ? 0 : centers.hashCode());
		result = prime * result + ((cpias == null) ? 0 : cpias.hashCode());
		result = prime * result + ((currencys == null) ? 0 : currencys.hashCode());
		result = prime * result + ((dash_moneda == null) ? 0 : dash_moneda.hashCode());
		result = prime * result + ((dash_nia == null) ? 0 : dash_nia.hashCode());
		result = prime * result + ((dash_region == null) ? 0 : dash_region.hashCode());
		result = prime * result + ((dash_tasa == null) ? 0 : dash_tasa.hashCode());
		result = prime * result + ((indicador == null) ? 0 : indicador.hashCode());
		result = prime * result + ((indicador_drill == null) ? 0 : indicador_drill.hashCode());
		result = prime * result + ((interfaz == null) ? 0 : interfaz.hashCode());
		result = prime * result + ((levels == null) ? 0 : levels.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
		result = prime * result + ((moneda == null) ? 0 : moneda.hashCode());
		result = prime * result + tipoUsuario;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		session other = (session) obj;
		if (anio == null) {
			if (other.anio != null)
				return false;
		} else if (!anio.equals(other.anio))
			return false;
		if (campo_descripcion == null) {
			if (other.campo_descripcion != null)
				return false;
		} else if (!campo_descripcion.equals(other.campo_descripcion))
			return false;
		if (campo_llave == null) {
			if (other.campo_llave != null)
				return false;
		} else if (!campo_llave.equals(other.campo_llave))
			return false;
		if (centers == null) {
			if (other.centers != null)
				return false;
		} else if (!centers.equals(other.centers))
			return false;
		if (cpias == null) {
			if (other.cpias != null)
				return false;
		} else if (!cpias.equals(other.cpias))
			return false;
		if (currencys == null) {
			if (other.currencys != null)
				return false;
		} else if (!currencys.equals(other.currencys))
			return false;
		if (dash_moneda == null) {
			if (other.dash_moneda != null)
				return false;
		} else if (!dash_moneda.equals(other.dash_moneda))
			return false;
		if (dash_nia == null) {
			if (other.dash_nia != null)
				return false;
		} else if (!dash_nia.equals(other.dash_nia))
			return false;
		if (dash_region == null) {
			if (other.dash_region != null)
				return false;
		} else if (!dash_region.equals(other.dash_region))
			return false;
		if (dash_tasa == null) {
			if (other.dash_tasa != null)
				return false;
		} else if (!dash_tasa.equals(other.dash_tasa))
			return false;
		if (indicador == null) {
			if (other.indicador != null)
				return false;
		} else if (!indicador.equals(other.indicador))
			return false;
		if (indicador_drill == null) {
			if (other.indicador_drill != null)
				return false;
		} else if (!indicador_drill.equals(other.indicador_drill))
			return false;
		if (interfaz == null) {
			if (other.interfaz != null)
				return false;
		} else if (!interfaz.equals(other.interfaz))
			return false;
		if (levels == null) {
			if (other.levels != null)
				return false;
		} else if (!levels.equals(other.levels))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		if (moneda == null) {
			if (other.moneda != null)
				return false;
		} else if (!moneda.equals(other.moneda))
			return false;
		if (tipoUsuario != other.tipoUsuario)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Map<String, String> getCpias() {
		return cpias;
	}

	public void setCpias(Map<String, String> cpias) {
		this.cpias = cpias;
	}

	public Map<String, String> getLevels() {
		return levels;
	}

	public void setLevels(Map<String, String> levels) {
		this.levels = levels;
	}

	public Map<String, String> getCenters() {
		return centers;
	}

	public void setCenters(Map<String, String> centers) {
		this.centers = centers;
	}

	public Map<String, String> getCurrencys() {
		return currencys;
	}

	public void setCurrencys(Map<String, String> currencys) {
		this.currencys = currencys;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getIndicador() {
		return indicador;
	}

	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}

	public String getInterfaz() {
		return interfaz;
	}

	public void setInterfaz(String interfaz) {
		this.interfaz = interfaz;
	}

	public String getDash_region() {
		return dash_region;
	}

	public void setDash_region(String dash_region) {
		this.dash_region = dash_region;
	}

	public String getDash_nia() {
		return dash_nia;
	}

	public void setDash_nia(String dash_nia) {
		this.dash_nia = dash_nia;
	}

	public String getDash_moneda() {
		return dash_moneda;
	}

	public void setDash_moneda(String dash_moneda) {
		this.dash_moneda = dash_moneda;
	}

	public String getDash_tasa() {
		return dash_tasa;
	}

	public void setDash_tasa(String dash_tasa) {
		this.dash_tasa = dash_tasa;
	}

	public String getCampo_llave() {
		return campo_llave;
	}

	public void setCampo_llave(String campo_llave) {
		this.campo_llave = campo_llave;
	}

	public String getCampo_descripcion() {
		return campo_descripcion;
	}

	public void setCampo_descripcion(String campo_descripcion) {
		this.campo_descripcion = campo_descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getIndicador_drill() {
		return indicador_drill;
	}

	public void setIndicador_drill(String indicador_drill) {
		this.indicador_drill = indicador_drill;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
	
	
}
