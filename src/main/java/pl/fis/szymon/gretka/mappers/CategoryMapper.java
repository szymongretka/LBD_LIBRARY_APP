package pl.fis.szymon.gretka.mappers;

import java.util.Set;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import pl.fis.szymon.gretka.dtos.CategoryDTO;
import pl.fis.szymon.gretka.entities.Category;

@Mapper(componentModel = "cdi")
public interface CategoryMapper {
	
	CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );
	
	@Mapping(source = "booksDTO", target = "books")
	Category mapToCategory(CategoryDTO categoryDTO);
	
    Set<Category> mapToCategorySet(Set<CategoryDTO> categoryDTOS);

    @InheritInverseConfiguration(name = "mapToCategory")
    CategoryDTO mapToCategoryDTO(Category category);
    
    @Mapping(source = "booksDTO", target = "books")
    void updateCategoryFromDTO(CategoryDTO categoryDTO, @MappingTarget Category category);
}
