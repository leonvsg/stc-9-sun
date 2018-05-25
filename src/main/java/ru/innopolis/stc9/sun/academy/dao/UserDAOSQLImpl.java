package ru.innopolis.stc9.sun.academy.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.stc9.sun.academy.connection.ConnectionManager;
import ru.innopolis.stc9.sun.academy.dao.factory.UserFactory;
import ru.innopolis.stc9.sun.academy.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserDAOSQLImpl implements UserDAO {
    private final ConnectionManager connectionManager;
    private final UserFactory userFactory;
    private static final Logger LOGGER = Logger.getLogger(UserDAOSQLImpl.class);

    static final String INSERT_USER_SQL = "INSERT INTO \"user\" (firstname, lastname, patronymic, email, password, is_active) VALUES (?, ?, ?, ?, ?, ?) ";
    static final String SELECT_USER_SQL = "SELECT * FROM \"user\" WHERE id = ?";
    static final String SELECT_ALL_USERS_SQL = "SELECT id, firstname, lastname, patronymic FROM \"user\" ORDER BY id";
    static final String UPDATE_USER_SQL = "UPDATE \"user\" SET firstname = ?, lastname = ?, patronymic = ?, email = ?, password = ?, is_active = ? WHERE id = ?";
    static final String DELETE_USER_SQL = "DELETE FROM \"user\" WHERE id = ?";

    @Autowired
    public UserDAOSQLImpl(ConnectionManager connectionManager, UserFactory userFactory) {
        this.connectionManager = connectionManager;
        this.userFactory = userFactory;
    }

    @Override
    public boolean add(User user) {
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT_USER_SQL)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPatronymic());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setBoolean(6, user.getActive());
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return true;
    }

    @Override
    public User getById(int id) {
        Connection connection = connectionManager.getConnection();
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_USER_SQL)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = userFactory.createUser(resultSet);
                }
            }
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return user;
    }

    @Override
    public Set<User> getAll() {
        Set<User> users = new HashSet<>();
        Connection connection = connectionManager.getConnection();
        try {
            try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS_SQL)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        users.add(userFactory.createUser(resultSet));
                    }
                }
            }
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return users;
    }

    @Override
    public boolean update(User user) {
        Connection connection = connectionManager.getConnection();
        int count = 0;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPatronymic());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setBoolean(6, user.getActive());
            statement.setInt(7, user.getId());
            count = statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return count > 0;
    }

    @Override
    public boolean deleteById(int id) {
        Connection connection = connectionManager.getConnection();
        int count = 0;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL)) {
            statement.setInt(1, id);
            count = statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return count > 0;
    }
}
