package by.epam.hospital.command.impl.authorization;

import org.apache.log4j.Logger;
import by.epam.hospital.command.Command;
import by.epam.hospital.command.CommandHelper;
import by.epam.hospital.entity.Person;
import by.epam.hospital.service.PersonService;
import by.epam.hospital.service.factory.ServiceFactory;
import by.epam.hospital.utils.PagesManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    private static final Logger logger = Logger.getLogger(LoginCommand.class);

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page = PagesManager.getProperty("path.page.login");

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);

        PersonService personLogic = ServiceFactory.getPersonService();
        Person person = personLogic.login(login, password);

        logger.debug(person);

        if (person != null) {
            session.setAttribute("user", person);

            Command redirect = CommandHelper.getInstance().defineCommand("redirect");
            return redirect.execute(request, response);
        } else {
            logger.debug("Login failed. Incorrect login or password.");
            session.setAttribute("errorLoginPassMessage", "Incorrect login or password.");
            session.setAttribute("login", login);
        }
        return page;
    }
}
