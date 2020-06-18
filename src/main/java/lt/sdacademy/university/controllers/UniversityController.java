package lt.sdacademy.university.controllers;

import java.util.List;
import javax.validation.Valid;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.services.UniversityService;
import lt.sdacademy.university.validators.UniversityValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    private final UniversityService universityService;
    private final UniversityValidator universityValidator;

    public UniversityController(UniversityService universityService, UniversityValidator universityValidator) {
        this.universityService = universityService;
        this.universityValidator = universityValidator;
    }

    @GetMapping
    public List<University> getAll() {
        return universityService.getUniversities();
    }

    @GetMapping("/{id}")
    public University getUniversity(@PathVariable Integer id) {
        return universityService.getUniversity(id);
    }

    @PostMapping
    public University save(@RequestBody @Valid University university) {
        universityValidator.validate(university);

        return universityService.save(university);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        universityService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
