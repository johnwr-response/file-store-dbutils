package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.ImageMetadataTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ImageMetadataTagRepository extends JpaRepository<ImageMetadataTag, UUID> {
    ImageMetadataTag findFirstById(UUID imageMetadataTagId);
    ImageMetadataTag findFirstByTagDec(Integer imageMetadataTagDec);
    ImageMetadataTag findFirstByKeyName(String imageMetadataTagKeyName);
    ImageMetadataTag findFirstByDirectoryIdAndKeyName(UUID imageMetadataDirectoryId, String imageMetadataTagKeyName);
    List<ImageMetadataTag> findAllByDirectoryId(UUID imageMetadataDirectoryId);
}
