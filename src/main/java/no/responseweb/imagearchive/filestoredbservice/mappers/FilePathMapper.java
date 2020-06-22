package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.FilePath;
import no.responseweb.imagearchive.model.FilePathDto;
import org.mapstruct.Mapper;

@Mapper
public interface FilePathMapper {
    FilePath filePathDtoToFilePath(FilePathDto filePathDto);
    FilePathDto filePathToFilePathDto(FilePath filePath);
}
