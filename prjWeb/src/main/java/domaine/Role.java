package domaine;
// Generated 29 janv. 2016 14:52:40 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "prj")
public class Role implements java.io.Serializable {

	private Integer idRole;
	private Compte compte;
	private String role;

	public Role() {
	}

	public Role(Compte compte, String role) {
		this.compte = compte;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idRole", unique = true, nullable = false)
	public Integer getIdRole() {
		return this.idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "login", nullable = false)
	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Column(name = "role", nullable = false, length = 50)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}