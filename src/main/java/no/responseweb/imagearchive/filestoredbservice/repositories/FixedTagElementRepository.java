package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.FixedTagElement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FixedTagElementRepository extends JpaRepository<FixedTagElement, UUID> {
    FixedTagElement findFirstById(UUID id);
    FixedTagElement findFirstByNameAndLanguageId(String name, UUID languageId);
}
