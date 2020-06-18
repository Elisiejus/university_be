package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import lt.sdacademy.university.converters.UniversityConverter;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UniversityServiceTest {

    private UniversityService universityService;

    @BeforeEach
    public void init() {
        universityService = new UniversityService(mock(UniversityConverter.class), mock(UniversityRepository.class));
    }

    @Test
    void getUniversities() {
        assertNotNull(universityService.getUniversities());
    }
}
