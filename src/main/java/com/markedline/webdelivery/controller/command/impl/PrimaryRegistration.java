package com.markedline.webdelivery.controller.command.impl;

import com.markedline.webdelivery.controller.command.Command;
import com.markedline.webdelivery.entity.User;
import com.markedline.webdelivery.service.ServiceException;
import com.markedline.webdelivery.service.ServiceProvider;
import com.markedline.webdelivery.service.UserService;
import com.markedline.webdelivery.service.validator.ValidatorException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrimaryRegistration implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        String login = request.getParameter("login");

        try {
            if (userService.isLoginTaken(login)) {
                String errorMessage = "This login is already taken!";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
                requestDispatcher.forward(request, response);
                return;
            }
        } catch (ServiceException e) {
            response.sendRedirect("Controller?command=gotoerrorpage&errorMessage=" + e.getMessage());
            return;
        }


        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("repeatedPassword");

        if (!password.equals(repeatedPassword)) {
            String errorMessage = "Passwords don't match!";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
            requestDispatcher.forward(request, response);
            return;
        }

        User user = new User(login, password);
        try {
            userService.primaryRegistration(user);
            response.sendRedirect("Controller?command=gotoindexpage");
        } catch (ValidatorException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            response.sendRedirect("Controller?command=gotoerrorpage&errorMessage=" + e.getMessage());
        }
    }
}
