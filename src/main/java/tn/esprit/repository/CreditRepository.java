package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Credit;



@Repository
public interface CreditRepository extends CrudRepository<Credit,Long>{

}
