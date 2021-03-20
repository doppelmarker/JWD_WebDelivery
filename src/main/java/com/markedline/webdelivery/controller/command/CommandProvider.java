package com.markedline.webdelivery.controller.command;

import com.markedline.webdelivery.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {

        commands.put(CommandName.LOGIN, new Login());
        commands.put(CommandName.GOTOERRORPAGE, new GoToErrorPage());
        commands.put(CommandName.LOGOUT, new Logout());
        commands.put(CommandName.REGISTRATION, new PrimaryRegistration());
        commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
        commands.put(CommandName.GOTOLOGINPAGE, new GoToLoginPage());
        commands.put(CommandName.GOTOPRIMARYREGISTRATIONPAGE, new GoToPrimaryRegistrationPage());
        commands.put(CommandName.GOTOPROFILEINFOPAGE, new GoToProfileInfoPage());
    }

    public Command takeCommand(String name) {
        return commands.get(CommandName.valueOf(name.toUpperCase()));
    }
}
