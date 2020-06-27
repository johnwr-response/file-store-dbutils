package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.Language;
import no.responseweb.imagearchive.model.LanguageDto;
import org.mapstruct.Mapper;

@Mapper
public interface LanguageMapper {
    Language languageDtoToLanguage(LanguageDto languageDto);
    LanguageDto languageToLanguageDto(Language language);
}
