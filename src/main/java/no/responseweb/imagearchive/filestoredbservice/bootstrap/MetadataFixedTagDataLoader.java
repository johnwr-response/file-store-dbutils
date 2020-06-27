package no.responseweb.imagearchive.filestoredbservice.bootstrap;

import lombok.RequiredArgsConstructor;
import no.responseweb.imagearchive.filestoredbservice.domain.*;
import no.responseweb.imagearchive.filestoredbservice.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MetadataFixedTagDataLoader implements CommandLineRunner {

    private final LanguageRepository languageRepository;
    private final FixedTagStructureRepository fixedTagStructureRepository;
    private final FixedTagObjectRepository fixedTagObjectRepository;
    private final FixedTagElementRepository fixedTagElementRepository;
    private final FixedTagObjectContextRepository fixedTagObjectContextRepository;

    @Override
    public void run(String... args) {
        loadMetadata();
    }
    private void loadMetadata() {
        Language english = makeSureLanguageExists("English");

        FixedTagStructure group = makeSureFixedTagStructureExists("Group of persons", null, english);
        FixedTagStructure person = makeSureFixedTagStructureExists("Person", group, english);
        FixedTagStructure location = makeSureFixedTagStructureExists("Location", null, english);
        FixedTagStructure object = makeSureFixedTagStructureExists("Object", null, english);

        FixedTagObject objectSofa = makeSureFixedTagObjectExists("Sofa",object, english);
        FixedTagObject personName = makeSureFixedTagObjectExists("Name",person, english);
        FixedTagObject locationBeach = makeSureFixedTagObjectExists("Beach",location, english);
        FixedTagObject personHair = makeSureFixedTagObjectExists("Hair",person, english);
        FixedTagObject personTattoo = makeSureFixedTagObjectExists("Tattoo",person, english);
        FixedTagObject groupName = makeSureFixedTagObjectExists("Name",group, english);
        FixedTagObject groupType = makeSureFixedTagObjectExists("Type",group, english);

        FixedTagElement elementFirstName = makeSureFixedTagElementExists("First Name", english);
        FixedTagElement elementColor = makeSureFixedTagElementExists("Color", english);
        FixedTagElement elementName = makeSureFixedTagElementExists("Name", english);
        FixedTagElement elementLength = makeSureFixedTagElementExists("Length", english);
        FixedTagElement elementPlacement = makeSureFixedTagElementExists("Placement", english);
        FixedTagElement elementGroupName = makeSureFixedTagElementExists("Group Name", english);

        makeSureFixedTagObjectContextExists(objectSofa, elementColor);
        makeSureFixedTagObjectContextExists(personName, elementFirstName);
        makeSureFixedTagObjectContextExists(locationBeach,elementName);
        makeSureFixedTagObjectContextExists(personHair, elementColor);
        makeSureFixedTagObjectContextExists(personHair, elementLength);
        makeSureFixedTagObjectContextExists(personTattoo, elementColor);
        makeSureFixedTagObjectContextExists(personTattoo, elementPlacement);
        makeSureFixedTagObjectContextExists(groupName, elementGroupName);
        makeSureFixedTagObjectContextExists(groupType, elementName);

    }

    private Language makeSureLanguageExists(@SuppressWarnings("SameParameterValue") String languageName) {
        Language language = languageRepository.findFirstByName(languageName);
        if (language == null) {
            language = languageRepository.save(Language.builder().name(languageName).build());
        }
        return language;
    }

    private FixedTagStructure makeSureFixedTagStructureExists(String structureName, FixedTagStructure parent, Language language) {
        FixedTagStructure fixedTagStructure = fixedTagStructureRepository.findFirstByNameAndLanguageId(structureName, language.getId());
        if (fixedTagStructure == null) {
            if (parent==null) {
                fixedTagStructure = fixedTagStructureRepository.save(FixedTagStructure.builder().name(structureName).languageId(language.getId()).build());
            } else {
                fixedTagStructure = fixedTagStructureRepository.save(FixedTagStructure.builder().name(structureName).parentId(parent.getId()).languageId(language.getId()).build());
            }
        }
        return fixedTagStructure;
    }

    private FixedTagObject makeSureFixedTagObjectExists(String objectName, FixedTagStructure fixedTagStructure, Language language) {
        FixedTagObject fixedTagObject = fixedTagObjectRepository.findFirstByNameAndFixedTagStructureIdAndLanguageId(objectName, fixedTagStructure.getId(), language.getId());
        if (fixedTagObject == null) {
            fixedTagObject = fixedTagObjectRepository.save(FixedTagObject.builder().name(objectName).fixedTagStructureId(fixedTagStructure.getId()).languageId(language.getId()).build());
        }
        return fixedTagObject;
    }

    private FixedTagElement makeSureFixedTagElementExists(String elementName, Language language) {
        FixedTagElement fixedTagElement = fixedTagElementRepository.findFirstByNameAndLanguageId(elementName,language.getId());
        if (fixedTagElement == null) {
            fixedTagElement = fixedTagElementRepository.save(FixedTagElement.builder().name(elementName).languageId(language.getId()).build());
        }
        return fixedTagElement;
    }

    @SuppressWarnings("UnusedReturnValue")
    private FixedTagObjectContext makeSureFixedTagObjectContextExists(FixedTagObject fixedTagObject, FixedTagElement fixedTagElement) {
        FixedTagObjectContext fixedTagObjectContext = fixedTagObjectContextRepository.findFirstByFixedTagObjectIdAndFixedTagElementId(fixedTagObject.getId(), fixedTagElement.getId());
        if (fixedTagObjectContext == null) {
            fixedTagObjectContext = fixedTagObjectContextRepository.save(FixedTagObjectContext.builder().fixedTagObjectId(fixedTagObject.getId()).fixedTagElementId(fixedTagElement.getId()).build());
        }
        return fixedTagObjectContext;
    }

}
