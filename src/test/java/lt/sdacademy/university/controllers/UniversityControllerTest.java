package lt.sdacademy.university.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import lt.sdacademy.university.converters.StudyProgramConverter;
import lt.sdacademy.university.converters.UniversityConverter;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.models.exceptions.ValidationException;
import lt.sdacademy.university.repositories.UniversityRepository;
import lt.sdacademy.university.services.UniversityService;
import lt.sdacademy.university.validators.UniversityValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UniversityControllerTest {

    private UniversityController universityController;

    @Mock
    private UniversityRepository universityRepository;

    @BeforeEach
    void setUp() {
        StudyProgramConverter studyProgramConverter = new StudyProgramConverter();
        UniversityConverter universityConverter = new UniversityConverter(studyProgramConverter, universityRepository);
        UniversityService universityService = new UniversityService(universityConverter, universityRepository);
        UniversityValidator universityValidator = new UniversityValidator(universityRepository);
        universityController = new UniversityController(universityService, universityValidator);
    }

    @Test
    void save_codeIsNull() {
        University university = new University();

        assertThrows(ValidationException.class, () -> {
            universityController.save(university);
        });
    }

    @Test
    void save() {
        University university = new University();
        university.setCode("TEST");
        university.setTitle("Test University");
        UniversityEntity expectedResult = new UniversityEntity();
        expectedResult.setId(4);
        expectedResult.setCode("TEST");
        expectedResult.setTitle("Test University");
        when(universityRepository.save(any())).thenReturn(expectedResult);

        University result = universityController.save(university);

        assertEquals(4, result.getId());
        assertEquals("TEST", result.getCode());
        assertEquals("Test University", result.getTitle());
    }

    @Test
    void getAll() {

        // Pre-work: mocked repo should return list of universities (at least two)

        // Get all universities

        // Verify result
    }
}
