package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.MediaType;
import no.responseweb.imagearchive.model.MediaTypeDto;
import org.mapstruct.Mapper;

@Mapper
public interface MediaTypeMapper {
    MediaType mediaTypeDtoToMediaType(MediaTypeDto mediaTypeDto);
    MediaTypeDto mediaTypeToMediaTypeDto(MediaType mediaType);
}
