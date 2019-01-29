package org.konate.tpjavajee.rest;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.konate.tpjavajee.ejb.DepartementEJB;
import org.konate.tpjavajee.model.Departement;
import org.konate.tpjavajee.rest.LINK.LINK;

@Path("departement")
public class DepartementRS {

	@EJB
	private DepartementEJB departementEJB;

	@GET @Path("retrieve/{id}")
	@Produces({
		MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON
	})
	public Response getMaire(@PathParam("id") long id) {
		Departement departement = departementEJB.retrieveDepartement(id);
		return Response.ok()
				.entity(departement)
				.build(); 
	}

	@POST @Path("create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("name") String nom){
		long id = departementEJB.createDepartement(nom);		
		return Response.ok()
				.entity("Departement created with ID : " + id)
				.build();
	}

	@POST @Path("update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response update(@FormParam("id") long id, @FormParam("name") String newName){
		departementEJB.updateDepartement(id, newName);		
		return Response.ok()
				.entity("Departement updated successfully")
				.build();
	}

	@GET @Path("delete/{id}")
	@Produces({
		MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON
	})
	public Response deleteMaire(@PathParam("id") long id) {
		departementEJB.deleteDepartement(id);
		return Response.ok()
				.entity("Departement with ID : " + id + " removed successfully")
				.build(); 
	}

	@LINK @Path("{idDepartement}/commune/codepostal/{codepostal}")
	@Produces({
		MediaType.APPLICATION_XML,
	})
	public Response link(@PathParam("idDepartement") long idDepartement, @PathParam("codepostal") long codepostal) {
		Departement departement = departementEJB.linkDepartementToCommunes(idDepartement, codepostal);
		return Response.ok()
				.entity(departement)
				.build(); 
	}
	
	@GET @Path("{id}/communes")
	@Produces({
		MediaType.APPLICATION_XML,
	})
	public Response getCommunes(@PathParam("id") long id) {
		Departement departement = departementEJB.retrieveDepartement(id);
		return Response.ok()
				.entity(departement.getCommunes())
				.build(); 
	}
	
	@GET @Path("all")
	@Produces({
		MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON
	})
	public Response getDepartements() {
		List<Departement> departements = departementEJB.retrieveDepartements();
		return Response.ok()
				.entity(departements)
				.build();
	}
}





