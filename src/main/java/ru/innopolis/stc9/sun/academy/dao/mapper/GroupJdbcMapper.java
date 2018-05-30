package ru.innopolis.stc9.sun.academy.dao.mapper;

import ru.innopolis.stc9.sun.academy.entity.Group;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupJdbcMapper {

    public GroupJdbcMapper() {
    }

    public static Group toGroup(ResultSet resultSet) throws SQLException {
        return new Group(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("description"),
                resultSet.getString("start_date"),
                resultSet.getString("finished_date"),
                resultSet.getBoolean("is_active")
        );
    }

    public static void toStatement(PreparedStatement statement, Group group) throws SQLException {
        statement.setString(1, group.getTitle());
        statement.setString(2, group.getDescription());
        statement.setString(3, group.getStart_date());
        statement.setString(4, group.getFinished_date());
        statement.setBoolean(5, group.isIs_active());
    }
}
