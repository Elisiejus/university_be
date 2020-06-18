package lt.sdacademy.university.services;

import java.util.List;
import lt.sdacademy.university.converters.StudyProgramConverter;
import lt.sdacademy.university.models.dto.StudyProgram;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import lt.sdacademy.university.repositories.StudyProgramRepository;
import org.springframework.stereotype.Service;

@Service
public class StudyProgramService {

    private final StudyProgramConverter studyProgramConverter;
    private final StudyProgramRepository studyProgramRepository;

    public StudyProgramService(StudyProgramConverter studyProgramConverter, StudyProgramRepository studyProgramRepository) {
        this.studyProgramConverter = studyProgramConverter;
        this.studyProgramRepository = studyProgramRepository;
    }

    public List<StudyProgram> getStudyPrograms(String title) {
        List<StudyProgramEntity> studyPrograms = studyProgramRepository.findAllByModuleTitleLike(title);

        return studyProgramConverter.convert(studyPrograms);
    }
}
