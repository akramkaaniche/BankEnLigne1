package tn.esprit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Client;



@Repository
public interface ClientRepository extends CrudRepository<Client,Long>{
	
	@Query("SELECT c FROM Client c join c.logclient l where l.email= :email")
	Client retrieveClientByEmail(@Param("email") String email);

}
