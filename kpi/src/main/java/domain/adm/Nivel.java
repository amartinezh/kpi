package domain.adm;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import domain.login.User;

@Entity
@Table(name="nivel_organico", schema="gestion")
public class Nivel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	//@NotEmpty
	@Column(name="nivel_organico_id")
	private int id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="area_estrategica")
	private String area_estrategica;
	
	@OneToMany(mappedBy="nivel")
	private Set<User> users;
	
	public Nivel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nivel(int id) {
		super();
		this.id = id;
	}

	public Nivel(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Nivel(int id, String descripcion, String area_estrategica,
			Set<User> users) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.area_estrategica = area_estrategica;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getArea_estrategica() {
		return area_estrategica;
	}

	public void setArea_estrategica(String area_estrategica) {
		this.area_estrategica = area_estrategica;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((area_estrategica == null) ? 0 : area_estrategica.hashCode());
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + id;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Nivel other = (Nivel) obj;
		if (area_estrategica == null) {
			if (other.area_estrategica != null)
				return false;
		} else if (!area_estrategica.equals(other.area_estrategica))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	
	
}
