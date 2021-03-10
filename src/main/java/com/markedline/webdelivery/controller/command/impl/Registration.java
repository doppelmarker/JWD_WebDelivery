package com.markedline.webdelivery.controller.command.impl;

import com.markedline.webdelivery.controller.command.Command;
import com.markedline.webdelivery.entity.User;
import com.markedline.webdelivery.service.ServiceException;
import com.markedline.webdelivery.service.ServiceProvider;
import com.markedline.webdelivery.service.UserService;
import com.markedline.webdelivery.service.validator.ValidatorException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        String login = request.getParameter("username");

        try {
            if (userService.isLoginTaken(login)) {
                response.sendRedirect("Controller?command=gotoregistrationpage&errorMessage=This login is already taken!");
                return;
            }
        } catch (ServiceException e) {
            response.sendRedirect("Controller?command=gotoerrorpage&errorMessage=" + e.getMessage());
            return;
        }


        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("repeatedPassword");

        if (!password.equals(repeatedPassword)) {
            response.sendRedirect("Controller?command=gotoregistrationpage&errorMessage=Passwords don't match!");
            return;
        }

        User user = new User(login, password);
        try {
            userService.primaryRegistration(user);
            response.sendRedirect("Controller?command=gotoindexpage");
        } catch (ValidatorException e) {
            response.sendRedirect("Controller?command=gotoregistrationpage&errorMessage=" + e.getMessage());
        } catch (ServiceException e) {
            response.sendRedirect("Controller?command=gotoerrorpage&errorMessage=" + e.getMessage());
        }
    }
}
