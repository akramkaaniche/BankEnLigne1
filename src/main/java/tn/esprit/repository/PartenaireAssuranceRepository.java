package tn.esprit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.PartenaireAssurance;

@Repository
public interface PartenaireAssuranceRepository extends CrudRepository<PartenaireAssurance,Long> {

	@Query("SELECT p FROM PartenaireAssurance p join p.logpartenaire l where l.email= :email")
	PartenaireAssurance retrievePartenaireAssuranceByEmail(@Param("email") String email);
}
