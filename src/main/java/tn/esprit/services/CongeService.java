package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Conge;

public interface CongeService {
	
	List<Conge> retrieveAllConges();

	Conge addConge (Conge a);

	void deleteConge (Long id);

	Conge retrieveConge (Long id);
	
	Conge updateConge (Conge a);
	

}
