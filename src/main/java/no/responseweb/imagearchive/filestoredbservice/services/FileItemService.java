package no.responseweb.imagearchive.filestoredbservice.services;

import no.responseweb.imagearchive.model.FileItemDto;

public interface FileItemService {
    FileItemDto save(FileItemDto fileItemDto);
    FileItemDto findFirstById(FileItemDto fileItemDto);
    void delete(FileItemDto fileItemDto);
}
