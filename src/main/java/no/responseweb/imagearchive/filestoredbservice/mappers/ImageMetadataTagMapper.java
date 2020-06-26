package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.ImageMetadataTag;
import no.responseweb.imagearchive.model.ImageMetadataTagDto;
import org.mapstruct.Mapper;

@Mapper
public interface ImageMetadataTagMapper {
    ImageMetadataTag imageMetadataTagDtoToImageMetadataTag(ImageMetadataTagDto imageMetadataTagDto);
    ImageMetadataTagDto imageMetadataTagToImageMetadataTagDto(ImageMetadataTag imageMetadataTag);
}
