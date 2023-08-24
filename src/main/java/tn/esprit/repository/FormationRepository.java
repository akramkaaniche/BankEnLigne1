package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Formation;



@Repository
public interface FormationRepository  extends CrudRepository<Formation,Long>{

}
