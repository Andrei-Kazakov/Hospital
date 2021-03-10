package by.epam.hospital.command.impl.admin;

import org.apache.log4j.Logger;
import by.epam.hospital.command.Command;
import by.epam.hospital.entity.Chamber;
import by.epam.hospital.service.ChamberService;
import by.epam.hospital.service.factory.ServiceFactory;
import by.epam.hospital.utils.PagesManager;
import by.epam.hospital.utils.UserUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RemoveChamberCommand implements Command {

    private static final Logger logger = Logger.getLogger(RemoveChamberCommand.class);

    private static ChamberService chamberService = ServiceFactory.getChamberService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        logger.debug("Try to remove chamber");

        if (!UserUtils.getInstance().hasAccess(request, PagesManager.getProperty("path.page.manageHospital"))) {
            return PagesManager.getProperty("path.page.error.accessDenied");
        }

        HttpSession session = request.getSession();

        List<Chamber> chamberList = (List<Chamber>) session.getAttribute("chambersInHospital");
        Long id = Long.valueOf(request.getParameter("id"));

        ChamberService chamberService = ServiceFactory.getChamberService();
        Chamber chamber = chamberService.findChamberById(id);

        String page;

        if (chamber != null) {
            if (chamber.getPatients().size() == 0) {
                if (chamberService.deleteChamber(chamber)) {
                    chamberList.remove(chamber);
                    logger.debug("successful deleted");
                } else {
                    logger.debug("unsuccessful deleted");
                }
                session.removeAttribute("removeChamberFailed");
                session.setAttribute("chambersInHospital", chamberList);
            } else {
                session.setAttribute("removeChamberFailed", "removeChamberFailed");
            }
            page = (String) session.getAttribute("currentPage");
        } else {
            page = PagesManager.getProperty("path.page.error");
        }

        return page;
    }
}
