package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.FileItemTagLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FileItemTagLinkRepository extends JpaRepository<FileItemTagLink, UUID> {
    FileItemTagLink findFirstById(UUID id);
    FileItemTagLink findFirstByFileItemIdAndFixedTagEntityIdAndFixedTagObjectContextId(UUID fileItemId, UUID fixedTagEntityId, UUID fixedTagObjectContextId);
    List<FileItemTagLink> findAllByFileItemId(UUID fileItemId);
}
