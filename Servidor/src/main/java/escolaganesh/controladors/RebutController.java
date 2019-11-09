package escolaganesh.controladors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.jdbc.StringUtils;
import escolaganesh.models.RebutDTO;
import escolaganesh.serveis.RebutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rebut")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RebutController {

    @Autowired
    private RebutService rebutService;

    @PostMapping
    @ResponseBody
    public String create() {
        return rebutService.create();
    }

    @PutMapping(path = {"/{id}"})
    @ResponseBody
    public void validar(@PathVariable("id") int id) {
        rebutService.validar(id);
    }

    @GetMapping
    @ResponseBody
    public List<RebutDTO> findAll(@RequestParam(required = false, defaultValue = "", name = "cercaMes") String cercaMes,
                                  @RequestParam(required = false, defaultValue = "", name = "cercaAny") String cercaAny) throws JsonProcessingException {
        if (StringUtils.isEmptyOrWhitespaceOnly(cercaMes)) {
            cercaMes = null;
        }
        if (StringUtils.isEmptyOrWhitespaceOnly(cercaAny)) {
            cercaAny = null;
        }
        List<RebutDTO> allRebuts = rebutService.findAll(cercaMes, cercaAny);
        return allRebuts;
    }

}
