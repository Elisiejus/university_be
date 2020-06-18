package lt.sdacademy.university.repositories;

import lt.sdacademy.university.models.entities.UserEntity;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity, Integer> {

    UserEntity findOneByEmail(String email);

    UserEntity save(UserEntity user);
}
