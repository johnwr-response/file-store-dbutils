package no.responseweb.imagearchive.filestoredbservice.repositories;

import no.responseweb.imagearchive.filestoredbservice.domain.FileStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileStoreRepository extends JpaRepository<FileStore, UUID> {
    FileStore findFirstById(UUID id);
    FileStore findByNickname(String fileStoreNickname);
}
