package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.ImageMetadataDirectory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ImageMetadataDirectoryRepository extends JpaRepository<ImageMetadataDirectory, UUID> {
    ImageMetadataDirectory findFirstById(UUID imageMetadataDirectoryId);
    ImageMetadataDirectory findFirstByName(String imageMetadataDirectoryName);
    List<ImageMetadataDirectory> findAllByCollectionId(UUID imageMetadataCollectionId);
}
