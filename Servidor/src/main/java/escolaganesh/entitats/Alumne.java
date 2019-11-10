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
@Table(name = "alumnes")
public class Alumne {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String cid;
    @Column
    private String dni;
    @Column
    private String direccio;
    @Column
    private String poblacio;
    @Column
    private String telefon;
    @Column
    private String dadesBancaries;
    @Column
    private Boolean jjk;
    @Column
    private Boolean totsival;
    @Column
    private Boolean tkd;
    @Column
    private Boolean jjkInfantil;
    @Column
    private Boolean jjkIniciacio;
    @Column
    private Boolean ioga;
    @Column
    private Double cuota;
    @Column
    private String observacions;
    @Column
    private String lastUpdate;
    @Column
    private Boolean actiu;

    @OneToMany(mappedBy = "alumne")
    private List<Llicencia> llicencies = new ArrayList<>();

    @OneToMany(mappedBy = "alumne")
    private List<Mensualitat> mensualitats = new ArrayList<>();

    @OneToMany(mappedBy = "alumne")
    private List<LiniaRebut> liniesRebut = new ArrayList<>();

    @OneToMany(mappedBy = "alumne")
    private List<Comanda> comandes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getDadesBancaries() {
        return dadesBancaries;
    }

    public void setDadesBancaries(String dadesBancaries) {
        this.dadesBancaries = dadesBancaries;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    public String getObservacions() {
        return observacions;
    }

    public void setObservacions(String observacions) {
        this.observacions = observacions;
    }

    public Boolean isJjk() {
        return jjk;
    }

    public void setJjk(Boolean jjk) {
        this.jjk = jjk;
    }

    public Boolean isTotsival() {
        return totsival;
    }

    public void setTotsival(Boolean totsival) {
        this.totsival = totsival;
    }

    public Boolean isTkd() {
        return tkd;
    }

    public void setTkd(Boolean tkd) {
        this.tkd = tkd;
    }

    public Boolean isJjkInfantil() {
        return jjkInfantil;
    }

    public void setJjkInfantil(Boolean jjkInfantil) {
        this.jjkInfantil = jjkInfantil;
    }

    public Boolean isJjkIniciacio() {
        return jjkIniciacio;
    }

    public void setJjkIniciacio(Boolean jjkIniciacio) {
        this.jjkIniciacio = jjkIniciacio;
    }

    public Boolean isIoga() {
        return ioga;
    }

    public void setIoga(Boolean ioga) {
        this.ioga = ioga;
    }

    public Boolean isActiu() {
        return actiu;
    }

    public void setActiu(Boolean actiu) {
        this.actiu = actiu;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Llicencia> getLlicencies() {
        return llicencies;
    }

    public void setLlicencies(List<Llicencia> llicencies) {
        this.llicencies = llicencies;
    }

    public List<Mensualitat> getMensualitats() {
        return mensualitats;
    }

    public void setMensualitats(List<Mensualitat> mensualitats) {
        this.mensualitats = mensualitats;
    }

    public List<LiniaRebut> getLiniesRebut() {
        return liniesRebut;
    }

    public void setLiniesRebut(List<LiniaRebut> liniesRebut) {
        this.liniesRebut = liniesRebut;
    }

    public List<Comanda> getComandes() {
        return comandes;
    }

    public void setComandes(List<Comanda> comandes) {
        this.comandes = comandes;
    }

}
