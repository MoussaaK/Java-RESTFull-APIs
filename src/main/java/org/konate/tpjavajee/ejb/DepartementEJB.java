package org.konate.tpjavajee.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.konate.tpjavajee.model.Commune;
import org.konate.tpjavajee.model.Departement;

@Stateless
public class DepartementEJB {
	@PersistenceContext(unitName="jpa-test")
	private EntityManager em;

	public long createDepartement(String name) {
		Departement departement  = new Departement();
		departement.setNom(name);
		em.persist(departement);
		return departement.getId();
	}

	public Departement retrieveDepartement(long id) {
		return em.find(Departement.class, id);
	}

	public Departement deleteDepartement(long id) {
		Departement departement = em.find(Departement.class, id);
		em.remove(departement);
		return departement;
	}

	public void updateDepartement(long id, String newName) {
		Departement departement = em.find(Departement.class, id);
		departement.setNom(newName);
	}

	public Departement linkDepartementToCommunes(long idDepartement, long debutCodePostal) {
		Departement departement = em.find(Departement.class, idDepartement);
		for (Commune commune : departement.getCommunes()) {
			if(commune.getDpt().toString().startsWith(Long.toString(debutCodePostal)))
				commune.setDpt(departement);
		}
		return departement;
	}

	@SuppressWarnings("unchecked")
	public List<Departement> retrieveDepartements() {
		Query query = em.createNativeQuery("SELECT id, nom, code FROM departements;");
		return query.getResultList();
	}
}
