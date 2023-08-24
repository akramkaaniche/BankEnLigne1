package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.CompteCourant;



@Repository
public interface CompteCourantRepository extends CrudRepository<CompteCourant,Long> {

}
