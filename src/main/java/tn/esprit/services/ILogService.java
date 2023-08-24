package tn.esprit.services;

import tn.esprit.entities.Log;

public interface ILogService {
	
	Log findLogByLogEmail(String email);
	void fireAgent(Long id);
	
	Log updateAgentLog(Log l);
	Log updateClientLog(Log l);
	Log updatePartenaireAssuranceLog(Log l);
	
}
