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
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import pl.fis.szymon.gretka.container.BookEntityManager;
import pl.fis.szymon.gretka.entities.Book;

@Path("/")
public class DefaultEndopint {
	
	@Inject
	private BookEntityManager bookEntityManager;

	@GET
	@Path("books")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getListOfBooks() {
		return bookEntityManager.getBooks();
	}
	
	@POST
	@Path("books")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBook(Book book) {
		
		bookEntityManager.addBook(book);
	}
	
	@DELETE
	@Path("books/{id}")
	public void deleteBook(@PathParam("id") long id) {
		bookEntityManager.deleteBook(id);
	}
	
	@PUT
	@Path("books/{id}")
	public void updateBook(@PathParam("id") long id, Book book) {
		bookEntityManager.updateBook(id, book);
	}
	
	
	

}
