package ru.innopolis.stc9.sun.academy.dao.factory;

import org.springframework.stereotype.Component;
import ru.innopolis.stc9.sun.academy.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserFactory {
    public User createUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("firstname"),
                resultSet.getString("lastname"),
                resultSet.getString("patronymic"),
                resultSet.getString("email"),
                resultSet.getString("password"),
                resultSet.getBoolean("is_active")
        );
    }
}
