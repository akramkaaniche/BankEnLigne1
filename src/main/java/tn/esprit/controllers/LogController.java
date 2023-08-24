package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Log;
import tn.esprit.repository.LogRepository;
import tn.esprit.services.ILogService;



//import tn.MITProject.services.ILogService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	ILogService iLogService;
	@Autowired
	LogRepository logRepository;

	// http://localhost:8083/SpringMVC/log/fire-agent/8
		@PutMapping("/fire-agent/{agent-id}")
		@ResponseBody
		public void fireAgent(@PathVariable("agent-id") Long agentId) {
		   iLogService.fireAgent(agentId);
		}
		
		
		
		
		// http://localhost:8083/SpringMVC/log/users
		@GetMapping("/users/{login}")
		  public   ResponseEntity<Log> getUserByLogin(@PathVariable String login) {
			  Log User = logRepository.findByEmail(login);
			   return ResponseEntity.ok().body(User);
		  } 
		
	
		
		// http://localhost:8083/SpringMVC/log/modify-logagent
		@PutMapping("/modify-logagent")
		@ResponseBody
		public Log modifyLogAgent(@RequestBody Log user) {
		return iLogService.updateAgentLog(user);
		}
		
		// http://localhost:8083/SpringMVC/log/modify-logclient
		@PutMapping("/modify-logclient")
		@ResponseBody
		public Log modifyLogClient(@RequestBody Log user) {
		return iLogService.updateClientLog(user);
		}
		
		// http://localhost:8083/SpringMVC/log/modify-logpartenaireAssurance
		@PutMapping("/modify-logpartenaireAssurance")
		@ResponseBody
		public Log modifyLogPartenaireAssurance(@RequestBody Log user) {
		return iLogService.updatePartenaireAssuranceLog(user);
		}
			
		
}
