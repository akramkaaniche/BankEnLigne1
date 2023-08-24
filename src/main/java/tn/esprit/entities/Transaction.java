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
public class Transaction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTrans;
	private float coutTrans;
	private float montant;
	private String nomBenef;
	private String RIBBenef;

	private Date DateTrans;
	private Date DateDebut;
	@Enumerated(EnumType.STRING)
	private StatutTrans statutTrans;
	@Enumerated(EnumType.STRING)
	private ModeTransaction modetrans ;
	
	@ManyToOne
	Client clienttransaction;

}
