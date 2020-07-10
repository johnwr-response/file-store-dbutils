package no.responseweb.imagearchive.filestoredbservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.responseweb.imagearchive.filestoredbservice.mappers.MediaTypeMapper;
import no.responseweb.imagearchive.filestoredbservice.repositories.MediaTypeRepository;
import no.responseweb.imagearchive.model.MediaTypeDto;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MediaTypeServiceImpl implements MediaTypeService {

    private final MediaTypeRepository mediaTypeRepository;
    private final MediaTypeMapper mediaTypeMapper;

    @Override
    public MediaTypeDto findFirstById(MediaTypeDto mediaTypeDto) {
        if (mediaTypeDto == null) return null;
        return mediaTypeMapper.mediaTypeToMediaTypeDto(mediaTypeRepository.findFirstById(mediaTypeDto.getId()));
    }

    @Override
    public MediaTypeDto findFirstByTypeAndSubtype(String type, String subtype) {
        if (type == null && subtype == null) return null;
        return mediaTypeMapper.mediaTypeToMediaTypeDto(mediaTypeRepository.findFirstByTypeAndSubtype(type, subtype));
    }

    @Override
    public MediaTypeDto save(MediaTypeDto mediaTypeDto) {
        if (mediaTypeDto==null) return null;
        return mediaTypeMapper.mediaTypeToMediaTypeDto(
                mediaTypeRepository.saveAndFlush(mediaTypeMapper.mediaTypeDtoToMediaType(mediaTypeDto))
        );
    }
}
