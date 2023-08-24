package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Formation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFormation;
	private String libelle;
	private Date dateDebut;
	private String durée;
	private long nbrParticip;
	private String lieu;
	@Enumerated(EnumType.STRING)
	private ModeFormation mode;
	
	@ManyToMany
	private Set<Agent> agent;
}
