package tn.esprit.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


import lombok.Data;

@Data
@Entity

public class Log implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idlog;
	private String email;
	private String password;
	private boolean active;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne(mappedBy="logagent" ,optional=true, fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
	private Agent agent;
	
	@OneToOne(mappedBy="logclient" ,optional=true, fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
	private Client client;
	
	@OneToOne(mappedBy="logpartenaire" ,optional=true, fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
	private PartenaireAssurance pa ;
	
	@ManyToMany(mappedBy="logs", cascade = CascadeType.ALL) 
	private Set<Conversation> conversations;
	
	
}
