package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.FileEntity;
import no.responseweb.imagearchive.model.FileEntityDto;
import org.mapstruct.Mapper;

@Mapper
public interface FileEntityMapper {
    FileEntity fileEntityDtoToFileEntity(FileEntityDto fileEntityDto);
    FileEntityDto fileEntityToFileEntityDto(FileEntity fileEntity);
}
