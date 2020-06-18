package lt.sdacademy.university.services;

import java.util.List;
import lt.sdacademy.university.converters.UniversityConverter;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UniversityService {

    private final UniversityConverter universityConverter;
    private final UniversityRepository universityRepository;

    public UniversityService(UniversityConverter universityConverter, UniversityRepository universityRepository) {
        this.universityConverter = universityConverter;
        this.universityRepository = universityRepository;
    }

    public List<University> getUniversities() {
        List<UniversityEntity> universities = universityRepository.findAll();

        return universityConverter.convert(universities);
    }

    public University getUniversity(Integer id) {
        UniversityEntity universityEntity = universityRepository.findOneById(id);

        return universityConverter.convert(universityEntity);
    }

    public University save(University university) {
        UniversityEntity universityEntity = universityConverter.convertToEntity(university);
        UniversityEntity result = universityRepository.save(universityEntity);

        return universityConverter.convert(result);
    }

    @Transactional
    public void delete(Integer id) {
        universityRepository.deleteOneById(id);
    }
}
