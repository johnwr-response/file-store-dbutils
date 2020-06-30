package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.ImageFile;
import no.responseweb.imagearchive.model.ImageFileDto;
import org.mapstruct.Mapper;

@Mapper
public interface ImageFileMapper {
    ImageFile imageFileDtoToImageFile(ImageFileDto imageFileDto);
    ImageFileDto imageFileToImageFileDto(ImageFile imageFile);
}
