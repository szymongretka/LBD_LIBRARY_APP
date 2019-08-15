package pl.fis.szymon.gretka.endpoints;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.fis.szymon.gretka.entities.Client;
import pl.fis.szymon.gretka.repositories.ClientEntityManager;

@Path("/clients")
public class ClientEndpoint {
	
	@Inject
	private ClientEntityManager clientEntityManager;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getListOfClients() {
		return clientEntityManager.getClients();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addClient(Client client) {
		
		clientEntityManager.addClient(client);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteClient(@PathParam("id") long id) {
		clientEntityManager.deleteClient(id);
	}
	
	@PUT
	@Path("/{id}")
	public void updateClient(@PathParam("id") long id, Client client) {
		clientEntityManager.updateClient(id, client);
	}
	
}
