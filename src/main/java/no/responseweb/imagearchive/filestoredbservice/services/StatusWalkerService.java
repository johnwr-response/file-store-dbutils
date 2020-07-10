package no.responseweb.imagearchive.filestoredbservice.services;

import no.responseweb.imagearchive.model.StatusWalkerDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface StatusWalkerService {
    StatusWalkerDto findFirstByWalkerInstanceTokenAndFileStoreId(UUID walkerInstanceToken, UUID fileStoreId);
    List<StatusWalkerDto> findAllByFileStoreIdAndLastActiveDateIsBefore(UUID fileStoreId, LocalDateTime cutoffDate);
    StatusWalkerDto save(StatusWalkerDto statusWalkerDto);
    void deleteAllByFileStoreIdAndLastActiveDateIsBeforeInBatch(UUID fileStoreId, LocalDateTime cutoffDate);
}
