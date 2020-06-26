package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.ImageMetadataValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ImageMetadataValueRepository extends JpaRepository<ImageMetadataValue, UUID> {
    ImageMetadataValue findFirstById(UUID imageMetadataValueId);
    ImageMetadataValue findFirstByTagIdAndFileItemId(UUID imageMetadataTagId, UUID fileItemId);
    List<ImageMetadataValue> findAllByFileItemId(UUID fileItemId);
}
