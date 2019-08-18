package pl.fis.szymon.gretka.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;;


@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Entity(name = "BOOK")
public class Book { // implements Serializable {
	
	//private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "BOOK_ID") 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name", nullable = false, length = 50)
	@NotBlank
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "book_categories",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
	//@JsonManagedReference
    private Set<Category> categories = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "book_authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
	//@JsonManagedReference
    private Set<Author> authors = new HashSet<>();
	
	@Column(name = "isBorrowed", columnDefinition = "boolean default false")
	private boolean isBorrowed;

	private Date date_of_borrow;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	
	public Book() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	/*public void addClient(Client client) {
		client.getClientBooks().add(this);
	}*/
	
	public Client getClient() {
		return client;
	}

	
	public Set<Category> getCategories() {
		return categories;
	}
	

	public void addCategory(Category category) {
		categories.add(category);
		//category.getBooks().add(this);
	}
	
	public Set<Author> getAuthors() {
		return authors;
	}

	public void addAuthor(Author author) {
		authors.add(author);
		//author.getBooks().add(this);
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public Date getDate_of_borrow() {
		return date_of_borrow;
	}

	public void setDate_of_borrow(Date date_of_borrow) {
		this.date_of_borrow = date_of_borrow;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((date_of_borrow == null) ? 0 : date_of_borrow.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isBorrowed ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (date_of_borrow == null) {
			if (other.date_of_borrow != null)
				return false;
		} else if (!date_of_borrow.equals(other.date_of_borrow))
			return false;
		if (id != other.id)
			return false;
		if (isBorrowed != other.isBorrowed)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", "+ 
				", categories='" + categories.stream()
				.map(Category::getName)
				.collect(Collectors.toList()) + '\'' +
                '}';
	}*/

	

	
	
	
	
}
