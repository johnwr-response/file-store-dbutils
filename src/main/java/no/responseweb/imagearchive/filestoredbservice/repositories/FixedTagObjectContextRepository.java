package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.FixedTagObjectContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FixedTagObjectContextRepository extends JpaRepository<FixedTagObjectContext, UUID> {
    FixedTagObjectContext findFirstById(UUID id);
    FixedTagObjectContext findFirstByFixedTagObjectIdAndFixedTagElementId(UUID fixedTagObjectId, UUID fixedTagElementId);
    List<FixedTagObjectContext> findAllByFixedTagObjectId(UUID fixedTagObjectId);
}
