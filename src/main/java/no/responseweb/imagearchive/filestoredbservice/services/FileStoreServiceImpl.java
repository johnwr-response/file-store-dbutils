package no.responseweb.imagearchive.filestoredbservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.responseweb.imagearchive.filestoredbservice.mappers.FileStoreMapper;
import no.responseweb.imagearchive.filestoredbservice.repositories.FileStoreRepository;
import no.responseweb.imagearchive.model.FileStoreDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class FileStoreServiceImpl implements FileStoreService {

    private final FileStoreRepository fileStoreRepository;
    private final FileStoreMapper fileStoreMapper;

    @Override
    public FileStoreDto save(FileStoreDto fileStoreDto) {
        if (fileStoreDto==null) return null;
        return fileStoreMapper.fileStoreToFileStoreDto(fileStoreRepository.saveAndFlush(fileStoreMapper.fileStoreDtoToFileStore(fileStoreDto)));
    }

    @Override
    public FileStoreDto findFirstById(FileStoreDto fileStoreDto) {
        if (fileStoreDto == null) return null;
        return fileStoreMapper.fileStoreToFileStoreDto(fileStoreRepository.findFirstById(fileStoreDto.getId()));

    }
}
