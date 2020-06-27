package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.FixedTagObjectContext;
import no.responseweb.imagearchive.model.FixedTagObjectContextDto;
import org.mapstruct.Mapper;

@Mapper
public interface FixedTagObjectContextMapper {
    FixedTagObjectContext fixedTagObjectContextDtoToFixedTagObjectContext(FixedTagObjectContextDto fixedTagObjectContextDto);
    FixedTagObjectContextDto fixedTagObjectContextToFixedTagObjectContextDto(FixedTagObjectContext fixedTagObjectContext);
}
