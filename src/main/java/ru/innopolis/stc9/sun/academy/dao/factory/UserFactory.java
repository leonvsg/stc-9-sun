package ru.innopolis.stc9.sun.academy.dao.factory;

import ru.innopolis.stc9.sun.academy.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFactory {
    private UserFactory() {
    }

    public static User createUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("firstname"),
                resultSet.getString("lastname"),
                resultSet.getString("patronymic")
        );
    }
}
