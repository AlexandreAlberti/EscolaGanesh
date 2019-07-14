package escolaganesh.models;

public class RebutDTO {
    private int id;
    private String year;
    private String mes;
    private boolean validat;

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

    public boolean isValidat() {
	return validat;
    }

    public void setValidat(boolean validat) {
	this.validat = validat;
    }

}
