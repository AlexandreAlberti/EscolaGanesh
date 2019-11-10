package escolaganesh.entitats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "material")
    private List<Comanda> comandes = new ArrayList<>();

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
        return stock != null ? stock : 0;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStockMinim() {
        return stockMinim != null ? stockMinim : 0;
    }

    public void setStockMinim(Integer stockMinim) {
        this.stockMinim = stockMinim;
    }

    public List<Comanda> getComandes() {
        return comandes;
    }

    public void setComandes(List<Comanda> comandes) {
        this.comandes = comandes;
    }
}
