package pl.fis.szymon.gretka.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "CLIENT")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CLIENT_ID") 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<Book> clientBooks = new HashSet<>();
	
	
	@Column(name = "firstname", nullable = false, length = 50) 
    private String firstName;
	
	
	@Column(name = "lastname", nullable = false, length = 50) 
    private String lastName;
	
    private String email;
    
    
    public Client() {}
    
    public Client(String firstName, String lastName, String email) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    }
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Book> getClientBooks() {
		return clientBooks;
	}
	public void addBookToClient(Book book) {
		//clientBooks.add(book);
		//book.addClient(this);
		book.setClient(this);
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientBooks == null) ? 0 : clientBooks.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (clientBooks == null) {
			if (other.clientBooks != null)
				return false;
		} else if (!clientBooks.equals(other.clientBooks))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", clientBooks=" + clientBooks + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}

}
