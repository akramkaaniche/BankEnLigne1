package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Transaction;



@Repository
public interface TransactionRepository  extends CrudRepository<Transaction,Long> {

}
