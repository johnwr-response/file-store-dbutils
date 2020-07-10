package no.responseweb.imagearchive.filestoredbservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.responseweb.imagearchive.filestoredbservice.mappers.FileItemMapper;
import no.responseweb.imagearchive.filestoredbservice.repositories.FileItemRepository;
import no.responseweb.imagearchive.model.FileItemDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class FileItemServiceImpl implements FileItemService {

    private final FileItemRepository fileItemRepository;
    private final FileItemMapper fileItemMapper;

    @Override
    public FileItemDto save(FileItemDto fileItemDto) {
        if (fileItemDto==null) return null;
        return fileItemMapper.fileItemToFileItemDto(
                fileItemRepository.saveAndFlush(fileItemMapper.fileItemDtoToFileItem(fileItemDto))
        );
    }

    @Override
    public FileItemDto findFirstById(FileItemDto fileItemDto) {
        if (fileItemDto == null) return null;
        return fileItemMapper.fileItemToFileItemDto(fileItemRepository.findFirstById(fileItemDto.getId()));
    }

    @Override
    public void delete(FileItemDto fileItemDto) {
        fileItemRepository.delete(fileItemMapper.fileItemDtoToFileItem(fileItemDto));
    }
}
