package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Agent;



public interface AgentService {
	
	List<Agent> retrieveAllAgents();

	Agent addAgent (Agent a);

	void deleteAgent (Long id);

	Agent retrieveAgent (Long id);
	
	Agent updateAgent (Agent a);
	
	Agent retrieveConnectedAgent();
	

}
