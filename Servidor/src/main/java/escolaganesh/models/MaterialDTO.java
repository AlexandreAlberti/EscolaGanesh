package escolaganesh.models;

public class MaterialDTO {

	private Integer id;
	private String descripcio;
	private String observacions;
	private Integer tipus;
	private Double cost;
	private Boolean comprable;
	private Integer stock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public String getObservacions() {
		return observacions;
	}

	public void setObservacions(String observacions) {
		this.observacions = observacions;
	}

	public Integer getTipus() {
		return tipus;
	}

	public void setTipus(Integer tipus) {
		this.tipus = tipus;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Boolean isComprable() {
		return comprable;
	}

	public void setComprable(Boolean comprable) {
		this.comprable = comprable;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
