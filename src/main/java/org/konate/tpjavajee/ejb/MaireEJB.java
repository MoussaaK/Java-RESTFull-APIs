package org.konate.tpjavajee.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.konate.tpjavajee.model.Maire;

@Stateless
public class MaireEJB {
	
	@PersistenceContext(unitName="jpa-test")
	private EntityManager em;

	public long createMaire(String name) {
		Maire maire = new Maire();
		maire.setNom(name);
		em.persist(maire);
		return maire.getId();
	}

	public Maire retrieveMaire(long id) {
		return em.find(Maire.class, id);
	}

	public void deleteMaire(long id) {
		Maire maire = em.find(Maire.class, id);
		em.remove(maire);
	}

	public void updateMaire(long id, String newName) {
		Maire maire = em.find(Maire.class, id);
		maire.setNom(newName);
	}

	@SuppressWarnings("unchecked")
	public List<Maire> retrieveMaires() {
		Query query = em.createNativeQuery("SELECT id, nom, prenom FROM maires;");
		return query.getResultList();
	}
}
