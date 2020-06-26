package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.ImageMetadataCollection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageMetadataCollectionRepository extends JpaRepository<ImageMetadataCollection, UUID> {
    ImageMetadataCollection findFirstById(UUID imageMetadataCollectionId);
    ImageMetadataCollection findFirstByName(String imageMetadataCollectionName);
}
