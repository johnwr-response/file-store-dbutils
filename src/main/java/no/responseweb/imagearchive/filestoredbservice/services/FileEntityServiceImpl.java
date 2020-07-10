package no.responseweb.imagearchive.filestoredbservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.responseweb.imagearchive.filestoredbservice.mappers.FileEntityMapper;
import no.responseweb.imagearchive.filestoredbservice.repositories.FileEntityRepository;
import no.responseweb.imagearchive.model.FileEntityDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class FileEntityServiceImpl implements FileEntityService {

    private final FileEntityRepository fileEntityRepository;
    private final FileEntityMapper fileEntityMapper;

    @Override
    public FileEntityDto findFirstById(UUID fileEntityId) {
        if (fileEntityId==null) return null;
        return fileEntityMapper.fileEntityToFileEntityDto(
                fileEntityRepository.findFirstById(fileEntityId)
        );
    }

    @Override
    public FileEntityDto save(FileEntityDto fileEntityDto) {
        if (fileEntityDto==null) return null;
        return fileEntityMapper.fileEntityToFileEntityDto(
                fileEntityRepository.saveAndFlush(fileEntityMapper.fileEntityDtoToFileEntity(fileEntityDto))
        );
    }

    @Override
    public List<FileEntityDto> findDistinctByIdNotLike(UUID fileEntityId) {
        return fileEntityRepository.findDistinctByIdNotLike(fileEntityId).stream().map(fileEntityMapper::fileEntityToFileEntityDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID fileEntityId) {
        if (fileEntityRepository.findFirstById(fileEntityId)!=null) {
            fileEntityRepository.deleteById(fileEntityId);
        }
    }
}
