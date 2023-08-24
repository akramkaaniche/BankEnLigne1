package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.CompteTitre;



@Repository
public interface CompteTitreRepository extends CrudRepository<CompteTitre,Long> {

}
