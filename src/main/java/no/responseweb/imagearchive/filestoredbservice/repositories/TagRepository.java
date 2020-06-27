package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
    Tag findFirstById(UUID id);
    Tag findFirstByValue(String value);
}
