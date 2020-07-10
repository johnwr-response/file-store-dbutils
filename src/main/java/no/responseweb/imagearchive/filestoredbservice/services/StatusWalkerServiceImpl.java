package no.responseweb.imagearchive.filestoredbservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.responseweb.imagearchive.filestoredbservice.mappers.StatusWalkerMapper;
import no.responseweb.imagearchive.filestoredbservice.repositories.StatusWalkerRepository;
import no.responseweb.imagearchive.model.StatusWalkerDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class StatusWalkerServiceImpl implements StatusWalkerService {

    private final StatusWalkerRepository statusWalkerRepository;
    private final StatusWalkerMapper statusWalkerMapper;

    @Override
    public StatusWalkerDto findFirstByWalkerInstanceTokenAndFileStoreId(UUID walkerInstanceToken, UUID fileStoreId) {
        if (walkerInstanceToken==null || fileStoreId==null) return null;
        return statusWalkerMapper.map(
                statusWalkerRepository.findFirstByWalkerInstanceTokenAndFileStoreId(walkerInstanceToken, fileStoreId)
        );
    }

    @Override
    public List<StatusWalkerDto> findAllByFileStoreIdAndLastActiveDateIsBefore(UUID fileStoreId, LocalDateTime cutoffDate) {
        if (fileStoreId==null || cutoffDate==null) return new ArrayList<>();
        return statusWalkerRepository.findAllByFileStoreIdAndLastActiveDateIsBefore(fileStoreId, cutoffDate).stream()
                .map(statusWalkerMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public StatusWalkerDto save(StatusWalkerDto statusWalkerDto) {
        if (statusWalkerDto==null) return null;
        return statusWalkerMapper.map(statusWalkerRepository.saveAndFlush(statusWalkerMapper.map(statusWalkerDto)));
    }

    @Override
    public void deleteAllByFileStoreIdAndLastActiveDateIsBeforeInBatch(UUID fileStoreId, LocalDateTime cutoffDate) {
        if (fileStoreId!=null && cutoffDate!=null) {
            statusWalkerRepository.deleteInBatch(
                    statusWalkerRepository.findAllByFileStoreIdAndLastActiveDateIsBefore(
                            fileStoreId,
                            cutoffDate
                    )
            );
        }
    }
}
