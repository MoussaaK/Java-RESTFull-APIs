package org.konate.tpjavajee.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Entity(name="Departements")
@Table(name="departements")
public class Departement implements Serializable {

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
	@Column(length=50, name="code")
	private String code;
	
	@XmlElement(name="liste‐de‐communes")
	@JoinColumn(name="communes")
	private Collection<Commune> communes;

	public Departement() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Collection<Commune> getCommunes() {
		return communes;
	}

	public void setCommunes(Collection<Commune> communes) {
		this.communes = communes;
	}
}
