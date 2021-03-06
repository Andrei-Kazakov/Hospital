package by.epam.hospital.command.impl.profile;

import org.apache.log4j.Logger;
import by.epam.hospital.command.Command;
import by.epam.hospital.entity.Person;
import by.epam.hospital.service.PersonService;
import by.epam.hospital.service.factory.ServiceFactory;
import by.epam.hospital.utils.PagesManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePasswordCommand implements Command {

    private static final Logger logger = Logger.getLogger(ChangePasswordCommand.class);

    private static final PersonService personService = ServiceFactory.getPersonService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {


        logger.debug("Change password command");

        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");

        String newPassword = request.getParameter("newpass");
        String newPasswordRepeat = request.getParameter("newrepeat");

        if (newPassword.equals(newPasswordRepeat) && !newPassword.isEmpty()) {
            logger.debug("Passwords are equal");

            person.setPassword(newPassword);
            personService.changePersonPassword(person);

            session.invalidate();

            return PagesManager.getProperty("path.page.login");
        } else {
            logger.debug("Passwords are not equal");
            session.setAttribute("error", "error");
            return (String) session.getAttribute("currentPage");
        }
    }

}
