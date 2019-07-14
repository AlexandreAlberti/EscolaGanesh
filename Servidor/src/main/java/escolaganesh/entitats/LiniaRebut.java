package escolaganesh.entitats;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "liniaRebut")
public class LiniaRebut {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn
    @ManyToOne
    private Alumne alumne;

    @JoinColumn
    @ManyToOne
    private Rebut rebut;

    @Column
    private Double total;

    @OneToMany(mappedBy = "liniaRebut")
    private List<LiniaDetallRebut> detalls;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Alumne getAlumne() {
	return alumne;
    }

    public void setAlumne(Alumne alumne) {
	this.alumne = alumne;
    }

    public Rebut getRebut() {
	return rebut;
    }

    public void setRebut(Rebut rebut) {
	this.rebut = rebut;
    }

    public List<LiniaDetallRebut> getDetalls() {
	return detalls;
    }

    public void setDetalls(List<LiniaDetallRebut> detalls) {
	this.detalls = detalls;
    }

    public Double getTotal() {
	return total;
    }

    public void setTotal(Double total) {
	this.total = total;
    }

}
