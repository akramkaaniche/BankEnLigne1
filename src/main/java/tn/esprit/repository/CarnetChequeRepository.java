package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.CarnetCheque;



@Repository
public interface CarnetChequeRepository extends CrudRepository<CarnetCheque,Long> {

}
