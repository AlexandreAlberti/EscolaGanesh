package escolaganesh.entitats;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rebut")
public class Rebut {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String year;

    @Column
    private String mes;

    @Column
    private Boolean validat;

    @Column
    private Date creationDate;

    @Column
    private Double total;

    @OneToMany(mappedBy = "rebut")
    private List<LiniaRebut> liniesRebut;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getYear() {
	return year;
    }

    public void setYear(String year) {
	this.year = year;
    }

    public String getMes() {
	return mes;
    }

    public void setMes(String mes) {
	this.mes = mes;
    }

    public Boolean getValidat() {
	return validat;
    }

    public void setValidat(Boolean validat) {
	this.validat = validat;
    }

    public List<LiniaRebut> getLiniesRebut() {
	return liniesRebut;
    }

    public void setLiniesRebut(List<LiniaRebut> liniesRebut) {
	this.liniesRebut = liniesRebut;
    }

    public Date getCreationDate() {
	return creationDate;
    }

    public void setCreationDate(Date date) {
	this.creationDate = date;
    }

    public Double getTotal() {
	return total;
    }

    public void setTotal(Double total) {
	this.total = total;
    }

}
