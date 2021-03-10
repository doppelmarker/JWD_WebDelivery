package com.markedline.webdelivery.dao.impl;

import com.markedline.webdelivery.dao.DAOException;
import com.markedline.webdelivery.dao.UserDAO;
import com.markedline.webdelivery.db.pool.ConnectionPool;
import com.markedline.webdelivery.db.pool.ConnectionPoolException;
import com.markedline.webdelivery.entity.Address;
import com.markedline.webdelivery.entity.User;
import com.markedline.webdelivery.entity.UserDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final String REGISTER_USER = "INSERT INTO users (login, password) VALUES (?, ?)";
    private static final String GET_ALL_USERS = "SELECT users.id, login, password, user_roles.name, " +
            "user_details.name, surname, age, phone, email, city, street, house, path, payment_methods.name\n" +
            "FROM users\n" +
            "INNER JOIN user_roles on users.role_id = user_roles.id\n" +
            "INNER JOIN user_statuses on users.status_id = user_statuses.id\n" +
            "INNER JOIN user_details on users.detail_id = user_details.id\n" +
            "INNER JOIN payment_methods on user_details.pmethod_id = payment_methods.id\n" +
            "INNER JOIN user_pics on user_details.pic_id = user_pics.id\n" +
            "INNER JOIN addresses on user_details.address_id = addresses.id";

    private final ConnectionPool connectionPool;

    public UserDAOImpl() throws DAOException {
        try {
            connectionPool = ConnectionPool.getInstance();
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean primaryRegistration(User user) throws DAOException {
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
        List<User> listUsers = new ArrayList<>();

        try (Connection connection = connectionPool.takeConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(GET_ALL_USERS);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setRole(resultSet.getString(4));
                UserDetail userDetail = new UserDetail();
                userDetail.setName(resultSet.getString(5));
                userDetail.setSurname(resultSet.getString(6));
                userDetail.setAge(resultSet.getInt(7));
                userDetail.setPhone(resultSet.getString(8));
                userDetail.setEmail(resultSet.getString(9));
                Address address = new Address();
                address.setCity(resultSet.getString(10));
                address.setStreet(resultSet.getString(11));
                address.setHouse(resultSet.getString(12));
                userDetail.setAddress(address);
                userDetail.setPicture(resultSet.getString(13));
                userDetail.setPaymentMethod(resultSet.getString(14));
                user.setDetail(userDetail);
                user.setStatus(resultSet.getString(15));

                listUsers.add(user);
            }
        } catch (SQLException e) {
            throw new DAOException("Database access error.", e);
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }

        return listUsers;
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
