package pl.fis.szymon.gretka.endpoints;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.Valid;
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

import pl.fis.szymon.gretka.dtos.AuthorDTO;
import pl.fis.szymon.gretka.dtos.BookDTO;
import pl.fis.szymon.gretka.dtos.CategoryDTO;
import pl.fis.szymon.gretka.dtos.ClientDTO;
import pl.fis.szymon.gretka.entities.Author;
import pl.fis.szymon.gretka.entities.Book;
import pl.fis.szymon.gretka.entities.Category;
import pl.fis.szymon.gretka.entities.Client;
import pl.fis.szymon.gretka.exceptions.ResourceNotFound;
import pl.fis.szymon.gretka.mappers.AuthorMapper;
import pl.fis.szymon.gretka.mappers.BookMapper;
import pl.fis.szymon.gretka.mappers.CategoryMapper;
import pl.fis.szymon.gretka.mappers.ClientMapper;
import pl.fis.szymon.gretka.repositories.BookEntityManager;

@Path("/books")
public class BookEndopint {
	
	@Inject
	private BookEntityManager bookEntityManager;
	
	@Inject
	private BookMapper bookMapper;
	
	@Inject
	private CategoryMapper categoryMapper;
	
	@Inject
	private ClientMapper clientMapper;
	
	@Inject
	private AuthorMapper authorMapper;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListOfBooks() {
		
		Set<BookDTO> booksDTO = bookMapper.mapToBooksDTOs(bookEntityManager.getBooks());
	    return Response.status(Response.Status.OK).entity(booksDTO).build();
		
		//return bookEntityManager.getBooks();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public BookDTO getBookByID(@PathParam(value = "id") long id) {
		Book book = bookEntityManager.findBookById(id);

		if(book == null) {
			throw new ResourceNotFound("Resource with id: " + id + " has not been found!");
		}
		
		return bookMapper.mapToBookDTO(book);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBook(@Valid BookDTO bookDTO) {
		Book book = bookMapper.mapToBook(bookDTO);
		bookEntityManager.addBook(book);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteBook(@PathParam("id") long id) {
		bookEntityManager.deleteBook(id);
	}
	
	@PUT
	@Path("/{id}")
	public void updateBook(@PathParam("id") long id, BookDTO bookDTO) {
		Book book = bookMapper.mapToBook(bookDTO);
		bookEntityManager.updateBook(id, book);
	}
	
	@PUT
	@Path("/{id}/borrow")
	public void borrowBook(@PathParam("id") long id, ClientDTO clientDTO) {
		Client client = clientMapper.mapToClient(clientDTO);
		bookEntityManager.borrowBook(id, client);
	}
	
	@PUT
	@Path("/{id}/set-category")
	public void setNewCategoryBook(@PathParam("id") long id, CategoryDTO categoryDTO) {
		Category category = categoryMapper.mapToCategory(categoryDTO);
		bookEntityManager.setNewCategoryBook(id, category);
	}
	
	@PUT
	@Path("/{id}/set-author")
	public void setNewAuthorBook(@PathParam("id") long id, AuthorDTO authorDTO) {
		Author author = authorMapper.mapToAuthor(authorDTO);
		bookEntityManager.setNewAuthorBook(id, author);
	}
	
	

}
