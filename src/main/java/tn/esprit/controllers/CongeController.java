package tn.esprit.controllers;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.entities.Conge;
import tn.esprit.services.CongeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/conge")
public class CongeController {
	
	@Autowired
	CongeService congeService;

	// http://localhost:8083/SpringMVC/conge/retrieve-all-conges
	@GetMapping("/retrieve-all-conges")
	@ResponseBody
	public List<Conge> getConges() {
	List<Conge> listConges = congeService.retrieveAllConges();
	return listConges;
	}
	
	// http://localhost:8083/SpringMVC/conge/retrieve-conge/8
	@GetMapping("/retrieve-conge/{conge-id}")
	@ResponseBody
	public Conge retrieveConge(@PathVariable("conge-id") Long congeId) {
	return congeService.retrieveConge(congeId);
	}

	// http://localhost:8083/SpringMVC/conge/add-conge
	@PostMapping("/add-conge")
	@ResponseBody
	public Conge addConge(@RequestBody Conge a)
	{
	Conge conge = congeService.addConge(a);
	return conge;
	}
	

	// http://localhost:8083/SpringMVC/conge/modify-conge
		@PutMapping("/modify-conge")
		@ResponseBody
		public Conge modifyConge(@RequestBody Conge conge) {
		return congeService.updateConge(conge);
		}
	
	
	// http://localhost:8083/SpringMVC/conge/remove-conge/{conge-id}
	@DeleteMapping("/remove-conge/{conge-id}")
	@ResponseBody
	public void removeConge(@PathVariable("conge-id") Long congeId) {
	congeService.deleteConge(congeId);
	}

}
