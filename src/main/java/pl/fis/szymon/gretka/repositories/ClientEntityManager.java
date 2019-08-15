package pl.fis.szymon.gretka.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.fis.szymon.gretka.entities.Client;


@Stateless
public class ClientEntityManager {
	
	@PersistenceContext//(unitName = "postgres-pu")
	private EntityManager entityManager;
	
	public ClientEntityManager() {}
	
	public Client findClientById(int clientID) { 
		Client client = entityManager.find(Client.class, clientID); 
		return client;
	}
	
	public void addClient(Client client) {
        entityManager.persist(client);
    }

    public void deleteClient(long id) {
    	Client client = entityManager.find(Client.class, id); 
        entityManager.remove(client);
    }
    
    public void updateClient(long id, Client updatedClient) {
    	Client client = entityManager.find(Client.class, id); 
    	//book.addCategory(updatedBook.getCategories());
    	//client.setFirstName(updatedClient.getFirstName());
    	//client.setLastName(updatedClient.getLastName());
        entityManager.merge(client);
    }

   /* @SuppressWarnings("unchecked")
	public List<Client> findByCategory(Category category) {
        final Query query = entityManager.createQuery("SELECT c FROM CLIENT b WHERE b.category = :category");
        query.setParameter("category", category);
        return query.getResultList();
    }*/
    

    @SuppressWarnings("unchecked")
	public List<Client> getClients() {// throws Exception {
        Query query = entityManager.createQuery("SELECT c from CLIENT c");
        return query.getResultList();
    }


}

