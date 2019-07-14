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
@Table(name = "liniaDetallRebut")
public class LiniaDetallRebut {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn
	@ManyToOne
	private LiniaRebut liniaRebut;

	// TODO: ENUM a futur per si cal distingir entre comanda/mensualitat
	@Column
	private Integer tipus;

	// TODO: Id que identifica el tipus de contingut, si escau. Comanda de material.
	@Column
	private Integer idTipus;

	@Column
	private String descripcio;

	@Column
	private Double quantitat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LiniaRebut getLiniaRebut() {
		return liniaRebut;
	}

	public void setLiniaRebut(LiniaRebut liniaRebut) {
		this.liniaRebut = liniaRebut;
	}

	public Integer getTipus() {
		return tipus;
	}

	public void setTipus(Integer tipus) {
		this.tipus = tipus;
	}

	public Integer getIdTipus() {
		return idTipus;
	}

	public void setIdTipus(Integer idTipus) {
		this.idTipus = idTipus;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public Double getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(Double quantitat) {
		this.quantitat = quantitat;
	}


}
