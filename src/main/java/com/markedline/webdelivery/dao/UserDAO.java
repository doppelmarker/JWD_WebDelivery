package com.markedline.webdelivery.dao;

import com.markedline.webdelivery.entity.User;

import java.util.List;

public interface UserDAO {

    boolean registration(User user) throws DAOException;

    User authorization(String login, String password) throws DAOException;

    List<User> getAll() throws DAOException;

    User getById() throws DAOException;

    User update(User user) throws DAOException;

    void delete(User user) throws DAOException;
}
