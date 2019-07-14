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

import escolaganesh.models.AlumneDTO;
import escolaganesh.models.LlicenciaDTO;
import escolaganesh.models.MensualitatDTO;
import escolaganesh.serveis.AlumneService;
import escolaganesh.serveis.LlicenciaService;
import escolaganesh.serveis.MensualitatService;

@Controller
@RequestMapping("/alumne")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AlumneController {

	@Autowired
	private AlumneService alumneService;
	@Autowired
	private LlicenciaService llicenciaService;
	@Autowired
	private MensualitatService mensualitatService;

	@PostMapping
	@ResponseBody
	public AlumneDTO create(@RequestBody AlumneDTO user) {
		return alumneService.create(user);
	}

	@GetMapping(path = { "/{id}" })
	@ResponseBody
	public AlumneDTO findOne(@PathVariable("id") int id) {
		return alumneService.findById(id);
	}

	@PutMapping(path = { "/{id}" })
	@ResponseBody
	public AlumneDTO update(@PathVariable("id") int id, @RequestBody AlumneDTO user) {
		user.setId(id);
		return alumneService.update(user);
	}

	@DeleteMapping(path = { "/{id}" })
	@ResponseBody
	public int delete(@PathVariable("id") int id) {
		return alumneService.delete(id);
	}

	@GetMapping
	@ResponseBody
	public List<AlumneDTO> findAll(@RequestParam(required = false, defaultValue = "", name = "cerca") String cerca)
			throws JsonProcessingException {
		if (StringUtils.isEmptyOrWhitespaceOnly(cerca)) {
			cerca = null;
		}
		List<AlumneDTO> allAlumnes = alumneService.findAll(cerca);
		return allAlumnes;
	}

	@PostMapping("/{id}/llicencia")
	@ResponseBody
	public LlicenciaDTO createLlicencia(@RequestBody LlicenciaDTO user) {
		return llicenciaService.create(user);
	}

	@DeleteMapping(path = { "/{id}/llicencia/{idLlicencia}" })
	@ResponseBody
	public int deleteLlicencia(@PathVariable("id") int id, @PathVariable("idLlicencia") int idLlicencia) {
		return llicenciaService.delete(idLlicencia);
	}

	@PostMapping("/{id}/mensualitat")
	@ResponseBody
	public MensualitatDTO createMensualitat(@RequestBody MensualitatDTO mensualitat) {
		return mensualitatService.create(mensualitat);
	}

	@PutMapping("/{id}/mensualitat/{idMensualitat}/pagat")
	@ResponseBody
	public Boolean pagarMensualitat(@PathVariable("idMensualitat") int idMensualitat) {
		return mensualitatService.pagat(idMensualitat);
	}

	@PutMapping("/{id}/mensualitat/{idMensualitat}/retornar")
	@ResponseBody
	public Boolean retornarMensualitat(@PathVariable("idMensualitat") int idMensualitat) {
		return mensualitatService.retornat(idMensualitat);
	}

	@DeleteMapping(path = { "/{id}/mensualitat/{idMensualitat}" })
	@ResponseBody
	public int deleteMensualitat(@PathVariable("id") int id, @PathVariable("idMensualitat") int idMensualitat) {
		return mensualitatService.delete(idMensualitat);
	}

}
