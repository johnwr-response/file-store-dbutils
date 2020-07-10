package no.responseweb.imagearchive.filestoredbservice.services;

import no.responseweb.imagearchive.model.MediaTypeDto;

public interface MediaTypeService {
    MediaTypeDto findFirstById(MediaTypeDto mediaTypeDto);
    MediaTypeDto findFirstByTypeAndSubtype(String type, String subtype);
    MediaTypeDto save(MediaTypeDto mediaTypeDto);
}
