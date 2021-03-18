package com.markedline.webdelivery.controller.command.impl;

import com.markedline.webdelivery.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (session != null) {
//            session.removeAttribute("auth");
//        }

        request.getSession().invalidate();

        response.sendRedirect("Controller?command=gotoindexpage&message=Logout successful!");
    }
}
