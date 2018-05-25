package ru.innopolis.stc9.sun.academy.mapper;

import org.springframework.stereotype.Component;
import ru.innopolis.stc9.sun.academy.dto.UserDTO;
import ru.innopolis.stc9.sun.academy.entity.User;

@Component
public class UserMapper {
    UserMapper() {
    }

    public static UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPatronymic(user.getPatronymic());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setActive(user.getActive());
        return userDTO;
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPatronymic(userDTO.getPatronymic());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setActive(userDTO.getActive());
        return user;
    }
}
