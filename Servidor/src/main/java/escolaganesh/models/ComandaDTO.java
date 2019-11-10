package escolaganesh.models;

public class ComandaDTO {

    private int id;
    private int idAlumne;
    private int idMaterial;
    private int idLiniaDetall;
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

    public int getIdLiniaDetall() {
        return idLiniaDetall;
    }

    public void setIdLiniaDetall(int idLiniaDetall) {
        this.idLiniaDetall = idLiniaDetall;
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
