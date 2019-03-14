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
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import escolaganesh.models.AlumneDTO;
import escolaganesh.serveis.AlumneService;

@Controller
@RequestMapping("/alumne")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AlumneController {

	@Autowired
	private AlumneService userService;

	@PostMapping
	@ResponseBody
	public AlumneDTO create(@RequestBody AlumneDTO user) {
		return userService.create(user);
	}

	@GetMapping(path = { "/{id}" })
	@ResponseBody
	public AlumneDTO findOne(@PathVariable("id") int id) {
		return userService.findById(id);
	}

	@PutMapping(path = { "/{id}" })
	@ResponseBody
	public AlumneDTO update(@PathVariable("id") int id, @RequestBody AlumneDTO user) {
		user.setId(id);
		return userService.update(user);
	}

	@DeleteMapping(path = { "/{id}" })
	@ResponseBody
	public int delete(@PathVariable("id") int id) {
		return userService.delete(id);
	}

	@GetMapping
	@ResponseBody
	public List<AlumneDTO> findAll() throws JsonProcessingException {
		List<AlumneDTO> allAlumnes = userService.findAll();
		System.out.println(new ObjectMapper().writeValueAsString(allAlumnes));
		return allAlumnes;
	}
}
