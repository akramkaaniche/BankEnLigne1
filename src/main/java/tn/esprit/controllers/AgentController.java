package tn.esprit.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.entities.Agent;
import tn.esprit.services.AgentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/agent")
public class AgentController {
	
	@Autowired
	AgentService agentService;

	// http://localhost:8083/SpringMVC/agent/retrieve-all-agents
	@GetMapping("/retrieve-all-agents")
	@ResponseBody
	public List<Agent> getAgents() {
	List<Agent> listAgents = agentService.retrieveAllAgents();
	return listAgents;
	}
	
	// http://localhost:8083/SpringMVC/agent/retrieve-agent/8
	@GetMapping("/retrieve-agent/{agent-id}")
	@ResponseBody
	public Agent retrieveAgent(@PathVariable("agent-id") Long agentId) {
	return agentService.retrieveAgent(agentId);
	}

	// http://localhost:8083/SpringMVC/agent/add-agent
	@PostMapping("/add-agent")
	@ResponseBody
	public Agent addAgent(@RequestBody Agent a)
	{
	Agent agent = agentService.addAgent(a);
	return agent;
	}
	

	// http://localhost:8083/SpringMVC/agent/modify-agent
		@PutMapping("/modify-agent")
		@ResponseBody
		public Agent modifyAgent(@RequestBody Agent agent) {
		return agentService.updateAgent(agent);
		}
	
	
	// http://localhost:8083/SpringMVC/agent/remove-agent/{agent-id}
	@DeleteMapping("/remove-agent/{agent-id}")
	@ResponseBody
	public void removeAgent(@PathVariable("agent-id") Long agentId) {
	agentService.deleteAgent(agentId);
	}

}
