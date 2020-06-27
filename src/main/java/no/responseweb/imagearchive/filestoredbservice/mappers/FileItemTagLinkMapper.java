package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.FileItemTagLink;
import no.responseweb.imagearchive.model.FileItemTagLinkDto;
import org.mapstruct.Mapper;

@Mapper
public interface FileItemTagLinkMapper {
    FileItemTagLink fileItemTagLinkDtoToFileItemTagLink(FileItemTagLinkDto fileItemTagLinkDto);
    FileItemTagLinkDto fileItemTagLinkToFileItemTagLinkDto(FileItemTagLink fileItemTagLink);
}
