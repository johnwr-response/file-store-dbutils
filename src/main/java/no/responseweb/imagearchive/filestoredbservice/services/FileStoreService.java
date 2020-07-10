package no.responseweb.imagearchive.filestoredbservice.services;

import no.responseweb.imagearchive.model.FileStoreDto;

public interface FileStoreService {
    FileStoreDto save(FileStoreDto fileStoreDto);
    FileStoreDto findFirstById(FileStoreDto fileStoreDto);
}
