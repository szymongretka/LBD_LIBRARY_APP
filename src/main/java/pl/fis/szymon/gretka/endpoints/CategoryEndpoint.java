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

import pl.fis.szymon.gretka.entities.Category;
import pl.fis.szymon.gretka.repositories.CategoryEntityManager;

@Path("/categories")
public class CategoryEndpoint {
	
	@Inject
	private CategoryEntityManager categoryEntityManager;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getListOfCategories() {
		return categoryEntityManager.getCategories();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCategory(Category category) {
		
		categoryEntityManager.addCategory(category);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteCategory(@PathParam("id") long id) {
		categoryEntityManager.deleteCategory(id);
	}
	
	@PUT
	@Path("/{id}")
	public void updateCategory(@PathParam("id") long id, Category category) {
		categoryEntityManager.updateCategory(id, category);
	}

}
