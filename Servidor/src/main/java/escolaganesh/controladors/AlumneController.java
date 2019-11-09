package escolaganesh.controladors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation. *;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.jdbc.StringUtils;

import escolaganesh.models.AlumneDTO;
import escolaganesh.models.LlicenciaDTO;
import escolaganesh.models.MensualitatDTO;
import escolaganesh.serveis.AlumneService;
import escolaganesh.serveis.LlicenciaService;
import escolaganesh.serveis.MensualitatService;

@RestController
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
	public @ResponseBody AlumneDTO create(@RequestBody AlumneDTO user) {
		return alumneService.create(user);
	}

	@GetMapping(path = { "/{id}" })
	public @ResponseBody AlumneDTO findOne(@PathVariable("id") int id) {
		return alumneService.findById(id);
	}

	@PutMapping(path = { "/{id}" })

	public @ResponseBody AlumneDTO update(@PathVariable("id") int id, @RequestBody AlumneDTO user) {
		user.setId(id);
		return alumneService.update(user);
	}

	@DeleteMapping(path = { "/{id}" })
	public @ResponseBody int delete(@PathVariable("id") int id) {
		return alumneService.delete(id);
	}

	@GetMapping
	public @ResponseBody List<AlumneDTO> findAll(@RequestParam(required = false, defaultValue = "", name = "cerca") String cerca)
			throws JsonProcessingException {
		if (StringUtils.isEmptyOrWhitespaceOnly(cerca)) {
			cerca = null;
		}
		List<AlumneDTO> allAlumnes = alumneService.findAll(cerca);
		return allAlumnes;
	}

	@PostMapping("/{id}/llicencia")
	public @ResponseBody LlicenciaDTO createLlicencia(@RequestBody LlicenciaDTO user) {
		return llicenciaService.create(user);
	}

	@DeleteMapping(path = { "/{id}/llicencia/{idLlicencia}" })
	public @ResponseBody int deleteLlicencia(@PathVariable("id") int id, @PathVariable("idLlicencia") int idLlicencia) {
		return llicenciaService.delete(idLlicencia);
	}

	@PostMapping("/{id}/mensualitat")
	public @ResponseBody MensualitatDTO createMensualitat(@RequestBody MensualitatDTO mensualitat) {
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
