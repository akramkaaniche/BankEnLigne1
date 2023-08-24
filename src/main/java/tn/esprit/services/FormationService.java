package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Formation;

public interface FormationService {
	
	List<Formation> retrieveAllFormations();

	Formation addFormation (Formation a);

	void deleteFormation (Long id);

	Formation retrieveFormation (Long id);
	
	Formation updateFormation (Formation a);
	
	void inscriptionFormation (Long idFormation);
	

}
