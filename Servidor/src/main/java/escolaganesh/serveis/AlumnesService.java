package escolaganesh.serveis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import escolaganesh.entitats.Alumnes;
import escolaganesh.models.AlumnesDTO;
import escolaganesh.repositoris.AlumnesRepository;

@Service
public class AlumnesService {

	@Autowired
	private AlumnesRepository repository;

	public AlumnesDTO create(AlumnesDTO user) {
		return toDTO(repository.save(toEntitat(user)));
	}

	public int delete(int id) {
		Alumnes user = repository.findById(id).orElse(null);
		if (user != null) {
			repository.delete(user);
		}
		return id;
	}

	public List<AlumnesDTO> findAll() {
		List<Alumnes> allAlumnes = repository.findAll();
		try {
			System.out.println(new ObjectMapper().writeValueAsString(allAlumnes));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		List<AlumnesDTO> resultat = new ArrayList<>();
		for (Alumnes a : allAlumnes) {
			resultat.add(toDTO(a));
		}
		return resultat;
	}

	public AlumnesDTO findById(int id) {
		return toDTO(repository.findById(id).orElse(null));
	}

	public AlumnesDTO update(AlumnesDTO user) {
		return toDTO(repository.save(toEntitat(user)));
	}

	private Alumnes toEntitat(AlumnesDTO dto) {
		Alumnes alumne = new Alumnes();
		alumne.setId(dto.getId());
		alumne.setEmail(dto.getEmail());
		alumne.setFirstName(dto.getFirstName());
		alumne.setLastName(dto.getLastName());
		return alumne;
	}

	private AlumnesDTO toDTO(Alumnes alum) {
		AlumnesDTO dto = new AlumnesDTO();
		dto.setId(alum.getId());
		dto.setEmail(alum.getEmail());
		dto.setFirstName(alum.getFirstName());
		dto.setLastName(alum.getLastName());
		return dto;
	}
}
