package org.konate.tpjavajee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name="Commune")
@Table(name="communes")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Commune implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@XmlAttribute
	@Column(length=50, name="id")
	private long id;
	
	@XmlElement
	@Column(length=50, name="nom")
	private String nom;
	
	@XmlElement
	@Column(length=50, name="code_postale")
	private String code_postale;
	
	@XmlElement
	@JoinColumn
	private Departement dpt;
	
	public Departement getDpt() {
		return dpt;
	}
	public void setDpt(Departement dpt) {
		this.dpt = dpt;
	}
	@XmlElement
	@JoinColumn(name="Maire")
    private Maire maire;
	
	public Commune() {
	}
	public Commune(long id, String nom) {
		this.id=id;
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setId(long id) {
		this.id = id;
	}
		
	public long getId() {
		return this.id;
	}
	public Maire getMaire() {
		return maire;
	}
	public void setMaire(Maire maire) {
		this.maire = maire;
	}

}
