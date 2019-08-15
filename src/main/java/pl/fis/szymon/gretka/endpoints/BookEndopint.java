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

import pl.fis.szymon.gretka.entities.Author;
import pl.fis.szymon.gretka.entities.Book;
import pl.fis.szymon.gretka.entities.Category;
import pl.fis.szymon.gretka.entities.Client;
import pl.fis.szymon.gretka.repositories.BookEntityManager;

@Path("/books")
public class BookEndopint {
	
	@Inject
	private BookEntityManager bookEntityManager;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getListOfBooks() {
		return bookEntityManager.getBooks();
	}
	
	@POST
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
	@Path("/{id}")
	public void updateBook(@PathParam("id") long id, Book book) {
		bookEntityManager.updateBook(id, book);
	}
	
	@PUT
	@Path("/{id}/borrow")
	public void borrowBook(@PathParam("id") long id, Client client) {
		bookEntityManager.borrowBook(id, client);
	}
	
	@PUT
	@Path("/{id}/set-category")
	public void setNewCategoryBook(@PathParam("id") long id, Category category) {
		bookEntityManager.setNewCategoryBook(id, category);
	}
	
	@PUT
	@Path("/{id}/set-author")
	public void setNewAuthorBook(@PathParam("id") long id, Author author) {
		bookEntityManager.setNewAuthorBook(id, author);
	}
	
	

}
