package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.User;
import lt.sdacademy.university.models.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convert(User user) {
        if (user == null) {
            return null;
        }

        UserEntity result = new UserEntity();
        result.setId(user.getId());
        result.setName(user.getName());
        result.setEmail(user.getUsername());

        return result;
    }

    public User convert(UserEntity userEntity) {
        return null;
    }
}
