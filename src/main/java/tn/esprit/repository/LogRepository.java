package tn.esprit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Log;



@Repository
public interface LogRepository  extends CrudRepository<Log,Long> {
	@Query("SELECT l FROM Log l WHERE l.email= :email")
	Log findByEmail(String email);
	
	

}
