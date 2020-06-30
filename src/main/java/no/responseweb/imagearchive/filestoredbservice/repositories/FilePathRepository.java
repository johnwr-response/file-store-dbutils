package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.FilePath;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FilePathRepository extends JpaRepository<FilePath, UUID> {
    FilePath findFirstById(UUID filePathId);
    List<FilePath> findByFileStoreId(UUID fileStoreId);
    FilePath findByFileStoreIdAndRelativePath(UUID fileStoreId, String relativePath);
}
