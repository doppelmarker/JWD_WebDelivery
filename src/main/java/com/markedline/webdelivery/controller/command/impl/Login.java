package com.markedline.webdelivery.controller.command.impl;

import com.markedline.webdelivery.controller.command.Command;
import com.markedline.webdelivery.entity.User;
import com.markedline.webdelivery.service.ServiceException;
import com.markedline.webdelivery.service.ServiceProvider;
import com.markedline.webdelivery.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        User user;
        try {
            user = userService.authorization(login, password);

            if (user == null) {
                String errorMessage = "Invalid username or password!";
                response.sendRedirect("Controller?command=gotologinpage&errorMessage=" + errorMessage);
                return;
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("auth", true);
            session.setAttribute("loginedUser", user);
            response.sendRedirect("Controller?command=gotoindexpage");
        } catch (ServiceException e) {
            response.sendRedirect("Controller?command=gotoerrorpage&errorMessage=" + e.getMessage());
        }
    }
}
