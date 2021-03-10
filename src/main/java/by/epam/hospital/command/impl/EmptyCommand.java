package by.epam.hospital.command.impl;

import org.apache.log4j.Logger;
import by.epam.hospital.command.Command;
import by.epam.hospital.utils.PagesManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmptyCommand implements Command {

    private static final Logger logger = Logger.getLogger(EmptyCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("Empty command");
        return PagesManager.getProperty("path.page.login");
    }
}
