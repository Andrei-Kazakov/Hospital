package by.epam.hospital.command.impl.authorization;

import org.apache.log4j.Logger;
import by.epam.hospital.command.Command;
import by.epam.hospital.utils.PagesManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    private static final Logger logger = Logger.getLogger(LogoutCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        logger.debug(session);
        session.invalidate();
        return PagesManager.getProperty("path.page.index");
    }

}
