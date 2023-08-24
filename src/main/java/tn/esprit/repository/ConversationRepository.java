package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Conversation;



@Repository
public interface ConversationRepository extends CrudRepository<Conversation,Long> {

}
