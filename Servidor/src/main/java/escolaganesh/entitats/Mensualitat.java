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
@Table(name = "mensualitat")
public class Mensualitat {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private Integer any;

	@Column
	private Integer mes;
	@Column
	private Double quantitat;
	@Column
	private Boolean pagat;

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

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Double getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(Double quantitat) {
		this.quantitat = quantitat;
	}

	public Boolean getPagat() {
		return pagat;
	}

	public void setPagat(Boolean pagat) {
		this.pagat = pagat;
	}


}
