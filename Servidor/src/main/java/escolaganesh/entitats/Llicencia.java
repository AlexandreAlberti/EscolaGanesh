package escolaganesh.entitats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "llicencies")
public class Llicencia {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private Integer any;
	
	@JoinColumn
	@ManyToOne
	private Alumne alumne;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getAny() {
		return any;
	}

	public void setAny(Integer any) {
		this.any = any;
	}

	public Alumne getAlumne() {
		return alumne;
	}

	public void setAlumne(Alumne alumne) {
		this.alumne = alumne;
	}


}
