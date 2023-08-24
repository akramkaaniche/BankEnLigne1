package tn.esprit.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Formation;
import tn.esprit.repository.FormationRepository;

@Service
public class FormationServiceImpl implements FormationService {
	
	@Autowired
	FormationRepository formationRepository  ;
	@Autowired
	AgentService agentService;
	

	@Override
	public List<Formation> retrieveAllFormations() {
		return (List<Formation>) formationRepository.findAll();
	}

	@Override
	public Formation addFormation(Formation c) {
		formationRepository.save(c);
		return c;
	}
	
	
	@Override
	public Formation updateFormation(Formation c) {
		formationRepository.save(c);
		return c;
	}
	

	@Override
	public void deleteFormation(Long id) {
		formationRepository.deleteById(id);
	}
	
	
	@Override
	public Formation retrieveFormation(Long id) {
		return formationRepository.findById(id).orElse(null);
	}

	@Override
	public void inscriptionFormation(Long idFormation) {
		Formation f= formationRepository.findById(idFormation).orElse(null);
		f.getAgent().add(agentService.retrieveConnectedAgent());
		f.setNbrParticip(f.getNbrParticip()+1);
		formationRepository.save(f);
	}

}
