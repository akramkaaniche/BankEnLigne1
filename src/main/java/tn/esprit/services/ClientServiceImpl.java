package tn.esprit.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Client;
import tn.esprit.entities.Log;
import tn.esprit.entities.Role;
import tn.esprit.repository.ClientRepository;
import tn.esprit.repository.LogRepository;



@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientrepository;
	@Autowired
	LogRepository logrepository;
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


	@Override
	public List<Client> retrieveAllClients() {
		return (List<Client>) clientrepository.findAll();
		
	}

	@Transactional
	public Client addClient(Client a) {
		Log log= saveLog(a);
		a.setLogclient(log);
		clientrepository.save(a);
		return a;
	}
	
	private Log saveLog(Client a){
		Log log=a.getLogclient();
		log.setPassword(bCryptPasswordEncoder.encode(a.getLogclient().getPassword()));
		log.setRole(Role.Client);
		logrepository.save(log);
		return log;
	}

	@Override
	public void deleteClient(Long id) {
		clientrepository.deleteById(id);
		
	}

	@Transactional
	public Client updateClient(Client a) {
		Log log= updateLog(a);
		a.setLogclient(log);
		clientrepository.save(a);
		return a;
	}
	
	private Log updateLog(Client a){
		Log log=a.getLogclient();
		log.setPassword(bCryptPasswordEncoder.encode(a.getLogclient().getPassword()));
		log.setRole(Role.Client);
		logrepository.save(log);
		return log;
	}

	@Override
	public Client retrieveClient(Long id) {
		return clientrepository.findById(id).orElse(null);
	
	}
	
	@Override
	public Client retrieveConnectedClient(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String currentPrincipalName = authentication.getName();
	    Client c=clientrepository.retrieveClientByEmail(currentPrincipalName);
	    return c;
	}

}
