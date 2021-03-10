package com.markedline.webdelivery.dao;

import com.markedline.webdelivery.dao.impl.UserDAOImpl;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private UserDAO userDAO;

    private DAOProvider() {
        try {
            userDAO = new UserDAOImpl();
        } catch (DAOException e) {
            userDAO = null;
            //logger
        }
    }

    public static DAOProvider getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

}
