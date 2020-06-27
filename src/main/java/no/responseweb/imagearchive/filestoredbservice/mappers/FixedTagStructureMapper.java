package no.responseweb.imagearchive.filestoredbservice.mappers;

import no.responseweb.imagearchive.filestoredbservice.domain.FixedTagStructure;
import no.responseweb.imagearchive.model.FixedTagStructureDto;
import org.mapstruct.Mapper;

@Mapper
public interface FixedTagStructureMapper {
    FixedTagStructure fixedTagStructureDtoToFixedTagStructure(FixedTagStructureDto fixedTagStructureDto);
    FixedTagStructureDto fixedTagStructureToFixedTagStructureDto(FixedTagStructure fixedTagStructure);
}
