package no.responseweb.imagearchive.filestoredbservice.services;

import no.responseweb.imagearchive.model.FileEntityDto;

import java.util.List;
import java.util.UUID;

public interface FileEntityService {
    FileEntityDto findFirstById(UUID fileEntityId);
    FileEntityDto save(FileEntityDto fileEntityDto);
    List<FileEntityDto> findDistinctByIdNotLike(UUID fileEntityId);
    void deleteById(UUID fileEntityId);
}
