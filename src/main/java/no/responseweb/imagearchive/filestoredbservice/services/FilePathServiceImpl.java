package no.responseweb.imagearchive.filestoredbservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.responseweb.imagearchive.filestoredbservice.mappers.FilePathMapper;
import no.responseweb.imagearchive.filestoredbservice.repositories.FilePathRepository;
import no.responseweb.imagearchive.model.FilePathDto;
import no.responseweb.imagearchive.model.FileStoreDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class FilePathServiceImpl implements FilePathService {

    private final FilePathRepository filePathRepository;
    private final FilePathMapper filePathMapper;

    @Override
    public FilePathDto save(FilePathDto filePathDto) {
        if (filePathDto==null) return null;
        return filePathMapper.filePathToFilePathDto(
                filePathRepository.saveAndFlush(
                        filePathMapper.filePathDtoToFilePath(filePathDto)
                )
        );
    }

    @Override
    public FilePathDto findFirstById(FilePathDto filePathDto) {
        if (filePathDto == null) return null;
        return filePathMapper.filePathToFilePathDto(filePathRepository.findFirstById(filePathDto.getId()));
    }

    @Override
    public FilePathDto findByFileStoreIdAndRelativePath(FileStoreDto fileStoreDto, FilePathDto filePathDto) {
        return filePathMapper.filePathToFilePathDto(
          filePathRepository.findByFileStoreIdAndRelativePath(
                  fileStoreDto.getId(),
                  (filePathDto.getRelativePath()!=null ? filePathDto.getRelativePath() : "")
          )
        );
    }
}
