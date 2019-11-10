package escolaganesh.serveis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escolaganesh.entitats.Material;
import escolaganesh.models.MaterialDTO;
import escolaganesh.repositoris.MaterialRepository;

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository repository;

	
	public MaterialDTO create(MaterialDTO user) {
		return toDTO(repository.save(toEntitat(user)));
	}

	public int delete(int id) {
		Material user = repository.findById(id).orElse(null);
		if (user != null) {
			repository.delete(user);
		}
		return id;
	}

	public List<MaterialDTO> findAll(String cerca) {
		
		List<Material> allMaterials = null;
		if (cerca == null) {
			allMaterials = repository.findAll();
		} else {
			allMaterials = repository.findByDescripcioContainingIgnoreCase(cerca);
		}
		
		List<MaterialDTO> resultat = new ArrayList<>();
		for (Material a : allMaterials) {
			resultat.add(toDTO(a));
		}
		return resultat;
	}

	public MaterialDTO findById(int id) {
		return toDTO(repository.findById(id).orElse(null));
	}

	public MaterialDTO update(MaterialDTO user) {
		Material entitat = toEntitat(user);
		return toDTO(repository.save(entitat));
	}

	private Material toEntitat(MaterialDTO dto) {
		Material material = new Material();
		material.setId(dto.getId());
		material.setDescripcio(dto.getDescripcio());
		material.setCost(dto.getCost());
		material.setObservacions(dto.getObservacions());
		material.setTipus(dto.getTipus());
		material.setComprable(dto.isComprable());
		material.setStock(dto.getStock());
		material.setStockMinim(dto.getStockMinim());
		return material;
	}

	private MaterialDTO toDTO(Material mat) {
		MaterialDTO dto = new MaterialDTO();
		dto.setId(mat.getId());
		dto.setDescripcio(mat.getDescripcio());
		dto.setObservacions(mat.getObservacions());
		dto.setTipus(mat.getTipus());
		dto.setCost(mat.getCost());
		dto.setComprable(mat.isComprable());
		dto.setStock(mat.getStock());
		dto.setStockMinim(mat.getStockMinim());
		return dto;
	}
}
