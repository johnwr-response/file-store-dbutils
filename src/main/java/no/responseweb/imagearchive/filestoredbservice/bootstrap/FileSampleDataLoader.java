package no.responseweb.imagearchive.filestoredbservice.bootstrap;

import lombok.RequiredArgsConstructor;
import no.responseweb.imagearchive.filestoredbservice.domain.FileStore;
import no.responseweb.imagearchive.filestoredbservice.domain.ImageMetadataCollection;
import no.responseweb.imagearchive.filestoredbservice.repositories.FileStoreRepository;
import no.responseweb.imagearchive.filestoredbservice.repositories.ImageMetadataCollectionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FileSampleDataLoader implements CommandLineRunner {

    private final FileStoreRepository fileStoreRepository;
    private final ImageMetadataCollectionRepository imageMetadataCollectionRepository;

    @Override
    public void run(String... args) {
        if(imageMetadataCollectionRepository.count() == 0 ) {
            loadMetadata();
        }
        if(fileStoreRepository.count() == 0 ) {
            loadSample();
        }
    }
    private void loadMetadata() {
        imageMetadataCollectionRepository.save(
                ImageMetadataCollection.builder()
                        .name("unset")
                        .build()
        );
    }
    private void loadSample() {
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
