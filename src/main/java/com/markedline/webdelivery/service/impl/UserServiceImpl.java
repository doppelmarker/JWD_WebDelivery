package com.markedline.webdelivery.service.impl;

import com.markedline.webdelivery.dao.DAOException;
import com.markedline.webdelivery.dao.DAOProvider;
import com.markedline.webdelivery.dao.UserDAO;
import com.markedline.webdelivery.entity.User;
import com.markedline.webdelivery.service.ServiceException;
import com.markedline.webdelivery.service.UserService;
import com.markedline.webdelivery.service.validator.CommonValidator;
import com.markedline.webdelivery.service.validator.ValidatorException;
import com.markedline.webdelivery.service.validator.impl.RegistrationInfoValidator;
import com.markedline.webdelivery.service.validator.info.RegistrationInfo;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final CommonValidator validator = new RegistrationInfoValidator();
    private final DAOProvider daoProvider = DAOProvider.getInstance();

    @Override
    public boolean primaryRegistration(User user) throws ServiceException, ValidatorException {
        RegistrationInfo registrationInfo = new RegistrationInfo(user.getLogin(), user.getPassword());
        UserDAO userDAO = daoProvider.getUserDAO();
        boolean isRegistered = false;
        try {
            if (validator.validate(registrationInfo)) {
                isRegistered = userDAO.primaryRegistration(user);
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return isRegistered;
    }

    @Override
    public User authorization(String login, String password) throws ServiceException {
        return null;
    }

    @Override
    public boolean isLoginTaken(String login) throws ServiceException {
        UserDAO userDAO = daoProvider.getUserDAO();

        try {
            List<User> listUsers = userDAO.getAll();
            for (User user : listUsers) {
                if (user.getLogin().equals(login))
                    return true;
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return false;
    }
}
