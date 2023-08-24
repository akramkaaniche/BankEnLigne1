package tn.esprit.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Agent;
import tn.esprit.entities.Client;
import tn.esprit.entities.Log;
import tn.esprit.entities.PartenaireAssurance;
import tn.esprit.repository.AgentRepository;
import tn.esprit.repository.ClientRepository;
import tn.esprit.repository.LogRepository;
import tn.esprit.repository.PartenaireAssuranceRepository;



@Service
public class LogService implements ILogService {
	
	@Autowired
	private LogRepository logRepository;
	
	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PartenaireAssuranceRepository partenaireAssuranceRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	@Override
	public Log findLogByLogEmail(String email) {
		return logRepository.findByEmail(email);
	}
	/*public Log saveLog(Log log) {
		log.setPassword(bCryptPasswordEncoder.encode(log.getPassword()));
		log.setActive(true);
		return logRepository.save(log);
	}*/
	
	@Override
	public void fireAgent(Long id) {
		/*Long idLog= logRepository.findAgent(id);
		Log agent=logRepository.findById(idLog).orElse(null);
	    agent.setActive(false);	
	    logRepository.save(agent);*/
	    }
	
	
	
	@Transactional
	public Log updateAgentLog(Log l) {
		Agent agent= updateAgent(l);
		l.setAgent(agent);
		l.setPassword(bCryptPasswordEncoder.encode(l.getPassword()));
		//l.setRole(Role);
		logRepository.save(l);
		return l;
	}
	
	private Agent updateAgent(Log l){
		Agent agent=l.getAgent();
		agentRepository.save(agent);
		return agent;
	}

	@Transactional
	public Log updateClientLog(Log l) {
		Client client= updateClient(l);
		l.setClient(client);
		l.setPassword(bCryptPasswordEncoder.encode(l.getPassword()));
		//l.setRole(Role);
		logRepository.save(l);
		return l;
	}
	
	private Client updateClient(Log l){
		Client client=l.getClient();
		clientRepository.save(client);
		return client;
	}
	
	@Transactional
	public Log updatePartenaireAssuranceLog(Log l) {
		PartenaireAssurance partenaireAssurance= updatePartenaireAssurance(l);
		l.setPa(partenaireAssurance);
		l.setPassword(bCryptPasswordEncoder.encode(l.getPassword()));
		//l.setRole(Role);
		logRepository.save(l);
		return l;
	}
	
	private PartenaireAssurance updatePartenaireAssurance(Log l){
		PartenaireAssurance partenaireAssurance=l.getPa();
		partenaireAssuranceRepository.save(partenaireAssurance);
		return partenaireAssurance;
	}


}
