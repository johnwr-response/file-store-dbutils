package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.FileItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FileItemRepository extends JpaRepository<FileItem, UUID> {
    FileItem findFirstById(UUID fileItemId);
    List<FileItem> findAllByFileStorePathId(UUID filePathId);
}
