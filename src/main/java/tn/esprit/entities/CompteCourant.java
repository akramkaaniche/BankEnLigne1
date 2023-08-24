package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class CompteCourant  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCmptCourant;
	private String RIB;
	private Date dateOuverture;
	private float solde;
	private float autorDecouv;
	
	@ManyToOne
	Client clientcourant;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="comptecourant")
	private Set<CarnetCheque> carnetcheques ;
	
	
}
