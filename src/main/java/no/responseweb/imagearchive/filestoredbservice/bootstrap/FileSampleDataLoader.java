package no.responseweb.imagearchive.filestoredbservice.bootstrap;

import lombok.RequiredArgsConstructor;
import no.responseweb.imagearchive.filestoredbservice.domain.FileStore;
import no.responseweb.imagearchive.filestoredbservice.repositories.FileStoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FileSampleDataLoader implements CommandLineRunner {

    private final FileStoreRepository fileStoreRepository;

    @Override
    public void run(String... args) {
        if(fileStoreRepository.count() == 0 ) {
            loadObjects();
        }
    }
    private void loadObjects() {
        String baseServer = "storage6000";
        String baseShare = "Share";
        String baseFolder = "Test";
        String mountPoint = "a";
        FileStore store = FileStore.builder()
                .baseServer(baseServer)
                .baseShare(baseShare)
                .baseFolder(baseFolder)
                .mountPoint(mountPoint)
                .nickname("test a")
                .build();
        fileStoreRepository.save(store);
    }
}
