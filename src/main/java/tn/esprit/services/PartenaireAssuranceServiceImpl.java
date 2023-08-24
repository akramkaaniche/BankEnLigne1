package tn.esprit.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Log;
import tn.esprit.entities.PartenaireAssurance;
import tn.esprit.entities.Role;
import tn.esprit.repository.LogRepository;
import tn.esprit.repository.PartenaireAssuranceRepository;

@Service
public class PartenaireAssuranceServiceImpl implements PartenaireAssuranceService {
	
	@Autowired
	PartenaireAssuranceRepository partenaireAssurancerepository;
	@Autowired
	LogRepository logrepository;
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


	@Override
	public List<PartenaireAssurance> retrieveAllPartenaireAssurances() {
		return (List<PartenaireAssurance>) partenaireAssurancerepository.findAll();
		
	}

	@Transactional
	public PartenaireAssurance addPartenaireAssurance(PartenaireAssurance a) {
		Log log= saveLog(a);
		a.setLogpartenaire(log);
		partenaireAssurancerepository.save(a);
		return a;
	}
	
	private Log saveLog(PartenaireAssurance a){
		Log log=a.getLogpartenaire();
		log.setPassword(bCryptPasswordEncoder.encode(a.getLogpartenaire().getPassword()));
		log.setRole(Role.PartenaireAssurance);
		logrepository.save(log);
		return log;
	}

	@Override
	public void deletePartenaireAssurance(Long id) {
		partenaireAssurancerepository.deleteById(id);
		
	}

	@Transactional
	public PartenaireAssurance updatePartenaireAssurance(PartenaireAssurance a) {
		Log log= updateLog(a);
		a.setLogpartenaire(log);
		partenaireAssurancerepository.save(a);
		return a;
	}
	
	private Log updateLog(PartenaireAssurance a){
		Log log=a.getLogpartenaire();
		log.setPassword(bCryptPasswordEncoder.encode(a.getLogpartenaire().getPassword()));
		log.setRole(Role.PartenaireAssurance);
		logrepository.save(log);
		return log;
	}

	@Override
	public PartenaireAssurance retrievePartenaireAssurance(Long id) {
		return partenaireAssurancerepository.findById(id).orElse(null);
	
	}
	
	@Override
	public PartenaireAssurance retrieveConnectedPartenaireAssurance(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String currentPrincipalName = authentication.getName();
	    PartenaireAssurance a=partenaireAssurancerepository.retrievePartenaireAssuranceByEmail(currentPrincipalName);
	    return a;
	}

}
