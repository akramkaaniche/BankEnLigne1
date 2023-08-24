package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.CompteEpargne;



@Repository
public interface CompteEpargneRepository extends CrudRepository<CompteEpargne,Long>{

}
