package pl.fis.szymon.gretka.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import pl.fis.szymon.gretka.dtos.ClientDTO;
import pl.fis.szymon.gretka.entities.Client;

@Mapper(componentModel = "cdi")
public interface ClientMapper {

	ClientMapper INSTANCE = Mappers.getMapper( ClientMapper.class );
	
	@Mapping(source = "clientBooksDTO", target = "clientBooks")
	Client mapToClient(ClientDTO clientDTO);
	
	@InheritInverseConfiguration(name = "mapToClient")
	ClientDTO mapToClientDTO(Client client);
	
	@Mapping(source = "clientBooksDTO", target = "clientBooks")
	void updateClientFromDTO(ClientDTO clientDTO, @MappingTarget Client client);
}
