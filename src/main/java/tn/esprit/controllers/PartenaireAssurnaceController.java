package tn.esprit.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
import tn.esprit.entities.PartenaireAssurance;
import tn.esprit.services.PartenaireAssuranceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/partenaireAssurance")
public class PartenaireAssurnaceController {
	
	@Autowired
	PartenaireAssuranceService partenaireAssuranceService;

	// http://localhost:8083/SpringMVC/partenaireAssurance/retrieve-all-partenaireAssurances
	@GetMapping("/retrieve-all-partenaireAssurances")
	@ResponseBody
	public List<PartenaireAssurance> getPartenaireAssurances() {
	List<PartenaireAssurance> listPartenaireAssurances = partenaireAssuranceService.retrieveAllPartenaireAssurances();
	return listPartenaireAssurances;
	}
	
	// http://localhost:8083/SpringMVC/partenaireAssurance/retrieve-partenaireAssurance/8
	@GetMapping("/retrieve-partenaireAssurance/{partenaireAssurance-id}")
	@ResponseBody
	public PartenaireAssurance retrievePartenaireAssurance(@PathVariable("partenaireAssurance-id") Long partenaireAssuranceId) {
	return partenaireAssuranceService.retrievePartenaireAssurance(partenaireAssuranceId);
	}

	// http://localhost:8083/SpringMVC/partenaireAssurance/add-partenaireAssurance
	@PostMapping("/add-partenaireAssurance")
	@ResponseBody
	public PartenaireAssurance addPartenaireAssurance(@RequestBody PartenaireAssurance a)
	{
	PartenaireAssurance partenaireAssurance = partenaireAssuranceService.addPartenaireAssurance(a);
	return partenaireAssurance;
	}
	

	// http://localhost:8083/SpringMVC/partenaireAssurance/modify-partenaireAssurance
		@PutMapping("/modify-partenaireAssurance")
		@ResponseBody
		public PartenaireAssurance modifyPartenaireAssurance(@RequestBody PartenaireAssurance partenaireAssurance) {
		return partenaireAssuranceService.updatePartenaireAssurance(partenaireAssurance);
		}
	
	
	// http://localhost:8083/SpringMVC/partenaireAssurance/remove-partenaireAssurance/{partenaireAssurance-id}
	@DeleteMapping("/remove-partenaireAssurance/{partenaireAssurance-id}")
	@ResponseBody
	public void removePartenaireAssurance(@PathVariable("partenaireAssurance-id") Long partenaireAssuranceId) {
	partenaireAssuranceService.deletePartenaireAssurance(partenaireAssuranceId);
	}

}
