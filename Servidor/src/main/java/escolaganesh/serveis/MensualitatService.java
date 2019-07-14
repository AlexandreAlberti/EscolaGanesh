package escolaganesh.serveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import escolaganesh.entitats.Alumne;
import escolaganesh.entitats.Mensualitat;
import escolaganesh.models.MensualitatDTO;
import escolaganesh.repositoris.AlumneRepository;
import escolaganesh.repositoris.MensualitatRepository;

@Service
public class MensualitatService {

	@Autowired
	private MensualitatRepository repository;
	@Autowired
	private AlumneRepository repositoryAlumne;

	public MensualitatDTO create(MensualitatDTO mensualitat) {
		try {
			Alumne alumne = repositoryAlumne.findById(mensualitat.getIdAlumne()).orElseThrow(() -> new NotFoundException());
			return toDTO(repository.save(toEntitat(mensualitat, alumne)), mensualitat.getIdAlumne());
		} catch (NotFoundException e) {
			return null;
		}

	}

	public int delete(int id) {
		Mensualitat r = repository.findById(id).orElse(null);
		if (r != null) {
			repository.delete(r);
		}
		return id;
	}

	public Boolean pagat(int idMensualitat) {
		Mensualitat r = repository.findById(idMensualitat).orElse(null);
		if (r != null && !Boolean.TRUE.equals(r.getPagat())) {
			r.setPagat(true);
			repository.save(r);
			return true;
		}
		return false;
	}

	public Boolean retornat(int idMensualitat) {
		Mensualitat r = repository.findById(idMensualitat).orElse(null);
		if (r != null && !Boolean.FALSE.equals(r.getPagat())) {
			r.setPagat(false);
			repository.save(r);
			return true;
		}
		return false;
	}

	public Mensualitat toEntitat(MensualitatDTO dto, Alumne alumne) {
		Mensualitat mensualitat = new Mensualitat();
		mensualitat.setId(dto.getId());
		mensualitat.setAny(dto.getAny());
		mensualitat.setMes(dto.getMes());
		mensualitat.setAlumne(alumne);
		mensualitat.setQuantitat(dto.getQuantitat());
		mensualitat.setPagat(dto.isPagat());
		return mensualitat;
	}

	public static MensualitatDTO toDTO(Mensualitat r, int idAlum) {
		MensualitatDTO dto = new MensualitatDTO();
		dto.setId(r.getId());
		dto.setIdAlumne(idAlum);
		dto.setAny(r.getAny());
		dto.setMes(r.getMes());
		dto.setQuantitat(r.getQuantitat() == null ? 0.0 : r.getQuantitat());
		dto.setPagat(Boolean.TRUE.equals(r.getPagat()));
		return dto;
	}
}
