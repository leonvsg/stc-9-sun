package ru.innopolis.stc9.sun.academy.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.stc9.sun.academy.connection.ConnectionManager;
import ru.innopolis.stc9.sun.academy.dao.mapper.GroupJdbcMapper;
import ru.innopolis.stc9.sun.academy.entity.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Component
public class GroupDAOImpl implements GroupDAO {

    static final String INSERT_GROUP_SQL = "INSERT INTO groups (title, description, start_date, finished_date, is_active) VALUES (?, ?, to_date(?,'YYYY-MM-DD'), to_date(?,'YYYY-MM-DD'), ?)";
    static final String UPDATE_GROUP_SQL = "UPDATE groups SET title = ?, description = ?, start_date = to_date(?,'YYYY-MM-DD'), finished_date = to_date(?,'YYYY-MM-DD'), is_active = ? WHERE id = ?";
    static final String DELETE_GROUP_SQL = "DELETE FROM groups WHERE id = ?";
    static final String SELECT_ALL_GROUPS_SQL = "SELECT id, title, description, start_date, finished_date, is_active FROM groups ORDER BY id";

    private final ConnectionManager connectionManager;
    private static final Logger LOGGER = Logger.getLogger(UserDAOJdbcImpl.class);

    @Autowired
    public GroupDAOImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public boolean add(Group group) {
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT_GROUP_SQL)) {
            GroupJdbcMapper.toStatement(statement, group);
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean update(Group group) {
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_GROUP_SQL)) {
            GroupJdbcMapper.toStatement(statement, group);
            statement.setInt(6, group.getId());
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_GROUP_SQL)) {
            statement.setInt(1, id);
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return true;
    }

    @Override
    public Set<Group> getAll() {
        Set<Group> groups = new HashSet<>();
        Connection connection = connectionManager.getConnection();
        try {
            try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_GROUPS_SQL)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        groups.add(GroupJdbcMapper.toGroup(resultSet));
                    }
                }
            }
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return groups;
    }
}
