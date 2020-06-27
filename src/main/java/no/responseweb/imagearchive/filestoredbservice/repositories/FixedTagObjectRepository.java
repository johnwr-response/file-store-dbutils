package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.FixedTagObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FixedTagObjectRepository extends JpaRepository<FixedTagObject, UUID> {
    FixedTagObject findFirstById(UUID id);
    FixedTagObject findFirstByNameAndFixedTagStructureIdAndLanguageId(String name, UUID fixedTagStructureId, UUID languageId);
    List<FixedTagObject> findAllByFixedTagStructureId(UUID fixedTagStructureId);
}
