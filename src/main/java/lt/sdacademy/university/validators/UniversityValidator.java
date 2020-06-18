package lt.sdacademy.university.validators;

import java.util.HashMap;
import java.util.Map;

import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.exceptions.ValidationException;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.stereotype.Component;

@Component
public class UniversityValidator {

    private final UniversityRepository universityRepository;

    public UniversityValidator(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public void validate(University university) {
        Map<String, String> errors = new HashMap<>();

        if (university == null) {
            errors.put("university", "university cannot be null");
            throw new ValidationException(errors);
        }

        validateCode(university, errors);
        validateTitle(university, errors);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private void validateCode(University university, Map<String, String> errors) {
        if (university.getCode() == null) {
            errors.put("code", "code cannot be null");
            return;
        }

        String universityCode = university.getCode().trim();

        if (universityCode.length() < 2) {
            errors.put("code", "size must be between 2 and 10");
            return;
        }

        if (universityRepository.existsByCode(universityCode)) {
            errors.put("code", "such university already exists");
        }

        if (universityCode.substring(0, 1).matches("[0-9]")) {
            errors.put("code", "first character cannot be number");
        }
        // TODO: validate first character not a number

        university.setCode(universityCode);
    }

    private void validateTitle(University university, Map<String, String> errors) {
        if (university.getTitle() == null) {
            errors.put("title", "title cannot be null");
            return;
        }
        // TODO: validate - length, exists
        String universityTitle = university.getTitle().trim();

        if (universityTitle.length() < 6) {
            errors.put("title", "title must be longer than 6");
        }
    }
}
