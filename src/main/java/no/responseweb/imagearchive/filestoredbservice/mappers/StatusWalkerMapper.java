package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.StatusWalker;
import no.responseweb.imagearchive.model.StatusWalkerDto;
import org.mapstruct.Mapper;

@Mapper
public interface StatusWalkerMapper {
    StatusWalker map(StatusWalkerDto tagDto);
    StatusWalkerDto map(StatusWalker tag);
}
