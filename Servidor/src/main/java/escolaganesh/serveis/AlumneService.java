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
		alumne.setDireccio(dto.getDireccio());
		alumne.setCid(dto.getCid());
		alumne.setCuota(dto.getCuota());
		alumne.setDadesBancaries(dto.getDadesBancaries());
		alumne.setDni(dto.getDni());
		alumne.setIoga(dto.isIoga());
		alumne.setJjk(dto.isJjk());
		alumne.setJjkInfantil(dto.isJjkInfantil());
		alumne.setJjkIniciacio(dto.isJjkIniciacio());
		alumne.setObservacions(dto.getObservacions());
		alumne.setPoblacio(dto.getPoblacio());
		alumne.setTelefon(dto.getTelefon());
		alumne.setTkd(dto.isTkd());
		alumne.setTotsival(dto.isTotsival());
		return alumne;
	}

	private AlumneDTO toDTO(Alumne alum) {
		AlumneDTO dto = new AlumneDTO();
		dto.setId(alum.getId());
		dto.setEmail(alum.getEmail());
		dto.setFirstName(alum.getFirstName());
		dto.setLastName(alum.getLastName());
		dto.setDireccio(alum.getDireccio());
		dto.setCid(alum.getCid());
		dto.setCuota(alum.getCuota());
		dto.setDadesBancaries(alum.getDadesBancaries());
		dto.setDni(alum.getDni());
		dto.setIoga(alum.isIoga());
		dto.setJjk(alum.isJjk());
		dto.setJjkInfantil(alum.isJjkInfantil());
		dto.setJjkIniciacio(alum.isJjkIniciacio());
		dto.setObservacions(alum.getObservacions());
		dto.setPoblacio(alum.getPoblacio());
		dto.setTelefon(alum.getTelefon());
		dto.setTkd(alum.isTkd());
		dto.setTotsival(alum.isTotsival());
		return dto;
	}
}
