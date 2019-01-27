package org.konate.tpjavajee.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.konate.tpjavajee.model.Commune;
import org.konate.tpjavajee.model.Maire;

@Stateless
public class CommuneEJB {
	
	@PersistenceContext(unitName="jpa-test")
	private EntityManager em;
	
	
	public long createCommune(String name) {
		Commune commune = new Commune();
		commune.setNom(name);
		em.persist(commune);
		return commune.getId();
	}
	
	public Commune retrieveCommune(long id) {
		return em.find(Commune.class, id);
	}

	public Commune deleteCommune(long id) {
		Commune commune = em.find(Commune.class, id);
		em.remove(commune);
		return commune;
	}

	public void updateCommune(long id, String newName) {
		Commune commune = em.find(Commune.class, id);
		commune.setNom(newName);
	}

	public Commune linkCommuneToMaire(long communeId, long maireId) {
		Commune commune = retrieveCommune(communeId);
		commune.setMaire(em.find(Maire.class, maireId));
		
		return commune;
	}
	
	@SuppressWarnings("unchecked")
	public List<Commune> retrieveCommunes() {
		Query query = em.createNativeQuery("SELECT id, nom, maire FROM communes;");
		return query.getResultList();
	}
}
