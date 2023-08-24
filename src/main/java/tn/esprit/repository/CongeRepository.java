package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Conge;



@Repository
public interface CongeRepository  extends CrudRepository<Conge,Long> {

}
