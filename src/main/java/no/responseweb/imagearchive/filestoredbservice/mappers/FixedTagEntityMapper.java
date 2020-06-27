package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.FixedTagEntity;
import no.responseweb.imagearchive.model.FixedTagEntityDto;
import org.mapstruct.Mapper;

@Mapper
public interface FixedTagEntityMapper {
    FixedTagEntity fixedTagEntityDtoToFixedTagEntity(FixedTagEntityDto fixedTagEntityDto);
    FixedTagEntityDto fixedTagEntityToFixedTagEntityDto(FixedTagEntity fixedTagEntity);
}
