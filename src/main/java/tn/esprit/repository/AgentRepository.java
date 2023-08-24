package tn.esprit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Agent;



@Repository
public interface AgentRepository extends CrudRepository<Agent,Long> {

	@Query("SELECT a FROM Agent a join a.logagent l where l.email= :email")
	Agent retrieveAgentByEmail(@Param("email") String email);
}
