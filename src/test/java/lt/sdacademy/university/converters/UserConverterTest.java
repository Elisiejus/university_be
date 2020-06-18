package lt.sdacademy.university.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import lt.sdacademy.university.models.dto.User;
import lt.sdacademy.university.models.entities.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserConverterTest {

    private UserConverter userConverter;

    @BeforeEach
    void setUp() {
        userConverter = new UserConverter();
    }

    @Test
    void convertDtoToEntity_dtoIsNull() {
        User user = null;

        UserEntity result = userConverter.convert(user);

        assertNull(result);
    }

    @Test
    void convertDtoToEntity_emptyDto() {
        User user = new User();

        UserEntity result = userConverter.convert(user);

        assertNull(result.getPassword());
        assertNull(result.getEmail());
        assertNull(result.getName());
        assertNull(result.getUsername());
    }


    @Test
    void convertDtoToEntity_dtoWithFields() {
        User user = new User(14, "Test", "Test_username");

        UserEntity result = userConverter.convert(user);

        assertEquals(14, result.getId());
        assertEquals("Test", result.getName());
        assertEquals("Test_username", result.getUsername());
    }
}
