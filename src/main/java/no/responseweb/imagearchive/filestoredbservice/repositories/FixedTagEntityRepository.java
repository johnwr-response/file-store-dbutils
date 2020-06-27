package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.FixedTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FixedTagEntityRepository extends JpaRepository<FixedTagEntity, UUID> {
    FixedTagEntity findFirstById(UUID id);
    List<FixedTagEntity> findAllByFixedTagStructureId(UUID fixedTagStructureId);
}
