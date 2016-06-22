package domain.adm;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="region", schema="gestion")

public class Region implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "region_id")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gestion.region_region_id_seq")
	//@SequenceGenerator(name="gestion.region_region_id_seq", sequenceName="gestion.region_region_id_seq", allocationSize=1)
    private String region_id;
	
	String descripcion;
	
	@OneToMany(mappedBy="region_id")
	private Set<Company> comp;
	
	public Region() {
	}
	
	public Region(String region_id) {
		super();
		this.region_id = region_id;
		this.descripcion = "";
	}
	
	public Region(String region_id, String descripcion) {
		super();
		this.region_id = region_id;
		this.descripcion = descripcion;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Set<Company> getComp() {
		return comp;
	}

	public void setComp(Set<Company> comp) {
		this.comp = comp;
	}

	@Override
	public String toString() {
		return "Region [region_id=" + region_id + ", descripcion=" + descripcion + ", comp=" + comp + "]";
	}
}
