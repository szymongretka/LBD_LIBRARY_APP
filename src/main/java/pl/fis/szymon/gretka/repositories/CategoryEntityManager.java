package pl.fis.szymon.gretka.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.fis.szymon.gretka.entities.Category;

@Stateless
public class CategoryEntityManager {
	
	@PersistenceContext//(unitName = "postgres-pu")
	private EntityManager entityManager;
	
	public CategoryEntityManager() {}
	
	public Category findCategoryById(int categoryID) { 
		Category category = entityManager.find(Category.class, categoryID); 
		return category;
	}
	
	public void addCategory(Category category) {
        entityManager.persist(category);
    }

    public void deleteCategory(long id) {
    	Category category = entityManager.find(Category.class, id); 
        entityManager.remove(category);
    }
    
    public void updateCategory(long id, Category updatedCategory) {
    	Category category = entityManager.find(Category.class, id); 
    	//book.addCategory(updatedBook.getCategories());
    	//client.setFirstName(updatedClient.getFirstName());
    	//client.setLastName(updatedClient.getLastName());
        entityManager.merge(category);
    }

   /* @SuppressWarnings("unchecked")
	public List<Client> findByCategory(Category category) {
        final Query query = entityManager.createQuery("SELECT c FROM CLIENT b WHERE b.category = :category");
        query.setParameter("category", category);
        return query.getResultList();
    }*/
    

    @SuppressWarnings("unchecked")
	public List<Category> getCategories() {// throws Exception {
        Query query = entityManager.createQuery("SELECT c from CATEGORY c");
        return query.getResultList();
    }


}