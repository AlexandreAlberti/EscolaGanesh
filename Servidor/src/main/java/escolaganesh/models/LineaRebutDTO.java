package escolaganesh.models;

public class LineaRebutDTO {

    private int id;
    private int alumneId;
    private String alumneNom;
    private int rebutId;
    private Double total;
    private boolean retornat;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getAlumneId() {
	return alumneId;
    }

    public void setAlumneId(int alumneId) {
	this.alumneId = alumneId;
    }

    public String getAlumneNom() {
	return alumneNom;
    }

    public void setAlumneNom(String alumneNom) {
	this.alumneNom = alumneNom;
    }

    public int getRebutId() {
	return rebutId;
    }

    public void setRebutId(int rebutId) {
	this.rebutId = rebutId;
    }

    public Double getTotal() {
	return total;
    }

    public void setTotal(Double total) {
	this.total = total;
    }

    public boolean isRetornat() {
	return retornat;
    }

    public void setRetornat(boolean retornat) {
	this.retornat = retornat;
    }

}
