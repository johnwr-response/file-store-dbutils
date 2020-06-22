package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.FileStore;
import no.responseweb.imagearchive.model.FileStoreDto;
import org.mapstruct.Mapper;

@Mapper
public interface FileStoreMapper {
    FileStore fileStoreDtoToFileStore(FileStoreDto fileStoreDto);
    FileStoreDto fileStoreToFileStoreDto(FileStore fileStore);
}
