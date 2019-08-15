package pl.fis.szymon.gretka.dtos;

import java.io.Serializable;
import java.util.Set;

public class CategoryDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private int id;
    private String name;
    private Set<BookDTO> booksDTO;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<BookDTO> getBooksDTO() {
		return booksDTO;
	}
	public void setBooksDTO(Set<BookDTO> booksDTO) {
		this.booksDTO = booksDTO;
	}
	
	
    
    
}
