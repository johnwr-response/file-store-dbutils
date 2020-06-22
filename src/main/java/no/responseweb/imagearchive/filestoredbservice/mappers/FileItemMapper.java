package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.FileItem;
import no.responseweb.imagearchive.model.FileItemDto;
import org.mapstruct.Mapper;

// @Mapper(uses = {DateMapper.class})
@Mapper
public interface FileItemMapper {
    FileItem fileItemDtoToFileItem(FileItemDto fileItemDto);
    FileItemDto fileItemToFileItemDto(FileItem fileItem);
}
