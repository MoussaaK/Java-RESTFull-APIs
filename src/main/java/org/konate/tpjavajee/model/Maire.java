package org.konate.tpjavajee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.konate.tpjavajee.util.Civility;

@Entity(name="Maire")
@Table( name="maires")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Maire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@XmlAttribute
	@Column(length=50, name="id")
	private long id;
	
	@XmlElement
	@Column(length=50, name="nom")
	private String nom;
	
	@XmlElement
	@Column(length=50, name="prenom")
	private String prenom;
	
	@XmlElement
	@Column(length=5, name="civilite")
	@Enumerated(EnumType.STRING)
	private Civility civilite;
	
	@XmlElement
	@Column(length=5, name="date")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@OneToOne(mappedBy="maire")
	@JoinColumn(name="commune")
    private Commune commune;

	public Maire() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Civility getCivilite() {
		return civilite;
	}

	public void setCivilite(Civility civilite) {
		this.civilite = civilite;
	}
	
}
