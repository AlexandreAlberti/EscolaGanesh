package escolaganesh.serveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import escolaganesh.entitats.Rebut;
import escolaganesh.models.RebutDTO;
import escolaganesh.repositoris.AlumneRepository;
import escolaganesh.repositoris.RebutRepository;

@Service
public class RebutService {

	@Autowired
	private RebutRepository repository;
	@Autowired
	private AlumneRepository repositoryAlumne;

	public RebutDTO create(RebutDTO user) {
		return toDTO(repository.save(toEntitat(user)), user.getIdAlumne());
	}

	public int delete(int id) {
		Rebut user = repository.findById(id).orElse(null);
		if (user != null) {
			repository.delete(user);
		}
		return id;
	}

	public Rebut toEntitat(RebutDTO dto) {
		Rebut llicencia = new Rebut();
		llicencia.setId(dto.getId());
		llicencia.setAny(dto.getAny());
		llicencia.setMes(dto.getMes());
		try {
			llicencia
					.setAlumne(repositoryAlumne.findById(dto.getIdAlumne()).orElseThrow(() -> new NotFoundException()));
		} catch (NotFoundException e) {
			return null;
		}
		return llicencia;
	}

	public RebutDTO toDTO(Rebut lic, int idAlum) {
		RebutDTO dto = new RebutDTO();
		dto.setId(lic.getId());
		dto.setIdAlumne(idAlum);
		dto.setAny(lic.getAny());
		dto.setMes(lic.getMes());
		return dto;
	}
}
