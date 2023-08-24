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
import tn.esprit.entities.Formation;
import tn.esprit.services.FormationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/formation")
public class FormationController {
	
	@Autowired
	FormationService formationService;

	// http://localhost:8083/SpringMVC/formation/retrieve-all-formations
	@GetMapping("/retrieve-all-formations")
	@ResponseBody
	public List<Formation> getFormations() {
	List<Formation> listFormations = formationService.retrieveAllFormations();
	return listFormations;
	}
	
	// http://localhost:8083/SpringMVC/formation/retrieve-formation/8
	@GetMapping("/retrieve-formation/{formation-id}")
	@ResponseBody
	public Formation retrieveFormation(@PathVariable("formation-id") Long formationId) {
	return formationService.retrieveFormation(formationId);
	}

	// http://localhost:8083/SpringMVC/formation/add-formation
	@PostMapping("/add-formation")
	@ResponseBody
	public Formation addFormation(@RequestBody Formation a)
	{
	Formation formation = formationService.addFormation(a);
	return formation;
	}
	

	// http://localhost:8083/SpringMVC/formation/modify-formation
		@PutMapping("/modify-formation")
		@ResponseBody
		public Formation modifyFormation(@RequestBody Formation formation) {
		return formationService.updateFormation(formation);
		}
	
	
	// http://localhost:8083/SpringMVC/formation/remove-formation/{formation-id}
	@DeleteMapping("/remove-formation/{formation-id}")
	@ResponseBody
	public void removeFormation(@PathVariable("formation-id") Long formationId) {
	formationService.deleteFormation(formationId);
	}
	
	// http://localhost:8083/SpringMVC/formation/inscription-formation/{formation-id}
		@DeleteMapping("/inscription-formation/{formation-id}")
		@ResponseBody
		public void inscriptionFormation(@PathVariable("formation-id") Long formationId) {
		formationService.inscriptionFormation(formationId);
		}

}
