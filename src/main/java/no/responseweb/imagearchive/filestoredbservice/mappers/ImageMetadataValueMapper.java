package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.ImageMetadataValue;
import no.responseweb.imagearchive.model.ImageMetadataValueDto;
import org.mapstruct.Mapper;

@Mapper
public interface ImageMetadataValueMapper {
    ImageMetadataValue imageMetadataValueDtoToImageMetadataValue(ImageMetadataValueDto imageMetadataValueDto);
    ImageMetadataValueDto imageMetadataValueToImageMetadataValueDto(ImageMetadataValue imageMetadataValue);
}
