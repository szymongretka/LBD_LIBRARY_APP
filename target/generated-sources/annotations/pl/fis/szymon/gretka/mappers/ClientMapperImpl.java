package pl.fis.szymon.gretka.mappers;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import pl.fis.szymon.gretka.dtos.BookDTO;
import pl.fis.szymon.gretka.dtos.ClientDTO;
import pl.fis.szymon.gretka.entities.Book;
import pl.fis.szymon.gretka.entities.Client;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-16T09:56:50+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@ApplicationScoped
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client mapToClient(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        if ( client.getClientBooks() != null ) {
            Set<Book> set = bookDTOSetToBookSet( clientDTO.getClientBooksDTO() );
            if ( set != null ) {
                client.getClientBooks().addAll( set );
            }
        }
        client.setId( clientDTO.getId() );
        client.setFirstName( clientDTO.getFirstName() );
        client.setLastName( clientDTO.getLastName() );
        client.setEmail( clientDTO.getEmail() );

        return client;
    }

    @Override
    public ClientDTO mapToClientDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setClientBooksDTO( bookSetToBookDTOSet( client.getClientBooks() ) );
        clientDTO.setId( client.getId() );
        clientDTO.setFirstName( client.getFirstName() );
        clientDTO.setLastName( client.getLastName() );
        clientDTO.setEmail( client.getEmail() );

        return clientDTO;
    }

    @Override
    public void updateClientFromDTO(ClientDTO clientDTO, Client client) {
        if ( clientDTO == null ) {
            return;
        }

        if ( client.getClientBooks() != null ) {
            client.getClientBooks().clear();
            Set<Book> set = bookDTOSetToBookSet( clientDTO.getClientBooksDTO() );
            if ( set != null ) {
                client.getClientBooks().addAll( set );
            }
        }
        client.setId( clientDTO.getId() );
        client.setFirstName( clientDTO.getFirstName() );
        client.setLastName( clientDTO.getLastName() );
        client.setEmail( clientDTO.getEmail() );
    }

    protected Book bookDTOToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDTO.getId() );
        book.setClient( mapToClient( bookDTO.getClient() ) );
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

    protected BookDTO bookToBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( book.getId() );
        bookDTO.setName( book.getName() );
        bookDTO.setBorrowed( book.isBorrowed() );
        bookDTO.setClient( mapToClientDTO( book.getClient() ) );

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
