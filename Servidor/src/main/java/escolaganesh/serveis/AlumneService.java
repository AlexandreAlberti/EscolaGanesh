package escolaganesh.serveis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escolaganesh.entitats.Alumne;
import escolaganesh.models.AlumneDTO;
import escolaganesh.repositoris.AlumneRepository;

@Service
public class AlumneService {

	@Autowired
	private AlumneRepository repository;

	public AlumneDTO create(AlumneDTO user) {
		return toDTO(repository.save(toEntitat(user)));
	}

	public int delete(int id) {
		Alumne user = repository.findById(id).orElse(null);
		if (user != null) {
			repository.delete(user);
		}
		return id;
	}

	public List<AlumneDTO> findAll(String cerca) {
		
		List<Alumne> allAlumnes = null;
		if (cerca == null) {
			allAlumnes = repository.findAll();
		} else {
			allAlumnes = repository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(cerca,cerca);
		}
		
		List<AlumneDTO> resultat = new ArrayList<>();
		for (Alumne a : allAlumnes) {
			resultat.add(toDTO(a));
		}
		return resultat;
	}

	public AlumneDTO findById(int id) {
		return toDTO(repository.findById(id).orElse(null));
	}

	public AlumneDTO update(AlumneDTO user) {
		return toDTO(repository.save(toEntitat(user)));
	}

	private Alumne toEntitat(AlumneDTO dto) {
		Alumne alumne = new Alumne();
		alumne.setId(dto.getId());
		alumne.setEmail(dto.getEmail());
		alumne.setFirstName(dto.getFirstName());
		alumne.setLastName(dto.getLastName());
		return alumne;
	}

	private AlumneDTO toDTO(Alumne alum) {
		AlumneDTO dto = new AlumneDTO();
		dto.setId(alum.getId());
		dto.setEmail(alum.getEmail());
		dto.setFirstName(alum.getFirstName());
		dto.setLastName(alum.getLastName());
		return dto;
	}
}
