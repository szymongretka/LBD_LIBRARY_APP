package pl.fis.szymon.gretka.mappers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import pl.fis.szymon.gretka.dtos.AuthorDTO;
import pl.fis.szymon.gretka.dtos.BookDTO;
import pl.fis.szymon.gretka.dtos.CategoryDTO;
import pl.fis.szymon.gretka.dtos.ClientDTO;
import pl.fis.szymon.gretka.entities.Author;
import pl.fis.szymon.gretka.entities.Book;
import pl.fis.szymon.gretka.entities.Category;
import pl.fis.szymon.gretka.entities.Client;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-15T23:27:01+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@ApplicationScoped
public class BookMapperImpl implements BookMapper {

    @Override
    public Book mapToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setCategories( categoryDTOSetToCategorySet( bookDTO.getCategoriesDTO() ) );
        book.setAuthors( authorDTOSetToAuthorSet( bookDTO.getAuthorsDTO() ) );
        book.setId( bookDTO.getId() );
        book.setClient( clientDTOToClient( bookDTO.getClient() ) );
        book.setName( bookDTO.getName() );
        book.setBorrowed( bookDTO.isBorrowed() );

        return book;
    }

    @Override
    public Set<Book> mapToBookSet(List<BookDTO> bookDTOS) {
        if ( bookDTOS == null ) {
            return null;
        }

        Set<Book> set = new HashSet<Book>( Math.max( (int) ( bookDTOS.size() / .75f ) + 1, 16 ) );
        for ( BookDTO bookDTO : bookDTOS ) {
            set.add( mapToBook( bookDTO ) );
        }

        return set;
    }

    @Override
    public BookDTO mapToBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setAuthorsDTO( authorSetToAuthorDTOSet( book.getAuthors() ) );
        bookDTO.setCategoriesDTO( categorySetToCategoryDTOSet( book.getCategories() ) );
        bookDTO.setId( book.getId() );
        bookDTO.setName( book.getName() );
        bookDTO.setBorrowed( book.isBorrowed() );
        bookDTO.setClient( clientToClientDTO( book.getClient() ) );

        return bookDTO;
    }

    @Override
    public void updateBookFromDTO(BookDTO bookDTO, Book book) {
        if ( bookDTO == null ) {
            return;
        }

        if ( book.getCategories() != null ) {
            Set<Category> set = categoryDTOSetToCategorySet( bookDTO.getCategoriesDTO() );
            if ( set != null ) {
                book.getCategories().clear();
                book.getCategories().addAll( set );
            }
            else {
                book.setCategories( null );
            }
        }
        else {
            Set<Category> set = categoryDTOSetToCategorySet( bookDTO.getCategoriesDTO() );
            if ( set != null ) {
                book.setCategories( set );
            }
        }
        if ( book.getAuthors() != null ) {
            Set<Author> set1 = authorDTOSetToAuthorSet( bookDTO.getAuthorsDTO() );
            if ( set1 != null ) {
                book.getAuthors().clear();
                book.getAuthors().addAll( set1 );
            }
            else {
                book.setAuthors( null );
            }
        }
        else {
            Set<Author> set1 = authorDTOSetToAuthorSet( bookDTO.getAuthorsDTO() );
            if ( set1 != null ) {
                book.setAuthors( set1 );
            }
        }
        book.setId( bookDTO.getId() );
        if ( bookDTO.getClient() != null ) {
            if ( book.getClient() == null ) {
                book.setClient( new Client() );
            }
            clientDTOToClient1( bookDTO.getClient(), book.getClient() );
        }
        else {
            book.setClient( null );
        }
        book.setName( bookDTO.getName() );
        book.setBorrowed( bookDTO.isBorrowed() );
    }

    protected Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setName( categoryDTO.getName() );

        return category;
    }

    protected Set<Category> categoryDTOSetToCategorySet(Set<CategoryDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Category> set1 = new HashSet<Category>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CategoryDTO categoryDTO : set ) {
            set1.add( categoryDTOToCategory( categoryDTO ) );
        }

        return set1;
    }

    protected Author authorDTOToAuthor(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDTO.getId() );
        author.setFirstName( authorDTO.getFirstName() );
        author.setLastName( authorDTO.getLastName() );

        return author;
    }

    protected Set<Author> authorDTOSetToAuthorSet(Set<AuthorDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Author> set1 = new HashSet<Author>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AuthorDTO authorDTO : set ) {
            set1.add( authorDTOToAuthor( authorDTO ) );
        }

        return set1;
    }

    protected Client clientDTOToClient(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDTO.getId() );
        client.setFirstName( clientDTO.getFirstName() );
        client.setLastName( clientDTO.getLastName() );
        client.setEmail( clientDTO.getEmail() );

        return client;
    }

    protected AuthorDTO authorToAuthorDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId( author.getId() );
        authorDTO.setFirstName( author.getFirstName() );
        authorDTO.setLastName( author.getLastName() );

        return authorDTO;
    }

    protected Set<AuthorDTO> authorSetToAuthorDTOSet(Set<Author> set) {
        if ( set == null ) {
            return null;
        }

        Set<AuthorDTO> set1 = new HashSet<AuthorDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Author author : set ) {
            set1.add( authorToAuthorDTO( author ) );
        }

        return set1;
    }

    protected CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );

        return categoryDTO;
    }

    protected Set<CategoryDTO> categorySetToCategoryDTOSet(Set<Category> set) {
        if ( set == null ) {
            return null;
        }

        Set<CategoryDTO> set1 = new HashSet<CategoryDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Category category : set ) {
            set1.add( categoryToCategoryDTO( category ) );
        }

        return set1;
    }

    protected ClientDTO clientToClientDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId( client.getId() );
        clientDTO.setFirstName( client.getFirstName() );
        clientDTO.setLastName( client.getLastName() );
        clientDTO.setEmail( client.getEmail() );

        return clientDTO;
    }

    protected void clientDTOToClient1(ClientDTO clientDTO, Client mappingTarget) {
        if ( clientDTO == null ) {
            return;
        }

        mappingTarget.setId( clientDTO.getId() );
        mappingTarget.setFirstName( clientDTO.getFirstName() );
        mappingTarget.setLastName( clientDTO.getLastName() );
        mappingTarget.setEmail( clientDTO.getEmail() );
    }
}
