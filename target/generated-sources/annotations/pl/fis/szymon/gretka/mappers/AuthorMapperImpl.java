package pl.fis.szymon.gretka.mappers;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import pl.fis.szymon.gretka.dtos.AuthorDTO;
import pl.fis.szymon.gretka.dtos.BookDTO;
import pl.fis.szymon.gretka.dtos.ClientDTO;
import pl.fis.szymon.gretka.entities.Author;
import pl.fis.szymon.gretka.entities.Book;
import pl.fis.szymon.gretka.entities.Client;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-16T09:56:50+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@ApplicationScoped
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author mapToAuthor(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setBooks( bookDTOSetToBookSet( authorDTO.getBooksDTO() ) );
        author.setId( authorDTO.getId() );
        author.setFirstName( authorDTO.getFirstName() );
        author.setLastName( authorDTO.getLastName() );

        return author;
    }

    @Override
    public Set<Author> mapToAuthorSet(Set<AuthorDTO> authorDTOS) {
        if ( authorDTOS == null ) {
            return null;
        }

        Set<Author> set = new HashSet<Author>( Math.max( (int) ( authorDTOS.size() / .75f ) + 1, 16 ) );
        for ( AuthorDTO authorDTO : authorDTOS ) {
            set.add( mapToAuthor( authorDTO ) );
        }

        return set;
    }

    @Override
    public AuthorDTO mapToAuthorDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setBooksDTO( bookSetToBookDTOSet( author.getBooks() ) );
        authorDTO.setId( author.getId() );
        authorDTO.setFirstName( author.getFirstName() );
        authorDTO.setLastName( author.getLastName() );

        return authorDTO;
    }

    @Override
    public void updateAuthorFromDTO(AuthorDTO authorDTO, Author author) {
        if ( authorDTO == null ) {
            return;
        }

        if ( author.getBooks() != null ) {
            Set<Book> set = bookDTOSetToBookSet( authorDTO.getBooksDTO() );
            if ( set != null ) {
                author.getBooks().clear();
                author.getBooks().addAll( set );
            }
            else {
                author.setBooks( null );
            }
        }
        else {
            Set<Book> set = bookDTOSetToBookSet( authorDTO.getBooksDTO() );
            if ( set != null ) {
                author.setBooks( set );
            }
        }
        author.setId( authorDTO.getId() );
        author.setFirstName( authorDTO.getFirstName() );
        author.setLastName( authorDTO.getLastName() );
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
