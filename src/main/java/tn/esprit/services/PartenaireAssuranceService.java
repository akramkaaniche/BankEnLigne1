package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.PartenaireAssurance;

public interface PartenaireAssuranceService {

	List<PartenaireAssurance> retrieveAllPartenaireAssurances();

	PartenaireAssurance addPartenaireAssurance (PartenaireAssurance a);

	void deletePartenaireAssurance (Long id);

	PartenaireAssurance updatePartenaireAssurance (PartenaireAssurance a);

	PartenaireAssurance retrievePartenaireAssurance (Long id);
	
	PartenaireAssurance retrieveConnectedPartenaireAssurance();

}
