package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FileEntityRepository extends JpaRepository<FileEntity, UUID> {
    FileEntity findFirstById(UUID fileEntityId);
    List<FileEntity> findDistinctByIdNotLike(UUID fileEntityId);
}
