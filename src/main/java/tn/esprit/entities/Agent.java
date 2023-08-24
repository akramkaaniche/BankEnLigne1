package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Agent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAgent;
	private String nom;
	private String prenom;
	private String salaire;
	private String soldeDeConge;
	@Temporal (TemporalType.DATE)
	private  Date dateNaissance;
	@Temporal (TemporalType.DATE)
	private Date dateEmbauche;
	@Enumerated(EnumType.STRING)
	private FonctionAgent fonctionAgent;
	@Enumerated(EnumType.STRING)

	private StatutAgent statut;
	
	@OneToOne
	@JsonIgnore
	private Log logagent ;
	
	@ManyToMany(mappedBy="agent") 
	private Set<Formation> formations;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="agentconge")
	private Set<Conge> conges;
}
