package com.markedline.webdelivery.controller.command;

import com.markedline.webdelivery.controller.command.impl.GoToIndexPage;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {

//        commands.put(CommandName.LOGINATION, new Logination());
//        commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
//        commands.put(CommandName.LOGOUT, new Logout());
//        commands.put(CommandName.REGISTRATION, new Registration());
        commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());

    }

    public Command takeCommand(String name) {
        return commands.get(CommandName.valueOf(name.toUpperCase()));
    }
}
