package escolaganesh.controladors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.jdbc.StringUtils;

import escolaganesh.models.MaterialDTO;
import escolaganesh.models.TipusMaterial;
import escolaganesh.serveis.MaterialService;

@Controller
@RequestMapping("/material")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MaterialController {

	@Autowired
	private MaterialService materialService;

	@PostMapping
	@ResponseBody
	public MaterialDTO create(@RequestBody MaterialDTO user) {
		return materialService.create(user);
	}

	@GetMapping(path = { "/{id}" })
	@ResponseBody
	public MaterialDTO findOne(@PathVariable("id") int id) {
		return materialService.findById(id);
	}

	@PutMapping(path = { "/{id}" })
	@ResponseBody
	public MaterialDTO update(@PathVariable("id") int id, @RequestBody MaterialDTO user) {
		user.setId(id);
		return materialService.update(user);
	}

	@DeleteMapping(path = { "/{id}" })
	@ResponseBody
	public int delete(@PathVariable("id") int id) {
		return materialService.delete(id);
	}

	@GetMapping
	@ResponseBody
	public List<MaterialDTO> findAll(@RequestParam(required = false, defaultValue = "", name = "cerca") String cerca)
			throws JsonProcessingException {
		if (StringUtils.isEmptyOrWhitespaceOnly(cerca)) {
			cerca = null;
		}
		List<MaterialDTO> allMaterials = materialService.findAll(cerca);
		return allMaterials;
	}

	@GetMapping(path = { "/tipus" })
	@ResponseBody
	public List<TipusMaterial> allTipus() {
		return TipusMaterial.values();
	}
}
