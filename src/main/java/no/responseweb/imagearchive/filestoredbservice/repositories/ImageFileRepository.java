package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageFileRepository extends JpaRepository<ImageFile, UUID> {
    ImageFile findFirstById(UUID imageFileId);
}
