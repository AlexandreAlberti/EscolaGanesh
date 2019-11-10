package escolaganesh.entitats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materials")
public class Material {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String descripcio;
    @Column
    private Integer tipus;
    @Column
    private Double cost;
    @Column
    private String observacions;
    @Column
    private Boolean comprable;
    @Column
    private Integer stock;
    @Column
    private Integer stockMinim;

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

    public String getObservacions() {
        return observacions;
    }

    public void setObservacions(String observacions) {
        this.observacions = observacions;
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

    public Integer getStockMinim() {
        return stockMinim;
    }

    public void setStockMinim(Integer stockMinim) {
        this.stockMinim = stockMinim;
    }

}
