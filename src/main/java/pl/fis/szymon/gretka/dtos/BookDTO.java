package pl.fis.szymon.gretka.dtos;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private Set<CategoryDTO> categoriesDTO;
	private Set<AuthorDTO> authorsDTO;
	private boolean isBorrowed;
	private ClientDTO client;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<CategoryDTO> getCategoriesDTO() {
		return categoriesDTO;
	}
	public void setCategoriesDTO(Set<CategoryDTO> categoriesDTO) {
		this.categoriesDTO = categoriesDTO;
	}
	public Set<AuthorDTO> getAuthorsDTO() {
		return authorsDTO;
	}
	public void setAuthorsDTO(Set<AuthorDTO> authorsDTO) {
		this.authorsDTO = authorsDTO;
	}
	public boolean isBorrowed() {
		return isBorrowed;
	}
	@JsonProperty
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	public ClientDTO getClient() {
		return client;
	}
	public void setClient(ClientDTO client) {
		this.client = client;
	}
	
	
}
