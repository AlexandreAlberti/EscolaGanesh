package escolaganesh.models;

import java.util.List;

public class AlumneDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String cid;
	private String dni;
	private String direccio;
	private String poblacio;
	private String telefon;
	private String dadesBancaries;
	private Boolean jjk;
	private Boolean totsival;
	private Boolean tkd;
	private Boolean jjkInfantil;
	private Boolean jjkIniciacio;
	private Boolean ioga;
	private Double cuota;
	private String observacions;
	private Boolean actiu;

	private List<LlicenciaDTO> llicencies;
	private List<MensualitatDTO> mensualitats;
	private boolean llicenciaPagada = false;
	private boolean mensualitatPagat = false;
	private double balanc;
	
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

	public Boolean isJjk() {
		return jjk;
	}

	public void setJjk(Boolean jjk) {
		this.jjk = Boolean.TRUE.equals(jjk);
	}

	public Boolean isTotsival() {
		return totsival;
	}

	public void setTotsival(Boolean totsival) {
		this.totsival = Boolean.TRUE.equals(totsival);
	}

	public Boolean isTkd() {
		return tkd;
	}

	public void setTkd(Boolean tkd) {
		this.tkd = Boolean.TRUE.equals(tkd);
	}

	public Boolean isJjkInfantil() {
		return jjkInfantil;
	}

	public void setJjkInfantil(Boolean jjkInfantil) {
		this.jjkInfantil = Boolean.TRUE.equals(jjkInfantil);
	}

	public Boolean isJjkIniciacio() {
		return jjkIniciacio;
	}

	public void setJjkIniciacio(Boolean jjkIniciacio) {
		this.jjkIniciacio = Boolean.TRUE.equals(jjkIniciacio);
	}

	public Boolean isIoga() {
		return ioga;
	}

	public void setIoga(Boolean ioga) {
		this.ioga = Boolean.TRUE.equals(ioga);
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

	public List<LlicenciaDTO> getLlicencies() {
		return llicencies;
	}

	public void setLlicencies(List<LlicenciaDTO> llicencies) {
		this.llicencies = llicencies;
	}

	public boolean isLlicenciaPagada() {
		return llicenciaPagada;
	}

	public void setLlicenciaPagada(boolean llicenciaPagada) {
		this.llicenciaPagada = llicenciaPagada;
	}
	
	public Boolean isActiu() {
		return actiu;
	}

	public void setActiu(Boolean actiu) {
		this.actiu = actiu;
	}

	public List<MensualitatDTO> getMensualitats() {
		return mensualitats;
	}

	public void setMensualitats(List<MensualitatDTO> mensualitats) {
		this.mensualitats = mensualitats;
	}

	public boolean isMensualitatPagat() {
		return mensualitatPagat;
	}

	public void setMensualitatPagat(boolean mensualitatPagat) {
		this.mensualitatPagat = mensualitatPagat;
	}

	public double getBalanc() {
		return balanc;
	}

	public void setBalanc(double balanc) {
		this.balanc = balanc;
	}
}
