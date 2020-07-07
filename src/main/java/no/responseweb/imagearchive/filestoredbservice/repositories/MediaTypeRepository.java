package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MediaTypeRepository extends JpaRepository<MediaType, UUID> {
    MediaType findFirstById(UUID mediaTypeId);
    MediaType findFirstByTypeAndSubtype(String type, String subtype);
}
