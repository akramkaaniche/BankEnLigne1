package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Conge implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idConge;
	private Date dateDebut;
	private Date dateFin;

	@Enumerated(EnumType.STRING)
	private TypeConge type;
	@Enumerated(EnumType.STRING)
	private StatutConge statut;
	
	@ManyToOne
	Agent agentconge;
}
