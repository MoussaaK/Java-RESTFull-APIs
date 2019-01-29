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

import org.konate.tpjavajee.ejb.MaireEJB;
import org.konate.tpjavajee.model.Maire;

@Path("maire")
public class MaireRS {

	@EJB
	private MaireEJB maireEJB;

	@GET @Path("retrieve/{id}")
	@Produces({
				MediaType.APPLICATION_XML,
			    MediaType.APPLICATION_JSON
			  })
	public Response getMaire(@PathParam("id") long id) {
		return Response.ok()
				.entity(maireEJB.retrieveMaire(id))
				.build(); 
	}

	@POST @Path("create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("name") String nom){
		long id = maireEJB.createMaire(nom);		
		return Response.ok()
				.entity("maire creee avec l'id " + id)
				.build();
	}
	
	@POST @Path("update")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response update(@FormParam("id") long id, @FormParam("name") String newName){
		maireEJB.updateMaire(id, newName);		
		return Response.ok()
				.entity("maire updated successfully")
				.build();
	}
	
	@GET @Path("delete/{id}")
	@Produces({
				MediaType.APPLICATION_XML,
			    MediaType.APPLICATION_JSON
			  })
	public Response deleteMaire(@PathParam("id") long id) {
		maireEJB.deleteMaire(id);
		return Response.ok()
				.entity("Maire with ID : " + id + " removed successfully")
				.build(); 
	}
	
	@GET @Path("all")
	@Produces({
		MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON
	})
	public Response getMaires() {
		List<Maire> maires = maireEJB.retrieveMaires();
		return Response.ok()
				.entity(maires)
				.build();
	}

}





