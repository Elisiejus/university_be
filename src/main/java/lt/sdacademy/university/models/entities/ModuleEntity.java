package lt.sdacademy.university.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "module")
public class ModuleEntity extends AbstractEntity {

    @Column(name = "title", length = 250, nullable = false)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
