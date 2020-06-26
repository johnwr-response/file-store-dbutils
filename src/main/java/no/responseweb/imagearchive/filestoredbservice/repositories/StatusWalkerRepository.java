package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.StatusWalker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface StatusWalkerRepository extends JpaRepository<StatusWalker, UUID> {
    List<StatusWalker> findAllByWalkerInstanceToken(UUID walkerInstanceToken);

    List<StatusWalker> findAllByFileStoreId(UUID fileStoreId);

    StatusWalker findFirstByFileStoreIdAndReadyIsTrue(UUID fileStoreId);

    StatusWalker findFirstByWalkerInstanceTokenAndFileStoreId(UUID walkerInstanceToken, UUID filePathId);

    List<StatusWalker> findAllByFileStoreIdAndLastActiveDateIsBefore(UUID fileStoreId, LocalDateTime cutoffDate);
}
