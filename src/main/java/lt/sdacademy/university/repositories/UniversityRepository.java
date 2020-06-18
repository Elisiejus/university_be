package lt.sdacademy.university.repositories;

import java.util.List;
import lt.sdacademy.university.models.entities.UniversityEntity;
import org.springframework.data.repository.Repository;

public interface UniversityRepository extends Repository<UniversityEntity, Integer> {

    UniversityEntity findOneById(Integer id);

    boolean existsByCode(String code);

    List<UniversityEntity> findAll();

    UniversityEntity save(UniversityEntity university);

    void deleteOneById(Integer id);
}
