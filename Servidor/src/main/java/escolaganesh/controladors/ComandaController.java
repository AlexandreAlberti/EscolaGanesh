package escolaganesh.controladors;

import com.fasterxml.jackson.core.JsonProcessingException;
import escolaganesh.models.ComandaDTO;
import escolaganesh.serveis.ComandaService;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comanda")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ComandaController {

	@Autowired
	private ComandaService materialService;

	@PostMapping
	@ResponseBody
	public ComandaDTO create(@RequestBody ComandaDTO user) {
		return materialService.create(user);
	}

	@PutMapping(path = { "/pagat/{id}" })
	@ResponseBody
	public void pagat(@PathVariable("id") int id) {
		materialService.pagat(id,true);
	}

	@PutMapping(path = { "/nopagat/{id}" })
	@ResponseBody
	public void nopagat(@PathVariable("id") int id) {
		materialService.pagat(id,false);
	}

	@PutMapping(path = { "/entregat/{id}" })
	@ResponseBody
	public void entregat(@PathVariable("id") int id) {
		materialService.entregat(id,true);
	}

	@PutMapping(path = { "/noentregat/{id}" })
	@ResponseBody
	public void noentregat(@PathVariable("id") int id) {
		materialService.entregat(id,false);
	}

	@DeleteMapping(path = { "/{id}" })
	@ResponseBody
	public int delete(@PathVariable("id") int id) {
		return materialService.delete(id);
	}

	@GetMapping
	@ResponseBody
	public List<ComandaDTO> findAll()
			throws JsonProcessingException {
		List<ComandaDTO> allComandas = materialService.findAll();
		return allComandas;
	}
}
