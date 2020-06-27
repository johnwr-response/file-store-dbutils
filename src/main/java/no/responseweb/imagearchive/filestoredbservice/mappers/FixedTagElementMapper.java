package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.FixedTagElement;
import no.responseweb.imagearchive.model.FixedTagElementDto;
import org.mapstruct.Mapper;

@Mapper
public interface FixedTagElementMapper {
    FixedTagElement fixedTagElementDtoToFixedTagElement(FixedTagElementDto fixedTagElementDto);
    FixedTagElementDto fixedTagElementToFixedTagElementDto(FixedTagElement fixedTagElement);
}
