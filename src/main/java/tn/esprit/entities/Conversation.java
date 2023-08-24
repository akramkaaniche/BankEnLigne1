package tn.esprit.entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity 
public class Conversation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idConversation;
	
	
	@ManyToMany
	private Set<Log> logs;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="conversation")
	private Set<Message> messages;

}
