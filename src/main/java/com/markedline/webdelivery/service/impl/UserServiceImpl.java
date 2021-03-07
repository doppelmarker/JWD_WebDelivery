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

public class UserServiceImpl implements UserService {

    private final CommonValidator validator = new RegistrationInfoValidator();
    private final DAOProvider daoProvider = DAOProvider.getInstance();

    @Override
    public boolean registration(User user) throws ServiceException {
        RegistrationInfo registrationInfo = new RegistrationInfo(user.getLogin(), user.getPassword());
        UserDAO userDAO = daoProvider.getUserDAO();
        boolean isRegistered = false;
        try {
            if (validator.validate(registrationInfo)) {
                isRegistered = userDAO.registration(user);
            }
        } catch (ValidatorException | DAOException e) {
            throw new ServiceException(e);
        }
        return isRegistered;
    }

    @Override
    public User authorization(String login, String password) throws ServiceException {
        return null;
    }
}
