package pl.fis.szymon.gretka.mappers;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import pl.fis.szymon.gretka.dtos.BookDTO;
import pl.fis.szymon.gretka.dtos.CategoryDTO;
import pl.fis.szymon.gretka.dtos.ClientDTO;
import pl.fis.szymon.gretka.entities.Book;
import pl.fis.szymon.gretka.entities.Category;
import pl.fis.szymon.gretka.entities.Client;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-15T23:27:00+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@ApplicationScoped
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category mapToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        if ( category.getBooks() != null ) {
            Set<Book> set = bookDTOSetToBookSet( categoryDTO.getBooksDTO() );
            if ( set != null ) {
                category.getBooks().addAll( set );
            }
        }
        category.setId( categoryDTO.getId() );
        category.setName( categoryDTO.getName() );

        return category;
    }

    @Override
    public Set<Category> mapToCategorySet(Set<CategoryDTO> categoryDTOS) {
        if ( categoryDTOS == null ) {
            return null;
        }

        Set<Category> set = new HashSet<Category>( Math.max( (int) ( categoryDTOS.size() / .75f ) + 1, 16 ) );
        for ( CategoryDTO categoryDTO : categoryDTOS ) {
            set.add( mapToCategory( categoryDTO ) );
        }

        return set;
    }

    @Override
    public CategoryDTO mapToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setBooksDTO( bookSetToBookDTOSet( category.getBooks() ) );
        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );

        return categoryDTO;
    }

    @Override
    public void updateCategoryFromDTO(CategoryDTO categoryDTO, Category category) {
        if ( categoryDTO == null ) {
            return;
        }

        if ( category.getBooks() != null ) {
            category.getBooks().clear();
            Set<Book> set = bookDTOSetToBookSet( categoryDTO.getBooksDTO() );
            if ( set != null ) {
                category.getBooks().addAll( set );
            }
        }
        category.setId( categoryDTO.getId() );
        category.setName( categoryDTO.getName() );
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

    protected Book bookDTOToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDTO.getId() );
        book.setClient( clientDTOToClient( bookDTO.getClient() ) );
        book.setName( bookDTO.getName() );
        book.setBorrowed( bookDTO.isBorrowed() );

        return book;
    }

    protected Set<Book> bookDTOSetToBookSet(Set<BookDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Book> set1 = new HashSet<Book>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( BookDTO bookDTO : set ) {
            set1.add( bookDTOToBook( bookDTO ) );
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

    protected BookDTO bookToBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( book.getId() );
        bookDTO.setName( book.getName() );
        bookDTO.setBorrowed( book.isBorrowed() );
        bookDTO.setClient( clientToClientDTO( book.getClient() ) );

        return bookDTO;
    }

    protected Set<BookDTO> bookSetToBookDTOSet(Set<Book> set) {
        if ( set == null ) {
            return null;
        }

        Set<BookDTO> set1 = new HashSet<BookDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Book book : set ) {
            set1.add( bookToBookDTO( book ) );
        }

        return set1;
    }
}
