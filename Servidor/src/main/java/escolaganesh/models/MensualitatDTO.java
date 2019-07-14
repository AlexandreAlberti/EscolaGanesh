package escolaganesh.models;

public class MensualitatDTO {

	private int id;
	private int idAlumne;
	private int any;
	private int mes;
	private double quantitat;
	private boolean pagat;

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

	public int getAny() {
		return any;
	}

	public void setAny(int any) {
		this.any = any;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public double getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(double quantitat) {
		this.quantitat = quantitat;
	}

	public boolean isPagat() {
		return pagat;
	}

	public void setPagat(boolean pagat) {
		this.pagat = pagat;
	}

}
