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
@Table(name = "comandes")
public class Comanda {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Integer idLiniaDetall;
    @Column
    private Boolean pagat;
    @Column
    private Boolean entregat;
    @Column
    private Double preuFinal;
    @Column
    private String concepteAdicional;
    @Column
    private Integer quantitat;
    @JoinColumn
    @ManyToOne
    private Alumne alumne;
    @JoinColumn
    @ManyToOne
    private Material material;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdLiniaDetall() {
        return idLiniaDetall;
    }

    public void setIdLiniaDetall(Integer idLiniaDetall) {
        this.idLiniaDetall = idLiniaDetall;
    }

    public Boolean getPagat() {
        return pagat;
    }

    public void setPagat(Boolean pagat) {
        this.pagat = pagat;
    }

    public Boolean getEntregat() {
        return entregat;
    }

    public void setEntregat(Boolean entregat) {
        this.entregat = entregat;
    }

    public Double getPreuFinal() {
        return preuFinal;
    }

    public void setPreuFinal(Double preuFinal) {
        this.preuFinal = preuFinal;
    }

    public String getConcepteAdicional() {
        return concepteAdicional;
    }

    public void setConcepteAdicional(String concepteAdicional) {
        this.concepteAdicional = concepteAdicional;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getQuantitat() {
        return quantitat != null ? quantitat : 0;
    }

    public void setQuantitat(Integer quantitat) {
        this.quantitat = quantitat;
    }
}
