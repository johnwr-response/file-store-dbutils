package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.ImageMetadataDirectory;
import no.responseweb.imagearchive.model.ImageMetadataDirectoryDto;
import org.mapstruct.Mapper;

@Mapper
public interface ImageMetadataDirectoryMapper {
    ImageMetadataDirectory imageMetadataDirectoryDtoToImageMetadataDirectory(ImageMetadataDirectoryDto imageMetadataDirectoryDto);
    ImageMetadataDirectoryDto imageMetadataDirectoryToImageMetadataDirectoryDto(ImageMetadataDirectory imageMetadataDirectory);
}
