package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.StudyProgram;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

class StudyProgramConverterTest {

    private StudyProgramConverter studyProgramConverter;

    @BeforeEach
    void setUp() {
        studyProgramConverter = new StudyProgramConverter();
    }

    @Test
    void convertDtoToEntity_dtoIsNull() {

        List<StudyProgramEntity> studyProgramEntities = null;

        List<StudyProgram> result = studyProgramConverter.convert(studyProgramEntities);

        assertNull(result);


    }

}
