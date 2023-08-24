package tn.esprit.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Agent;
import tn.esprit.entities.Client;
import tn.esprit.entities.FonctionAgent;
import tn.esprit.entities.Log;
import tn.esprit.entities.Role;
import tn.esprit.repository.AgentRepository;
import tn.esprit.repository.LogRepository;

@Service
public class AgentServiceImpl implements AgentService {
	
	@Autowired
	AgentRepository agentrepository;
	@Autowired
	LogRepository logrepository;
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


	@Override
	public List<Agent> retrieveAllAgents() {
		return (List<Agent>) agentrepository.findAll();
	}

	@Transactional
	public Agent addAgent(Agent a) {
		Log log= saveLog(a);
		a.setLogagent(log);
		agentrepository.save(a);
		return a;
	}
	
	private Log saveLog(Agent a){
		Log log=a.getLogagent();
		log.setPassword(bCryptPasswordEncoder.encode(a.getLogagent().getPassword()));
		switch (a.getFonctionAgent()) {
		case GestionnaireClient : log.setRole(Role.GestionnaireClient);
			break;
		case ConseillerClient: log.setRole(Role.ConseillerClient);
			break;
		case RH: log.setRole(Role.RH);
			break;
		default:
			break;
		}
		log.setActive(true);
			
		logrepository.save(log);
		return log;
	}
	
	@Transactional
	public Agent updateAgent(Agent a) {
		Log log= updateLog(a);
		a.setLogagent(log);
		agentrepository.save(a);
		return a;
	}
	
	private Log updateLog(Agent a){
		Log log=a.getLogagent();
		log.setPassword(bCryptPasswordEncoder.encode(a.getLogagent().getPassword()));
		switch (a.getFonctionAgent()) {
		case GestionnaireClient : log.setRole(Role.GestionnaireClient);
			break;
		case ConseillerClient: log.setRole(Role.ConseillerClient);
			break;
		case RH: log.setRole(Role.RH);
			break;
		default:
			break;
		}
		logrepository.save(log);
		return log;
	}

	@Override
	public void deleteAgent(Long id) {
		agentrepository.deleteById(id);
	}
	
	

	@Override
	public Agent retrieveAgent(Long id) {
		return agentrepository.findById(id).orElse(null);
	}

	@Override
	public Agent retrieveConnectedAgent(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String currentPrincipalName = authentication.getName();
	    Agent a=agentrepository.retrieveAgentByEmail(currentPrincipalName);
	    return a;
	}

}


