package pl.fis.szymon.gretka.dtos;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Set<BookDTO> clientBooksDTO;
	private String firstName;
	private String lastName;	
    private String email;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Set<BookDTO> getClientBooksDTO() {
		return clientBooksDTO;
	}
	public void setClientBooksDTO(Set<BookDTO> clientBooksDTO) {
		this.clientBooksDTO = clientBooksDTO;
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
    
    
}
