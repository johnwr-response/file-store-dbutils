package no.responseweb.imagearchive.filestoredbservice.services;

import no.responseweb.imagearchive.model.FilePathDto;
import no.responseweb.imagearchive.model.FileStoreDto;

public interface FilePathService {
    FilePathDto save(FilePathDto filePathDto);
    FilePathDto findFirstById(FilePathDto filePathDto);
    FilePathDto findByFileStoreIdAndRelativePath(FileStoreDto fileStoreDto, FilePathDto filePathDto);
}
