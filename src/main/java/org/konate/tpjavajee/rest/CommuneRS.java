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

import org.konate.tpjavajee.ejb.CommuneEJB;
import org.konate.tpjavajee.model.Commune;
import org.konate.tpjavajee.rest.LINK.LINK;

@Path("commune")
public class CommuneRS {

	@EJB
	private CommuneEJB communeEJB;

	@GET @Path("retrieve/{id}")
	@Produces({
		MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON
	})
	public Response getCommune(@PathParam("id") long id) {
		return Response.ok()
				.entity(communeEJB.retrieveCommune(id))
				.build(); 
	}
	
	@GET @Path("all")
	@Produces({
		MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON
	})
	public Response getCommunes() {
		List<Commune> communes = communeEJB.retrieveCommunes();
		return Response.ok()
				.entity(communes)
				.build();
	}

	@POST @Path("create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("name") String nom){
		long id = communeEJB.createCommune(nom);		
		return Response.ok()
				.entity("commune creee avec l'id " + id)
				.build();
	}

	@POST @Path("update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response update(@FormParam("id") long id, @FormParam("name") String newName){
		communeEJB.updateCommune(id, newName);		
		return Response.ok()
				.entity("commune updated successfully")
				.build();
	}

	@GET @Path("delete/{id}")
	@Produces({
		MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON
	})
	public Response deleteCommune(@PathParam("id") long id) {
		communeEJB.deleteCommune(id);
		return Response.ok()
				.entity("Commune with ID : " + id + " removed successfully")
				.build(); 
	}

	@LINK @Path("{idCommune}/maire/{idMaire}")
	@Produces({
		MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON
	})
	public Response link(@PathParam("idCommune") long idCommune, @PathParam("idMaire") long idMaire) {
		return Response.ok()
				.entity(communeEJB.linkCommuneToMaire(idCommune, idMaire))
				.build(); 
	}
}





