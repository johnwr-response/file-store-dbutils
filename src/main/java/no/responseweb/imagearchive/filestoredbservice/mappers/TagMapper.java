package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.Tag;
import no.responseweb.imagearchive.model.TagDto;
import org.mapstruct.Mapper;

@Mapper
public interface TagMapper {
    Tag tagDtoToTag(TagDto tagDto);
    TagDto tagToTagDto(Tag tag);
}
