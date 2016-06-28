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
@Table(name="currency", schema="gestion")
public class Currency implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	//@NotEmpty
	@Column(name="currency_id")
	private int id;
	
	@Column(name="currency_desc")
	private String descripcion;
	
	@OneToMany(mappedBy="curr")
	private Set<User> users;
	
	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Currency(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public Currency(int id) {
		super();
		this.id = id;
		this.descripcion = "";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", descripcion=" + descripcion
				+ ", users=" + users + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Currency other = (Currency) obj;
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
