package escolaganesh.serveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import escolaganesh.entitats.Llicencia;
import escolaganesh.models.LlicenciaDTO;
import escolaganesh.repositoris.AlumneRepository;
import escolaganesh.repositoris.LlicenciaRepository;

@Service
public class LlicenciaService {

	@Autowired
	private LlicenciaRepository repository;
	@Autowired
	private AlumneRepository repositoryAlumne;

	public LlicenciaDTO create(LlicenciaDTO user) {
		return toDTO(repository.save(toEntitat(user)), user.getIdAlumne());
	}

	public int delete(int id) {
		Llicencia user = repository.findById(id).orElse(null);
		if (user != null) {
			repository.delete(user);
		}
		return id;
	}

	public Llicencia toEntitat(LlicenciaDTO dto) {
		Llicencia llicencia = new Llicencia();
		llicencia.setId(dto.getId());
		llicencia.setAny(dto.getAny());
		try {
			llicencia
					.setAlumne(repositoryAlumne.findById(dto.getIdAlumne()).orElseThrow(() -> new NotFoundException()));
		} catch (NotFoundException e) {
			return null;
		}
		return llicencia;
	}

	public LlicenciaDTO toDTO(Llicencia lic, int idAlum) {
		LlicenciaDTO dto = new LlicenciaDTO();
		dto.setId(lic.getId());
		dto.setIdAlumne(idAlum);
		dto.setAny(lic.getAny());
		return dto;
	}
}
