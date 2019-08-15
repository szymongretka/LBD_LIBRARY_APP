package pl.fis.szymon.gretka.mappers;

import java.util.Set;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import pl.fis.szymon.gretka.dtos.AuthorDTO;
import pl.fis.szymon.gretka.entities.Author;


@Mapper(componentModel = "cdi")
public interface AuthorMapper {
	
	AuthorMapper INSTANCE = Mappers.getMapper( AuthorMapper.class );
	
	@Mapping(source = "booksDTO", target = "books")
	Author mapToAuthor(AuthorDTO authorDTO);
	
    Set<Author> mapToAuthorSet(Set<AuthorDTO> authorDTOS);

    @InheritInverseConfiguration(name = "mapToAuthor")
    AuthorDTO mapToAuthorDTO(Author author);
    
    
    @Mapping(source = "booksDTO", target = "books")
    void updateAuthorFromDTO(AuthorDTO authorDTO, @MappingTarget Author author);
}
