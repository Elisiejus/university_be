package lt.sdacademy.university.controllers;

import java.util.List;

import lt.sdacademy.university.converters.StudyProgramConverter;
import lt.sdacademy.university.models.dto.StudyProgram;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import lt.sdacademy.university.services.StudyProgramService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/study-programs")
public class StudyProgramController {

    private final StudyProgramService studyProgramService;

    public StudyProgramController(StudyProgramService studyProgramService) {
        this.studyProgramService = studyProgramService;
    }

    @GetMapping
    public List<StudyProgram> getAll(@RequestParam(name = "module-title", required = false) String moduleTitle) {
        return studyProgramService.getStudyPrograms(moduleTitle);
    }
}
