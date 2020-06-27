package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.FixedTagStructure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FixedTagStructureRepository extends JpaRepository<FixedTagStructure, UUID> {
    FixedTagStructure findFirstById(UUID id);
    FixedTagStructure findFirstByNameAndLanguageId(String name, UUID languageId);
    List<FixedTagStructure> findAllByParentId(UUID parentId);
}
