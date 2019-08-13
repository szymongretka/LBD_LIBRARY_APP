package pl.fis.szymon.gretka.container;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pl.fis.szymon.gretka.entities.Book;
import pl.fis.szymon.gretka.entities.Category;

@Stateless
public class BookEntityManager {
	
	@PersistenceContext//(unitName = "postgres-pu")
	private EntityManager entityManager;
	
	public BookEntityManager() {}
	
	public Book findBookById(int bookID) { 
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


}
