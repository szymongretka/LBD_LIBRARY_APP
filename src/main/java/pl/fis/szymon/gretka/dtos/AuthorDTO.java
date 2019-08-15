package pl.fis.szymon.gretka.dtos;

import java.io.Serializable;
import java.util.Set;


public class AuthorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
    private String firstName;
    private String lastName;
    private Set<BookDTO> booksDTO;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Set<BookDTO> getBooksDTO() {
		return booksDTO;
	}
	public void setBooksDTO(Set<BookDTO> booksDTO) {
		this.booksDTO = booksDTO;
	}
	
	
    
    
}
