package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.ImageMetadataCollection;
import no.responseweb.imagearchive.model.ImageMetadataCollectionDto;
import org.mapstruct.Mapper;

@Mapper
public interface ImageMetadataCollectionMapper {
    ImageMetadataCollection imageMetadataCollectionDtoToImageMetadataCollection(ImageMetadataCollectionDto imageMetadataCollectionDto);
    ImageMetadataCollectionDto imageMetadataCollectionToImageMetadataCollectionDto(ImageMetadataCollection imageMetadataCollection);
}
