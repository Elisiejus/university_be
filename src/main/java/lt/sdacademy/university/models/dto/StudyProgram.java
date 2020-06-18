package lt.sdacademy.university.models.dto;

import java.util.List;

public class StudyProgram {

    private Integer id;

    private String title;

    private List<String> modules;

    public StudyProgram() {
    }

    public StudyProgram(Integer id, String title, List<String> modules) {
        this.id = id;
        this.title = title;
        this.modules = modules;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getModules() {
        return modules;
    }

    public void setModules(List<String> modules) {
        this.modules = modules;
    }
}
