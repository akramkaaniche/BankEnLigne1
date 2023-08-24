package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Message;



@Repository
public interface MessageRepository extends CrudRepository<Message,Long> {

}
