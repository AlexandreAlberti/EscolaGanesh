package escolaganesh.models;

import java.util.ArrayList;
import java.util.List;

public class RebutDTO {

    public RebutDTO() {
    }

    public RebutDTO(String text) {
	this.text = text;
    }

    private int id;
    private String year;
    private String mes;
    private boolean validat;
    private String text;
    private List<LineaRebutDTO> linees = new ArrayList<>();;

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

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public List<LineaRebutDTO> getLinees() {
	return linees;
    }

    public void setLinees(List<LineaRebutDTO> linees) {
	this.linees = linees;
    }

}
