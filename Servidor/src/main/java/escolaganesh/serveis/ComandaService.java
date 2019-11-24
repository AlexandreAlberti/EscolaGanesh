package escolaganesh.serveis;

import escolaganesh.entitats.Alumne;
import escolaganesh.entitats.Comanda;
import escolaganesh.entitats.Material;
import escolaganesh.models.ComandaDTO;
import escolaganesh.repositoris.AlumneRepository;
import escolaganesh.repositoris.ComandaRepository;
import escolaganesh.repositoris.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository repository;
    @Autowired
    private AlumneRepository repositoryAlumne;
    @Autowired
    private MaterialRepository repositoryMaterial;

    public ComandaDTO create(ComandaDTO user) {
        return toDTO(repository.save(toEntitat(user)));
    }

    public int delete(int id) {
        Comanda c = repository.findById(id).orElse(null);
        if (c != null && c.getIdLiniaDetall() == null) {
            repository.delete(c);
        }
        return id;
    }

    public void pagat(int id, boolean isPagat) {
        Comanda c = repository.findById(id).get();
        c.setPagat(isPagat);
        repository.save(c);
    }

    public void entregat(int id, boolean isEntregat) {
        Comanda c = repository.findById(id).get();
        c.setEntregat(isEntregat);
        repository.save(c);
    }

    public List<ComandaDTO> findAll() {
        List<Comanda> allComandas = repository.findAll();
        List<ComandaDTO> resultat = new ArrayList<>();
        for (Comanda a : allComandas) {
            resultat.add(toDTO(a));
        }
        return resultat;
    }

    private Comanda toEntitat(ComandaDTO dto) {
        Comanda comanda = new Comanda();
        comanda.setAlumne(repositoryAlumne.findById(dto.getIdAlumne()).get());
        comanda.setConcepteAdicional(dto.getConcepteAdicional());
        comanda.setEntregat(dto.isEntregat());
        comanda.setPagat(dto.isPagat());
        comanda.setQuantitat(dto.getQuantitat());
        comanda.setPreuFinal(dto.getPreuFinal());
        comanda.setMaterial(repositoryMaterial.findById(dto.getIdMaterial()).get());
        return comanda;
    }

    private ComandaDTO toDTO(Comanda com) {
        ComandaDTO dto = new ComandaDTO();
        dto.setId(com.getId());
        Alumne alumne = com.getAlumne();
        dto.setIdAlumne(alumne.getId());
        dto.setNomAlumne(alumne.getFirstName() + " " + alumne.getLastName());
        dto.setConcepteAdicional(com.getConcepteAdicional());
        dto.setEntregat(com.getEntregat());
        dto.setPagat(com.getPagat());
        dto.setQuantitat(com.getQuantitat());
        dto.setPreuFinal(com.getPreuFinal());
        Material material = com.getMaterial();
        dto.setIdMaterial(material.getId());
        dto.setDescMaterial(material.getDescripcio() + (StringUtils.isEmpty(material.getObservacions()) ? "" : ("(" + material.getObservacions() + ")")));
        if (com.getIdLiniaDetall() != null) {
            dto.setIdLiniaDetall(com.getIdLiniaDetall());
        }
        return dto;
    }
}
