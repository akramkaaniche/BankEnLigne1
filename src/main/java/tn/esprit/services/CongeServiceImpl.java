package tn.esprit.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Conge;
import tn.esprit.entities.StatutConge;
import tn.esprit.repository.CongeRepository;

@Service
public class CongeServiceImpl implements CongeService {
	
	@Autowired
	CongeRepository congerepository;
	@Autowired
	AgentService agentService;


	@Override
	public List<Conge> retrieveAllConges() {
		return (List<Conge>) congerepository.findAll();
	}

	@Override
	public Conge addConge(Conge c) {
		c.setAgentconge(agentService.retrieveConnectedAgent());
		c.setStatut(StatutConge.EnCours);
		congerepository.save(c);
		return c;
	}
	
	
	@Override
	public Conge updateConge(Conge c) {
		congerepository.save(c);
		return c;
	}
	

	@Override
	public void deleteConge(Long id) {
		congerepository.deleteById(id);
	}
	
	
	@Override
	public Conge retrieveConge(Long id) {
		return congerepository.findById(id).orElse(null);
	}

}
