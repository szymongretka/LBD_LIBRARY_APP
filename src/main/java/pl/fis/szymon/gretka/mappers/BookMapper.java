package pl.fis.szymon.gretka.mappers;

import java.util.List;
import java.util.Set;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import pl.fis.szymon.gretka.dtos.BookDTO;
import pl.fis.szymon.gretka.entities.Book;

@Mapper(componentModel = "cdi")
public interface BookMapper {
	
	//BookMapper INSTANCE = Mappers.getMapper( BookMapper.class );
	
	@Mappings({
		@Mapping(source = "categoriesDTO", target = "categories"),
		@Mapping(source = "authorsDTO", target = "authors")
	})
	Book mapToBook(BookDTO bookDTO);
	
	Set<Book> mapToBookSet(List<BookDTO> bookDTOS);
	
	@InheritInverseConfiguration(name = "mapToBook")
    BookDTO mapToBookDTO(Book book);
	
	
	@Mappings({
		@Mapping(source = "categoriesDTO", target = "categories"),
		@Mapping(source = "authorsDTO", target = "authors")
	})
	void updateBookFromDTO(BookDTO bookDTO, @MappingTarget Book book);
	
	
	
	Set<Book> mapToBooks(List<BookDTO> booksDTO);

	@InheritInverseConfiguration(name = "mapToBooks")
	Set<BookDTO> mapToBooksDTOs(List<Book> books);
	
}
