package escolaganesh.models;

import java.util.ArrayList;
import java.util.List;

public class TipusMaterial {

	private Integer id;
	private String nom;

	private TipusMaterial(Integer material, String nom) {
		this.id = material;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public static List<TipusMaterial> values() {
		List<TipusMaterial> resultat = new ArrayList<>();
		resultat.add(new TipusMaterial(0, " "));
		resultat.add(new TipusMaterial(1, "Proteccions"));
		resultat.add(new TipusMaterial(2, "Roba"));
		resultat.add(new TipusMaterial(3, "Examens/Cursos"));
		resultat.add(new TipusMaterial(4, "Altres"));
		return resultat;
	}
}
