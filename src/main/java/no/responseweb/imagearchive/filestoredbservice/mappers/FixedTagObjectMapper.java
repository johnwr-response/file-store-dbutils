package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.FixedTagObject;
import no.responseweb.imagearchive.model.FixedTagObjectDto;
import org.mapstruct.Mapper;

@Mapper
public interface FixedTagObjectMapper {
    FixedTagObject fixedTagObjectDtoToFixedTagObject(FixedTagObjectDto fixedTagObjectDto);
    FixedTagObjectDto fixedTagObjectToFixedTagObjectDto(FixedTagObject fixedTagObject);
}
