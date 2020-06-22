package no.responseweb.imagearchive.filestoredbservice.bootstrap;

import lombok.RequiredArgsConstructor;
import no.responseweb.imagearchive.filestoredbservice.domain.FileItem;
import no.responseweb.imagearchive.filestoredbservice.domain.FilePath;
import no.responseweb.imagearchive.filestoredbservice.domain.FileStore;
import no.responseweb.imagearchive.filestoredbservice.repositories.FileItemRepository;
import no.responseweb.imagearchive.filestoredbservice.repositories.FilePathRepository;
import no.responseweb.imagearchive.filestoredbservice.repositories.FileStoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class FileSampleDataLoader implements CommandLineRunner {

    private final FileStoreRepository fileStoreRepository;
    private final FilePathRepository filePathRepository;
    private final FileItemRepository fileItemRepository;

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
        String baseFileStore = File.separator + File.separator + baseServer + File.separator + baseShare + File.separator + baseFolder;
        // String baseFileStore = "//storage6000/Share/Test";
        Path pathBaseFileStore = Paths.get(baseFileStore);
        @SuppressWarnings("SpellCheckingInspection")
        Path pathSampleSubDir = Paths.get(baseFileStore + "/Testfolder");
        FileStore store = FileStore.builder()
                .baseServer(baseServer)
                .baseShare(baseShare)
                .baseFolder(baseFolder)
                .mountPoint(mountPoint)
//                .baseUri(Paths.get(baseFileStore).toString())
                .nickname("test a")
                .build();
        FileStore savedStore = fileStoreRepository.save(store);
        FilePath rootPath = FilePath.builder()
                .fileStoreId(savedStore.getId())
                .relativePath(pathBaseFileStore.relativize(pathBaseFileStore).toString())
                .build();
        FilePath savedRootPath = filePathRepository.save(rootPath);
        FilePath path = FilePath.builder()
                .fileStoreId(savedStore.getId())
                .relativePath(pathBaseFileStore.relativize(pathSampleSubDir).toString())
                .build();
        FilePath savedPath = filePathRepository.save(path);
        FileItem item1 = FileItem.builder()
                .filename("2013-10-05 20.53.06.jpg")
                .fileStorePathId(savedRootPath.getId())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
        fileItemRepository.save(item1);
        @SuppressWarnings("SpellCheckingInspection")
        FileItem item2 = FileItem.builder()
                .filename("Ambassdorclass.jpg")
                .fileStorePathId(savedPath.getId())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
        fileItemRepository.save(item2);
    }
}
