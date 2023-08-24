package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity 
public class Client  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idclient;
	private String Nom;
	private String Prenom;
	private String Sexe;
	@Temporal (TemporalType.DATE)
	private Date DatedeNaissance ;
	private String Nationalite;
	private String tel;
	private String cin;
	private String adresse;
	private String profession;
	
	@OneToOne
	private Log logclient ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clienttitre")
	private Set<CompteTitre> comptetitres ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clientepargne")
	private Set<CompteEpargne> compteepargnes ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clientcourant")
	private Set<CompteCourant> comptecourants ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clientcredit")
	private Set<Credit> credits ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clienttransaction")
	private Set<Transaction> transactions ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clientcartebancaire")
	private Set<CarteBancaire> cartebancaires ;
	
	
}
