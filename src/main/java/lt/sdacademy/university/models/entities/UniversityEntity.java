package lt.sdacademy.university.models.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "university")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UniversityEntity extends AbstractEntity {

    @Column(name = "code", length = 10, nullable = false)
    private String code;

    @Column(name = "title", length = 250, nullable = false)
    private String title;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "university", orphanRemoval = true)
    private List<StudyProgramEntity> studyPrograms = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<StudyProgramEntity> getStudyPrograms() {
        return studyPrograms;
    }

    public void setStudyPrograms(List<StudyProgramEntity> studyPrograms) {
        this.studyPrograms = studyPrograms;
    }
}
