package com.markedline.webdelivery.dao.impl;

import com.markedline.webdelivery.dao.DAOException;
import com.markedline.webdelivery.dao.UserDAO;
import com.markedline.webdelivery.db.pool.ConnectionPool;
import com.markedline.webdelivery.db.pool.ConnectionPoolException;
import com.markedline.webdelivery.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final String REGISTER_USER = "insert into users (login, password) values (?, ?)";

    private final ConnectionPool connectionPool;

    public UserDAOImpl() throws DAOException {
        try {
            connectionPool = ConnectionPool.getInstance();
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean registration(User user) throws DAOException {
        boolean isRegistered;
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_USER)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            isRegistered = preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Database access error or" +
                    " attempt on preparing a statement on a closed connection.", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }
        return isRegistered;
    }

    @Override
    public User authorization(String login, String password) throws DAOException {
        return null;
    }

    @Override
    public List<User> getAll() throws DAOException {
        return null;
    }

    @Override
    public User getById() throws DAOException {
        return null;
    }

    @Override
    public User update(User user) throws DAOException {
        return null;
    }

    @Override
    public void delete(User user) throws DAOException {

    }
}
