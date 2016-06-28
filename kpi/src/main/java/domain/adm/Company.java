package domain.adm;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import domain.login.User;

@Entity
@Table(name="company", schema="gestion")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "comp_id")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="admin.company_comp_id_seq")
	//@SequenceGenerator(name="admin.company_comp_id_seq", sequenceName="admin.company_comp_id_seq", allocationSize=1)
    private String id;
	
	@NotEmpty(message = "Por favor ingrese la descripción")
	@Column(name = "comp_desc")
	private String descripcion;
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", descripcion=" + descripcion + "]";
	}

	@OneToMany(mappedBy="comp")
	private Set<User> users;
	
	@ManyToOne @JoinColumn(name="region_id")
	private Region region_id;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}
	
	public Company(String id) {
		super();
		this.id = id;
	}

	public Company(String id, String descripcion, Region region_id) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.region_id = region_id;
	}



	public String getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Region getRegion_id() {
		return region_id;
	}

	public void setRegion_id(Region region_id) {
		this.region_id = region_id;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
}
