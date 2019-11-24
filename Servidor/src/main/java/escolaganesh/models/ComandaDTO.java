package escolaganesh.models;

public class ComandaDTO {

    private int id;
    private int idAlumne;
    private String nomAlumne;
    private int idMaterial;
    private String descMaterial;
    private int idLiniaDetall;
    private int quantitat;
    private double preuFinal;
    private boolean pagat;
    private boolean entregat;
    private String concepteAdicional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlumne() {
        return idAlumne;
    }

    public void setIdAlumne(int idAlumne) {
        this.idAlumne = idAlumne;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNomAlumne() {
        return nomAlumne;
    }

    public void setNomAlumne(String nomAlumne) {
        this.nomAlumne = nomAlumne;
    }

    public String getDescMaterial() {
        return descMaterial;
    }

    public void setDescMaterial(String descMaterial) {
        this.descMaterial = descMaterial;
    }

    public int getIdLiniaDetall() {
        return idLiniaDetall;
    }

    public void setIdLiniaDetall(int idLiniaDetall) {
        this.idLiniaDetall = idLiniaDetall;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public double getPreuFinal() {
        return preuFinal;
    }

    public void setPreuFinal(double preuFinal) {
        this.preuFinal = preuFinal;
    }

    public boolean isPagat() {
        return pagat;
    }

    public void setPagat(boolean pagat) {
        this.pagat = pagat;
    }

    public boolean isEntregat() {
        return entregat;
    }

    public void setEntregat(boolean entregat) {
        this.entregat = entregat;
    }

    public String getConcepteAdicional() {
        return concepteAdicional;
    }

    public void setConcepteAdicional(String concepteAdicional) {
        this.concepteAdicional = concepteAdicional;
    }
}
