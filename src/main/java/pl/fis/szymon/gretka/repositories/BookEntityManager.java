package pl.fis.szymon.gretka.repositories;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.fis.szymon.gretka.entities.Author;
import pl.fis.szymon.gretka.entities.Book;
import pl.fis.szymon.gretka.entities.Category;
import pl.fis.szymon.gretka.entities.Client;

@Stateless
public class BookEntityManager {
	
	protected final Logger log = Logger.getLogger(getClass().getName());
	
	@PersistenceContext//(unitName = "postgres-pu")
	private EntityManager entityManager;
	
	public BookEntityManager() {}
	
	public Book findBookById(long bookID) { 
		Book book = entityManager.find(Book.class, bookID); 
		return book;
	}
	
	public void addBook(Book book) {
        entityManager.persist(book);
    }

    public void deleteBook(long id) {
    	Book book = entityManager.find(Book.class, id); 
        entityManager.remove(book);
    }
    
    public void updateBook(long id, Book updatedBook) {
    	Book book = entityManager.find(Book.class, id); 
    	//book.addCategory(updatedBook.getCategories());
    	book.setName(updatedBook.getName());
        entityManager.merge(book);
    }
    
    public void borrowBook(long bookId, Client client) {
    	Book book = entityManager.find(Book.class, bookId);
    	if(book.isBorrowed()) {
    		log.info("is borrowed");
    	} else {
    		book.setClient(client);
    	}
    }
    

    @SuppressWarnings("unchecked")
	public List<Book> findByCategory(Category category) {
        final Query query = entityManager.createQuery("SELECT b FROM BOOK b WHERE b.category = :category");
        query.setParameter("category", category);
        return query.getResultList();
    }
    

    @SuppressWarnings("unchecked")
	public List<Book> getBooks() {// throws Exception {
        Query query = entityManager.createQuery("SELECT b from BOOK b");
        return query.getResultList();
    }

	public void setNewCategoryBook(long id, Category category) {
		Book book = entityManager.find(Book.class, id);
		book.addCategory(category);
	}

	public void setNewAuthorBook(long id, Author author) {
		Book book = entityManager.find(Book.class, id);
		book.addAuthor(author);
		
	}


}
